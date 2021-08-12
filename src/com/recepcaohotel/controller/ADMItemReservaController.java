package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.model.Reserva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ADMItemReservaController {
    private Reserva reserva = null;

    @FXML
    private Label codigoReserva;

    @FXML
    private Label precoTotal;

    @FXML
    private Label textoEmProgresso;

    @FXML
    private Label textoCancelado;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private void editar(ActionEvent event) {
        // TODO: Guardar as informações no contexto de admin.

        if (event.getSource() == botaoEditar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMEditarReserva.fxml"));
                botaoEditar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        // TODO: Guardar as informações no contexto de admin.

        if (event.getSource() == botaoCancelar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMConfirmarCancelarReserva.fxml"));
                botaoCancelar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateInfo() {
        if (reserva == null) {
            return;
        }
        // TODO: atualizar texto dos campos com base no objeto reserva.
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;

        updateInfo();
    }
}
