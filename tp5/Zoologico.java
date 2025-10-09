/**
 * Clase Zoologico que permite administrar las visitas
 */
import java.util.*;
public class Zoologico{
    private String nombre;
    private ArrayList<Visitante> visitantes;
    
    /**
     * Constructor que incializa el zoologico con un array de visitantes.
     * @param p_nombre nombre del zoologico
     * @param p_visitantes array de visitantes del zoologico
     */
    public Zoologico(String p_nombre, ArrayList<Visitante> p_visitantes){
        this.setNombre(p_nombre);
        this.setVisitantes(p_visitantes);
    }
    
    /**
     * Cosntructor que incializa el zoologico con un visitante.
     * @param p_nombre nombre del Zoologico.
     * @param p_visitante visitante del zoologico.
     */
    public Zoologico(String p_nombre, Visitante p_visitante){
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList<Visitante>());
        this.nuevoVisitante(p_visitante);
    }
    
    /**
     * Constructor que incializa el Zoologico con 0 visitantes.
     * @param p_nombre nombre del zoologico.
     */
    public Zoologico(String p_nombre){
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList<Visitante>());
    }
    
    //setters
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setVisitantes(ArrayList<Visitante> p_visitantes){this.visitantes = p_visitantes;}
    
    //getters
    public String getNombre(){return this.nombre;}
    public ArrayList<Visitante> getVisitantes(){return this.visitantes;}
    
    //agregar visitante
    public boolean nuevoVisitante(Visitante p_visitante){
        return this.getVisitantes().add(p_visitante);
    }
    
    //quitar visitante
    public boolean quitarVisitante(Visitante p_visitante){
        return this.getVisitantes().remove(p_visitante);
    }
    
    /**
     * Método que lista el tipo de visitante.
     */
    public void listarTipoVisitantePorfecha(Calendar p_fecha, String p_tipoVisitante){
        for(Visitante unVisitante: this.getVisitantes()){
            unVisitante.listarPorFecha(p_fecha, p_tipoVisitante);
        }
    }
    
    /**
     * método que lista por fecha a los visitantes.
     * debo validar que muestre un individuo y no la delegación.
     */
    public void listarVisitantePorFecha(Calendar p_fecha){
        for(Visitante unVistante: this.getVisitantes()){
            if(unVistante.getFecha().equals(p_fecha)){
                for(Persona unaPer: unVistante.listarPersonas()){
                    unaPer.mostrar();
                }
            }
        }
    }
    
    /**
     * método para obtener lo que se recaudo en cierto periodo
     * utilizo compareTo que devuele un num negativo si el objeto es anterior
     * 0 si son iguales y un num positivo si es posterior.
     */
    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta){
        double monto = 0.0;
        for(Visitante unVisitante: this.getVisitantes()){
            if(unVisitante.getFecha().compareTo(p_fechaDesde) >= 0 && unVisitante.getFecha().compareTo(p_fechaHasta) <= 0){
                monto += unVisitante.entrada();
            }
        }
        return monto;
    }
    
    /**
     * método para listar a las personas que visitaron el zoo sin repetir.
     * utilizo instanceof para validar que sea un individuo y no una delagacion
     */
    public HashSet<Persona> listarPersonasQueVisitaronElZoo(){
        HashSet<Persona> lista = new HashSet<Persona>();
        for(Visitante unVisitante: this.getVisitantes()){
            if(unVisitante instanceof Individuo){
                Individuo unIndividuo = (Individuo)unVisitante;
                lista.add(unIndividuo.getPersona());
            }
        }
        return lista;
    }
}
