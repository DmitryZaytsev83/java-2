package ru.dmitryzaytsev.lesson1.competitors;


/**
 * Класс, реализующий поведение "Бег"
 */
public class RunTheTrack implements IRunnable {

    @Override
    public boolean run(int runLength, int maxRunLength, String name, String type) {
        if (runLength <= maxRunLength) {
            System.out.printf("%s %s пробежал %d\n", type, name, runLength);
            return true;
        } else {
            System.out.printf("%s %s не пробежал %d  и выбыл\n", type, name, runLength);
        }
        return false;
    }
}
