package ru.dmitryzaytsev.lesson5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        calcWithOneThread();
        try {
            calcWithTwoThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void calcWithOneThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) *
                    Math.cos(0.4f + (float) i / 2));
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    public static void calcWithTwoThreads() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);
        long start = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) *
                        Math.cos(0.4f + (float) i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (float) (i + HALF) / 5) * Math.cos(0.2f + (float) (i + HALF) / 5) *
                        Math.cos(0.4f + (float) (i + HALF) / 2));
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
