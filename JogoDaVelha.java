import java.util.ArrayList;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        // ArrayList para guardar o histórico
        ArrayList<String> historicoJogadas = new ArrayList<>();

        System.out.println("=== BEM-VINDO AO JOGO DA VELHA ORIENTADO A OBJETOS ===");
        System.out.print("Nome do Jogador 1 (Humano - X): ");
        String nome1 = scanner.nextLine();
        Jogador jogador1 = new JogadorHumano(nome1, 'X');

        System.out.println("\nVais jogar contra quem?");
        System.out.println("1 - Computador (Bot)");
        System.out.println("2 - Outro Humano");
        System.out.print("Escolha (1 ou 2): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        Jogador jogador2;
        if (escolha == 1) {
            // Instancia o Bot (Herança)
            jogador2 = new JogadorBot("Bot Inteligente", 'O');
        } else {
            // Instancia outro Humano
            System.out.print("Nome do Jogador 2 (Humano - O): ");
            String nome2 = scanner.nextLine();
            jogador2 = new JogadorHumano(nome2, 'O');
        }

        Jogador jogadorAtual = jogador1; // que começa com o simbolo "X"
        boolean jogoRolando = true; // A codiçãodo laço de repetição

        // Controle de Fluxo
        while (jogoRolando) {
            tabuleiro.desenhar();
            try {
                // POLIMORFISMO NA PRÁTICA: 
                // Se for humano, pede teclado. Se for Bot, gera números aleatórios.
                // O Main não precisa saber quem é, só chama o metodo!
                int[] jogada = jogadorAtual.fazerJogada();

                // Tenta marcar a jogada (pode lançar a JogadaInvalidaException)
                tabuleiro.marcarJogada(jogada, jogadorAtual.getSimbolo());

                // Guarda no ArrayList
                historicoJogadas.add(jogadorAtual.getNome() + " colocou '" + jogadorAtual.getSimbolo() + "' na Posição [" + jogada[0] + ", " + jogada[1] + "]");

                // Verifica se o jogador atual venceu
                if (tabuleiro.verificarVitoria(null)) {
                    tabuleiro.desenhar();
                    System.out.println("\n🏆 PARABÉNS! " + jogadorAtual.getNome() + " venceu a partida! 🏆");
                    jogoRolando = false;
                }
                // Verifica se deu empate (velha)
                else if (tabuleiro.tabuleiroCheio(null)) {
                    tabuleiro.desenhar();
                    System.out.println("\nEmpate! O tabuleiro está cheio, DEU VELHA!");
                    jogoRolando = false;
                }
                // Se não venceu e não empatou, troca o turno
                else {
                    jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1; // altero o valor davariavel que aponta para o jogador atual, e assim a alterno a jogadas
                }

            } catch (JogadaInvalidaException e) {
                // Apanha a exceção própria que nós criámos
                System.out.println("\n⚠️ ERRO: " + e.getMessage() + " Tenta de novo.");
            } catch (Exception e) {
                // Apanha qualquer outro erro inesperado
                System.out.println("\n⚠️ ERRO INESPERADO: Aconteceu um problema. Tenta de novo.");
            }
        }

        // Exibir o histórico usando o ArrayList no final do jogo
        System.out.println("\n=== HISTÓRICO DA PARTIDA ===");
        for (String registro : historicoJogadas) {
            System.out.println(registro);
        }

        System.out.println("\nFim do jogo! Obrigado por jogar.");
        scanner.close();
    }
}