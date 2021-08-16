package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.controller.context.AdminContext;
import com.recepcaohotel.model.Quarto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ADMItemQuartoController {
    private Quarto quarto = null;

    @FXML
    private Label numeroQuarto;

    @FXML
    private Label numeroCamasDeCasal;

    @FXML
    private Label numeroCamasDeSolteiro;

    @FXML
    private Label precoEstadia;

    @FXML
    private Label textoDisponibilidade;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoRemover;

    @FXML
    private void editar(ActionEvent event) {
        if (!selecionarQuarto()) {
            return;
        }

        if (event.getSource() == botaoEditar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMEditarQuarto.fxml"));
                botaoEditar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void remover(ActionEvent event) {
        if (!selecionarQuarto()) {
            return;
        }

        if (event.getSource() == botaoRemover) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMConfirmarRemoverQuarto.fxml"));
                botaoRemover.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateInfo() {
        if (quarto == null) {
            return;
        }
        // Atualizar texto dos campos com base no objeto quarto.
        numeroQuarto.setText(String.valueOf(quarto.getNumero()));
        numeroCamasDeCasal.setText("Camas de Casal: " + quarto.getQntdCamasCasal());
        numeroCamasDeSolteiro.setText("Camas de Solteiro: " + quarto.getQntdCamasSolteiro());
        precoEstadia.setText("R$" + quarto.getDiaria());
        textoDisponibilidade.setText(quarto.getDisponivel() ? "Disponível" : "Indisponível");
        if (quarto.getDisponivel()) {
            textoDisponibilidade.getStyleClass().add("unavailable");
        }
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;

        updateInfo();
    }

    private boolean selecionarQuarto() {
        if (quarto == null) {
            // Mostrar mensagem de erro.
            mostrarErro();
            return false;
        }
        // Guardar as informações no contexto de admin.
        AdminContext ctx = AdminContext.getInstance();
        ctx.setQuartoSelecionado(quarto);
        return true;
    }

    private void mostrarErro() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de execução");
        alert.setContentText("Ops! Parece que houve um erro ao selecionar o quarto.");
        alert.showAndWait();
    }
}
