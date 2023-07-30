package ru.unlegit.synergy.module3;

import java.util.function.Consumer;

public interface Set<T> {

    void add(T value);

    void remove(T value);

    boolean contains(T value);

    void forEach(Consumer<T> handler);
}