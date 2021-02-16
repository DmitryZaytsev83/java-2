package ru.dmitryzaytsev.lesson1.competitors;

/**
 * Класс, реализующий поведение "Прыжок"
 */
public class JumpOverTheWall implements IJumpable {

    @Override
    public boolean jump(int height, int maxJumpHeight, String name, String type) {
        if (height <= maxJumpHeight) {
            System.out.printf("%s %s перепрыгнул %d\n", type, name, height);
            return true;
        } else {
            System.out.printf("%s %s не перепрыгнул %d и выбыл\n", type, name, height);
        }
        return false;
    }
}
