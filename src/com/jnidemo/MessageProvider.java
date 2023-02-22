package com.jnidemo;

public class MessageProvider {
    public static final String MESSAGE_TEXT = "Hello there!";
    private String privateMessage = "default_private_message_value";

    public void printPrivateMessage() {
        System.out.println("Message: " + this.privateMessage);
    }

    public void setPrivateMessage(final String message) {
        this.privateMessage = message;
    }
}
