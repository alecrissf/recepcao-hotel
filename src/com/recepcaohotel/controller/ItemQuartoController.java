package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.ReservationContext;
import com.recepcaohotel.model.Quarto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ItemQuartoController {
    private Quarto quarto = null;

    @FXML
    private Label numeroQuarto;

    @FXML
    private Label numeroCamasDeCasal;

    @FXML
    private Label numeroCamasDeSolteiro;

    @FXML
    private Label dataEntrada;

    @FXML
    private Label dataSaida;

    @FXML
    private Label precoEstadia;

    @FXML
    private Button botaoReservar;

    @FXML
    private void reservar(ActionEvent event) {
        if (quarto == null) {
            // Mostrar mensagem de erro.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro de execução");
            alert.setContentText("Ops! Parece que houve um erro ao selecionar o quarto.");
            alert.showAndWait();
            return;
        }
        // Guardar as informações no contexto de reserva.
        ReservationContext ctx = ReservationContext.getInstance();
        ctx.setQuartoSelecionado(quarto);

        if (event.getSource() == botaoReservar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ConfirmarDados.fxml"));
                botaoReservar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateInfo() {
        if (quarto == null) {
            return;
        }
        ReservationContext ctx = ReservationContext.getInstance();

        // Atualizar texto dos campos com base no objeto quarto.
        numeroQuarto.setText(String.valueOf(quarto.getNumero()));
        numeroCamasDeCasal.setText("Camas de Casal: " + quarto.getQntdCamasCasal());
        numeroCamasDeSolteiro.setText("Camas de Solteiro: " + quarto.getQntdCamasSolteiro());
        dataEntrada.setText(ctx.getDataEntrada().toString());
        dataSaida.setText(ctx.getDataSaida().toString());
        precoEstadia.setText("R$" + quarto.getDiaria());
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;

        updateInfo();
    }
}
