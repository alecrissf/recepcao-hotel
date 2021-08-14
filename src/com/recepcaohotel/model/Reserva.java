package com.recepcaohotel.model;

import java.util.Date;
import java.util.Random;

public class Reserva {
    private int id;
    private Date dataEntrada;
    private Date dataSaida;
    private boolean isConcluida;
    private boolean isCancelada;

    public Reserva() {
        // Gerar código da reserva em sequencia pseudoaleatoria
        // Pensar em verificar a ocorrência de números aleatórios iguais
        Random f = new Random();
        this.id = f.nextInt(100000);
    }

    public Reserva(Date dataEntrada, Date dataSaida) {
        // Gerar código da reserva em sequencia pseudoaleatoria
        // Pensar em verificar a ocorrência de números aleatórios iguais
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.isCancelada = false;
        this.isConcluida = false;
        Random f = new Random();
        this.id = f.nextInt(100000);
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setCancelada(boolean isCancelada) {
        this.isCancelada = isCancelada;
    }

    public void setConcluida(boolean isConcluida) {
        this.isConcluida = isConcluida;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
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

    int estadiaEmDias() {
        // Se negativo, significa que data de entrada maior que de saída
        long diff = getDataSaida().getTime() - getDataEntrada().getTime();
        return (int) diff / (1000 * 60 * 60 * 24);
    }

    // Declaração de data:
    // Calendar calendar = Calendar.getInstance();
    // calendar.set(2000,1,10);
    // Date dataIni = calendar.getTime();

}
