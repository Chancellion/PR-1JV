package com.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        System.out.println("Введiть шлях до файлу або текст:");
        String input = scanner.nextLine();

        String text;
        if (Files.exists(Paths.get(input))) {
            text = new String(Files.readAllBytes(Paths.get(input)));
        } else {
            text = input;
        }

        List<String> words = Arrays.asList(text.split("\\W+"));

        System.out.println("Введiть лiтеру для фiльтрацiї слiв:");
        String letter = scanner.nextLine();

        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith(letter))
                .sorted()
                .collect(Collectors.toList());

        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Вiдфiльтрованi та вiдсортованi слова:");
        filteredWords.forEach(System.out::println);

        System.out.println("Кiлькiсть унiкальних слiв:");
        wordCount.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
