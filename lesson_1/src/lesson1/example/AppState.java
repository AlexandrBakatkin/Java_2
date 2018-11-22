package lesson1.example;

public enum AppState {
    INIT(5), PREPARE(2), WORK(4), SAVE(10), TERMINATE(1);

    private int priority;

    public int getPriority() {
        return priority;
    }

    AppState(int priority){
        this.priority = priority;
    }
}
