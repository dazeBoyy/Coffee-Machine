package com.project.coffee_machine.dto.response;

import lombok.Builder;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Builder
@Getter
@Setter
@Schema(description = "Информация о приготовленном напитке")
public class DrinkResponseDTO {
    @Schema(description = "Название напитка", example = "Капучино")
    private String drinkName;

    @Schema(description = "Использованные ингредиенты (название: количество)")
    private Map<String, Integer> usedIngredients;
}