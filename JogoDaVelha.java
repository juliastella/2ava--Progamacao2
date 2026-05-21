import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) { // função principal
        Campo[][] velha = new Campo[3][3] ; // matriz 3x3 de campos
        Boolean game= true; // inidica se o jogo está acontecendo ou não
        char jogadorAtual = 'X'; // simbolo do jogador atual ('X' ou 'O')
        String vitoria = ""; // armazena o resultado da partida (vencedor ou empate)
        Scanner scan= new Scanner(System.in); // objeto para ler a entrada do usuário

        while (game){
            desenharJogo(velha); // Cria o quadro do jogo
            vitoria = verificarVitoria(velha); // Verifica se há um vencedor ou empate
            if (!vitoria.equals("")){ // quando retorna algo diferente de vazio, retorno o jogador vencedor e para o loop
                System.out.printf("Jogador %s venceu%n", vitoria); // Exibe o vencedor
                break;
            }
            try { // Onde vai aconter o jogo

            }catch (Exception e){
                System.out.printf("Erro");
            }
        }
        System.out.printf("Fim do jogo!"); // Exibe mensagem de fim de jogo
    }
    public static void desenharJogo(Campo[][] velha){
        //limparTela(); // função para limpar a tela (pode ser implementada de acordo com o sistema operacional)
        System.out.println("  0 1 2"); // exibe os índices das
        System.out.printf("0, %c | %c | %c\n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("  ---+---+---"); // separador entre as linhas
        System.out.printf("1, %c | %c | %c\n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("  ---+---+---"); // separador entre as linhas
        System.out.printf("2, %c | %c | %c\n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }

    //função para limpar a tela

    public static void limparTela() {
        for(int i = 0; i < 200; i++) {
            System.out.println(""); // Imprime várias linhas em branco para simular a limpeza da tela
        }
    }

    //

    public boolean verificaJogada(Campo[][] velha, int pontoJogar[], char simboloAtual) {

        if (velha[pontoJogar[0]][pontoJogar[1]].getSimbolo() == ' ') {
            velha[pontoJogar[0]][pontoJogar[1]].setSimbolo(simboloAtual); // insere símbolo
            return true; // jogada válida
        } else {
            return false; // jogada inválida
        }
    }


    public static  String verificarVitoria(Campo[][] velha){
        return "";
    }

}
