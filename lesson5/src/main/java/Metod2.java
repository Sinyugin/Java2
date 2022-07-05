public class Metod2 {

    static int size = 10_000_000;
    static final int h = size / 2;
    static float[] arr = new float[size]; // исходный массив
    static float[] newArr = new float[size]; // склеенный массив
    static float[] arr1 = new float[h]; //первая половина массива
    static float[] arr2 = new float[h]; //вторая половина массива

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start(); // запуск первого потока вычисляет первую половину массива
        t2.start(); // запуск второго потока вычисляет вторую половину массива

        System.arraycopy(arr1, 0, newArr, 0, h);
        System.arraycopy(arr2, 0, newArr, h, h);

        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() -
                startTime) + " ms.");


    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                        / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                        / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

}