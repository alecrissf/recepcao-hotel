package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.model.Quarto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemQuartoController {
    private Quarto quarto = null;

    @FXML
    private Label numeroQuarto;

    @FXML
    private Label numeroCamasDeCasal;

    @FXML
    private Label numeroCamasDeSolteiro;

    @FXML
    private Label dataEntrada;

    @FXML
    private Label dataSaida;

    @FXML
    private Label precoEstadia;

    @FXML
    private Button botaoReservar;

    @FXML
    private void reservar(ActionEvent event) {
        // TODO: Guardar as informações no contexto de reserva.

        if (event.getSource() == botaoReservar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ConfirmarDados.fxml")); // TODO:
                botaoReservar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateInfo() {
        if (quarto == null) {
            return;
        }
        // TODO: atualizar texto dos campos com base no objeto quarto.
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;

        updateInfo();
    }
}
