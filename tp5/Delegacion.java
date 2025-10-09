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
        if(this.cantidadIntegrantes() > 1){
        return this.getIntegrantes().remove(p_integrante);
        }else{
            System.out.println("No se puede eliminar más inviduos.\n");
            return false;
        }
    }
    
    /**
     * Saber la cantidad de integrantes.
     */
    public int cantidadIntegrantes(){
        return this.listarPersonas().size();
    }
    
    /**
     * método para listar por fecha.
     */
    public void listarPorFecha(Calendar p_fecha, String p_visitante){
        if(super.getFecha().equals(p_fecha) && this.tipoVisitante().equalsIgnoreCase(p_visitante)){
            this.mostrar();
        }
    }
    
    /**
     * método para listar a las personas.
     * 
     */
    @Override
    public HashSet<Persona> listarPersonas(){
        HashSet<Persona> listaPersona = new HashSet<Persona>();
        for(Individuo unIndi: this.getIntegrantes()){
            listaPersona.addAll(unIndi.listarPersonas());
        }
        return listaPersona;
    }
    
    /**
     * método para poder calcular el costo de entrada de la delegación.
     */
    @Override
    public double entrada(){
        double costo = 0.0;
        for(Individuo unIndi: this.getIntegrantes()){
            costo =+ unIndi.entrada();
        }
        return costo - (costo * 10 / 100);
    }
    
    /**
     * método para retornar el tipo de visitante.
     */
    @Override
    public String tipoVisitante(){
        return "delegacion";
    }
    
    /**
     * método para mostrar los detalles de la delegación.
     * utilizo la lista de personas de HashSet que evita las duplicaciones y saco la cantidad
     * de integrantes de allí.
     */
    public void mostrar(){
        System.out.println("Delegación: " + this.getNombre());
            System.out.println("Integrantes");
            for(Persona unIntegrante: this.listarPersonas()){
                unIntegrante.mostrar();
            }
            System.out.println("Cantidad de integrantes: " + this.cantidadIntegrantes());
    }
}