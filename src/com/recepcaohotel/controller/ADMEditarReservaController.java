package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.AdminContext;
import com.recepcaohotel.model.DetalhesEstadia;
import com.recepcaohotel.model.Reserva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ADMEditarReservaController {
    @FXML
    private Label texoDataSaida;

    @FXML
    private DatePicker campoDataSaida;

    @FXML
    private TextField campoQtdServicoQuarto;

    @FXML
    private TextField campoValorServicoQuarto;

    @FXML
    private TextField campoQtdConsumoFrigobar;

    @FXML
    private TextField campoValorConsumoFrigobar;

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private void inicializar() {
        // Colocar o valor atual da data de saída em textoDataSaida.
        Reserva reserva = AdminContext.getInstance().getReservaSelecionada();
        texoDataSaida.setText(reserva.getDataSaida().toString());
        campoDataSaida.setValue(reserva.getDataSaida());
    }

    @FXML
    private void confirmar(ActionEvent event) {
        // OBS.: campos vazios significam não mudança.

        // Recuperar os valores dos campos.
        String qtdServicoQuarto = campoQtdServicoQuarto.getText();
        String valorServicoQuarto = campoValorServicoQuarto.getText();
        String qtdConsumoFrigobar = campoQtdConsumoFrigobar.getText();
        String valorConsumoFrigobar = campoValorConsumoFrigobar.getText();

        // Recuperar a reserva selecionada.
        Reserva reserva = AdminContext.getInstance().getReservaSelecionada();

        // Colocar o valor de campo data saida na reserva.
        reserva.setDataSaida(campoDataSaida.getValue());

        DetalhesEstadia de = reserva.getDetalhesEstadia();

        // Caso ambos os campos estejam preenchidos editar o objeto detalhes estadia.
        if (!qtdServicoQuarto.isBlank() && !valorServicoQuarto.isBlank()) {
            de.addServicoDeQuarto(Float.parseFloat(valorServicoQuarto), Integer.parseInt(qtdServicoQuarto));
        } else if (!(qtdServicoQuarto.isBlank() && valorServicoQuarto.isBlank())) {
            mostrarErroCampos(
                    "Os campos \"Quantidade Serviço de Quarto\" e \"Valor Serviço de Quarto\" devem estar ambos preenchidos.");
            return;
        }

        // Caso ambos os campos estejam preenchidos editar o objeto detalhes estadia.
        if (!qtdConsumoFrigobar.isBlank() && !valorConsumoFrigobar.isBlank()) {
            de.addFrigobar(Float.parseFloat(valorConsumoFrigobar), Integer.parseInt(qtdConsumoFrigobar));
        } else if (!(qtdConsumoFrigobar.isBlank() && valorConsumoFrigobar.isBlank())) {
            mostrarErroCampos(
                    "Os campos \"Quantidade Consumo Frigobar\" e \"Valor Consumo Frigobar\" devem estar ambos preenchidos.");
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
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMListaReservas.fxml"));
            parent.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarErroCampos(String msg) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de campos");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
