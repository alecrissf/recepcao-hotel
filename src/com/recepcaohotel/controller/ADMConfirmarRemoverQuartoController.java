package com.recepcaohotel.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ADMConfirmarRemoverQuartoController {
    @FXML
    private Label codigoQuarto;

    @FXML
    private Button botaoSim;

    @FXML
    private Button botaoNao;

    @FXML
    private void initialize() {
        // TODO: mudar o texto de codigoQuarto para o código guardado no contexto do admin.
    }

    @FXML
    private void sim(ActionEvent event) {
        // TODO: remover quarto.

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
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMListaQuartos.fxml"));
            parent.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
