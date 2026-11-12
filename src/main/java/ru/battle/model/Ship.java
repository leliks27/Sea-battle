package ru.battle.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    private final int size;
    private final List<Coordinate> coordinates = new ArrayList<>();
    private int hits = 0;

    public Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void addCoordinate(Coordinate coord) {
        coordinates.add(coord);
    }

    public void takeHit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= size;
    }

    // Полиморфный метод: каждый корабль сам возвращает своё описание
    public abstract String getShipType();
}