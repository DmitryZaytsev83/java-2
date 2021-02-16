package ru.dmitryzaytsev.lesson1.obstacles;

import java.util.Random;

/**
 * Класс "Полоса препятствий"
 * генерирует массив рандомных препятствий от 4 до 10 шт из enum Obstacle
 */
public class ObstacleCourse {
    private final IObstructing[] obstacles;

    public IObstructing[] getObstacles() {
        return obstacles;
    }

    public ObstacleCourse() {
        this.obstacles = new IObstructing[(new Random().nextInt(7)) + 4];
        for (int i = 0; i < obstacles.length; i++) {
            switch (Obstacle.getRandomObstacle()) {
                case WALL -> obstacles[i] = new Wall();
                case TRACK -> obstacles[i] = new Track();
            }

        }
    }
}
