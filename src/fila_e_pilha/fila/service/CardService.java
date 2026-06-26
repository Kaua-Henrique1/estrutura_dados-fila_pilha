package fila_e_pilha.fila.service;

import fila_e_pilha.fila.domain.Card;
import fila_e_pilha.fila.domain.Tarefa;

public class CardService {
    private Card cardAtivo;

    public void criarNovoCard(String titulo, int limiteMinutos) {
        this.cardAtivo = new Card(titulo, limiteMinutos);
    }

    public String adicionarTarefaNoCard(String titulo, String descricao, int duracaoMinutos) {
        if (cardAtivo == null) {
            return "[ERRO] Nenhum card ativo encontrado.";
        }

        Tarefa novaTarefa = new Tarefa(titulo, descricao, duracaoMinutos);
        boolean sucesso = cardAtivo.enfileirarTarefa(novaTarefa);

        if (sucesso) {
            return "[SUCESSO] Tarefa adicionada à Fila do Card.";
        } else {
            return "[ERRO] Não há espaço de tempo suficiente neste Card!";
        }
    }

    public String concluirTarefaAtual() {
        if (cardAtivo == null) return "[ERRO] Nenhum card ativo.";

        Tarefa concluida = cardAtivo.desenfileirarTarefa();
        if (concluida != null) {
            return "[CONCLUÍDA] A Tarefa \"" + concluida.getTitulo() + "\" foi removida da Fila.";
        } else {
            return "A Fila deste Card já está vazia.";
        }
    }

    public String espiarProxima() {
        if (cardAtivo == null) return "[ERRO] Nenhum card ativo.";

        Tarefa proxima = cardAtivo.espiarProximaTarefa();
        if (proxima != null) {
            return "Próxima Tarefa da Fila:\n" + proxima.toString();
        } else {
            return "Nenhuma Tarefa na Fila do Card.";
        }
    }

    public String listarTodasAsTarefas() {
        if (cardAtivo == null) return "[ERRO] Nenhum card ativo.";
        if (cardAtivo.getTarefaTarefas().isEmpty()) return "Nenhuma Tarefa agendada.";

        StringBuilder sb = new StringBuilder();
        int pos = 1;
        for (Tarefa t : cardAtivo.getTarefaTarefas()) {
            sb.append(pos).append("º) ").append(t.toString()).append("\n");
            pos++;
        }
        return sb.toString().trim();
    }

    public String obterStatusCardTexto() {
        if (cardAtivo == null) return "Nenhum card ativo.";

        return "==================================================\n" +
                "CARD ATIVO: " + cardAtivo.getTitulo().toUpperCase() + "\n" +
                "Tempo Alocado: " + cardAtivo.getMinutosAlocados() + "/" + cardAtivo.getLimiteMinutos() + " min\n" +
                "Tempo Restante Livre: " + cardAtivo.getTempoRestante() + " min\n" +
                "==================================================";
    }
}