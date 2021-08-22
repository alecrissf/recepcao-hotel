package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.app.App;
import com.recepcaohotel.model.Quarto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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

        try {
            //Verificar os campos antes de usá-los.
            if (campoNumQuarto.getText().isBlank() || campoQtdCamasCasal.getText().isBlank()
                    || campoQtdCamasSolteiro.getText().isBlank() || campoValorDiaria.getText().isBlank()) {

                mostrarErroVazio();
                return;
            }

            int numQuarto = Integer.parseInt(this.campoNumQuarto.getText());
            int qntCamaCasal = Integer.parseInt(this.campoQtdCamasCasal.getText());
            int qntCamaSolteiro = Integer.parseInt(this.campoQtdCamasSolteiro.getText());
            float valorDiaria = Float.parseFloat(this.campoValorDiaria.getText());

            Quarto quarto = new Quarto(numQuarto, qntCamaCasal, qntCamaSolteiro, valorDiaria);
            App.getSystemInstance().adicionarQuarto(quarto);
        }

        //Erro caso seja digitado algo que não possa ser convertido para números.
        catch (NumberFormatException exception) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro de preenchimento");
            alerta.setContentText(
                    "Por favor, digite apenas números nos espaços e, na diária, digite apenas o valor dividindo os centavos com um ponto (Ex: 548.25)");
            alerta.showAndWait();
            return;
        }

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

    private void mostrarErroVazio() {

        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro de preenchimento");
        alerta.setContentText("Por favor, não deixe nenhum campo vazio, todos devem ser preenchidos.");
        alerta.showAndWait();
    }
}
