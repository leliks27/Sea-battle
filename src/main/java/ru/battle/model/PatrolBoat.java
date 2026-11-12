package ru.battle.model;

public class PatrolBoat extends Ship {
    public PatrolBoat() {
        super(1); // 1 палуба
    }

    @Override
    public String getShipType() {
        return "Катер (1 палуба)";
    }
}