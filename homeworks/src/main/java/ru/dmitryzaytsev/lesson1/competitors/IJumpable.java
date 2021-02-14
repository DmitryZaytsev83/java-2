package ru.dmitryzaytsev.lesson1.competitors;

/**
 * Интерфейс "Способность прыгать"
 */
public interface IJumpable {
    /**
     * @param height - высота препятствия
     * @param maxJumpHeight - максимальная преодолимая высота, для сравнения
     * @param name - имя для вывода в консоль
     * @param type - тип для вывода в консоль
     * @return - boolean; true - если преодолел, false - если не преодолел
     */
    boolean jump(int height, int maxJumpHeight, String name, String type);
}
