package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.app.App;
import com.recepcaohotel.controller.context.AdminContext;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ADMConfirmarCancelarReservaController {
    @FXML
    private Label codigoReserva;

    @FXML
    private Button botaoSim;

    @FXML
    private Button botaoNao;

    @FXML
    private void initialize() {
        AdminContext ctx = AdminContext.getInstance();
        codigoReserva.setText("#" + String.valueOf(ctx.getReservaSelecionada().getId()));
    }

    @FXML
    private void sim(ActionEvent event) {

        Sistema s = App.getSystemInstance();
        AdminContext ctx = AdminContext.getInstance();

        // Atualiza a data de saída da reserva e seta a mesma como 'cancelada' e
        // 'finalizada'
        s.cancelarReserva(ctx.getReservaSelecionada().getId());

        if (event.getSource() == botaoSim) {
            voltar(botaoSim);
        }
    }

    @FXML
    private void nao(ActionEvent event) {
        if (event.getSource() == botaoNao) {
            voltar(botaoNao);
        }
    }

    private void voltar(Parent parent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMListaReservas.fxml"));
            parent.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
