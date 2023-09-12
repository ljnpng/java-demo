package me.lyou.event.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;

import java.util.function.Supplier;

public class FeedbackEvent<T extends FeedbackEvent.FeedbackEventObject> extends ApplicationEvent {
    public FeedbackEvent(Supplier<T> supplier) {
        super(supplier.get());
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getSource() {
        return (T) super.getSource();
    }

    @Data
    @RequiredArgsConstructor
    public static class FeedbackEventObject {

        private final String clueId;
        private final String content;
    }
}
