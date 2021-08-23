package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.AdminContext;
import com.recepcaohotel.model.Reserva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ADMItemReservaController {
    private Reserva reserva = null;

    @FXML
    private Label quarto;

    @FXML
    private Label codigoReserva;

    @FXML
    private Label precoTotal;

    @FXML
    private Label nomeUsuario;

    @FXML
    private Label email;

    @FXML
    private Label telefone;

    @FXML
    private Label textoEmProgresso;

    @FXML
    private Label textoCancelado;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private void editar(ActionEvent event) {
        if (!selecionarReserva()) {
            return;
        }

        if (event.getSource() == botaoEditar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMEditarReserva.fxml"));
                botaoEditar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        if (!selecionarReserva()) {
            return;
        }

        if (event.getSource() == botaoCancelar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMConfirmarCancelarReserva.fxml"));
                botaoCancelar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateInfo() {
        if (reserva == null) {
            return;
        }
        // Atualizar texto dos campos com base no objeto reserva.
        quarto.setText("Quarto " + String.format("%03d", reserva.getQuarto().getNumero()));
        codigoReserva.setText("#" + reserva.getId());
        precoTotal.setText("R$" + String.format("%.2f", reserva.calcularPrecoTotal()).replace(".", ","));
        nomeUsuario.setText(reserva.getCliente().getNome());
        email.setText(reserva.getCliente().getEmail());
        telefone.setText(reserva.getCliente().getTelefone());
        textoEmProgresso.setText(reserva.getConcluida() ? "Concluida" : "Em progresso");
        if (reserva.getConcluida()) {
            textoEmProgresso.getStyleClass().add("unavailable");
        }
        textoCancelado.setText(reserva.getCancelada() ? "Cancelada" : "Não Cancelada");
        if (reserva.getCancelada()) {
            textoCancelado.getStyleClass().add("unavailable");
        }
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;

        updateInfo();
    }

    private boolean selecionarReserva() {
        if (reserva == null) {
            // Mostrar mensagem de erro.
            mostrarErro();
            return false;
        }
        if (reserva.getCancelada()) {
            return false;
        }
        if (reserva.getConcluida()) {
            return false;
        }
        // Guardar as informações no contexto de admin.
        AdminContext ctx = AdminContext.getInstance();
        ctx.setReservaSelecionada(reserva);
        return true;
    }

    private void mostrarErro() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de execução");
        alert.setContentText("Ops! Parece que houve um erro ao selecionar a Reserva.");
        alert.showAndWait();
    }
}
