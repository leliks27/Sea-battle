package ru.battle;

import ru.battle.model.*;
import ru.battle.player.BotPlayer;
import ru.battle.player.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("    МОРСКОЙ БОЙ: ДЕМО РЕЖИМ");

        // 1. Создаем поле и расставляем корабли
        Board board = new Board();
        Ship boat = new PatrolBoat();
        Ship battleship = new Battleship();

        // Ставим катер на (2, 2)
        board.placeShip(boat, List.of(new Coordinate(2, 2)));
        System.out.println("Размещен: " + boat.getShipType() + " в клетке (2, 2)");

        // 2. Создаем игрока (полиморфизм: тип ссылки Player, объект BotPlayer)
        Player bot = new BotPlayer("Терминатор");
        System.out.println("В игру вступил противник: " + bot.getName());

        // 3. Делаем несколько пробных выстрелов
        System.out.println("\n--- Начинаем симуляцию стрельбы ---");

        // Прямой выстрел в катер
        Coordinate target = new Coordinate(2, 2);
        System.out.println("Выстрел по точке (2, 2)...");
        ShotResult result1 = board.shoot(target);
        System.out.println("Результат: " + result1); // Должно вывести KILLED

        // Выстрел в пустую клетку
        Coordinate missTarget = new Coordinate(0, 0);
        System.out.println("\nВыстрел по точке (0, 0)...");
        ShotResult result2 = board.shoot(missTarget);
        System.out.println("Результат: " + result2); // Должно вывести MISS

        // Бот делает случайный выстрел
        Coordinate botMove = bot.makeMove();
        System.out.println("\nБот выбрал случайную цель: (" + botMove.getX() + ", " + botMove.getY() + ")");
        ShotResult botResult = board.shoot(botMove);
        System.out.println("Результат выстрела бота: " + botResult);

        // Проверяем, победа или нет
        System.out.println("\nФлот уничтожен? " + (board.isAllSunk() ? "Да" : "Нет")); //чтобы не было тру фолс на англ решил через тернарный оператор русофицировать
    }
}