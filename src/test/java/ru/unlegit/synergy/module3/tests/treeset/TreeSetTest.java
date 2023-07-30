package ru.unlegit.synergy.module3.tests.treeset;

import ru.unlegit.synergy.module3.treeset.TreeSet;

public final class TreeSetTest {

    private static final String SEPARATION_LINE = "\n".concat("-".repeat(50)).concat("\n");

    public static void main(String[] args) {
        TreeSet<String> set = TreeSet.create();

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");

        System.out.println();

        set.forEach(System.out::println);

        System.out.println(SEPARATION_LINE);

        System.out.println("Результат проверки содержания значения One: " + set.contains("One"));
        System.out.println("Результат проверки содержания значения Two: " + set.contains("Two"));
        System.out.println("Результат проверки содержания значения Three: " + set.contains("Three"));
        System.out.println("Результат проверки содержания значения Four: " + set.contains("Four"));
        System.out.println("Результат проверки содержания значения Five: " + set.contains("Five"));
        System.out.println("Результат проверки содержания значения Six: " + set.contains("Six"));

        System.out.println(SEPARATION_LINE);

        set.remove("Two");
        set.remove("Five");

        set.forEach(System.out::println);
    }
}