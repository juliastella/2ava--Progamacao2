import java.util.Scanner;
import java.util.InputMismatchException;

// Herança (extends)
public class JogadorHumano extends Jogador {
    private Scanner scanner;

    public JogadorHumano(String nome, char simbolo) {
        super(nome, simbolo); // Chama o construtor da classe mãe (Jogador)
        this.scanner = new Scanner(System.in);
    }

    //  Polimorfismo: reescrevo o metodo abstrato
    // Inicio o jogo com as informações do jogador humano
    @Override
    public int[] fazerJogada() throws JogadaInvalidaException {
        try { // jogadas aleatorias
            System.out.println(getNome() + ", é a tua vez (" + getSimbolo() + ").");
            System.out.print("Digita a linha (0, 1 ou 2): ");
            int linha = scanner.nextInt();
            System.out.print("Digita a coluna (0, 1 ou 2): ");
            int coluna = scanner.nextInt();

            // Validação básica se está fora dos limites
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                throw new JogadaInvalidaException("Posição fora dos limites! Deves escolher entre 0 e 2.");
            }

            return new int[]{linha, coluna};
        } catch (InputMismatchException e) { // se tiver algum erro inisperado
            scanner.nextLine(); // Limpa o buffer do scanner
            // Dispara a exceção que criada se digitarem letras em vez de números
            throw new JogadaInvalidaException("Entrada inválida! Deves digitar apenas números.");
        }
    }
}