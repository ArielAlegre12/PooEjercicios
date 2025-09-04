import java.util.*;
/**
 * Clase libreria.
 */
public class Libreria{
    private String nombre;
    private ArrayList<Libro> libros;
    
    /**
     * Constructor que recibe nombre y libros de la libreria.
     */
    public Libreria(String p_nombre, ArrayList<Libro> p_libros){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
    }
    /**
     * Constructor que sólo recibe el nombre de la libreria.
     */
    public Libreria(String p_nombre){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
    }
    /**
     * Métodos setters y getters.
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setLibros(ArrayList<Libro> p_libros){this.libros = p_libros;}
    public String getNombre(){return this.nombre;}
    public ArrayList<Libro> getLibros(){return this.libros;}
    /**
     * Métodos para agregar y quitar un libro.
     */
    public boolean agregarLibro(Libro p_libro){
        return this.getLibros().add(p_libro);
    }
    public boolean quitarLibro(Libro p_libro){
        return this.getLibros().remove(p_libro);
    }
    /**
     * Método para obtener el monto del stock valorizado.
     */
    public void stockValorizado(){
        double monto = 0.0;
        for(Libro unLibro: this.getLibros()){
            monto = monto + unLibro.getPrecio();
        }
        System.out.println("---- Valor Stock: " + monto);
    }
    /**
     * Método para visualizar los datos de la libreria.
     */
    public void mostrar(){
        System.out.println("**** Libreria: " + this.getNombre() + " ****");
        for(Libro unLibro: this.getLibros()){
            unLibro.mostrar();
            System.out.println("*--------------------------------------------*");
        }
    }
}