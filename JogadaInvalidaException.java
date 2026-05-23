// conceito de Exceções Próprias (Herança de Exception)
public class JogadaInvalidaException extends Exception {
    public JogadaInvalidaException(String message) {
        super(message);
    }
}