package fila_e_pilha.pilha;

import java.util.ArrayList;

public class Pilha {
    private final ArrayList<Carro> pilha;
    
    public Pilha() {
        pilha = new ArrayList<>();
    }
     
    public void push(Carro carro) {
        pilha.add(carro);
    }
    
    public Carro pop() {
        if (isEmpty())
            return null;
        else
            return pilha.remove(pilha.size()-1);
    }
    
    public Carro top() {
        if (isEmpty())
            return null;
        else
            return pilha.get(pilha.size()-1);
    }
    
    public int size() {
        return pilha.size();
    }
    
    public boolean isEmpty() {
        return pilha.isEmpty();
    }    
    
    public ArrayList<Carro> getElementos() {
        return pilha;
    }
}