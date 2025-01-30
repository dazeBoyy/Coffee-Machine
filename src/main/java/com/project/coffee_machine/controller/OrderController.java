package com.project.coffee_machine.controller;


import com.project.coffee_machine.dto.response.DrinkResponseDTO;
import com.project.coffee_machine.dto.response.RecipeResponseDTO;
import com.project.coffee_machine.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @Operation(summary = "Приготовить напиток", description = "Списание ингредиентов по рецепту")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Напиток готов"),
            @ApiResponse(responseCode = "400", description = "Недостаточно ингредиентов")
    })
    @PostMapping
    public DrinkResponseDTO makeDrink(@RequestParam String drinkName) {
        return service.makeDrink(drinkName);
    }
}