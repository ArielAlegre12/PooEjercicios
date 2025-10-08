/**
 * Clase Hotel que representa uno y hereda de Alojamiento.
**/
import java.util.*;
public class Hotel extends Alojamiento{
    private String tipoHabitacion;
    
    /**
     * Constructor que inicializa el hotel con un array de servicios.
     */
    public Hotel(String p_tipoHabitacion, String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios){
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicios);
        this.setTipoHabitacion(p_tipoHabitacion);
    }
    
    /**
     * Constructor que inicaliza el hotel con un sólo servicio.
     */
    public Hotel(String p_tipoHabitacion, String p_nombre, double p_precioBase, int p_diasAlquiler, Servicio p_servicio){
        super(p_nombre, p_precioBase, p_diasAlquiler, p_servicio);
        this.setTipoHabitacion(p_tipoHabitacion);
    }
    
    /**
     * Constructor que inicializa el hotel sin servicios.
     */
    public Hotel(String p_tipoHabitacion, String p_nombre, double p_precioBase, int p_diasAlquiler){
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setTipoHabitacion(p_tipoHabitacion);
    }
    
    //setters
    private void setTipoHabitacion(String p_tipoHabitacion){this.tipoHabitacion = p_tipoHabitacion;}
    
    //getters
    public String getTipoHabitacion(){return this.tipoHabitacion;}
    
    /**
     * método para obtener el costo del hotel
     */
    public double costo(){
        double costo = super.costo();
        if(this.getTipoHabitacion().equalsIgnoreCase("single")){
            costo += (20 * super.getDiasAlquiler());
        }else if(this.getTipoHabitacion().equalsIgnoreCase("doble")){
            costo += (35 * super.getDiasAlquiler());
        }
        return costo;
    }
    
    /**
     * método que permitira contar los hoteles.
     */
    public int contar(String p_alojamiento){
        if(p_alojamiento.equalsIgnoreCase("hotel")){
            return 1;
        }else{
            return 0;
        }
    }
    
    /**
     * método para liquidar el hotel.
     */
    public void liquidar(){
        super.liquidar();
        System.out.println("Habitación " + this.getTipoHabitacion());
        System.out.printf("Total: ------> $%.2f\n", this.costo() + super.costoServicios());
    }
}