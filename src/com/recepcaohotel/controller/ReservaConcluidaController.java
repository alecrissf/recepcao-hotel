package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.ReservationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReservaConcluidaController {
    @FXML
    private Label reservationCode;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void initialize() {
        // Pegar o código guardado no contexto e colocar no label reservationCode.
        ReservationContext ctx = ReservationContext.getInstance();
        reservationCode.setText("#" + ctx.getReservaCriada().getId());
    }

    @FXML
    private void voltar(ActionEvent event) {
        // Finalizar o contexto de reserva.
        ReservationContext.finishContext();
        // Voltar para a página principal.
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
