package com.recepcaohotel.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Sistema {
    // Constantes dos nomes dos arquivos.
    public final String ARQ_QUARTOS = "quartos.csv";
    public final String ARQ_RESERVAS = "reservas.csv";
    public final String ARQ_USUARIOS = "usuarioa.csv";

    // Quartos serão dicionários de numeroQuarto - Quarto
    private Map<Integer, Quarto> quartos;
    private Map<Integer, Reserva> reservas;
    private Map<String, Admin> usuarios;
    private boolean isAutenticado;
    private String nomeUsuario;

    public Sistema() {
        this.isAutenticado = false;
        this.nomeUsuario = null;
        this.quartos = new HashMap<>();
        this.reservas = new HashMap<>();
        this.usuarios = new HashMap<>();

        // Pegar informações de arquivos para preencher as listas.
        this.recuperarDados();
    }

    public void cadastrarReserva(Reserva reserva) {
        // Fazer o quarto ficar indisponível.
        reserva.getQuarto().setDisponivel(false);

        // Como se espera um número único de Id, não devem haver problemas na inserção
        reservas.put(reserva.getId(), reserva);
    }

    public void cancelarReserva(int idReserva) {
        // Caso não ache no map, nada acontece
        Reserva reserva = getReserva(idReserva);
        if (reserva == null) {
            return;
        }
        reserva.getQuarto().setDisponivel(true);
        reserva.setCancelada(true);
        // reservas.remove(idReserva).getQuarto().setDisponivel(true);
    }

    public void adicionarQuarto(Quarto quarto) {

        // A ideia é que a inserção de um novo quarto com mesmo número, substitua o
        // anterior
        quartos.put(quarto.getNumero(), quarto);
    }

    public void removerQuarto(int numeroQuarto) {
        quartos.remove(numeroQuarto);
    }

    public void setIsAutenticado(boolean isAutenticado) {
        this.isAutenticado = isAutenticado;
    }

    public boolean getIsAutenticado() {
        return this.isAutenticado;
    }

    public boolean autenticar(String nomeUsuario, String senha) {
        Admin adm = usuarios.get(nomeUsuario);
        // Caso o nome de usuário não exista retornar falso.
        if (adm == null) {
            return false;
        }
        // Caso a senha for inválida retornar falso.
        if (!adm.compararSenha(senha)) {
            return false;
        }
        // Caso o admin criado esteja no map de usuários, autorizar
        setIsAutenticado(true);
        this.nomeUsuario = nomeUsuario;
        return true;
    }

    public void finalizarSessao() {
        this.nomeUsuario = null;
        setIsAutenticado(false);
    }

    public void realizarCheckout(int idReserva) {
        Reserva reserva = getReserva(idReserva);
        if (reserva == null) {
            return;
        }
        reserva.getQuarto().setDisponivel(true);
        reserva.setConcluida(true);
        // Adicionar também a lógica para calacular o preço total
        // reservas.remove(idReserva);
    }

    public Collection<Quarto> consultarQuartos() {
        // Precisa retornar uma copia do set
        Set<Quarto> copia = new LinkedHashSet<Quarto>();
        copia.addAll(quartos.values());
        return copia;
    }

    public Collection<Reserva> consultarReservas() {
        // Precisa retornar uma copia do set
        Set<Reserva> copia = new LinkedHashSet<Reserva>();
        copia.addAll(reservas.values());
        return copia;
    }

    public Quarto getQuarto(int num) {
        // Observar que retornar uma referencia para este quarto (cuidado!)
        return quartos.get(num);
    }

    public Reserva getReserva(int id) {
        // Observar que retornar uma referencia para esta reserva (cuidado!)
        return reservas.get(id);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void recuperarDados() {
        // TODO: Lógica para recuperar os dados dos arquivos salvos.
    }

    private void recuperarQuartos() {
    }

    private void recuperarReservas() {
    }

    private void recuperarUsuarios() {
    }

    public void salvarDados() {
        // TODO: Lógica para salvar os dados em arquivos.
    }

    private void salvarQuartos() {
    }

    private void salvarReservas() {
    }

    // Método apenas para testar todos os dados armazenados como Quartos
    public void imprimirQuartos(Collection<Quarto> quartos) {
        for (Quarto quarto : quartos) {
            System.out.println("Quarto numero: " + quarto.getNumero());
            System.out.println("Valor da diária: " + quarto.getDiaria());
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
