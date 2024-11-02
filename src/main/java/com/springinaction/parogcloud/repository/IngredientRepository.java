package com.springinaction.parogcloud.repository;

import com.springinaction.parogcloud.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
