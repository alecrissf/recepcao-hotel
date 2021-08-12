package com.recepcaohotel.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ADMNovoQuartoController {
    @FXML
    private TextField campoNumQuarto;

    @FXML
    private TextField campoValorDiaria;

    @FXML
    private TextField campoQtdCamasCasal;

    @FXML
    private TextField campoQtdCamasSolteiro;

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private void confirmar(ActionEvent event) {
        // TODO: Mudar as informações usando a instância da classe sistema.

        // OBS.: se houver campos vazios não fazer nada e mostrar uma mensagem para o usuário.

        if (event.getSource() == botaoConfirmar) {
            voltar(botaoConfirmar);
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        if (event.getSource() == botaoCancelar) {
            voltar(botaoCancelar);
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
