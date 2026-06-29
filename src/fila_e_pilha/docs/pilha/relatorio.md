# Relatório – Aplicação da Estrutura de Dados Pilha

## Tema
Aplicação da Estrutura de Dados Pilha

---

# 1. Introdução

As estruturas de dados são fundamentais para o desenvolvimento de sistemas computacionais, pois permitem organizar e manipular informações de maneira eficiente. Entre elas, a estrutura **Pilha (Stack)** destaca-se por seguir o princípio **LIFO (Last In, First Out)**, em que o último elemento inserido é o primeiro a ser removido.

Neste trabalho foi desenvolvida uma aplicação que simula um **estacionamento de vaga única**, utilizando a estrutura de dados Pilha para controlar a entrada e saída dos veículos.

---

# 2. Aplicação Escolhida

A aplicação consiste em um sistema simples de gerenciamento de um estacionamento onde os carros ficam estacionados um atrás do outro.

Nesse tipo de estacionamento, somente o último veículo que entrou pode sair imediatamente, tornando a Pilha a estrutura ideal para representar essa situação.

Cada veículo possui duas informações:

- Modelo
- Placa

O sistema permite ao usuário realizar as seguintes operações:

- Adicionar veículo;
- Remover veículo;
- Consultar o último veículo estacionado;
- Verificar a quantidade de veículos;
- Verificar se o estacionamento está vazio;
- Exibir todos os veículos.

---

# 3. Justificativa da Estrutura Utilizada

A estrutura **Pilha** foi escolhida porque seu funcionamento corresponde exatamente ao comportamento de um estacionamento de vaga única.

A pilha segue a política **LIFO (Last In, First Out)**:

> O último veículo que entra é o primeiro que pode sair.

Cada método da estrutura possui uma aplicação prática no sistema:

| Método | Função no sistema |
|---------|-------------------|
| push() | Adiciona um carro ao estacionamento |
| pop() | Remove o último carro estacionado |
| top() | Mostra qual carro está na saída |
| size() | Informa quantos carros existem |
| isEmpty() | Verifica se há veículos estacionados |

---

# 4. Funcionamento do Sistema

O projeto foi dividido em três classes.

## Carro.java

Representa um veículo, armazenando:

- Modelo
- Placa

---

## Pilha.java

Responsável por implementar a estrutura Pilha utilizando um `ArrayList`.

Ela contém os métodos principais:

- push()
- pop()
- top()
- size()
- isEmpty()

---

## SistemaEstacionamento.java

Classe principal do programa.

Ela apresenta um menu interativo onde o usuário escolhe qual operação deseja realizar sobre a pilha.

---

# 5. Simulação da Execução

## Estado inicial

```

Estacionamento vazio.

```

---

## Inserindo veículos

Usuário escolhe:

```

1 - Adicionar veículo

```

Entrada:

```

Modelo: Gol
Placa: ABC-1234

```

Resultado:

```

Veículo adicionado com sucesso.

```

Pilha:

```

Topo
┌──────────────┐
│ Gol          │
└──────────────┘

```

---

Usuário adiciona outro veículo.

```

Modelo: Onix
Placa: DEF-5678

```

Pilha:

```

Topo
┌──────────────┐
│ Onix         │
├──────────────┤
│ Gol          │
└──────────────┘

```

---

Usuário adiciona mais um veículo.

```

Modelo: HB20
Placa: GHI-9012

```

Pilha:

```

Topo
┌──────────────┐
│ HB20         │
├──────────────┤
│ Onix         │
├──────────────┤
│ Gol          │
└──────────────┘

```

---

## Consultando o topo

Usuário seleciona:

```

3 - Consultar último veículo

```

Saída:

```

Último veículo estacionado:

Modelo: HB20
Placa: GHI-9012

```

---

## Removendo um veículo

Usuário escolhe:

```

2 - Remover veículo

```

Resultado:

```

Veículo removido:

Modelo: HB20
Placa: GHI-9012

```

Nova pilha:

```

Topo
┌──────────────┐
│ Onix         │
├──────────────┤
│ Gol          │
└──────────────┘

```

---

## Consultando a quantidade

Usuário escolhe:

```

4 - Quantidade de veículos

```

Saída:

```

Quantidade: 2

```

---

## Verificando se está vazio

Usuário escolhe:

```

5 - Estacionamento vazio?

```

Saída:

```

Não.

Existem veículos estacionados.

```

---

## Exibindo todos os veículos

Usuário escolhe:

```

6 - Listar veículos

```

Saída:

```

Onix - DEF-5678
Gol - ABC-1234

```

---
