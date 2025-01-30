package com.project.coffee_machine.controller;

import com.project.coffee_machine.dto.request.AddReceiptRequestDTO;
import com.project.coffee_machine.dto.response.RecipeResponseDTO;
import com.project.coffee_machine.exceptions.DuplicateNameException;
import com.project.coffee_machine.exceptions.IngredientNotFoundException;
import com.project.coffee_machine.exceptions.InvalidIngredientException;
import com.project.coffee_machine.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Tag(name = "Рецепты", description = "Управление рецептами кофемашины")
public class RecipeController {
    private final RecipeService recipeService;

    @Operation(
            summary = "Создать новый рецепт",
            description = "Добавляет новый рецепт с указанными ингредиентами и их количеством."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Рецепт успешно создан"),
            @ApiResponse(responseCode = "400", description = "Неверные данные запроса"),
            @ApiResponse(responseCode = "409", description = "Рецепт с таким названием уже существует")
    })
    @PostMapping
    public ResponseEntity<RecipeResponseDTO> addRecipe(
            @Valid @RequestBody AddReceiptRequestDTO request
    ) {
        RecipeResponseDTO response = recipeService.addRecipe(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Получить все рецепты",
            description = "Возвращает список всех рецептов с их ингредиентами."
    )
    @GetMapping
    public List<RecipeResponseDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @ExceptionHandler(DuplicateNameException.class)
    public ResponseEntity<String> handleDuplicateName(DuplicateNameException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public ResponseEntity<String> handleIngredientNotFound(IngredientNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}