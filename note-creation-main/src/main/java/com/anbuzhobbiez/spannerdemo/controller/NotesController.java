package com.anbuzhobbiez.spannerdemo.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.anbuzhobbiez.spannerdemo.model.Note;
import com.anbuzhobbiez.spannerdemo.services.FirebaseMessagingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotesController {

    private final FirebaseMessagingService firebaseService;

    public NotesController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/notes")
    public String sendNotification(@ModelAttribute Note note) throws FirebaseMessagingException {
        note.setId(1);
        String id = firebaseService.sendNotification(note);
        return "admin";
    }
}