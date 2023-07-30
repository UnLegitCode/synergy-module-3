package ru.unlegit.synergy.module3.stream1;

import lombok.NonNull;

public record Phone(String producer, String model, int price) implements Comparable<Phone> {

    @Override
    public int compareTo(@NonNull Phone other) {
        return Integer.compare(price, other.price);
    }

    @Override
    public String toString() {
        return "%s %s: %d".formatted(producer, model, price);
    }
}