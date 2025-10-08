/**
 * Clase alojamiento que representa las caracteristicas del mismo, permite agregar o quitar servicios.
 * contar dias de alojamiento, costos de servicios y liquidar el resumen.
 */
import java.util.*;
public abstract class Alojamiento{
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicios;
    
    /**
     * Constructor que incializa el alojamiento con un array de servicios.
     * @param p_nombre nombre del alojamiento.
     * @param p_precioBase precio por dia del alojamiento.
     * @param p_diasAlquiler cantidad de dias en el alojamiento.
     * @param p_servicios lista de servicios usados.
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList<Servicio> p_servicios){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(p_servicios);
    }
    
    /**
     * Constructor que inicializa el alojamiento con un sólo servicio.
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, Servicio p_servicio){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(new ArrayList<Servicio>());
        this.agregarServicio(p_servicio);
    }
    
    /**
     * Constructor que incializa el alojamiento sin servicio utilizado.
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(new ArrayList<Servicio>());
    }
    
    //setters
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setPrecioBase(double p_precioBase){this.precioBase = p_precioBase;}
    private void setDiasAlquiler(int p_diasAlquiler){this.diasAlquiler = p_diasAlquiler;}
    private void setServicios(ArrayList<Servicio> p_servicios){this.servicios = p_servicios;}
    
    //getters
    public String getNombre(){return this.nombre;}
    public double getPrecioBase(){return this.precioBase;}
    public int getDiasAlquiler(){return this.diasAlquiler;}
    public ArrayList<Servicio> getServicios(){return this.servicios;}
    
    //método para agregar un servicio
    public boolean agregarServicio(Servicio p_servicio){
        return this.getServicios().add(p_servicio);
    }
    
    //método para quitar un servicio
    public boolean quitarServicio(Servicio p_servicio){
        return this.getServicios().remove(p_servicio);
    }
    
    //Clase abstracta
    public abstract int contar(String p_alojamiento);
    
    /**
     * método para obtener el costo del alojamiento.
     * simplemente costoBase x la cantida de dias de alojamiento.
     */
    public double costo(){
        return this.getPrecioBase() * this.getDiasAlquiler();
    }
    
    /**
     * método para obtener el costo de los servicios, el cual sera la suma de todos los usados.
     */
    public double costoServicios(){
        double costo = 0.0;
        for(Servicio unServi: this.getServicios()){
            costo += unServi.getPrecio();
        }
        return costo;
    }
    
    /**
     * método para listar los servicios utilizados, se recorre el array.
     */
    public void listarServicios(){
        for(Servicio unServi: this.getServicios()){
            System.out.printf("\t%s: $%.2f\n", unServi.getDescripcion(), unServi.getPrecio());
         }
    }
    
    /**
     * método para mostrar la liquidacion de la cabaña.
     */
    public void liquidar(){
        System.out.println("\nAlojamiento: " + this.getNombre());
        System.out.printf("Costo por %d dias: $%.2f\n", this.getDiasAlquiler(), this.costo());
        this.listarServicios();
    }
}
