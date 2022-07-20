package com.example.javafxchat44.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class ChatController {
    @FXML
    private TextField loginField;
    @FXML
    private HBox authBox;
    @FXML
    private PasswordField passField;
    @FXML
    private VBox messageBox;
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField MessageField;

    private final ChatClient client;

    public ChatController() {
        this.client = new ChatClient(this);
        while (true) {
            try {
                client.openConnection();
                break;
            } catch (IOException e) {
                showNotification();
            }
        }
    }

    private void showNotification() {
        final Alert alert = new Alert(Alert.AlertType.ERROR,
                "Не могу подключится к серверу. \n" +
                        "Проверьте, что сервер запущен и доступен",
                new ButtonType("Попробовать снова", ButtonBar.ButtonData.OK_DONE),
                new ButtonType("Выйти", ButtonBar.ButtonData.CANCEL_CLOSE)
        );
        alert.setTitle("Ошибка подключения! ");
        final Optional<ButtonType> answer = alert.showAndWait();
        final Boolean isExit = answer
                .map(select -> select.getButtonData().isCancelButton())
                .orElse(false);
        if (isExit){
            System.exit(0);
        }
    }

    public void clickSendButton() {
        final String message = MessageField.getText();
        if (message.isBlank()) {
            return;
        }

        client.sendMessage(message);
        MessageField.clear();
        MessageField.requestFocus();

    }

    public void addMessage(String message) {
        messageArea.appendText(message + "\n");
    }
    public void setAuth(boolean success){
        authBox.setVisible(!success);
        messageBox.setVisible(success);
    }
    public void signinBtnClick() {
        client.sendMessage("/auth " + loginField.getText() + " " + passField.getText());
    }
}