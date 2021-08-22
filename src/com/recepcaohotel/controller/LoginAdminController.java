package com.recepcaohotel.controller;

import java.io.IOException;

import com.recepcaohotel.app.App;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginAdminController {
    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void entrar(ActionEvent event) {
        // Verificar campos.
        if (campoUsuario.getText().isBlank()) {
            mostrarErroCampos();
            return;
        }
        if (campoSenha.getText().isBlank()) {
            mostrarErroCampos();
            return;
        }

        // Fazer o login do admin.
        Sistema s = App.getSystemInstance();
        if (!s.autenticar(campoUsuario.getText().strip(), campoSenha.getText().strip())) {
            mostrarErroLogin();
            return;
        }

        if (event.getSource() == botaoEntrar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/PainelControle.fxml"));
                botaoEntrar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Home.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarErroLogin() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de login");
        alert.setContentText("Nome de usuário ou senha inválidos.");
        alert.showAndWait();
    }

    private void mostrarErroCampos() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de campos");
        alert.setContentText("Os campos devem ser preenchidos.");
        alert.showAndWait();
    }
}
