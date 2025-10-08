import java.util.*;

/**
 * Clase Cabaña que hereda de Alojamiento.
 */
public class Cabaña extends Alojamiento{
    private int nroHabitacion;
    
    /**
     * Constructor que incializa la cabaña.
     * también inicaliza los valores de la superclase. esta vez mandando un array de servicios
     * @param p_nroHabitacion.
     */
    public Cabaña(int p_nroHabitacion,String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios){
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
        this.setNroHabitaciones(p_nroHabitacion);
    }
    
    /**
     *Este constructor manda sólo un servicio a la superclase
     */
    public Cabaña(int p_nroHabitacion,String p_nombre, double p_precioBase, int p_diasAlquiler, Servicio p_servicio){
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicio);
        this.setNroHabitaciones(p_nroHabitacion);
    }
    
    /**
     * Este constructor manda 0 servicios a la superclase.
     */
    public Cabaña(int p_nroHabitacion,String p_nombre, double p_precioBase, int p_diasAlquiler){
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setNroHabitaciones(p_nroHabitacion);
    }
    
    //setters
    private void setNroHabitaciones(int p_nroHabitaciones){this.nroHabitacion = p_nroHabitaciones;}
    
    //getters
    public int getNroHabitaciones(){return this.nroHabitacion;}
    
    /**
     * método que permitira ir contando la cantidad de cabañas en futuras colecciones.
     */
    public int contar(String p_alojamiento){
        if(p_alojamiento.equalsIgnoreCase("cabaña")){
            return 1;
        }else{
            return 0;
        }
    }
    
    /**
     * método para tener el costo de las habitaciones.
     * 
     */
    public double costo(){
        return super.costo() + ((30 * super.getDiasAlquiler() * this.getNroHabitaciones())); 
    }
    
    /**
     * método para imprimir la liquidación.
     */
    public void liquidar(){
        super.liquidar();
        System.out.printf("Cabaña con %d habitaciones.\n", this.getNroHabitaciones());
        System.out.printf("Total: ------> $%.2f\n", this.costo() + super.costoServicios());
    }
}