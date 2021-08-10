package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.model.Quarto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        // TODO: Guardar as informações no contexto de admin.

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
        // TODO: Guardar as informações no contexto de admin.

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
        // TODO: atualizar texto dos campos com base no objeto quarto.
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;

        updateInfo();
    }
}
