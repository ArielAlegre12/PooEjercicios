/**
 * clase para mandar los mensaje de exceptios a Libro
 * 
 * @author Barrios Guadalupe, Boilini Uriel, Alfonso Mariana
 */
public class LibroNoPrestadoException extends Exception {
    
    public LibroNoPrestadoException(String mensaje) {
        super(mensaje);
    }
}
