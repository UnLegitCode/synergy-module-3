package ru.unlegit.synergy.module3.tests.priorityqueue;

import ru.unlegit.synergy.module3.priorityqueue.PriorityLinkedQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public final class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityLinkedQueue<Integer> queue = PriorityLinkedQueue.create();

        queue.push(5);
        queue.push(3);
        queue.push(7);
        queue.push(0);
        queue.push(10);

        System.out.println();
        System.out.println(Arrays.toString(collect(queue, Integer[]::new)));

        System.out.println();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println();

        System.out.println(Arrays.toString(collect(queue, Integer[]::new)));

        System.out.println();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static <T> T[] collect(PriorityLinkedQueue<T> queue, IntFunction<T[]> arrayConstructor) {
        List<T> list = new ArrayList<>();

        queue.forEach(list::add);

        return list.toArray(arrayConstructor);
    }
}