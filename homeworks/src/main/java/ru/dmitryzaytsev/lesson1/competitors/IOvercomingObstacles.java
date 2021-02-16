package ru.dmitryzaytsev.lesson1.competitors;

import ru.dmitryzaytsev.lesson1.obstacles.IObstructing;

/**
 * Интерфейс "Способность преодолевать препятствия"
 */
public interface IOvercomingObstacles {

    /**
     * @param obstacle - препятствие
     */
    void overcomeObstacle(IObstructing obstacle);

    /**
     * @return boolean - способность дальше продолжать преодолевать препятствия
     */
    boolean isCompeteAble();
}
