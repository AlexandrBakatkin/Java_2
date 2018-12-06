public class ArrThread extends Thread {
    private float [] arrThread;

    public ArrThread(float[] arrThread) {
        this.arrThread = arrThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < arrThread.length; i++) {
            arrThread[i] = (float)(arrThread[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}