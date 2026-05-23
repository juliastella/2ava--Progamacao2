// Aplicação de Classes Abstratas, Encapsulamento e Modificadores de Acesso
public abstract class Jogador {
    private String nome;
    private char simbolo; // 'X' ou 'O'

    // Construtor
    public Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    // Métodos Getters (Encapsulamento)
    public String getNome() {
        return nome;
    }

    public char getSimbolo() {
        return simbolo;
    }

    // Método Abstrato: as classes filhas serão obrigadas a ter este método,
    // mas cada uma vai implementá-lo à sua maneira (Polimorfismo).
    public abstract int[] fazerJogada() throws JogadaInvalidaException;
}