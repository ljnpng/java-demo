package me.lyou.spi.provider;

import me.lyou.spi.MessageApi;

public class SpiMain {
    public static void main(String[] args) {
        MessageApi messageApi = new MessageApi();
        messageApi.printMessage("hello spi");
    }
}