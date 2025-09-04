import java.util.*;
/**
 * Clase libro que puede tener 1 o muchos autores
 */
public class Libro{
    private String titulo;
    private double precio;
    private ArrayList<Autor> autores;
    /**
     * Constructor que recibe titulo, precio y autores del libro.
     */
    public Libro(String p_titulo, double p_precio, ArrayList<Autor> p_autores){
        this.setTitulo(p_titulo);
        this.setPrecio(p_precio);
        this.setAutores(p_autores);
    }
    /**
     * Constructor que sólo recibe titulo y precio.
     */
    public Libro(String p_titulo, double p_precio){
        this.setTitulo(p_titulo);
        this.setPrecio(p_precio);
        this.setAutores(new ArrayList<Autor>());
    }
    /**
     * Métodos setters y getters
     */
    private void setTitulo(String p_titulo){this.titulo = p_titulo;}
    private void setPrecio(double p_precio){this.precio = p_precio;}
    private void setAutores(ArrayList<Autor> p_autores){this.autores = p_autores;}
    public String getTitulo(){return this.titulo;}
    public double getPrecio(){return this.precio;}
    public ArrayList<Autor> getAutores(){return this.autores;}
    
    public boolean agregarAutor(Autor p_autor){
        return this.getAutores().add(p_autor);
    }
    public boolean quitarAutor(Autor p_autor){
        return this.getAutores().remove(p_autor);
    }
    
    public void mostrar(){
        System.out.println("Título: " + this.getTitulo());
        for(Autor unAutor: this.getAutores()){
            unAutor.mostrar();
        }
    }
}