// Aplicação do conceito de Interfaces
public interface RegrasDoJogo {
    boolean verificarVitoria(Campo[][] velha); // percorre o tabuleiro e verifica se existem três simbolos iguais em linha ou coluna, horizontal, vertical ou diagonal
    boolean tabuleiroCheio(Campo[][] velha); // Analise o tabuleiro para ver se tem campos vazios ou se deu empate
}