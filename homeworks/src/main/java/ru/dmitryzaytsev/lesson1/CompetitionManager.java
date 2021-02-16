package ru.dmitryzaytsev.lesson1;

import ru.dmitryzaytsev.lesson1.competitors.*;
import ru.dmitryzaytsev.lesson1.obstacles.IObstructing;
import ru.dmitryzaytsev.lesson1.obstacles.ObstacleCourse;

public class CompetitionManager {
    public static void main(String[] args) {
        System.out.println("Наши конкурсанты: ");
        IOvercomingObstacles[] competitors = new IOvercomingObstacles[]{
                new Human("Петр", new RunTheTrack(), new JumpOverTheWall()),
                new Human("Василий", new RunTheTrack(), new JumpOverTheWall()),
                new Cat("Барсик", new RunTheTrack(), new JumpOverTheWall()),
                new Cat("Мурзик", new RunTheTrack(), new JumpOverTheWall()),
                new Robot("Вертер", new RunTheTrack(), new JumpOverTheWall()),
                new Robot("Бендер", new RunTheTrack(), new JumpOverTheWall()),
        };
        for (IOvercomingObstacles competitor : competitors) {
            System.out.println(competitor);
        }
        System.out.println();

        System.out.println("Наша полоса препятствий:");
        IObstructing[] obstacles = new ObstacleCourse().getObstacles();
        for (IObstructing obstacle : obstacles) {
            System.out.println(obstacle);
        }
        System.out.println();

        System.out.println("Соревнование началось:");
        for (IObstructing obstacle : obstacles) {
            System.out.println(obstacle);
            for (IOvercomingObstacles competitor : competitors) {
                if (competitor.isCompeteAble()) competitor.overcomeObstacle(obstacle);
            }
            System.out.println();
        }

        System.out.println("Сегодня полосу препятствий прошли:");
        for (IOvercomingObstacles competitor : competitors) {
            if (competitor.isCompeteAble()) {
                System.out.println(competitor);
            }
        }
    }
}
