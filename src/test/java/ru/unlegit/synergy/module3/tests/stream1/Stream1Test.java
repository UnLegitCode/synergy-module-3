package ru.unlegit.synergy.module3.tests.stream1;

import ru.unlegit.synergy.module3.stream1.Phone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class Stream1Test {

    public static void main(String[] args) {
        List<Phone> phones = List.of(
                new Phone("Honor", "9 Lite", 11_000),
                new Phone("Apple", "IPhone X", 50_000),
                new Phone("Techno", "Spark 8C", 12_000),
                new Phone("Apple", "IPhone 6", 5_000)
        );

        System.out.println(Arrays.toString(phones.toArray(Phone[]::new)));

        List<Phone> applePhones = phones.stream()
                .filter(phone -> phone.producer().equals("Apple"))
                .toList();

        System.out.println(Arrays.toString(applePhones.toArray(Phone[]::new)));

        List<Phone> phonesAscendingSortedByPrice = phones.stream()
                .sorted()
                .toList();

        System.out.println(Arrays.toString(phonesAscendingSortedByPrice.toArray(Phone[]::new)));

        List<Phone> phonesDescendingSortedByPrice = phones.stream()
                .sorted(Comparator.<Phone>naturalOrder().reversed())
                .toList();

        System.out.println(Arrays.toString(phonesDescendingSortedByPrice.toArray(Phone[]::new)));
    }
}