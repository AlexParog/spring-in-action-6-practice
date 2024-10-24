package com.springinaction.parogcloud.entity;

import lombok.Data;

/**
 * Класс, представляющий ингредиенты тако.
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public enum Type {
        WRAR, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
