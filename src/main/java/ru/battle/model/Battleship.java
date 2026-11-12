package ru.battle.model;

public class Battleship extends Ship {
    public Battleship() {
        super(4); // 4 палубы
    }

    @Override
    public String getShipType() {
        return "Линкор (4 палубы)";
    }
}