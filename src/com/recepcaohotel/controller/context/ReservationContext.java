package com.recepcaohotel.controller.context;

import java.time.LocalDate;

import com.recepcaohotel.model.Quarto;
import com.recepcaohotel.model.Reserva;

public class ReservationContext {
    // ---- Padrão Singleton ---------------------------------------------------
    private static ReservationContext instance;

    /**
     *
     * @return Context singleton instance.
     */
    public static ReservationContext getInstance() {
        if (instance == null) {
            instance = new ReservationContext();
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
    // Estadia
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    // Busca Quartos
    private Quarto quartoSelecionado;

    // Confirmar Dados
    private String nome;
    private String email;
    private String telefone;
    private Reserva reservaCriada;
    // -------------------------------------------------------------------------

    public ReservationContext() {
        // Estadia
        this.dataEntrada = LocalDate.now();
        this.dataSaida = LocalDate.now();

        // Busca Quartos
        this.quartoSelecionado = null;

        // Confirmar Dados
        this.nome = "";
        this.email = "";
        this.telefone = "";
        this.reservaCriada = null;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Quarto getQuartoSelecionado() {
        return quartoSelecionado;
    }

    public void setQuartoSelecionado(Quarto quartoSelecionado) {
        this.quartoSelecionado = quartoSelecionado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Reserva getReservaCriada() {
        return reservaCriada;
    }

    public void setReservaCriada(Reserva reservaCriada) {
        this.reservaCriada = reservaCriada;
    }
}
