package me.lyou.spi;

import java.util.ServiceLoader;

public class MessageApi {

    public void printMessage(String message){
        ServiceLoader<MessageService> services = ServiceLoader.load(MessageService.class);

        for (MessageService service : services) {
            System.out.println(service.getMessage(message));
        }
    }
}
