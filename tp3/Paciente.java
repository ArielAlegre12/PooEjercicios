/**
 * Clase del tipo paciente, el cual modela uno con sus datos principales.
 * por ej: De donde es, su historial clinico,  el domicilio.
 */
public class Paciente{
    private int historiaClinica;
    String nombre;
    String domicilio;
    Localidad localidadNacido;
    Localidad localidadVive;
    
    /**
     * Inicializa al paciente con sus datos.
     * @param p_historia número de historia clinica del paciente.
     * @param p_nombre nombre del paciente.
     * @param p_domicilio domicilio del paciente.
     * @param p_localidadNacido localidad en la que nació.
     * @param p_localidadVive localidad donde vive.
     */
    public Paciente(int p_historia, String p_nombre, String p_domicilio, Localidad p_localidadNacido, Localidad p_localidadVive){
        this.setHistoria(p_historia);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setNacido(p_localidadNacido);
        this.setVive(p_localidadVive);
    }
    /**
     * métodos accesores y mutadores en los que se establecen los distintos datos del paciente.
     */
    private void setHistoria(int p_historia){
        historiaClinica = p_historia;
    }
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setDomicilio(String p_domicilio){
        domicilio = p_domicilio;
    }
    private void setNacido(Localidad p_localidadNacido){
        localidadNacido = p_localidadNacido;
    }
    private void setVive(Localidad p_localidadVive){
        localidadVive = p_localidadVive;
    }
    public int getHistoria(){
        return historiaClinica;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDomicilio(){
        return nombre;
    }
    public Localidad getNacido(){
        return localidadNacido;
    }
    public Localidad getVive(){
        return localidadVive;
    }
    /**
     * método para mostrar los datos del paciente, muestra
     * nombre, domicilio, historia clinica, localidad y provincia del paciente.
     */
    public void mostrarDatosPantalla(){
        System.out.println("Paciente: " + this.getNombre() + "   Historia: " + this.getHistoria() + "   Domicilio: " + this.getDomicilio());
        System.out.println("Localidad: " + this.getVive().getNombre() + "   Provincia: " + this.getVive().getProvincia());
    }
    /**
     * método que retorna los datos concatenados.
     */
    public String cadenaDatos(){
        return this.getNombre() + "......" + this.getDomicilio()  + " - " + this.getVive().getNombre() + "--" + this.getVive().getProvincia();
    }
    
}