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

public class ADMConfirmarRemoverQuartoController {
    @FXML
    private Label codigoQuarto;

    @FXML
    private Button botaoSim;

    @FXML
    private Button botaoNao;

    @FXML
    private void initialize() {
        // Exibe o quarto no formato 'Quarto 00X' onde X é o número do quarto
        AdminContext ctx = AdminContext.getInstance();
        codigoQuarto.setText("Quarto " + " " + String.format("%03d", ctx.getQuartoSelecionado().getNumero()));
    }

    @FXML
    private void sim(ActionEvent event) {

        // Pega o quarto selecionado no contexto do ADM e remove do sistema
        Sistema s = App.getSystemInstance();
        AdminContext ctx = AdminContext.getInstance();

        s.removerQuarto(ctx.getQuartoSelecionado().getNumero());

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
