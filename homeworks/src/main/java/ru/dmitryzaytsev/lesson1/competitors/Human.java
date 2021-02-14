package ru.dmitryzaytsev.lesson1.competitors;

import ru.dmitryzaytsev.lesson1.obstacles.IObstructing;

import java.util.Random;

public class Human implements IOvercomingObstacles {
    private final String name;
    private final int maxRunLength;
    private final int maxJumpHeight;
    private boolean competeAble;

    private final IRunnable runBehavior;
    private final IJumpable jumpBehavior;

    public boolean isCompeteAble() {
        return competeAble;
    }

    public Human(String name, IRunnable runnable, IJumpable jumpable) {
        this.name = name;
        this.maxRunLength = new Random().nextInt(4) * 100 + 700;
        maxJumpHeight = new Random().nextInt(4) + 2;
        runBehavior = runnable;
        jumpBehavior = jumpable;
        competeAble = true;
    }

    private boolean performRun(int length) {
        return runBehavior.run(length, maxRunLength, name, this.getClass().getSimpleName());
    }

    private boolean performJump(int height) {
        return jumpBehavior.jump(height, maxJumpHeight, name, this.getClass().getSimpleName());
    }

    @Override
    public void overcomeObstacle(IObstructing obstacle) {
        switch (obstacle.getClass().getSimpleName()) {
            case "Track" -> {
                if (!performRun(obstacle.getObstructingValue())) competeAble = false;
            }
            case "Wall" -> {
                if (!performJump(obstacle.getObstructingValue())) competeAble = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Человек {" +
                "Имя: '" + name + '\'' +
                ", может пробежать: " + maxRunLength +
                ", может перепрыгнуть: " + maxJumpHeight +
                '}';
    }
}
