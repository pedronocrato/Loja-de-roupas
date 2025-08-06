# Loja de Roupas - Sistema de Vendas CLI

Bem-vindo ao repositório do meu projeto de **Loja de Roupas em Java**! 🚀 Este é um sistema de vendas simples, executado via linha de comando (CLI), desenvolvido para demonstrar conceitos fundamentais de Programação Orientada a Objetos (POO) em Java.

## Sobre

O objetivo deste repositório é apresentar uma aplicação prática que simula o processo de compra em uma loja de roupas. O usuário pode escolher diferentes tipos de produtos, selecionar modelos e tamanhos, calcular o valor final com base na forma de pagamento e, ao final, ter os itens do seu carrinho salvos em um arquivo `.csv`.

Este projeto serve como um exemplo educacional para quem está aprendendo sobre herança, polimorfismo, manipulação de arquivos e coleções em Java.

## Funcionalidades

O sistema permite ao usuário:

- **Selecionar Produtos**: Escolher entre diferentes categorias de itens.
  - Camisa
  - Calça
  - Calçado
  - Perfume
- **Personalizar Itens**: Definir modelo e tamanho para cada produto.
- **Calcular Pagamento**: Simular o valor final com duas opções:
  - **Pix**: Com 10% de desconto.
  - **Parcelado**: Com 20% de acréscimo.
- **Carrinho de Compras**: Adicionar múltiplos produtos a um carrinho.
- **Salvar Carrinho**: Exportar a lista de produtos do carrinho para um arquivo `produtos.csv` ao final da execução.

## Conceitos Aplicados

### Programação Orientada a Objetos
- **Herança**: A classe base `Produto` é estendida por classes específicas (`Camisa`, `Calca`, etc.).
- **Polimorfismo**: O carrinho (`List<Produto>`) armazena diferentes tipos de produtos que respondem de forma única a métodos como `getResumo()` e `pagarPix()`.

### Outros Conceitos
- **Java Collections Framework**: Uso de `ArrayList` para gerenciar o carrinho de compras.
- **Manipulação de Arquivos (I/O)**: Leitura de dados do console com `Scanner` e gravação dos produtos em um arquivo `.csv` usando `FileWriter` и `PrintWriter`.

## Ferramentas e Tecnologias

- **Java 17 ou superior**: Linguagem de programação utilizada.
- **IDE recomendada**: [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [Eclipse](https://www.eclipse.org/).
