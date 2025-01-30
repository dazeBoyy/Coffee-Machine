package com.project.coffee_machine.dto.response;


import lombok.Builder;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
@Getter
@Setter
@Schema(description = "Ответ с данными ингредиента")
public class IngredientResponseDTO {
    @Schema(description = "ID ингредиента", example = "1")
    private Long id;

    @Schema(description = "Название ингредиента", example = "Кофе")
    private String name;

    @Schema(description = "Доступное количество", example = "500")
    private int quantity;
}