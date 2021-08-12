package com.recepcaohotel.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class ConfirmarDadosController {
    @FXML
    Button botaoConfirmarReserva;

    @FXML
    Button botaoVoltar;

    @FXML
    private void confirmarReserva(ActionEvent event) {
        // TODO: guardar informações no contexto e mudar para a página final.

        if (event.getSource() == botaoConfirmarReserva) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ReservaConcluida.fxml"));
                botaoConfirmarReserva.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/BuscaQuartos.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
