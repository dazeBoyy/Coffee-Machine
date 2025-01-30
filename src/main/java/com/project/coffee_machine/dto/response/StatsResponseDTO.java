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
@Schema(description = "Статистика популярности напитка")
public class StatsResponseDTO {
    @Schema(description = "Название напитка", example = "Капучино")
    private String drinkName;

    @Schema(description = "Общее количество заказов", example = "42")
    private Long totalOrders;
}