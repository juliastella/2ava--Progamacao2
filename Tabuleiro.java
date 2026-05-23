// Aplicação de Interface (implements) e Composição
public class Tabuleiro implements RegrasDoJogo {
    private Campo[][] matriz; // Array bidimensional

    public Tabuleiro() {
        matriz = new Campo[3][3];
        // Inicializa cada espaço vazio, evitando NullPointerException
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = new Campo();
            }
        }
    }

    public void desenhar() {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d ", i);
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + matriz[i][j].getSimbolo() + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  ---+---+---");
        }
        System.out.println();
    }

    // Marca a jogada e lança erro se já estiver ocupado
    public void marcarJogada(int[] posicao, char simbolo) throws JogadaInvalidaException {
        int linha = posicao[0];
        int coluna = posicao[1];

        if (matriz[linha][coluna].getSimbolo() != ' ') {
            throw new JogadaInvalidaException("Este campo já está ocupado! Tenta outro.");
        }
        matriz[linha][coluna].setSimbolo(simbolo);
    }

    @Override
    public boolean verificarVitoria(Campo[][] velha) {
        // Verifica as Linhas e Colunas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0].getSimbolo() != ' ' && matriz[i][0].getSimbolo() == matriz[i][1].getSimbolo() && matriz[i][1].getSimbolo() == matriz[i][2].getSimbolo()) return true;
            if (matriz[0][i].getSimbolo() != ' ' && matriz[0][i].getSimbolo() == matriz[1][i].getSimbolo() && matriz[1][i].getSimbolo() == matriz[2][i].getSimbolo()) return true;
        }
        // Verifica as Diagonais
        if (matriz[0][0].getSimbolo() != ' ' && matriz[0][0].getSimbolo() == matriz[1][1].getSimbolo() && matriz[1][1].getSimbolo() == matriz[2][2].getSimbolo()) return true;
        if (matriz[0][2].getSimbolo() != ' ' && matriz[0][2].getSimbolo() == matriz[1][1].getSimbolo() && matriz[1][1].getSimbolo() == matriz[2][0].getSimbolo()) return true;

        return false;
    }

    @Override
    public boolean tabuleiroCheio(Campo[][] velha) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(matriz[i][j].getSimbolo() == ' ') return false;
            }
        }
        return true;
    }
}
