public class SingleTaskArray {
    static final int size = 10000000;
    float[] arr = new float[size];

    public SingleTaskArray() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время выполнения задачи в одном потоке:");
        System.out.println(System.currentTimeMillis() - a + " ms");
    }
}
