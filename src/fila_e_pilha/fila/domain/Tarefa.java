package fila_e_pilha.fila.domain;

public class Tarefa {
    private String titulo;
    private String descricao;
    private int duracaoMinutos;

    public Tarefa(String titulo, String descricao, int duracaoMinutos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public int getDuracaoMinutos() { return duracaoMinutos; }

    @Override
    public String toString() {
        return "[" + titulo + "] - " + descricao + " (" + duracaoMinutos + " min)";
    }
}