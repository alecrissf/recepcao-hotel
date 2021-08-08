package com.recepcaohotel.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class CheckoutFinishController {
    @FXML
    private Button botaoVoltar;

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            // Tenta carregar a página inicial.
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Home.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
