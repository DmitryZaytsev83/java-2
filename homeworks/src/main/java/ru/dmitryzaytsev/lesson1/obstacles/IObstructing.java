package ru.dmitryzaytsev.lesson1.obstacles;

/**
 * Интерфейс "Создающий препятствие"
 */
public interface IObstructing {
    /**
     * @return int - возвращает главную характеристику препятствия (длина, высота и тд.)
     */
    int getObstructingValue();
}
