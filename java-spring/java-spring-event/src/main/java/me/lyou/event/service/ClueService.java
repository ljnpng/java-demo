package me.lyou.event.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ClueService {

    public void addClue() {

    }

    public String getClue(String clueId) {
        return "Clue" + clueId;
    }

    @EventListener(FeedbackEvent.class)
    public void feedback(FeedbackEvent<FeedbackEvent.FeedbackEventObject> event) {
        FeedbackEvent.FeedbackEventObject source = event.getSource();
        String clueId = source.getClueId();
        String content = source.getContent();
        System.out.println( "Got feedback " + clueId + " " + content);
    }

}
