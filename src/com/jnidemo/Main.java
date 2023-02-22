package com.jnidemo;

public class Main {

    static native void goThere(MessageProvider messageProvider);

    public static void main(String[] args) {
        System.loadLibrary("TestLib");

        final MessageProvider mProvider = new MessageProvider();
        goThere(mProvider);
    }
}
