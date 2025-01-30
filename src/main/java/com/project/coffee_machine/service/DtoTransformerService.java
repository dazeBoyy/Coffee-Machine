package com.project.coffee_machine.service;

import com.project.coffee_machine.dto.IngredientQuantityDTO;
import com.project.coffee_machine.dto.request.AddReceiptRequestDTO;
import com.project.coffee_machine.dto.response.RecipeResponseDTO;
import com.project.coffee_machine.model.Recipe;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Getter
@Builder
@Setter
public class DtoTransformerService {

    public Recipe toEntity(AddReceiptRequestDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setName(dto.getName());
        recipe.setIngredients(dto.getIngredients()); // Map<String, Integer>
        return recipe;
    }

    public RecipeResponseDTO toDto(Recipe recipe) {
        return RecipeResponseDTO.builder()
                .id(recipe.getId())
                .name(recipe.getName())
                .ingredients(recipe.getIngredients()) // Map<String, Integer>
                .build();
    }
}