package me.lyou.event.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void feedback(String clueId, String content) {
        System.out.println("feedback " + clueId + " " + content);
        applicationEventPublisher.publishEvent(new FeedbackEvent<>(() -> new FeedbackEvent.FeedbackEventObject(clueId, content)));
    }
}
