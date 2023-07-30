package ru.unlegit.synergy.module3.priorityqueue;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
final class QueueNode<T> {

    final T value;
    QueueNode<T> next;

    public boolean hasNext() {
        return next != null;
    }
}