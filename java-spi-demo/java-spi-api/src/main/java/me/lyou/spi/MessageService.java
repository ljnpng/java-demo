package me.lyou.spi;

import java.util.ServiceLoader;

public interface MessageService {


    /**
     * 获取消息。
     *
     * @param  message  要获取的消息
     * @return          获取到的消息
     */
    String getMessage(String message);

    default void printMessage(String message){
        ServiceLoader<MessageService> services = ServiceLoader.load(MessageService.class);

        for (MessageService service : services) {
            System.out.println(service.getMessage("Hello"));
        }
    }
}
