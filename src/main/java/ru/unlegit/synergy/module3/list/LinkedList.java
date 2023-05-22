package ru.unlegit.synergy.module3.list;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class LinkedList<T> {

    Node<T> head;
    int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
        } else {
            Node<T> currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = node;
        }

        size++;
    }

    public T get(int index) {
        checkIndex(index);

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> previousNode = head;

            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.next;
            }

            previousNode.next = previousNode.next.next;
        }

        size--;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }
}