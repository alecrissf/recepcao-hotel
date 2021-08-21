package com.recepcaohotel.controller;

import java.io.IOException;
import java.util.Collection;

import com.recepcaohotel.app.App;
import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Sistema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ADMListaQuartosController {
    @FXML
    private VBox containerLista;

    @FXML
    private Button botaoAtualizar;

    @FXML
    private Button botaoAdicionarQuarto;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void initialize() {
        Sistema s = App.getSystemInstance();
        // Inicializar a lista de quartos.
        atualizarListaDeQuartos(s.consultarQuartos());
    }

    @FXML
    private void atualizar() {
        Sistema s = App.getSystemInstance();
        // Inicializar a lista de quartos.
        atualizarListaDeQuartos(s.consultarQuartos());
    }

    @FXML
    private void adicionarQuarto(ActionEvent event) {
        if (event.getSource() == botaoAdicionarQuarto) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/ADMNovoQuarto.fxml"));
                botaoAdicionarQuarto.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/PainelControle.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizarListaDeQuartos(Collection<Quarto> quartos) {
        if (containerLista == null) {
            return;
        }

        containerLista.getChildren().clear();

        for (Quarto quarto : quartos) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/ADMItemQuarto.fxml"));
                Parent listItem = loader.load();
                ADMItemQuartoController controller = loader.getController();
                controller.setQuarto(quarto);
                containerLista.getChildren().add(listItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
