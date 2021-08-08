package com.recepcaohotel.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CheckoutController {
    @FXML
    private TextField campoCodigoReserva;

    @FXML
    private Button botaoConfirmarCheckout;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void confirmarCheckout(ActionEvent event) {
        // TODO: fazer a lógica de fazer checkout.
        System.out.println("Código digitado: " + campoCodigoReserva.getText());

        if (event.getSource() == botaoConfirmarCheckout) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/CheckoutFinish.fxml"));
                botaoConfirmarCheckout.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Home.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
