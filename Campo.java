// Aplicação do conceito de Encapsulamento
public class Campo {
    private char simbolo; // Privado para proteger o dado

    public Campo() {
        this.simbolo = ' '; // Inicializa o campo como vazio
    }

    public char getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}