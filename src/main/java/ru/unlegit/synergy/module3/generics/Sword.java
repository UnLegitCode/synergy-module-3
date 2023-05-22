package ru.unlegit.synergy.module3.generics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class Sword<T extends Metal> {

    private final T material;

    public boolean isEnduring() {
        return material.getEndurance() > 49;
    }
}