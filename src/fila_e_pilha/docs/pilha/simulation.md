# Relatório Técnico: Arquitetura e Execução da Pilha (Estacionamento)

## 1. Visão Geral do Projeto

O sistema desenvolvido consiste num simulador de gestão para um estacionamento de via única executado via terminal.

O núcleo da aplicação é a entidade **Pilha (LIFO)**, construída a partir do zero utilizando encapsulamento, responsável por armazenar os objetos `Carro`.

Exemplo:

- Cenário: Estacionamento sem saída
- Estrutura interna: `ArrayList<Carro>` encapsulado
- Regra: O último carro a entrar bloqueia a saída dos restantes.

---

## 2. Fluxo Geral do Sistema

```text
                  [ Inicialização do Sistema ]
                               │
                               ▼
                  [ Criar Pilha (Estacionamento) ]
                               │
                               ▼
                     ┌──────────────────┐
                     │   MENU CENTRAL   │
                     └────────┬─────────┘
                              │
                              ▼

         ┌───────────────────────────────────────┐
         │                                       │
         ▼                                       ▼

   [1 - Entrada (Push)]                [2 - Saída (Pop)]

         │                                       │
         ▼                                       ▼

  Adicionar Carro                     Verificar se a Pilha
  no Topo da Pilha                    está Vazia

         │                                       │

         │                               ┌───────┴───────┐
         │                               │               │

         │                              Não             Sim

         │                               │               │

         ▼                               ▼               ▼

  Exibir Mensagem                 Remover do Topo      Exibir
  de Sucesso                      (LIFO)               Aviso de Erro

         │                               │               │
         └───────────────────────────────┴───────────────┘
                                 │
                                 ▼
                          Retorna ao Menu
```

---

## 3. Rastreamento da Execução

### Passo 1 – Início da Operação

O sistema inicia com a criação da Pilha vazia.

Estado inicial:

```text
Estacionamento:
- size = 0
- isEmpty = true
- topo = null
```

---

### Passo 2 – Inserção de Veículos

#### Ação do Operador

Usuário insere o `Fiat Uno`:

```text
Entrada: Fiat Uno
Operação: push()
```

Usuário insere o `Toyota Corolla`:

```text
Entrada: Toyota Corolla
Operação: push()
```

Resultado e Estado:

```text
Pilha:
[ Fiat Uno, Toyota Corolla ]

Topo atual (bloqueia a saída):
Toyota Corolla
```

---

### Passo 3 – Consulta do Veículo no Topo

Operação:

```java
top()
```

Resultado:

```text
Toyota Corolla
```

Estado da pilha permanece inalterado:

```text
[ Fiat Uno, Toyota Corolla ]
```

---

### Passo 4 – Remoção (Saída do Veículo)

Operação:

```java
pop()
```

Elemento removido (Obrigado a sair primeiro):

```text
Toyota Corolla
```

Novo estado:

```text
Pilha:
[ Fiat Uno ]

Topo atual:
Fiat Uno
```

Desta forma, o caminho físico encontra-se novamente livre para o veículo que entrou primeiro poder abandonar o local.