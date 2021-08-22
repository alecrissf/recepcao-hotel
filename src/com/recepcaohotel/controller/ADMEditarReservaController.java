package com.recepcaohotel.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

import com.recepcaohotel.app.App;
import com.recepcaohotel.controller.context.AdminContext;
import com.recepcaohotel.model.DetalhesEstadia;
import com.recepcaohotel.model.Reserva;
import com.recepcaohotel.model.Sistema;

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
    private void initialize() {
        // Colocar o valor atual da data de saída em textoDataSaida.
        Reserva reserva = AdminContext.getInstance().getReservaSelecionada();
        texoDataSaida.setText(String.format("%02d", reserva.getDataSaida().getDayOfMonth()) + "/"
                + String.format("%02d", reserva.getDataSaida().getMonthValue()) + "/"
                + reserva.getDataSaida().getYear());
        campoDataSaida.setValue(reserva.getDataSaida());
    }

    @FXML
    private void confirmar(ActionEvent event) {
        // OBS.: campos vazios significam não mudança.
        Sistema s = App.getSystemInstance();
        Collection<Reserva> reservas = s.consultarReservas();

        // Recuperar os valores dos campos.
        String qtdServicoQuarto = campoQtdServicoQuarto.getText();
        String valorServicoQuarto = campoValorServicoQuarto.getText();
        String qtdConsumoFrigobar = campoQtdConsumoFrigobar.getText();
        String valorConsumoFrigobar = campoValorConsumoFrigobar.getText();

        // Recuperar a reserva selecionada.
        Reserva reserva = AdminContext.getInstance().getReservaSelecionada();

        // Testar a nova data de saída e colocar o valor de campo data saida na reserva.
        if (campoDataSaida.getValue().isBefore(LocalDate.now())) {
            mostrarErroCampos("A 'Data de Saída' anterior a 'Data de Hoje'.");
            return;
        }

        if (campoDataSaida.getValue().isBefore(reserva.getDataEntrada())) {
            mostrarErroCampos("A 'Data de Saída' anterior a 'Data de Entrada'.'");
            return;
        }

        for (Reserva reservaSalvas : reservas) {
            if (reserva.getQuarto() == reservaSalvas.getQuarto()
                    && campoDataSaida.getValue().isAfter(reservaSalvas.getDataEntrada())) {
                mostrarErroCampos("A nova 'Data de Saída' está indiponível.'");
                return;
            }
        }

        reserva.setDataSaida(campoDataSaida.getValue());

        DetalhesEstadia de = reserva.getDetalhesEstadia();

        // Caso ambos os campos estejam preenchidos editar o objeto detalhes estadia.
        if (!qtdServicoQuarto.isBlank() && !valorServicoQuarto.isBlank()) {
            try {
                de.addServicoDeQuarto(Float.parseFloat(valorServicoQuarto.replace(",", ".")),
                        Integer.parseInt(qtdServicoQuarto));
            } catch (NumberFormatException e) {
                mostrarErroCampos("Verifique os dados do \"Serviço de Quarto\".");
                return;
            }
        } else if (!(qtdServicoQuarto.isBlank() && valorServicoQuarto.isBlank())) {
            mostrarErroCampos("Ambos os campos de \"Serviço de Quarto\" devem estar preenchidos.");
            return;
        }

        // Caso ambos os campos estejam preenchidos editar o objeto detalhes estadia.
        if (!qtdConsumoFrigobar.isBlank() && !valorConsumoFrigobar.isBlank()) {
            try {
                de.addFrigobar(Float.parseFloat(valorConsumoFrigobar.replace(",", ".")),
                        Integer.parseInt(qtdConsumoFrigobar));
            } catch (Exception e) {
                mostrarErroCampos("Verifique os dados do \"Consumo Frigobar\".");
                return;
            }
            // TODO: Verificar o tamanho do texto na caixa de mensagem
        } else if (!(qtdConsumoFrigobar.isBlank() && valorConsumoFrigobar.isBlank())) {
            mostrarErroCampos("Ambos os campos de \"Consumo Frigobar\" devem estar preenchidos.");
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
