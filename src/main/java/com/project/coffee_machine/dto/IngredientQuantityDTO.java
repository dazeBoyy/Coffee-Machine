package com.project.coffee_machine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class IngredientQuantityDTO {
    @NotBlank
    @Schema(description = "Название ингредиента", example = "Молоко")
    private String name;

    @Positive
    @Schema(description = "Количество", example = "100")
    private Integer quantity;
}
