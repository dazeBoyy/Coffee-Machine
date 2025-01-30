package com.project.coffee_machine.service;

import com.project.coffee_machine.dto.response.DrinkResponseDTO;
import com.project.coffee_machine.exceptions.IngredientNotFoundException;
import com.project.coffee_machine.exceptions.InsufficientIngredientException;
import com.project.coffee_machine.exceptions.RecipeNotFoundException;
import com.project.coffee_machine.model.DrinkOrder;
import com.project.coffee_machine.model.Ingredient;
import com.project.coffee_machine.model.Recipe;
import com.project.coffee_machine.repository.IngredientRepository;
import com.project.coffee_machine.repository.OrderRepository;
import com.project.coffee_machine.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public DrinkResponseDTO makeDrink(String drinkName) {
        // Находим рецепт
        Recipe recipe = recipeRepository.findByName(drinkName)
                .orElseThrow(() -> new RecipeNotFoundException(drinkName));

        // Подготавливаем данные для ответа
        Map<String, Integer> usedIngredients = new HashMap<>();

        // Проверяем и списываем ингредиенты
        recipe.getIngredients().forEach((name, required) -> {
            Ingredient ingredient = ingredientRepository.findByName(name)
                    .orElseThrow(() -> new IngredientNotFoundException(name));

            if (ingredient.getQuantity() < required) {
                throw new InsufficientIngredientException(name);
            }

            // Фиксируем использованное количество
            usedIngredients.put(name, required);

            // Обновляем остатки
            ingredient.setQuantity(ingredient.getQuantity() - required);
            ingredientRepository.save(ingredient);
        });

        // Сохраняем заказ
        DrinkOrder order = new DrinkOrder();
        order.setRecipe(recipe);
        orderRepository.save(order);

        // Возвращаем результат
        return DrinkResponseDTO.builder()
                .drinkName(drinkName)
                .usedIngredients(usedIngredients)
                .build();
    }
}