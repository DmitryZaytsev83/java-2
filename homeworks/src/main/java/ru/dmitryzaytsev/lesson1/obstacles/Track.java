package ru.dmitryzaytsev.lesson1.obstacles;

import java.util.Random;

/**
 * Класс "Беговая дорожка"
 * при создании генерирует длину от 100 до 1000
 */
public class Track implements IObstructing {

    private final int length;

    public Track() {
        this.length = (new Random().nextInt(10) * 100) + 100;
    }

    @Override
    public int getObstructingValue() {
        return length;
    }

    @Override
    public String toString() {
        return "Беговая дорожка {" + "длина: " + length + '}';
    }
}
