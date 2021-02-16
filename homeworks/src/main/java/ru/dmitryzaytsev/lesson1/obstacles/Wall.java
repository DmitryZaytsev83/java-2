package ru.dmitryzaytsev.lesson1.obstacles;

import java.util.Random;

/**
 * Класс "Стена"
 * при создании генерирует высоту от 1 до 5
 */
public class Wall implements IObstructing {
    private final int height;

    public Wall() {
        this.height = new Random().nextInt(5) + 1;
    }

    @Override
    public int getObstructingValue() {
        return height;
    }

    @Override
    public String toString() {
        return "Стена {" + "высота: " + height + '}';
    }
}
