package com.recepcaohotel.controller.context;

import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Reserva;

public class AdminContext {
    // ---- Padrão Singleton ---------------------------------------------------
    private static AdminContext instance;

    /**
     *
     * @return Context singleton instance.
     */
    public static AdminContext getInstance() {
        if (instance == null) {
            instance = new AdminContext();
        }
        return instance;
    }

    /**
     * Finaliza o contexto para não manter dados de uma utilização anterior do
     * contexto.
     */
    public static void finishContext() {
        instance = null;
    }
    // -------------------------------------------------------------------------

    // ---- Campos -------------------------------------------------------------
    // ---- Seção de Quartos ----
    // Usado para saber qual quarto será editado/removido.
    private Quarto quartoSelecionado;

    // ---- Seção de Reservas ----
    // Usado para saber qual reserva será editada/cancelada.
    private Reserva reservaSelecionada;
    // -------------------------------------------------------------------------

    public AdminContext() {
        // Definir valores iniciais para os campos.
        this.quartoSelecionado = null;
        this.reservaSelecionada = null;
    }

    public Quarto getQuartoSelecionado() {
        return quartoSelecionado;
    }

    public void setQuartoSelecionado(Quarto quartoSelecionado) {
        this.quartoSelecionado = quartoSelecionado;
    }

    public Reserva getReservaSelecionada() {
        return reservaSelecionada;
    }

    public void setReservaSelecionada(Reserva reservaSelecionada) {
        this.reservaSelecionada = reservaSelecionada;
    }
}
