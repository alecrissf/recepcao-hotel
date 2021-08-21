package com.recepcaohotel.controller;

import java.io.IOException;
import java.util.Collection;

import com.recepcaohotel.app.App;
import com.recepcaohotel.controller.context.ReservationContext;
import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Sistema;

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
        ReservationContext ctx = ReservationContext.getInstance();
        Sistema s = App.getSystemInstance();
        // Inicializar a lista de quartos.
        Collection<Quarto> listaQuartos = s.consultarQuartos();
        // TODO: Filtrar coleção usando as datas de entrada e saída do contexto.
        atualizarListaDeQuartos(listaQuartos);
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
