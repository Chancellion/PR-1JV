package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }
}

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Данiїл Iванченко, КIб-1-23-4.0д:");
        UserService userService = new UserService();

        // Список користувачів
        userService.addUser(new User(1, "Тарас"));
        userService.addUser(new User(2, "Вiталя"));
        userService.addUser(new User(3, "Степан"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введiть ID користувача для пошуку: ");
        int searchId = scanner.nextInt();

        Optional<User> userOptional = userService.findUserById(searchId);

        userOptional.ifPresentOrElse(
                user -> System.out.println("Користувач знайдений: " + user.getName()),
                () -> System.out.println("Користувача з iдентифiкатором " + searchId + " не знайдено")
        );
    }
}
