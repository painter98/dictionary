package com.example.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root=new Group(); //imporrting morre than one word as group
        Scene scene = new Scene(root, 500, 500); //text box
        stage.setTitle("Word Dictionary"); //text box title
        DictionaryPage page=new DictionaryPage(); //controller object creation
        root.getChildren().add(page.root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}