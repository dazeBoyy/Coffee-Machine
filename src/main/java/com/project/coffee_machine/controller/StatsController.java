package com.project.coffee_machine.controller;

import com.project.coffee_machine.dto.response.StatsResponseDTO;
import com.project.coffee_machine.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatsController {
    private final StatisticsService service;

    @Operation(summary = "Самый популярный напиток")
    @GetMapping("/most-popular")
    public StatsResponseDTO getMostPopularDrink() {
        return service.getMostPopularDrink();
    }
}
