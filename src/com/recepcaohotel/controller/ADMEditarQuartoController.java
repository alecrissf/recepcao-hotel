package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.app.App;
import com.recepcaohotel.controller.context.AdminContext;
import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ADMEditarQuartoController {
    @FXML
    private Label textoQtdCamasDeCasalAtual;

    @FXML
    private TextField campoQtdCamasDeCasal;

    @FXML
    private Label textoQtdCamasDeSolteiroAtual;

    @FXML
    private TextField campoQtdCamasDeSolteiro;

    @FXML
    private Label textoValorDiariaAtual;

    @FXML
    private TextField campoValorDiaria;

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private void initialize() {
        Sistema s = App.getSystemInstance();
        AdminContext ctx = AdminContext.getInstance();
        Quarto q = s.getQuarto(ctx.getQuartoSelecionado().getNumero());

        textoQtdCamasDeCasalAtual.setText(String.valueOf(q.getQntdCamasCasal()));
        textoQtdCamasDeSolteiroAtual.setText(String.valueOf(q.getQntdCamasSolteiro()));
        textoValorDiariaAtual.setText(String.valueOf(q.getDiaria()));
    }

    @FXML
    private void confirmar(ActionEvent event) {
        Sistema s = App.getSystemInstance();
        AdminContext ctx = AdminContext.getInstance();
        Quarto q = s.getQuarto(ctx.getQuartoSelecionado().getNumero());

        // OBS.: campos vazios significam não mudança.
        try {
            if (campoQtdCamasDeCasal.getText() != "") {
                q.setQntdCamasCasal(Integer.parseInt(campoQtdCamasDeCasal.getText()));
            }
        } catch (NumberFormatException e) {
            q.setQntdCamasCasal(Integer.parseInt("0"));
            e.printStackTrace();
        }

        try {
            if (campoQtdCamasDeSolteiro.getText() != "") {
                q.setQntdCamasSolteiro(Integer.parseInt(campoQtdCamasDeSolteiro.getText()));
            }
        } catch (NumberFormatException e) {
            q.setQntdCamasSolteiro(Integer.parseInt("0"));
            e.printStackTrace();
        }

        try {
            if (campoValorDiaria.getText() != "") {
                q.setDiaria(Float.parseFloat(campoValorDiaria.getText()));
                ;
            }
        } catch (NumberFormatException e) {
            q.setDiaria(Float.parseFloat("0.0"));
            e.printStackTrace();
        }
        s.adicionarQuarto(q);
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
