package ru.unlegit.synergy.module3.tests.stream2;

import ru.unlegit.synergy.module3.stream2.Address;
import ru.unlegit.synergy.module3.stream2.Student;

import java.util.Arrays;
import java.util.List;

public final class Stream2Test {

    public static void main(String[] args) {
        Student student1 = new Student("Vasya", new Address("Moscow", "Moscow"));
        Student student2 = new Student("Petya");

        printStudentInfo(student1);
        printStudentInfo(student2);

        //----------------------------------------------

        System.out.println();

        List<String> wordList = List.of("I", "love", "Java", "<3");

        System.out.println(Arrays.toString(wordList.toArray(String[]::new)));

        System.out.println(wordList.stream()
                .reduce("%s %s"::formatted)
                .orElse("")
        );
    }

    private static void printStudentInfo(Student student) {
        System.out.println(student.toString());
    }
}