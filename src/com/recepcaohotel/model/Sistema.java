package com.recepcaohotel.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
    // Pensar em como transformar essas coisas para serem lidas de arquivos

    // Quartos serão dicionários de numeroQuarto - Quarto
    Map<Integer, Quarto> quartos = new HashMap<Integer, Quarto>();
    Map<Integer, Reserva> reservas = new HashMap<Integer, Reserva>();
    Map<String, String> usuarios = new HashMap<String, String>();
    boolean isAutenticado;
    String nomeUsuario;

    public void cadastrarReserva(Reserva reserva) {

        // Como se espera um número único de Id, não devem haver problemas na inserção
        reservas.put(reserva.getId(), reserva);
    }

    public void cancelarReserva(int idReserva) {

        // Caso não ache no map, nada acontece
        reservas.remove(idReserva);
    }

    public void adicionarQuarto(Quarto quarto) {

        // A ideia é que a inserção de um novo quarto com mesmo número, substitua o
        // anterior
        quartos.put(quarto.getNumero(), quarto);
    }

    public void removerQuarto(int numeroQuarto) {
        quartos.remove(numeroQuarto);
    }

    public void setAutenticado(boolean isAutenticado) {
        this.isAutenticado = isAutenticado;
    }

    public void autenticar() {
        // TODO: Como pegar a senha sem perda de segurança?

        // Caso o admin criado esteja no map de usuários, autorizar
        setAutenticado(true);
    }

    public void finalizarSessao() {
        setAutenticado(false);
    }

    public void realizarCheckout(int idReserva) {
        // Adicionar também a lógica para calacular o preço total
        reservas.remove(idReserva);
    }

    public Collection<Quarto> consultarQuartos() {
        return quartos.values();
    }

    public Collection<Reserva> consultarReservas() {
        return reservas.values();
    }

    // Método apenas para testar todos os dados armazenados como Quartos
    public void imprimirQuartos(Collection<Quarto> quartos) {
        for (Quarto quarto : quartos) {
            System.out.println("Quarto numero: " + quarto.getNumero());
            System.out.println("Valor da diári: " + quarto.getDiaria());
            System.out.println("Camas de Casal: " + quarto.getQntdCamasCasal());
            System.out.println("Camas de Solteiro: " + quarto.getQntdCamasSolteiro());
            System.out.println("Disponibilidade: " + quarto.getDisponivel() + "\n");
        }
    }

    // Método apenas para testar todos os dados armazenados como Reservas
    public void imprimiReservas(Collection<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            System.out.println("Id da reserva: " + reserva.getId());
            System.out.println("Data de entrada: " + reserva.getDataEntrada());
            System.out.println("Data de Saída: " + reserva.getDataSaida());
            System.out.println("Cancelada: " + reserva.getCancelada());
            System.out.println("Concluida: " + reserva.getConcluida() + "\n");
        }
    }
}
