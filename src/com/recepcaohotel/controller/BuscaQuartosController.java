package com.recepcaohotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.recepcaohotel.model.Quarto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BuscaQuartosController {
    @FXML
    private VBox containerQuartos;

    @FXML
    private Button botaoVoltar;

    @FXML
    private void initialize() {
        // Inicializar a lista de quartos.
        // OBS.: versão temporária, sujeita a modificações futuras.
        Quarto demo[] = { new Quarto(), new Quarto(), new Quarto() };
        atualizarListaDeQuartos(new ArrayList<>(Arrays.asList(demo)));
    }

    @FXML
    private void voltar(ActionEvent event) {
        if (event.getSource() == botaoVoltar) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Estadia.fxml"));
                botaoVoltar.getScene().setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizarListaDeQuartos(Collection<Quarto> quartos) {
        if (containerQuartos == null) {
            return;
        }

        containerQuartos.getChildren().clear();

        for (Quarto quarto : quartos) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/ItemQuarto.fxml"));
                Parent listItem = loader.load();
                ItemQuartoController controller = loader.getController();
                controller.setQuarto(quarto);
                containerQuartos.getChildren().add(listItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
