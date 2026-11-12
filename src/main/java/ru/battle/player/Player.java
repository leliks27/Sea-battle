package ru.battle.player;

import ru.battle.model.Coordinate;

public interface Player {
    String getName();
    Coordinate makeMove();
}