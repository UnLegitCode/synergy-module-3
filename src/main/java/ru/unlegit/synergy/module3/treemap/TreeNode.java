package ru.unlegit.synergy.module3.treemap;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
final class TreeNode<K, V> {

    K key;
    V value;
    TreeNode<K, V> left;
    TreeNode<K, V> right;

    TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }
}