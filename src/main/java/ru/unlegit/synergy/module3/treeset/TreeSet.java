package ru.unlegit.synergy.module3.treeset;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import ru.unlegit.synergy.module3.Set;
import ru.unlegit.synergy.module3.treemap.TreeMap;

import java.util.Comparator;
import java.util.function.Consumer;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class TreeSet<T> implements Set<T> {

    private static final Object VALUE = new Object();

    public static <T> TreeSet<T> create(Comparator<T> comparator) {
        return new TreeSet<>(TreeMap.create(comparator));
    }

    public static <T extends Comparable<T>> TreeSet<T> create() {
        return new TreeSet<>(TreeMap.<T, Object>create());
    }

    private final TreeMap<T, Object> tree;

    @Override
    public void add(T value) {
        tree.put(value, VALUE);
    }

    @Override
    public void remove(T value) {
        tree.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return tree.containsKey(value);
    }

    @Override
    public void forEach(Consumer<T> handler) {
        tree.forEach((key, value) -> handler.accept(key));
    }
}