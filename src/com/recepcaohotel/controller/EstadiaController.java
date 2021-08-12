package com.recepcaohotel.controller;

import java.io.IOException;
import java.time.LocalDate;

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
        entradaDatePicker.setValue(LocalDate.now());
        saidaDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void buscarQuartos(ActionEvent event) {
        // TODO: coletar as informações dos campos de data e guardar no contexto de reserva.

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
