package me.lyou;

import me.lyou.spi.MessageApi;

public class SpiApp {
    public static void main(String[] args) {
        new MessageApi().printMessage("From SpiApp");
    }
}
