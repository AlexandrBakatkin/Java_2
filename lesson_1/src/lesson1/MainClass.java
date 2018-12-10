package lesson1;

import lesson1.Competitors.*;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class MainClass {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Cat ("Пушистик"), new Dog ("Рэкс")};
        Obstacle[] obstacles = {new Cross(400), new Wall(2), new Water(1)};


       /* for (Competitor c : competitors) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }

        System.out.println("========================");
        for (Competitor c : competitors) {
            c.showResult();
        }*/

       //Team team = new Team("DINAMO", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Cat ("Пушистик"));
        //
        Team team = new Team("Динамо", competitors);
        Course course = new Course(obstacles);

        team.teamInfo();        //общая информация о команде
        System.out.println("____________________");
        course.doIt(team);      //команда проходит полосу препятствий
        System.out.println("_____________________");
        team.teamInfo();
        System.out.println("________________");
        team.showResult();      //результаты прохождения всех участников команды
        System.out.println("________________");
        team.winCompetitor();   //участники, которые прошли полосу препятствий
    }
}