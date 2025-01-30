package com.project.coffee_machine.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Builder
@Schema(description = "Запрос на добавление ингредиента")
public class AddIngredientRequestDTO {
    @NotBlank
    @Schema(description = "Название ингредиента", example = "Шоколад")
    private String name;

    @Positive
    @Schema(description = "Количество", example = "500")
    private int quantity;
}