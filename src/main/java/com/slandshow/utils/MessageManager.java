package com.slandshow.utils;

import java.io.IOException;

public class MessageManager {

    private String addressee;

    private String text;

    private String subject;

    private String context;

    public static MessageManager createWelcomeMessage(String addressee) throws IOException {
        MessageManager message = new MessageManager();
        message.setContext(UtilsManager.getHelloContext());
        message.setSubject("Welcome to Rattler Station service!");
        message.setAddressee(addressee);
        return message;
    }

    // TODO: ADD TICKET UTILS
    public static MessageManager createTicketMessage(String addressee) throws IOException {
        MessageManager message = new MessageManager();
        //message.setContext(UtilsManager.getTicketContext());
        message.setSubject("Greetings! Do you wanna buy some tickets?");
        message.setAddressee(addressee);
        return message;
    }

    // Setters

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContext(String context) {
        this.context = context;
    }

    // Getters


    public String getAddressee() {
        return addressee;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public String getContext() {
        return context;
    }
}
