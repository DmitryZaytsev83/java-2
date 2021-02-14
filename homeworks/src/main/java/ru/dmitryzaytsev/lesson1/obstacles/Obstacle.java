package ru.dmitryzaytsev.lesson1.obstacles;

import java.util.Random;

public enum Obstacle {
    WALL, TRACK;

    public static Obstacle getRandomObstacle() {
        return values()[(new Random()).nextInt(ru.dmitryzaytsev.lesson1.obstacles.Obstacle.values().length)];
    }
}
