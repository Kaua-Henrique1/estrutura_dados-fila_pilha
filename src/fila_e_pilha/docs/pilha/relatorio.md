# Relatório Acadêmico: Fundamentos da Estrutura de Dados Pilha (Stack)

## 1. Funcionamento Teórico da Pilha

A estrutura de dados **Pilha (Stack)** opera estritamente sob o princípio **LIFO (Last-In, First-Out)**, ou seja, **Último a Entrar, Primeiro a Sair**.

O seu funcionamento é semelhante a um corredor de estacionamento de via única sem saída: os novos veículos entram sempre pelo mesmo lado (a entrada/saída do corredor) e a remoção ocorre obrigatoriamente por esse mesmo lado, obrigando a retirar o último veículo que entrou para liberar o caminho para os restantes.

---

## Ciclo de Vida e Estados da Pilha

Para compreender a dinâmica da estrutura, simulamos uma pilha (estacionamento) com capacidade para três elementos.

### Configuração Inicial

- **Capacidade:** Dinâmica (lista expansível via `ArrayList`). Para fins de demonstração visual, simularemos a entrada de 3 veículos.
- **Estado Inicial:** `[ vazio ]`

---

## 2. Operações Fundamentais da Pilha

### A. Inserção (Push / `push`)

Os elementos são inseridos sempre no topo da pilha (junto à saída do estacionamento).

#### Inserção 1
Inserir `Carro A`

```text
[Carro A]
```

O fundo e o topo apontam para o mesmo elemento.

#### Inserção 2
Inserir `Carro B`

```text
[Carro A, Carro B]
```

#### Inserção 3
Inserir `Carro C`

```text
[Carro A, Carro B, Carro C]
```

Estado da estrutura:

```text
FUNDO                              TOPO
[Carro A] ──> [Carro B] ──> [Carro C]
                               │
                               ▼
                        (Próximo a sair)
                        (Último inserido)
```

---

### B. Inspeção (Top / `top`)

Permite visualizar o elemento localizado no topo da pilha sem o remover.

#### Execução

```java
estacionamento.top();
```

#### Resultado

```text
Carro C
```

O estado da pilha permanece inalterado:

```text
[Carro A, Carro B, Carro C]
```

---

### C. Remoção (Pop / `pop`)

A remoção ocorre exclusivamente no topo da pilha.

#### Remoção 1

```java
estacionamento.pop();
```

Elemento removido:

```text
Carro C
```

Novo estado:

```text
[Carro A, Carro B]
```

O novo topo passa a ser o Carro B.

#### Remoção 2

```java
estacionamento.pop();
```

Elemento removido:

```text
Carro B
```

Novo estado:

```text
[Carro A]
```

Agora o fundo e o topo apontam novamente para o mesmo elemento.

---

## 3. Considerações Técnicas

Quando implementada através de uma lista dinâmica (`ArrayList`) encapsulada, as operações de inserção e remoção no final da lista possuem complexidade constante **O(1)**.

Isso ocorre porque a estrutura manipula apenas os índices e referências do último elemento inserido, evitando deslocamentos de dados na memória. Para o projeto, optou-se por construir a estrutura do zero, demonstrando o domínio sobre a mecânica da Pilha sem depender de bibliotecas nativas, seguindo a lógica apresentada na disciplina.

### Vantagens

- Inserção e remoção extremamente rápidas.
- Controle natural de processos reversos (desfazer ações).
- Solução perfeita para problemas com bloqueios físicos e dependência de ordem reversa, como o Estacionamento de Via Única.

### Desvantagens

- O acesso direto a elementos intermediários ou da base não é eficiente.
- A busca exige o desempilhamento sequencial dos elementos.

---

## Conclusão

A estrutura de dados Pilha é a solução incontestável para cenários em que a ordem de processamento deve respeitar um retrocesso exato dos passos anteriores. O seu modelo LIFO garante que o último elemento retido no sistema seja o primeiro a ser acessado, tornando-a numa representação fiel e eficiente da limitação física encontrada num estacionamento em formato de corredor sem saída.