import java.util.Scanner;
public class Campo {
    private char simbolo; // representa o simbolo que estara dentro do campo 'X', 'O' ou ' ' (vazio).
    public Campo() {
        this.simbolo = ' '; // Inicializa o campo como vazio
    }
    public char getSimbolo() { // obtemos o simbolo do campo
        return this.simbolo;
    }
    public void setSimbolo(char simbolo){ // iremos inserir o simbolo do jogador no campo
        if (this.simbolo == ' ') { // for igual a vazio
            this.simbolo = simbolo; // entao o simbolo do campo recebe o simbolo do jogador
        }else {
            System.out.print("Campo já ocupado!"); // caso o campo ja esteja ocupado, exibe uma mensagem de erro
        }
    }
}
