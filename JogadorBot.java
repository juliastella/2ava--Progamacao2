import java.util.Random;

// Aplicação de Herança
public class JogadorBot extends Jogador {
    private Random random;

    public JogadorBot(String nome, char simbolo) {
        super(nome, simbolo);
        this.random = new Random();
    }

    // Aplicação de Polimorfismo: O mesmo método, mas com comportamento diferente
    @Override
    public int[] fazerJogada() {
        System.out.println(getNome() + " (Computador) está a pensar...");
        int linha = random.nextInt(3); // Gera um número aleatório entre 0 e 2
        int coluna = random.nextInt(3);
        return new int[]{linha, coluna};
    }
}