package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {
    private DictionarySaver db;
    @FXML
    TextField Search;//connecting the controller to fxml file id search; object has to be same as in fxml
    @FXML
    public void searchButton(MouseEvent event) throws IOException, ClassNotFoundException { //mouseevent is the click
        db=new DictionarySaver();
        db.deserializeHashMap(); //database accessing

        Alert alert=new Alert(Alert.AlertType.INFORMATION); //kind of alert needed
        alert.setHeaderText("Dictionary");

        if(Search.getText().equals("")){
            alert.setContentText("Please enter the word to search");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }

        else if(db.getDictionaryList().containsKey(Search.getText().toLowerCase())){//to lowercase is to make it case insensitive

            alert.setContentText("The word is available in dictionary");//context of alert box
            alert.showAndWait(); //alert box waits for an action

        }

        else{
            alert.setContentText("The word is not available in dictionary");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }

    }
    @FXML
    TextField new_word;
    @FXML
    TextField meaning;
    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert=new Alert(Alert.AlertType.INFORMATION); //kind of alert needed
        alert.setHeaderText("Dictionary");

        if(new_word.getText().equals("")){ //empty word box
            alert.setContentText("Please enter the word to add");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }
        else if(meaning.getText().equals("")){ //empty meaning box
            alert.setContentText("Please enter the meaning to add");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }
        else if(db.getDictionaryList().containsKey(new_word.getText().toLowerCase())){ //if the word is already present in the dictionary gives alert
            alert.setContentText("The word is already present in the dictionary");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }
        else {
            db.getDictionaryList().put(new_word.getText().toLowerCase(), meaning.getText());
            db.serializeHashMap(); //creating database and save the meaning
            //System.out.println(meaning.getText());
            alert.setContentText("New word is added to the Dictionary");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }
    }
    @FXML
    TextField Find_meaning;
    @FXML
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert=new Alert(Alert.AlertType.INFORMATION); //kind of alert needed
        alert.setHeaderText("Meaning");

        if(Find_meaning.getText().equals("")){
            alert.setContentText("Please enter the word to search");//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }
        else if(db.getDictionaryList().containsKey(Find_meaning.getText().toLowerCase())){
            //System.out.println(db.getDictionaryList().get(Find_meaning.getText()));//hashmap contains the searched word
            alert.setContentText(db.getDictionaryList().get(Find_meaning.getText().toLowerCase()));//context of alert box
            alert.showAndWait(); //alert box waits for an action
        }
        //System.out.println(Find_meaning.getText());
    }
}
