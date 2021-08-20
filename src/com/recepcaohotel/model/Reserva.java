package com.recepcaohotel.model;

import java.time.LocalDate;
import java.util.Random;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private int id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private boolean isConcluida;
    private boolean isCancelada;
    private Quarto quarto;
    private DetalhesEstadia detalhesEstadia;
    private Cliente cliente;

    public Reserva() {
        this(new Quarto());
    }

    public Reserva(Quarto quarto) {
        this(quarto, LocalDate.now(), LocalDate.now());
    }

    public Reserva(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        // Gerar código da reserva em sequencia pseudoaleatoria
        // Pensar em verificar a ocorrência de números aleatórios iguais
        Random f = new Random();
        this.id = f.nextInt(100000);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.isCancelada = false;
        this.isConcluida = false;
        this.quarto = quarto;
        this.detalhesEstadia = new DetalhesEstadia();
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setCancelada(boolean isCancelada) {
        this.isCancelada = isCancelada;
    }

    public void setConcluida(boolean isConcluida) {
        this.isConcluida = isConcluida;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public boolean getConcluida() {
        return isConcluida;
    }

    public boolean getCancelada() {
        return isCancelada;
    }

    public int getId() {
        return id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public DetalhesEstadia getDetalhesEstadia() {
        return detalhesEstadia;
    }

    public void setDetalhesEstadia(DetalhesEstadia detalhesEstadia) {
        this.detalhesEstadia = detalhesEstadia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float calcularPrecoTotal() {
        return this.getQuarto().getDiaria() + this.getDetalhesEstadia().getServicoDeQuarto()
                + this.getDetalhesEstadia().getFrigobar();
    }

    public int estadiaEmDias() {
        // Se negativo, significa que data de entrada maior que de saída
        return (int) ChronoUnit.DAYS.between(this.getDataEntrada(), this.getDataSaida()) + 1;
    }
}
