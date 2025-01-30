package com.project.coffee_machine.service;

import com.project.coffee_machine.dto.response.StatsResponseDTO;
import com.project.coffee_machine.exceptions.NoOrdersFoundException;
import com.project.coffee_machine.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final OrderRepository orderRepository;

    public StatsResponseDTO getMostPopularDrink() {
        List<Object[]> stats = orderRepository.getPopularDrinks();

        if (stats.isEmpty()) {
            throw new NoOrdersFoundException();
        }

        Object[] result = stats.get(0);
        return StatsResponseDTO.builder()
                .drinkName((String) result[0])
                .totalOrders((Long) result[1])
                .build();
    }
}