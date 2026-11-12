package ru.battle;

import org.junit.jupiter.api.Test;
import ru.battle.model.*;
import ru.battle.player.BotPlayer;
import ru.battle.player.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    void testShipPlacementAndHit() {
        Board board = new Board();
        Ship boat = new PatrolBoat();
        Coordinate target = new Coordinate(2, 2);

        boolean placed = board.placeShip(boat, List.of(target));
        assertTrue(placed, "Корабль должен успешно встать на свободное место");

        ShotResult result = board.shoot(target);
        assertEquals(ShotResult.KILLED, result, "Однопалубный корабль должен быть потоплен с одного выстрела");
        assertTrue(board.isAllSunk(), "Все корабли на поле должны быть потоплены");
    }

    @Test
    void testMissShot() {
        Board board = new Board();
        Ship boat = new PatrolBoat();
        board.placeShip(boat, List.of(new Coordinate(0, 0)));

        ShotResult result = board.shoot(new Coordinate(5, 5));
        assertEquals(ShotResult.MISS, result, "Выстрел в пустую клетку должен быть промахом");
        assertFalse(board.isAllSunk());
    }

    @Test
    void testCoordinateValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(10, 0));
    }

    @Test
    void testPlayerPolymorphism() {
        Player player = new BotPlayer("Тестовый Бот");
        assertEquals("Тестовый Бот", player.getName());

        Coordinate move = player.makeMove();
        assertNotNull(move);
        assertTrue(move.getX() >= 0 && move.getX() <= 9);
        assertTrue(move.getY() >= 0 && move.getY() <= 9);
    }
}