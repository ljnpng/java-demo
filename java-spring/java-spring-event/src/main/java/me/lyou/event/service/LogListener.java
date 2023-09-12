package me.lyou.event.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener implements ApplicationListener<FeedbackEvent<FeedbackEvent.FeedbackEventObject>> {
    @Override
    public void onApplicationEvent(FeedbackEvent event) {
        System.out.println(event.getSource());
    }
}
