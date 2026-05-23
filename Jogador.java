// Classes Abstratas, Encapsulamento e Modificadores de Acesso
public abstract class Jogador {
    private String nome; // vai armazenar o nome
    private char simbolo; // 'X' ou 'O'

    // Construtor
    public Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    // Métodos Getters: pegam o que foi escrito e mostra
    public String getNome() {
        return nome;
    } //

    public char getSimbolo() {
        return simbolo;
    }

    // Metodo Abstrato: as classes filhas serão obrigadas a ter este metodo,
    // mas cada uma vai implementá-lo à sua maneira. Se acontecer um erro elas irão saber se reogranizar
    public abstract int[] fazerJogada() throws JogadaInvalidaException;
}