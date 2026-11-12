package ru.battle.player;

import ru.battle.model.Coordinate;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String name;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinate makeMove() {
        while (true) {
            try {
                System.out.print(name + ", введите координаты выстрела (X и Y от 0 до 9 через пробел): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                return new Coordinate(x, y);
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите два числа от 0 до 9.");
                scanner.nextLine(); // сброс некорректного ввода
            }
        }
    }
}