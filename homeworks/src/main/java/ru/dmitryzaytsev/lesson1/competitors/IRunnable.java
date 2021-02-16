package ru.dmitryzaytsev.lesson1.competitors;

/**
 * Интерфейс "Способность бегать"
 */
public interface IRunnable {
    /**
     * @param runLength - длина препятствия
     * @param maxRunLength - максимальная преодолимая длина, для сравнения
     * @param name - имя для вывода в консоль
     * @param type - тип для вывода в консоль
     * @return - boolean; true - если преодолел, false - если не преодолел
     */
    boolean run(int runLength, int maxRunLength, String name, String type);
}
