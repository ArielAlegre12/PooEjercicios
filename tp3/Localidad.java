/**
 * Clase del tipo Localidad, la cual permite modelar una localidad de una provincia.
 */
public class Localidad{
    private String nombre;
    private String provincia;
    
    /**
     * Constructor  que inicializa la localidad
     * @param p_nombre nombre la localidad.
     * @param p_provincia provincia a la cual pertenece la localidad.
     */
    public Localidad(String p_nombre, String p_provincia){
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }
    /**
     * métodos para establecer los datos del objeto, a través
     * de los getters y setters.
     */
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setProvincia(String p_provincia){
        provincia = p_provincia;
    }
    public String getNombre(){
        return nombre;
    }
    public String getProvincia(){
        return provincia;
    }
    /**
     * Método que visualiza los datos de la Localidad.
     */
    public String mostrar(){
        return "Localidad: " + this.getNombre() + "   Provincia: " + this.getProvincia();
    }
    
}