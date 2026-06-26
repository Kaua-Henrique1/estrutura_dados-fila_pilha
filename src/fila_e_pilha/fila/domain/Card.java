package fila_e_pilha.fila.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Card {
    private String titulo;
    private final int limiteMinutos;
    private int minutosAlocados;
    private final Queue<Tarefa> TarefaTarefas;

    public Card(String titulo, int limiteMinutos) {
        this.titulo = titulo;
        this.limiteMinutos = limiteMinutos;
        this.minutosAlocados = 0;
        this.TarefaTarefas = new LinkedList<>();
    }

    public boolean enfileirarTarefa(Tarefa Tarefa) {
        if (this.minutosAlocados + Tarefa.getDuracaoMinutos() > this.limiteMinutos) {
            return false;
        }
        TarefaTarefas.add(Tarefa);
        this.minutosAlocados += Tarefa.getDuracaoMinutos();
        return true;
    }

    public Tarefa desenfileirarTarefa() {
        Tarefa TarefaConcluida = TarefaTarefas.poll();
        if (TarefaConcluida != null) {
            this.minutosAlocados -= TarefaConcluida.getDuracaoMinutos();
        }
        return TarefaConcluida;
    }

    public Tarefa espiarProximaTarefa() {
        return TarefaTarefas.peek();
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public int getLimiteMinutos() { return limiteMinutos; }
    public int getMinutosAlocados() { return minutosAlocados; }
    public Queue<Tarefa> getTarefaTarefas() { return TarefaTarefas; }
    public int getTempoRestante() { return limiteMinutos - minutosAlocados; }
}