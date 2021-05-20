package com.project.note;

import com.project.note.NoteApplication.StageReadyEvent;
import com.project.note.controller.UserController;

import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    private final String applicationTitle;
    private final FxWeaver fxWeaver;

    public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle,
                            FxWeaver fxWeaver) {
        this.applicationTitle = applicationTitle;
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        Scene scene = new Scene(fxWeaver.loadView(UserController.class), 800, 600);
        scene.getStylesheets().add("styles/Styles.css");

        stage.setScene(scene);
        stage.setTitle(applicationTitle);
        stage.show();
    }
}
