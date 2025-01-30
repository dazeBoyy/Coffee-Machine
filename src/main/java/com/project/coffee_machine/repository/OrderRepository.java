package com.project.coffee_machine.repository;

import com.project.coffee_machine.model.DrinkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<DrinkOrder, Long> {
    @Query("SELECT r.name, COUNT(o.id) FROM DrinkOrder o JOIN o.recipe r GROUP BY r.name")
    List<Object[]> getPopularDrinks();
}