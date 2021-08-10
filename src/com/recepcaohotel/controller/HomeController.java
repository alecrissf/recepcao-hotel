package com.recepcaohotel.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button botaoNovaReserva;

    @FXML
    private Button botaoFazerCheckout;

    @FXML
    private Button botaoLogarAdmin;

    @FXML
    private void novaReserva(ActionEvent event) {
        if (event.getSource() == botaoNovaReserva) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Estadia.fxml"));
                botaoNovaReserva.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void fazerCheckout(ActionEvent event) {
        if (event.getSource() == botaoFazerCheckout) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Checkout.fxml"));
                botaoFazerCheckout.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void logarAdmin(ActionEvent event) {
        if (event.getSource() == botaoLogarAdmin) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/LoginAdmin.fxml"));
                botaoLogarAdmin.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
