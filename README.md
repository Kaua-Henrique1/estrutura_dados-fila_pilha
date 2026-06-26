# Estrutura de Dados - Fila (Queue)

Este projeto foi desenvolvido para demonstrar a aplicação prática de uma estrutura de dados do tipo **Fila (FIFO - First-In, First-Out)** em Java, utilizando um cenário de gestão e alocação de tarefas dentro de cartões de tempo (*Cards*).

---

## Sobre o Projeto

O sistema simula um gerenciador de rotina onde o usuário cria um **Card** com um limite máximo de tempo (em minutos). Dentro desse Card, é possível enfileirar várias **Tarefas**, desde que a soma do tempo delas não ultrapasse o limite do Card.

As operações de fila demonstradas são:
* **Enqueue (Adicionar):** Insere uma nova tarefa no final da fila.
* **Dequeue/Poll (Concluir):** Remove e conclui a tarefa que está no início da fila.
* **Peek (Espiar):** Visualiza qual é a próxima tarefa a ser executada sem removê-la.

---

## Documentação do Projeto

A análise detalhada sobre o comportamento da fila, simulações de cenários e o relatório do projeto podem ser consultados nos links abaixo:

* [Relatório de Desenvolvimento](./src/fila_e_pilha/docs/fila/relatorio.md)
* [Simulação da Fila de Tarefas](./src/fila_e_pilha/docs/fila/simulation.md) *(Clique aqui para ver a documentação da fila)*

---

## Dependências e Requisitos

Para compilar e rodar este projeto, você precisará apenas do ambiente básico do Java instalado na sua máquina:

| Requisito | Versão Mínima  | Link para Download |
| :--- |:--------------:| :--- |
| **Java JDK** | 17 ou superior | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) / [OpenJDK](https://adoptium.net/) |
| **Git** (Opcional) |      2.0+      | [Git SCM](https://git-scm.com/) |

*Nota: Não é necessária nenhuma biblioteca ou framework externo (como Spring ou Maven). O projeto utiliza puramente recursos nativos da linguagem Java (`java.util.Queue` e `java.util.LinkedList`).*

---

## Como Rodar o Projeto

### Opção 1: Pelo Terminal (Prompt de Comando/Bash)

1. Clone o repositório:
   ```bash
   git clone https://github.com/Kaua-Henrique1/estrutura_dados-fila_pilha.git
    ```

2. Compile todos os arquivos Java a partir da pasta raiz:
   ```bash
   javac src/fila_e_pilha/fila/domain/*.java src/fila_e_pilha/fila/service/*.java src/fila_e_pilha/fila/ui/*.java src/fila_e_pilha/fila/GerenciadorTarefas.java -d out/
   ```

3. Execute o programa:

   ```bash
   java -cp out fila_e_pilha.fila.GerenciadorTarefas
   ```