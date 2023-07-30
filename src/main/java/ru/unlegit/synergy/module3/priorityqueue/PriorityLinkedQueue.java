package ru.unlegit.synergy.module3.priorityqueue;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Comparator;
import java.util.function.Consumer;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class PriorityLinkedQueue<T> {

    public static <T> PriorityLinkedQueue<T> create(Comparator<T> comparator) {
        return new PriorityLinkedQueue<>(comparator);
    }

    public static <T extends Comparable<T>> PriorityLinkedQueue<T> create() {
        return create(Comparator.<T>naturalOrder());
    }

    final Comparator<T> comparator;
    QueueNode<T> root;

    public void push(T value) {
        QueueNode<T> newNode = new QueueNode<>(value);

        if (root == null) {
            root = newNode;
        } else if (comparator.compare(value, root.getValue()) > 0) {
            QueueNode<T> oldRoot = root;
            root = newNode;
            newNode.setNext(oldRoot);
        } else {
            QueueNode<T> current = root;

            while (comparator.compare(value, current.getValue()) <= 0 && current.hasNext()) {
                current = current.getNext();
            }

            QueueNode<T> oldNext = current.getNext();

            current.setNext(newNode);
            newNode.setNext(oldNext);
        }
    }

    public T poll() {
        if (root == null) return null;

        T oldHead = root.getValue();

        root = root.getNext();

        return oldHead;
    }

    public void forEach(Consumer<T> handler) {
        QueueNode<T> current = root;

        while (current != null) {
            handler.accept(current.getValue());
            current = current.getNext();
        }
    }
}