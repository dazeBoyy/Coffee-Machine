package com.project.coffee_machine.controller;

import com.project.coffee_machine.dto.request.AddIngredientRequestDTO;
import com.project.coffee_machine.dto.response.IngredientResponseDTO;
import com.project.coffee_machine.service.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService service;

    @Operation(summary = "Добавить ингредиент", description = "Пополняет запасы ингредиента")
    @PostMapping
    public IngredientResponseDTO addIngredient(@Valid @RequestBody AddIngredientRequestDTO request) {
        return service.addIngredient(request);
    }

    @Operation(summary = "Получить все ингредиенты")
    @GetMapping
    public List<IngredientResponseDTO> getAllIngredients() {
        return service.getAllIngredients();
    }
}