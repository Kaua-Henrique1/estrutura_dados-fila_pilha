package fila_e_pilha.fila;

import fila_e_pilha.fila.service.CardService;
import fila_e_pilha.fila.ui.MenuConsole;

public class GerenciadorTarefas {
    public static void main(String[] args) {
        CardService cardService = new CardService();
        MenuConsole menu = new MenuConsole(cardService);
        menu.iniciar();
    }
}