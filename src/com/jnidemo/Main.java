package com.jnidemo;

public class Main {
    private static native void goThere(int[] array, WriteStartedStatus status);

    private static int[] arrayForTest = new int[15];
    private static WriteStartedStatus writeStatus = new WriteStartedStatus();

    public static void main(String[] args) {
        System.loadLibrary("TestLib");

        SomeThread thread = new SomeThread();
        thread.start();

        goThere(arrayForTest, writeStatus);

        writeStatus.setIsInWriteStatus(0);
        Sleep(2000);

        System.out.println("Final array: \n");
        for (int element : arrayForTest) {
            System.out.println(element + "\n");
        }
    }

    public static class SomeThread extends Thread {
        public void run() {
            System.out.println("Thread has started!");

            // Wait for is writing event
            while (writeStatus.getIsInWriteStatus() == 0) {
            }

            int sum;
            while (writeStatus.getIsInWriteStatus() != 0) {
                sum = 0;
                for (int element : arrayForTest) {
                    sum += element;
                    System.out.println("SUM of elements: " + sum);
                }
            }

            System.out.println("Thread has ended!");
        }
    }

    private static void Sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class WriteStartedStatus {
        private int isInWrite = 0;

        public void setIsInWriteStatus(int status) {
            this.isInWrite = status;

        }

        public int getIsInWriteStatus() {
            return this.isInWrite;
        }
    }
}
