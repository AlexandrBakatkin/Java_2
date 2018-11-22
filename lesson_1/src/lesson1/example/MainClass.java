package lesson1.example;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        Flyable f = new Flyable() {
            @Override
            public void fly() {
                System.out.println("fly-fly-fly");
            }
        };

        f.fly();

        System.out.println(f.getClass().getName());

        Flyable f2 = new Flyable() {
            @Override
            public void fly() {
                System.out.println("fly-fly-fly");
            }
        };

        f2.fly();

        System.out.println(f2.getClass().getName());

        JButton jb1 = new JButton("Button #1");
        jb1.addActionListener(new JButton1Action());

        jb1.addActionListener(e -> System.out.println("CLICKED!!!"));



//        SOuter.SInner si = new SOuter.SInner();
//
//
//        class Point {
//            int x;
//            int y;
//
//            public Point(int x, int y) {
//                this.x = x;
//                this.y = y;
//            }
//        }
//
//
//        Point p = new Point(10,10);




//        Outer outer = new Outer(20);
//        Outer.Inner inner = new Outer(10).new Inner(30);
//        Outer.Inner inner2 = outer.new Inner(30);
    }

//    static AppState appState = AppState.INIT;
//
//    public static void main(String[] args) {
//        System.out.println(appState.getPriority());
//        appState = AppState.WORK;
//        System.out.println(appState.getPriority());
//    }


//    public static void main(String[] args) {
//        Animal a = new Cat();
//        Flyable f = new Parrot();
//        f.fly();
//        f.defaultFly();
//        ((Parrot)f).voice();
//        Predator[] predators = {new Cat(), new Cat(), new Cat()};
//    }
}
