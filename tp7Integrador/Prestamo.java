import java.util.*;
import java.text.*;

/**
 * Clase Prestamo que representa uno, y colabora con las clases de Socio y
 * Libro.
 */
public class Prestamo {
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Libro libro;
    private Socio socio;

    /**
     * Constructor que incializa un prestamo
     * 
     * @param p_fechaRetiro     fecha en la que se retiro un libro.
     * @param p_fechaDevolucion fecha en la que se debe devolver el libro.
     * @param p_libro           libro el cual se presta.
     * @param p_socio           socio al cual se le presta el libro.
     */
    public Prestamo(Calendar p_fechaRetiro, Libro p_libro, Socio p_socio) {
        this.setFechaRetiro(p_fechaRetiro);
        this.setFechaDevolucion(null);
        this.setLibro(p_libro);
        this.setSocio(p_socio);
    }

    // métodos set
    private void setFechaRetiro(Calendar p_fechaRetiro) {
        this.fechaRetiro = p_fechaRetiro;
    }

    private void setFechaDevolucion(Calendar p_fechaDevolucion) {
        this.fechaDevolucion = p_fechaDevolucion;
    }

    private void setLibro(Libro p_libro) {
        this.libro = p_libro;
    }

    private void setSocio(Socio p_socio) {
        this.socio = p_socio;
    }

    // métodos get
    public Calendar getFechaRetiro() {
        return this.fechaRetiro;
    }

    public Calendar getFechaDevolucion() {
        return this.fechaDevolucion;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public Socio getSocio() {
        return this.socio;
    }

    /**
     * método el cual registra la fecha en la que se devuelve un libro.
     */
    public void registrarFechaDevolucion(Calendar p_fecha) {
        this.setFechaDevolucion(p_fecha);
    }

    /**
     * método que permite calcular si el prestamo está vencido.
     * primero clona la fecha en la que se retiro y le suma los dias de prestamos
     * que asignaron al socio.
     * finalmente calcula si ya paso a la fecha de vencimiento.
     * utilizo el casteo porque el método clone() devuelve un Object.
     */
    public boolean vencido(Calendar p_fecha) {
        Calendar fechaVencimiento = (Calendar) this.getFechaRetiro().clone();
        fechaVencimiento.add(Calendar.DAY_OF_MONTH, this.getSocio().getDiasPrestamos());
        return p_fecha.after(fechaVencimiento);
    }

    /**
     * método que devuelve un string con una descripción del prestamo.
     */
    public String toString() {
        String cadena = "";
        SimpleDateFormat fechaFormateada = new SimpleDateFormat("yyyy, MM, dd");
        String retiroStr = (this.getFechaRetiro() != null) ? fechaFormateada.format(this.getFechaRetiro().getTime())
                : "N/A";
        String devolucionStr = (this.getFechaDevolucion() != null)
                ? fechaFormateada.format(this.getFechaDevolucion().getTime())
                : "Sin devolver";
        String tituloLibro = (this.getLibro() != null) ? this.getLibro().getTitulo() : "N/A";
        String nombreSocio = (this.getSocio() != null) ? this.getSocio().getNombre() : "N/A";
        cadena = "Retiro: " + retiroStr + " - Devolución: " + devolucionStr + "\n" +
                "Libro: " + tituloLibro + "\n" +
                "Socio: " + nombreSocio;
        return cadena;
    }
}