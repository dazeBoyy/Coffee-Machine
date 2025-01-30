package com.project.coffee_machine.dto.request;

import com.project.coffee_machine.dto.IngredientQuantityDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Data
@Getter
@Setter
@Builder
public class AddReceiptRequestDTO {
    @Schema(description = "Название рецепта", example = "espresso")
    private String name;

    @Schema(
            description = "Ингредиенты и их количество",
            example = "{\"water\": 50, \"coffee\": 20}"
    )
    private Map<String, Integer> ingredients;
}