package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.ReservationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class EstadiaController {
    @FXML
    private DatePicker entradaDatePicker;

    @FXML
    private DatePicker saidaDatePicker;

    @FXML
    private Button botaoBuscarQuartos;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void initialize() {
        ReservationContext ctx = ReservationContext.getInstance();

        entradaDatePicker.setValue(ctx.getDataEntrada());
        saidaDatePicker.setValue(ctx.getDataSaida());
    }

    @FXML
    private void buscarQuartos(ActionEvent event) {
        // Coletar as informações dos campos de data e guardar no contexto de reserva.
        ReservationContext ctx = ReservationContext.getInstance();

        ctx.setDataEntrada(entradaDatePicker.getValue());
        ctx.setDataSaida(saidaDatePicker.getValue());

        // Ir para a página de escolha de quartos.
        if (event.getSource() == botaoBuscarQuartos) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/BuscaQuartos.fxml"));
                botaoBuscarQuartos.getScene().setRoot(root);
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
