# Relatório Técnico: Arquitetura e Execução do MVP Card-Fila

## 1. Visão Geral do Projeto

O sistema desenvolvido consiste em um gerenciador de tempo executado via terminal.

O núcleo da aplicação é a entidade **Card**, responsável por representar um bloco de tempo previamente definido pelo usuário. Cada Card contém internamente uma **Fila (FIFO)** utilizada para armazenar tarefas.

Exemplo:

- Card: Estudos
- Tempo disponível: 180 minutos
- Estrutura interna: Queue<Tarefa>

---

## 2. Fluxo Geral do Sistema

```text
                  [ Inicialização do Sistema ]
                               │
                               ▼
                    [ Criar Card de Tempo ]
                  (Título e Duração Máxima)
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

   [Inserir Tarefa]                     [Concluir Tarefa]

         │                                       │
         ▼                                       ▼

 Verificar Tempo                    Verificar se a
 Disponível                         Fila está Vazia

         │                                       │

    ┌────┴─────┐                         ┌───────┴───────┐
    │          │                         │               │

   Sim        Não                       Não             Sim

    │          │                         │               │

    ▼          ▼                         ▼               ▼

Adicionar    Exibir              Remover da Fila    Exibir
na Fila      Erro                (FIFO)             Mensagem

    │                                    │
    └────────────────────────────────────┘
                     │
                     ▼
                Retorna ao Menu
```

---

## 3. Rastreamento da Execução

### Passo 1 – Criação do Card

O usuário cria um Card com as seguintes configurações:

```text
Título: Estudos
Tempo Máximo: 180 minutos
```

Estado inicial:

```text
Card:
- minutosAlocados = 0
- fila = vazia
```

---

### Passo 2 – Inserção de Tarefas

#### Tentativa 1

Usuário adiciona:

```text
Exercícios - 120 minutos
```

Validação:

```text
0 + 120 ≤ 180
```

Resultado:

```text
Permitido
```

Estado:

```text
Fila:
[ Exercícios ]

Tempo alocado:
120 minutos
```

---

#### Tentativa 2

Usuário adiciona:

```text
Revisão - 90 minutos
```

Validação:

```text
120 + 90 ≤ 180
```

Resultado:

```text
210 > 180
```

A operação é bloqueada.

Mensagem exibida:

```text
Tempo insuficiente.
Restam apenas 60 minutos disponíveis.
```

Estado permanece:

```text
Fila:
[ Exercícios ]

Tempo alocado:
120 minutos
```

---

### Passo 3 – Consulta da Próxima Tarefa

Operação:

```java
peek()
```

Resultado:

```text
Exercícios
```

Estado da fila permanece inalterado:

```text
[ Exercícios ]
```

---

### Passo 4 – Conclusão da Tarefa

Operação:

```java
poll()
```

Elemento removido:

```text
Exercícios
```

Novo estado:

```text
Fila:
[ vazia ]
```

Atualização automática:

```text
Tempo alocado:
0 minutos
```

Todo o tempo do Card fica novamente disponível.