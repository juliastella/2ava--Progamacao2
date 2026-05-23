# 2ava--Progamacao2

# 🎮 Jogo da Velha - Orientado a Objetos

## Proposta do Trabalho

A proposta deste projeto é demonstrar a aplicação prática e completa dos pilares da Orientação a Objetos através de um jogo clássico: o Jogo da Velha.

A escolha por desenvolver um jogo, em vez de um sistema de gerenciamento tradicional (como cadastros ou estoques), deu-se pelo fato de que jogos oferecem um cenário excelente, divertido e desafiador para a modelagem de classes.

##  Arquitetura e Requisitos das Classes

Oo projeto foi dividido em 7 classes principais e 1 interface:

### 1. Classe `Campo` (Encapsulamento e Objetos)

* **O que faz:** Representa uma única célula (quadradinho) do tabuleiro.
* **Conceito de POO:** É o  **Encapsulamento**. O atributo `simbolo` (que guarda 'X', 'O' ou espaço vazio) é `private`, protegendo a integridade do dado. A única forma de ler ou alterar esse símbolo é através do seu construtor e dos métodos públicos `getSimbolo()` e `setSimbolo()`.

### 2. Interface `RegrasDoJogo` (Interfaces)

* **O que faz:** Define um contrato obrigatório para qualquer tabuleiro que venha a ser criado no sistema.
* **Conceito de POO:**  **Interface**. Ela dita que o jogo deve ter métodos para `verificarVitoria` e verificar se o `tabuleiroCheio`, mas deixa a implementação (o "como fazer") para a classe que a assinar.

### 3. Classe `Tabuleiro` (Composição e Arrays)

* **O que faz:** Gerencia a matriz 3x3 do jogo, desenha o grid na tela e valida as linhas/colunas para checar se houve vitória.
* **Conceito de POO:** Implementa a interface `RegrasDoJogo` utiliza **Arrays** (através de uma matriz bidimensional do tipo `Campo[][]`). O uso de **Construtores** para inicializar os 9 objetos `Campo` instanciados na memória.

### 4. Classe Abstrata `Jogador` (Classes Abstratas)

* **O que faz:** Serve como um "molde" base para os jogadores da partida, guardando o `nome` e o `simbolo` escolhido ('X' ou 'O').
* **Conceito de POO:** Sendo uma **Classe Abstrata**, ela não pode ser instanciada diretamente. Ela possui um método abstrato `fazerJogada()` que força as suas classes filhas a implementarem suas próprias lógicas de jogada.

### 5. Classe `JogadorHumano` (Herança e Polimorfismo)

* **O que faz:** Representa um jogador real interagindo com o sistema via teclado (`Scanner`).
* **Conceito de POO:** Utiliza a **Herança** ao estender (`extends`) a classe `Jogador`. O **Polimorfismo** acontece ao sobrescrever (`@Override`) o método `fazerJogada()`, programando-o para ler as coordenadas (linha e coluna) digitadas pelo usuário.

### 6. Classe `JogadorBot` (Herança e Polimorfismo)

* **O que faz:** Representa o computador jogando contra o usuário.
* **Conceito de POO:** Também herda de `Jogador`, mas o seu **Polimorfismo** age diferente: o método `fazerJogada()` foi sobrescrito para usar a classe `Random`, gerando jogadas automáticas e aleatórias, provando que o mesmo método.

### 7. Classe `JogadaInvalidaException` (Exceções Customizadas)

* **O que faz:** Um tratador de erros específico para as regras do jogo.
* **Conceito de POO:** Herda da classe `Exception` do Java. Se o usuário tenta jogar em um campo já marcado, o tabuleiro lança (`throw`) esta exceção personalizada com uma mensagem de aviso, evitando que o programa feche abruptamente.

### 8. Classe `JogoDaVelha` (Classe Principal / Main)

* **O que faz:** É o motor que faz o jogo rodar, controlando os turnos, recebendo os inputs de configuração e declarando o vencedor.
* **Conceito de POO:** Demonstra a **Aplicação de Controles de Fluxo** (`while`, `if/else`), implementa os blocos `try/catch` para tratar a nossa exceção customizada, e faz o uso de **ArrayList** para guardar o histórico de todas as jogadas e imprimi-las ao final da partida.

---

# Gravação da explicação
