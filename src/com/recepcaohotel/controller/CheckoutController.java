package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.app.App;
import com.recepcaohotel.model.Reserva;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CheckoutController {
    @FXML
    private TextField campoCodigoReserva;

    @FXML
    private Button botaoConfirmarCheckout;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void confirmarCheckout(ActionEvent event) {
        // Fazer checkout.
        Sistema s = App.getSystemInstance();

        try {
            Reserva r = s.getReserva(Integer.parseInt(campoCodigoReserva.getText()));
            if (r == null) {
                mostrarErroCampos("Tente novamente, ou dirija-se a recepção.");
                return;
            } else if (r.getCancelada()) {
                mostrarErroCampos("Esta reserva foi cancelada.");
                return;
            } else if (r.getConcluida()) {
                mostrarErroCampos("Esta reserva já foi concluída.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarErroCampos("O código da reserva é composto apenas por números.");
            return;
        }

        s.realizarCheckout(Integer.parseInt(campoCodigoReserva.getText()));

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

    private void mostrarErroCampos(String msg) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Reserva não Encontrada");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
