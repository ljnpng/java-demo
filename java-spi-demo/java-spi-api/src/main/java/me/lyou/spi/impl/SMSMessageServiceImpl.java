package me.lyou.spi.impl;

import me.lyou.spi.MessageService;

public class SMSMessageServiceImpl implements MessageService {

    @Override
    public String getMessage(String message) {
        return "SMS: " + message;
    }
}
