/**
 * Clase Gerencia que permite administrar alojamientos.
 */
import java.util.*;
public class Gerencia{
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados;
    
    /**
     * Constructor que recibe un arrray de alojamientos.
     * @param p_nombre nombre de la gerencia.
     * @param p_alojamientosAlquilados array de los alojamientos.
     */
    public Gerencia(String p_nombre, ArrayList<Alojamiento> p_alojamientosAlquilados ){
        this.setNombre(p_nombre);
        this.setAlojamientos(p_alojamientosAlquilados);
    }
    
    /**
     * constructor que recibe 1 sólo alojamiento.
     */
    public Gerencia(String p_nombre, Alojamiento p_alojamiento){
        this.setNombre(p_nombre);
        this.setAlojamientos(new ArrayList<Alojamiento>());
        this.agregarAlojamiento(p_alojamiento);
    }
    
    /**
     * constructor que no recibe ningún alojamiento.
     */
    public Gerencia(String p_nombre){
        this.setNombre(p_nombre);
        this.setAlojamientos(new ArrayList<Alojamiento>());
    }
    
    //setters
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setAlojamientos(ArrayList<Alojamiento> p_alojamientos){this.alojamientosAlquilados = p_alojamientos;}
    
    //getters
    public String getNombre(){return this.nombre;}
    public ArrayList<Alojamiento> getAlojamientos(){return this.alojamientosAlquilados;}
    
    //método para agregar un alojamiento.
    public boolean agregarAlojamiento(Alojamiento p_alojamiento){
        return this.getAlojamientos().add(p_alojamiento);
    }
    
    //método para quitar un alojamiento.
    public boolean quitarAlojamiento(Alojamiento p_alojamiento){
        return this.getAlojamientos().remove(p_alojamiento);
    }
    
    /**
     * método para contar los alojamientos.
     */
    public int contarAlojamiento(String p_tipoAlojamiento){
        int cantidad = 0;
        for(Alojamiento unAloja: this.getAlojamientos()){
           cantidad += unAloja.contar(p_tipoAlojamiento);
        }
        return cantidad;
    }
    
    /**
     * método para mostrar liquidacion de cada alojamiento
     */
    public void liquidacion(){
        System.out.println("Liquidación-------------------");
        for(Alojamiento unAloja: this.getAlojamientos()){
            unAloja.liquidar();
        }
    }
    
    /**
     * método para mostrar resumen de liquidación de cada alojamiento
     */
    public void mostrarLiquidacion(){
        System.out.println("\nGerencia " + this.getNombre());
        this.liquidacion();
        System.out.println("\nAlojamiento tipo Cabaña ----> " + this.contarAlojamiento("cabaña"));
        System.out.println("Alojamiento tipo Hotel ------> " + this.contarAlojamiento("hotel"));
    }
}