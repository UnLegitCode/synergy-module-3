package ru.unlegit.synergy.module3.hashset;

import ru.unlegit.synergy.module3.Set;

import java.util.HashMap;
import java.util.function.Consumer;

public final class HashSet<T> implements Set<T> {

    private static final Object VALUE = new Object();

    private final HashMap<T, Object> table = new HashMap<>();

    @Override
    public void add(T value) {
        table.put(value, VALUE);
    }

    @Override
    public void remove(T value) {
        table.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return table.containsKey(value);
    }

    @Override
    public void forEach(Consumer<T> handler) {
        table.forEach((key, value) -> handler.accept(key));
    }
}