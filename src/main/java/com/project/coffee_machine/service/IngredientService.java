package com.project.coffee_machine.service;

import com.project.coffee_machine.dto.request.AddIngredientRequestDTO;
import com.project.coffee_machine.dto.response.IngredientResponseDTO;
import com.project.coffee_machine.exceptions.IngredientAlreadyExistsException;
import com.project.coffee_machine.model.Ingredient;
import com.project.coffee_machine.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Transactional
    public IngredientResponseDTO addIngredient(AddIngredientRequestDTO dto) {
        if (ingredientRepository.findByName(dto.getName()).isPresent()) {
            throw new IngredientAlreadyExistsException(dto.getName());
        }

        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getName());
        ingredient.setQuantity(dto.getQuantity());

        Ingredient savedIngredient = ingredientRepository.save(ingredient);

        return IngredientResponseDTO.builder()
                .id(savedIngredient.getId())
                .name(savedIngredient.getName())
                .quantity(savedIngredient.getQuantity())
                .build();
    }

    public List<IngredientResponseDTO> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(ingredient -> IngredientResponseDTO.builder()
                        .id(ingredient.getId())
                        .name(ingredient.getName())
                        .quantity(ingredient.getQuantity())
                        .build())
                .toList();
    }
}