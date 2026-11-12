package ru.battle.model;

public enum ShotResult {
    MISS("Мимо"),
    HIT("Ранил"),
    KILLED("Убил"),
    ALREADY_SHOT("В эту клетку уже стреляли!");

    private final String description;

    ShotResult(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}