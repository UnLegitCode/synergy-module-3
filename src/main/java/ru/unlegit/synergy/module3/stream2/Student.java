package ru.unlegit.synergy.module3.stream2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class Student {

    String name;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    Optional<Address> address;

    public Student(String name, Address address) {
        this.name = name;
        this.address = Optional.ofNullable(address);
    }

    public Student(String name) {
        this.name = name;
        this.address = Optional.empty();
    }

    @Override
    public String toString() {
        return name.concat(address
                .map(addr -> " (%s, %s)".formatted(addr.city(), addr.region()))
                .orElse("")
        );
    }
}