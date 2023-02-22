package com.jnidemo;

public class Main {

    private static native String goThere(MessageProvider messageProvider);

    public static void main(String[] args) {
        System.loadLibrary("TestLib");

        final MessageProvider mProvider = new MessageProvider();
        mProvider.printPrivateMessage();
        System.out.println("NF result: " + goThere(mProvider));

        mProvider.printPrivateMessage();
    }
}
