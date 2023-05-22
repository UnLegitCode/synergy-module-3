package ru.unlegit.synergy.module3.tests.list;

import ru.unlegit.synergy.module3.list.LinkedList;

public final class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("First value");
        list.add("Second value");
        list.add("Third value");

        System.out.println("Размер списка: " + list.size());
        System.out.println("Элемент по индексу 1: " + list.get(1));

        list.remove(1);

        System.out.println("Размер списка после удаления: " + list.size());
        System.out.println("Элемент по индексу 1 после удаления: " + list.get(1));
    }
}