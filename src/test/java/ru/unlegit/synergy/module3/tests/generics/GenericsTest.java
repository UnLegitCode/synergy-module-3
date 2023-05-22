package ru.unlegit.synergy.module3.tests.generics;

import ru.unlegit.synergy.module3.generics.*;

public final class GenericsTest {

    public static void main(String[] args) {
        if (createSword(new Plastic()) == null) {
            System.out.println("Unable to create plastic sword");
        } else {
            System.out.println("Successfully created plastic sword");
        }

        Sword<?> steelSword = createSword(new Steel());

        if (steelSword == null) {
            System.out.println("Unable to create steel sword");
        } else if (steelSword.isEnduring()) {
            System.out.println("Steel sword is enduring");
        } else {
            System.out.println("Steel sword isn't enduring");
        }
    }

    private static <T extends Material> Sword<?> createSword(T material) {
        try {
            return new Sword<>((Metal) material);
        } catch (ClassCastException exception) {
            return null;
        }
    }
}