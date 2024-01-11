package com.anbuzhobbiez.spannerdemo.services;

import com.google.firebase.messaging.*;
import com.anbuzhobbiez.spannerdemo.model.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(Note note) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .build();

        Message message = Message
                .builder()
                .setTopic("topic")
                .setNotification(notification)
                .build();

        System.out.print(note.getSubject() + "!!!!!!!");

        String fcm_id = firebaseMessaging.send(message);
        log.info("A notification has been sent and the return fcm_id is {}", fcm_id);
        return fcm_id;
    }

}