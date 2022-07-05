package com.example.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class Controller {
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField textMessage;

    public Controller() {

    }

    public void clickSendButton(ActionEvent actionEvent) {
        final String Message = textMessage.getText();

        String text = Message;
        historyArea.appendText(text + "\n");
        textMessage.clear();
        textMessage.requestFocus();
    }
}