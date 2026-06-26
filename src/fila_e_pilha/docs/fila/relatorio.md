# Relatório Acadêmico: Fundamentos da Estrutura de Dados Fila (Queue)

## 1. Funcionamento Teórico da Fila

A estrutura de dados **Fila (Queue)** opera estritamente sob o princípio **FIFO (First-In, First-Out)**, ou seja, **Primeiro a Entrar, Primeiro a Sair**.

Seu funcionamento é semelhante ao de uma fila de banco ou supermercado: os novos elementos entram sempre no final da fila, enquanto a remoção ocorre obrigatoriamente no início.

---

## Ciclo de Vida e Estados da Fila

Para compreender a dinâmica da estrutura, simulamos uma fila com capacidade máxima de três elementos.

### Configuração Inicial

- **Capacidade Máxima:** 3 elementos
- **Estado Inicial:** `[ vazia ]`

---

## 2. Operações Fundamentais da Fila

### A. Inserção (Enqueue / `add`)

Os elementos são inseridos sempre no final da fila.

#### Inserção 1
Inserir `Tarefa A`

```text
[Tarefa A]
```

Início e fim apontam para o mesmo elemento.

#### Inserção 2
Inserir `Tarefa B`

```text
[Tarefa A, Tarefa B]
```

#### Inserção 3
Inserir `Tarefa C`

```text
[Tarefa A, Tarefa B, Tarefa C]
```

Estado da estrutura:

```text
[Tarefa A] ──> [Tarefa B] ──> [Tarefa C]
     │                              │
     ▼                              ▼
  INÍCIO                          FIM
(Próximo a sair)          (Último inserido)
```

---

### B. Inspeção (Peek / `peek`)

Permite visualizar o elemento localizado no início da fila sem removê-lo.

#### Execução

```java
fila.peek();
```

#### Resultado

```text
Tarefa A
```

Estado da fila permanece:

```text
[Tarefa A, Tarefa B, Tarefa C]
```

---

### C. Remoção (Dequeue / `poll`)

A remoção ocorre exclusivamente no início da fila.

#### Remoção 1

```java
fila.poll();
```

Elemento removido:

```text
Tarefa A
```

Novo estado:

```text
[Tarefa B, Tarefa C]
```

O novo início passa a ser a Tarefa B.

#### Remoção 2

```java
fila.poll();
```

Elemento removido:

```text
Tarefa B
```

Novo estado:

```text
[Tarefa C]
```

Agora o início e o fim apontam para o mesmo elemento.

---

## 3. Matriz de Complexidade Assintótica

| Estrutura de Dados | Inserção | Remoção | Busca Geral | Espaço |
|-------------------|-----------|----------|-------------|---------|
| Fila (Queue - FIFO) | O(1) | O(1) | O(n) | O(n) |
| Pilha (Stack - LIFO) | O(1) | O(1) | O(n) | O(n) |
| Lista Encadeada | O(1) | O(n) | O(n) | O(n) |

---

## 4. Considerações Técnicas

Quando implementada através da interface `Queue` utilizando a classe `LinkedList` em Java, as operações de inserção e remoção possuem complexidade constante **O(1)**.

Isso ocorre porque a estrutura manipula apenas referências para os elementos de início e fim da fila, evitando deslocamentos de dados na memória.

### Vantagens

- Inserção rápida.
- Remoção rápida.
- Controle natural de processamento sequencial.
- Ideal para gerenciamento de tarefas, filas de impressão e sistemas de atendimento.

### Desvantagens

- Acesso direto a elementos intermediários não é eficiente.
- Busca exige percurso sequencial dos elementos.

---

## Conclusão

A estrutura de dados Fila é uma solução eficiente para cenários em que a ordem de processamento deve respeitar rigorosamente a sequência de chegada dos elementos. Seu modelo FIFO garante previsibilidade e simplicidade operacional, tornando-a amplamente utilizada em aplicações reais como escalonamento de processos, gerenciamento de tarefas e sistemas de atendimento.