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

public class PainelControleController {
    @FXML
    private Button botaoListarQuartos;

    @FXML
    private Button botaoListarReservas;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void listarQuartos(ActionEvent event) {
        if (event.getSource() == botaoListarQuartos) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMListaQuartos.fxml"));
                botaoListarQuartos.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void listarReservas(ActionEvent event) {
        if (event.getSource() == botaoListarReservas) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMListaReservas.fxml"));
                botaoListarReservas.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        // Deslogar o admin.
        Sistema s = App.getSystemInstance();
        s.finalizarSessao();
        // Resetar o contexto do admin.
        AdminContext.finishContext();

        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/LoginAdmin.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
