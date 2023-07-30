package ru.unlegit.synergy.module3.treemap;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class TreeMap<K, V> {

    public static <K, V> TreeMap<K, V> create(Comparator<K> keyComparator) {
        return new TreeMap<>(keyComparator);
    }

    /**
     * если тип ключа реализует интерфейс {@link Comparable}, то используем готовый компаратор
     */
    public static <K extends Comparable<K>, V> TreeMap<K, V> create() {
        return create(Comparator.<K>naturalOrder());
    }

    final Comparator<K> keyComparator;
    TreeNode<K, V> root;

    public void put(K key, V value) {
        if (root == null) {
            root = new TreeNode<>(key, value);
        } else {
            put(root, key, value);
        }
    }

    private void put(TreeNode<K, V> current, K key, V value) {
        int comparisonResult = keyComparator.compare(key, current.getKey());

        if (comparisonResult < 0) {
            if (current.hasLeft()) {
                put(current.getLeft(), key, value);
            } else {
                current.setLeft(new TreeNode<>(key, value));
            }
        } else if (comparisonResult == 0) {
            current.setValue(value);
        } else {
            if (current.hasRight()) {
                put(current.getRight(), key, value);
            } else {
                current.setRight(new TreeNode<>(key, value));
            }
        }
    }

    public V get(K key) {
        return Optional.ofNullable(get(root, key))
                .map(TreeNode::getValue)
                .orElse(null);
    }

    private TreeNode<K, V> get(TreeNode<K, V> current, K key) {
        if (current == null) return null;

        int comparisonResult = keyComparator.compare(key, current.getKey());

        if (comparisonResult < 0) return get(current.getLeft(), key);
        if (comparisonResult == 0) return current;

        return get(current.getRight(), key);
    }

    public void forEach(BiConsumer<K, V> handler) {
        forEach(root, handler);
    }

    private void forEach(TreeNode<K, V> current, BiConsumer<K, V> handler) {
        if (current == null) return;

        forEach(current.getLeft(), handler);
        handler.accept(current.getKey(), current.getValue());
        forEach(current.getRight(), handler);
    }

    public boolean containsKey(K key) {
        return get(root, key) != null;
    }

    public boolean containsValue(V value) {
        AtomicBoolean found = new AtomicBoolean();

        forEach((k, v) -> {
            if (Objects.equals(v, value)) {
                found.set(true);
            }
        });

        return found.get();
    }

    public void remove(K key) {
        if (root == null) return;

        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;

        while (current != null) {
            int comparisonResult = keyComparator.compare(key, current.getKey());

            if (comparisonResult == 0) break;

            parent = current;
            current = (comparisonResult < 0) ? current.getLeft() : current.getRight();
        }

        if (current == null) return;

        if (!current.hasRight()) {
            if (parent == null) {
                root = root.getLeft();
            } else {
                if (current == parent.getLeft()) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        } else {
            TreeNode<K, V> leftMost = current.getRight();
            parent = null;

            while (leftMost.hasLeft()) {
                parent = leftMost;
                leftMost = leftMost.getLeft();
            }

            if (parent != null) {
                parent.setLeft(leftMost.getRight());
            } else {
                current.setRight(leftMost.getRight());
            }

            current.setKey(leftMost.getKey());
            current.setValue(leftMost.getValue());
        }
    }
}