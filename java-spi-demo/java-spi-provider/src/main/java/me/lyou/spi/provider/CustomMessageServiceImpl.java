package me.lyou.spi.provider;

import me.lyou.spi.MessageService;

public class CustomMessageServiceImpl implements MessageService {


    @Override
    public String getMessage(String message) {
        return CustomMessageServiceImpl.class.getName() + ": " + message;
    }
}
