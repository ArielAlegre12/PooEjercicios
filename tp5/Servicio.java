/**
 * Clase servicio que permite saber el nombre y el costo de este mismo.
 */
public class Servicio{
    private String descripcion;
    private double precio;
    
    /**
     * Constructor que inicaliza la clase.
     * @param p_descripcion descripcion del servicio.
     * @param p_precio precio del servicio.
     */
    public Servicio(String p_descripcion, double p_precio){
        this.setDescripcion(p_descripcion);
        this.setPrecio(p_precio);
    }
    
    //setters
    private void setDescripcion(String p_descripcion){this.descripcion = p_descripcion;}
    private void setPrecio(double p_precio){this.precio = p_precio;}
    
    //getters
    public String getDescripcion(){return this.descripcion;}
    public double getPrecio(){return this.precio;}
}