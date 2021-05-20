package com.project.note;

import javafx.application.Application;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Application.launch(NoteApplication.class, args);
    }

}
