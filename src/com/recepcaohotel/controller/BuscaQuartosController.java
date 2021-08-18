package com.recepcaohotel.controller;

import java.io.IOException;
import java.util.Collection;

import com.recepcaohotel.app.App;
import com.recepcaohotel.controller.context.ReservationContext;
import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Reserva;
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

        // TODO: Discutir onde é realizado o tratamento de saída < entrada??

        // Inicializar a lista de quartos.
        Collection<Quarto> listaQuartos = s.consultarQuartos();
        Collection<Reserva> listaReservas = s.consultarReservas();

        // Percorre todos as reservas comparado a data de entrada e saída do context
        for (Reserva reserva : listaReservas) {

            // Caso em que a data de entrada do contexto está entre a entrada e saida da
            // reserva
            if (ctx.getDataEntrada().isBefore(reserva.getDataSaida())
                    && (ctx.getDataEntrada().isAfter(reserva.getDataEntrada())
                            || ctx.getDataEntrada().isEqual(reserva.getDataEntrada()))) {
                listaQuartos.remove(reserva.getQuarto());
            }

            // Caso em que a data de saida do contexto está entre a entrada e saída da
            // reserva
            else if (ctx.getDataSaida().isAfter(reserva.getDataEntrada())
                    && (ctx.getDataSaida().isBefore(reserva.getDataSaida())
                            || ctx.getDataSaida().isEqual(reserva.getDataSaida()))) {
                listaQuartos.remove(reserva.getQuarto());
            }

            // Caso em que a entrada do contexto é menor que a entrada da reserva
            // e que a saída do contexto é maior que a saída da reserva
            else if (ctx.getDataEntrada().isBefore(reserva.getDataEntrada())
                    && ctx.getDataSaida().isAfter(reserva.getDataSaida())) {
                listaQuartos.remove(reserva.getQuarto());
            }

            // Caso em que são exatamente iguais ambdas
            else if (ctx.getDataEntrada().isEqual(reserva.getDataEntrada())
                    && ctx.getDataSaida().isEqual(reserva.getDataSaida())) {
                listaQuartos.remove(reserva.getQuarto());
            }
        }
        
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
