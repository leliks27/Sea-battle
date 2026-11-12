package ru.battle.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
    private final List<Ship> ships = new ArrayList<>();
    private final Set<Coordinate> firedShots = new HashSet<>();

    public boolean placeShip(Ship ship, List<Coordinate> coords) {
        if (coords.size() != ship.getSize()) {
            return false;
        }

        // Проверка: клетка уже занята другим кораблём
        for (Coordinate c : coords) {
            for (Ship existing : ships) {
                if (existing.getCoordinates().contains(c)) {
                    return false;
                }
            }
        }

        for (Coordinate c : coords) {
            ship.addCoordinate(c);
        }
        ships.add(ship);
        return true;
    }

    public ShotResult shoot(Coordinate target) {
        if (firedShots.contains(target)) {
            return ShotResult.ALREADY_SHOT;
        }
        firedShots.add(target);

        for (Ship ship : ships) {
            if (ship.getCoordinates().contains(target)) {
                ship.takeHit();
                if (ship.isSunk()) {
                    return ShotResult.KILLED;
                }
                return ShotResult.HIT;
            }
        }
        return ShotResult.MISS;
    }

    public boolean isAllSunk() {
        if (ships.isEmpty()) return false;
        for (Ship ship : ships) {
            if (!ship.isSunk()) return false;
        }
        return true;
    }
}