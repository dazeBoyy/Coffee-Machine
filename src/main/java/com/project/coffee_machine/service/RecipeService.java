package com.project.coffee_machine.service;

import com.project.coffee_machine.dto.IngredientQuantityDTO;
import com.project.coffee_machine.dto.request.AddReceiptRequestDTO;
import com.project.coffee_machine.dto.response.RecipeResponseDTO;
import com.project.coffee_machine.exceptions.*;
import com.project.coffee_machine.model.Ingredient;
import com.project.coffee_machine.model.Recipe;
import com.project.coffee_machine.repository.IngredientRepository;
import com.project.coffee_machine.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final DtoTransformerService dtoTransformer;

    @Transactional
    public RecipeResponseDTO addRecipe(AddReceiptRequestDTO recipeDto) {
        // Проверка уникальности имени рецепта
        if (recipeRepository.findByName(recipeDto.getName()).isPresent()) {
            throw new DuplicateNameException("Рецепт '" + recipeDto.getName() + "' уже существует");
        }

        // Получаем названия всех ингредиентов из запроса
        Set<String> requiredIngredients = recipeDto.getIngredients().keySet();

        // Проверка существования ингредиентов в базе данных
        List<Ingredient> existingIngredients = ingredientRepository.findByNameIn(requiredIngredients);

        // Собираем названия существующих ингредиентов
        Set<String> existingNames = existingIngredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toSet());

        // Находим отсутствующие ингредиенты
        Set<String> missingIngredients = requiredIngredients.stream()
                .filter(name -> !existingNames.contains(name))
                .collect(Collectors.toSet());

        if (!missingIngredients.isEmpty()) {
            throw new IngredientNotFoundException("Отсутствуют ингредиенты: " + missingIngredients);
        }

        // Преобразуем DTO в сущность Recipe
        Recipe recipe = dtoTransformer.toEntity(recipeDto);

        // Сохраняем рецепт в базу данных
        Recipe savedRecipe = recipeRepository.save(recipe);

        // Преобразуем сущность Recipe в DTO для ответа
        return dtoTransformer.toDto(savedRecipe);
    }

    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(recipe -> RecipeResponseDTO.builder()
                        .id(recipe.getId())
                        .name(recipe.getName())
                        .ingredients(recipe.getIngredients())
                        .build())
                .toList();
    }
}