/**
 * Clase abstracta Visitante que represente algún tipo de visitante.
 */
import java.util.*;
public abstract class Visitante{
    private String nombre;
    private Calendar fecha;
    
    /**
     * Constructor que incializa al visitante con nombre y fecha.
     * @param p_nombre nombre del visitante.
     * @param p_ fecha de la visita.
     */
    public Visitante(String p_nombre, Calendar p_fecha){
        this.setNombre(p_nombre);
        this.setFecha(p_fecha);
    }
    
    //setters
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setFecha(Calendar p_fecha){this.fecha = p_fecha;}
    
    //getters
    public String getNombre(){return this.nombre;}
    public Calendar getFecha(){return this.fecha;}
    
    //métodos abstractos.
    public abstract void mostrar();
    public abstract double entrada();
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);
    public abstract String tipoVisitante();
    public abstract HashSet<Persona> listarPersonas();
}