package com.example;
import java.util.Scanner;

public class Task1 {
    @FunctionalInterface
    interface WordFinder {
        boolean find(String text, String word);
    }

    @FunctionalInterface
    interface WordReplacer {
        String replace(String text, String oldWord, String newWord);
    }

    @FunctionalInterface
    interface WordCounter {
        int count(String text);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        System.out.println("Текст:");
        String text = sc.nextLine();

        System.out.println("Операцiя над текстом:");
        System.out.println("1 - Пошук слова");
        System.out.println("2 - Змiна слова");
        System.out.println("3 - Пiдрахунок кiлькостi слiв");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1: {
                WordFinder finder = (t, w) -> t.contains(w);
                System.out.println("Яке слово шукаєм?");
                String word = sc.nextLine();
                boolean found = finder.find(text, word);
                System.out.println("Слово " + (found ? "знайдено" : "не знайдено"));
                break;
            }
            case 2: {
                WordReplacer replacer = (t, oldW, newW) -> t.replace(oldW, newW);
                System.out.println("Яке слово мiняєм?");
                String oldWord = sc.nextLine();
                System.out.println("На яке слово тодi мiняєм?");
                String newWord = sc.nextLine();
                text = replacer.replace(text, oldWord, newWord);
                System.out.println("Результат:");
                System.out.println(text);
                break;
            }
            case 3: {
                WordCounter counter = t -> {
                    if (t == null || t.trim().isEmpty()) return 0;
                    return t.trim().split("\\s+").length;
                };
                int count = counter.count(text);
                System.out.println("Кiлькiсть слiв: " + count);
                break;
            }
            default:
                System.out.println("Немає такої операцiї. От холєра.");
        }

        sc.close();
    }
}


