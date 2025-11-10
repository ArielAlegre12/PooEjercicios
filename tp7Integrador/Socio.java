import java.util.*;
import java.io.Serializable;
/**
 * Clase abstracta que representa un socio de la biblioteca.
 * Puede ser un Docente o un Estudiante.
 * Cada socio tiene un DNI, nombre, cantidad de días de préstamo permitidos
 * y una lista de préstamos activos.
 * @author Alegre Ariel Santiago
 */
public abstract class Socio implements Serializable{
    private static final long serialVersionUID = 1L;
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;   
    /**
     * Constructor que incializa al socio con un array de prestamos.
     * @param p_dniSocio dni del socio.
     * @param p_nombre nombre del socio.
     * @param p_diasPrestamo cantidad de dias del prestamo.
     * @param p_prestamos array que contiene los prestamos.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, ArrayList<Prestamo> p_prestamos){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(p_prestamos);
    }
    
    /**
     * Constructor que inicializa al socio con 1 prestamo.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo, Prestamo p_prestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
        this.agregarPrestamo(p_prestamo);
    }
    
    /**
     * Constructor que inicializa al socio con 0 prestamos.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo){
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    //métodos set
    private void setDniSocio(int p_dniSocio){this.dniSocio = p_dniSocio;}
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    protected void setDiasPrestamo(int p_diasPrestamo){this.diasPrestamo = p_diasPrestamo;}
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){this.prestamos = p_prestamos;}
    
    //métodos get
    public int getDniSocio(){return this.dniSocio;}
    public String getNombre(){return this.nombre;}
    public int getDiasPrestamos(){return this.diasPrestamo;}
    public ArrayList<Prestamo> getPrestamos(){return this.prestamos;}
    
    //Retorna una lista de préstamos activos (sin fecha de devolución)
    public ArrayList<Prestamo> getPrestamosActivos() {
        ArrayList<Prestamo> activos = new ArrayList<>();
        for(Prestamo prestamo : this.getPrestamos()) {
            if(prestamo.getFechaDevolucion() == null) {
                activos.add(prestamo);
            }
        }
        return activos;
    }
    
    /**
     * Clase abstracta
     */
    public abstract String soyDeLaClase();
    
    //método para agregar un prestamo
    public boolean agregarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }
    
    //método para quitar un prestamo
    public boolean quitarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * método que permite saber la cantidad de libros prestados actualmente.
     * Solo cuenta los préstamos que no tienen fecha de devolución.
     */
    public int catLibrosPrestados(){
        int conta = 0;
        for(Prestamo prestamo : this.getPrestamos()) {
            if(prestamo.getFechaDevolucion() == null) {
                conta++;
            }
        }
        return conta;
    }
    
    /**
     * método que retorna un string con detalles del socio.
     */
    public String toString(){
        return "DNI: " + this.getDniSocio() + " || " + this.getNombre() + "(" + this.soyDeLaClase() + ") || Libros Prestados: " + this.catLibrosPrestados();
    }
    
    /**
     * método para saber si puede pedir o no un prestamo.
     * primeramente verefico que la lista de prestamos no esté vacia, de ser así
     * se imprime un msj y se retorna verdadero.
     * de lo contrario recorre el array y va comprobando.
     */
    public boolean puedePedir(){
        if(this.getPrestamos().size() < 1){
            //System.out.println("Lista de prestamos vacía");
            return true;
        }else{
            Calendar fechaHoy = Calendar.getInstance();
            for(Prestamo unPrestamo: this.getPrestamos()){
                if(unPrestamo.vencido(fechaHoy)){
                    return false;
            }
        }
            return true;
        }
    }
}
