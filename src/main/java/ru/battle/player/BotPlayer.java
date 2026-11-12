package ru.battle.player;

import ru.battle.model.Coordinate;
import java.util.Random;

public class BotPlayer implements Player {
    private final String name;
    private final Random random = new Random();

    public BotPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinate makeMove() {
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return new Coordinate(x, y);
    }
}