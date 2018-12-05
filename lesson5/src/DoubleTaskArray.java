public class DoubleTaskArray {
    static final int size = 10000000;
    static final int h = size/2;
    float[] arr = new float[size];

    public DoubleTaskArray(){
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - a + " ms");
    }
}
