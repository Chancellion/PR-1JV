package com.example.app;

import com.example.model.Person;
import com.example.service.PersonService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        PersonService personService = new PersonService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Додати особу");
            System.out.println("2. Видалити особу");
            System.out.println("3. Знайти особу за ID");
            System.out.println("4. Показати всiх осiб");
            System.out.println("5. Вийти");
            System.out.print("Виберiть опцiю: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Введiть ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Введiть iм'я: ");
                    String name = scanner.nextLine();
                    System.out.print("Введiть вiк: ");
                    int age = scanner.nextInt();
                    personService.addPerson(new Person(id, name, age));
                    break;
                case 2:
                    System.out.print("Введiть ID для видалення: ");
                    int removeId = scanner.nextInt();
                    personService.removePerson(removeId);
                    break;
                case 3:
                    System.out.print("Введiть ID для пошуку: ");
                    int searchId = scanner.nextInt();
                    Optional<Person> personOptional = personService.findPersonById(searchId);
                    personOptional.ifPresentOrElse(
                            person -> System.out.println("Знайдено: " + person),
                            () -> System.out.println("Особа з ID " + searchId + " не знайдена")
                    );
                    break;
                case 4:
                    System.out.println("Список всiх осiб:");
                    personService.getAllPersons().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Вихiд...");
                    return;
                default:
                    System.out.println("Невiрна опцiя. Спробуйте ще раз.");
            }
        }
    }
}
