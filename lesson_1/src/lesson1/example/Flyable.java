package lesson1.example;

public interface Flyable {
    void fly();

    default void defaultFly(){
        System.out.println("defFly");
    }
}
