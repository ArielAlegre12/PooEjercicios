import java.util.*;
/**
 * Clase delegación que representa uno, recibe un conjunto de integrantes.
 * hereda de la clase Visitante.
 * 
 */
public class Delegacion extends Visitante{
    private ArrayList<Individuo> integrantes;
    
    
    /**
     * Constructor para inicializar la delegación. con un array de integrantes
     * 
     */
    public Delegacion(ArrayList<Individuo> p_integrantes, String p_nombre, Calendar p_fecha){
        super(p_nombre, p_fecha);
        this.setIntegrantes(p_integrantes);
    }
    
    //setters
    private void setIntegrantes(ArrayList<Individuo> p_integrantes){this.integrantes = p_integrantes;}
    
    //getters
    public ArrayList<Individuo> getIntegrantes(){return this.integrantes;}
    
    //Inscribir integrante
    public boolean inscribirIntegrante(Individuo p_integrante){
        return this.getIntegrantes().add(p_integrante);
    }
    
    //Quitar integrante
    public boolean quitarIntegrante(Individuo p_integrante){
        return this.getIntegrantes().remove(p_integrante);
    }
    
    /**
     * Saber la cantidad de integrantes.
     */
    public int cantidadIntegrantes(){
        int cantidad = 0;
        for(Individuo individuo: this.getIntegrantes()){
            cantidad ++;
        }
        return cantidad;
    }
    
    /**
     * método para listar por fecha.
     */
    public void listarPorFecha(Calendar p_fecha, String p_visitante){
        if(super.getFecha() == p_fecha && this.getNombre().equalsIgnoreCase(p_visitante)){
            for(Individuo unIndi: this.getIntegrantes()){
                unIndi.listarPorFecha(p_fecha, "individuo");
            }
        }
    }
}