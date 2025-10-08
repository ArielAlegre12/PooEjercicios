/**
 * Clase individuo, representa uno. con las caracteristicas de la 
 * visita al zoologico.
 */
import java.util.*;
public class Individuo extends Visitante{
    private Persona persona;
    
    /**
     * Constructor que inicializa al individuo.
     * @param p_persona objeto del tipo Persona que presta los servicios que brinda.
     */
    public Individuo(Persona p_persona, String p_nombre, Calendar p_fecha){
        super(p_nombre, p_fecha);
    }
    
    //setters
    private void setPersona(Persona p_persona){this.persona = p_persona;}
    
    //getters
    public Persona getPersona(){return this.persona;}
    
    /**
     * Retorna una el tipo de persona, en este caso individuo.
     */
    @Override
    public String tipoVisitante(){return "Individuo";}
    
    /**
     * método para listar los detalles del individuo
     */
    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante){
        if(super.getFecha() == p_fecha && this.tipoVisitante().equalsIgnoreCase(p_visitante)){
            this.getPersona().mostrar();
        }
    }
    
    /**
     * método para obtener la entrada.
     */
    public double entrada(){
        return 10.0;
    }
    
    /**
     * método para mostrar al individuo
     */
    public void mostrar(){
        System.out.println("Tipo de visitante: " + this.tipoVisitante());
        this.listarPorFecha(super.getFecha(), this.tipoVisitante());
        System.out.println("Entrada: " + this.entrada());
    }
    
    /**
     * método para listar persona. para luego ser usado en una colección.
     * debo crear una colección nueva, despues agregar al individuo y retornarlo.
     */
    public HashSet<Persona> listarPersonas(){
        HashSet<Persona> conjunto = new HashSet<Persona>();
        conjunto.add(this.getPersona());
        return conjunto;
    }
}