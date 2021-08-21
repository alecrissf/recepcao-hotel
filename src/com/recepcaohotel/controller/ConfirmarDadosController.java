package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.ReservationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfirmarDadosController {
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoTelefone;

    @FXML
    Button botaoConfirmarReserva;

    @FXML
    Button botaoVoltar;

    @FXML
    private void confirmarReserva(ActionEvent event) {
        ReservationContext ctx = ReservationContext.getInstance();
        // TODO: Criar a reserva, guardar informações no contexto e mudar para a página final.
        // TODO: Refatorar a classe Reserva para substituir o tipo Date por LocalDate.
        // Reserva reserva = new Reserva(ctx.getDataEntrada(), ctx.getDataSaida());

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
