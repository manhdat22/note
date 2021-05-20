package com.project.note.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.project.note.model.Category;
import com.project.note.model.Note;
import com.project.note.model.User;
import com.project.note.service.CategoryService;
import com.project.note.service.NoteService;
import com.project.note.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/User.fxml")
public class UserController implements Initializable{
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    NoteService noteService;

    @FXML
    private Accordion categoryAccordion;

    @FXML
    private TextField noteId;

    @FXML
    private TextField noteTitle;

    @FXML
    private TextArea noteContent;

    private ObservableList<Category> categories = FXCollections.observableArrayList();

    private ObservableList<Note> notes = FXCollections.observableArrayList();

    @FXML
    private void refresh(ActionEvent event) throws IOException {
    	refresh();
    }

    @FXML
    private void submit(ActionEvent event) throws IOException {
        Long id = Long.parseLong(noteId.getText());
    	Note note = noteService.findOrCreate(id);

        if (note == null) {
            System.out.println("Can not found note with id: " + id);
            return;
        }

        note.setTitle(noteTitle.getText());
        note.setContent(noteContent.getText());

        noteService.save(note);

        refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noteId.setManaged(false);
        refresh();
    }

    private void refresh() {
        loadMenuData();
    }

    private void clearMenu() {
        categoryAccordion.getPanes().clear();
		categories.clear();
        notes.clear();
    }

    private void loadMenuData() {
        clearMenu();

        categories.addAll(categoryService.findAll());

        for (Category category : categories) {

            notes.clear();
            notes.addAll(category.getNotes());

            ListView<Note> noteList = new ListView<Note>();

            for (Note note : notes) {
                noteList.getItems().add(note);
            }

            // Add listener for every category
            noteList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Note>() {
                @Override
                public void changed(ObservableValue<? extends Note> observable, Note oldValue, Note newValue) {
                    refreshFormData(newValue);
                }
            });

            TitledPane pane = new TitledPane(category.getTitle(), noteList);

            categoryAccordion.getPanes().add(pane);
        }
    }

    private void refreshFormData(Note note) {
        noteId.clear();
        noteTitle.clear();
        noteContent.clear();

        noteId.setText(String.valueOf(note.getId()));
        noteTitle.setText(note.getTitle());
        noteContent.setText(note.getContent());
    }
}
