package ru.unlegit.synergy.module3.tests.treemap;

import ru.unlegit.synergy.module3.treemap.TreeMap;

public final class TreeMapTest {

    private static final String SEPARATION_LINE = "\n".concat("-".repeat(50)).concat("\n");

    public static void main(String[] args) {
        TreeMap<String, String> tree = TreeMap.create();

        tree.put("First key", "First value");
        tree.put("Second key", "Second value");
        tree.put("Third key", "Third value");

        System.out.println();

        print(tree);

        System.out.println(SEPARATION_LINE);

        System.out.println("Значение по первому ключу: ".concat(tree.get("First key")));
        System.out.println("Значение по второму ключу: ".concat(tree.get("Second key")));
        System.out.println("Значение по третьему ключу: ".concat(tree.get("Third key")));

        System.out.println(SEPARATION_LINE);

        tree.remove("Second key");

        print(tree);

        System.out.println(SEPARATION_LINE);

        System.out.println("Значение по первому ключу: " + tree.get("First key"));
        System.out.println("Значение по второму ключу: " + tree.get("Second key"));
        System.out.println("Значение по третьему ключу: " + tree.get("Third key"));
    }

    private static <K, V> void print(TreeMap<K, V> tree) {
        tree.forEach((key, value) -> System.out.printf("%s: %s %n", key, value));
    }
}