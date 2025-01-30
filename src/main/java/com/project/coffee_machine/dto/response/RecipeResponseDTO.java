package com.project.coffee_machine.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Map;


@Data
@Builder
@Getter
@Setter
public class RecipeResponseDTO {
    @Schema(description = "ID рецепта", example = "1")
    private Long id;

    @Schema(description = "Название рецепта", example = "espresso")
    private String name;

    @Schema(
            description = "Ингредиенты и их количество",
            example = "{\"water\": 50, \"coffee\": 20}"
    )
    private Map<String, Integer> ingredients;
}