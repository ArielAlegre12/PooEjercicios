/**
 * Clase del tipo paciente, el cual modela uno con sus datos principales.
 * por ej: De donde es, su historial clinico,  el domicilio.
 * @Author Alegre Ariel, Antoniow Agustín.
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
        this.historiaClinica = p_historia;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setDomicilio(String p_domicilio){
        this.domicilio = p_domicilio;
    }
    private void setNacido(Localidad p_localidadNacido){
        this.localidadNacido = p_localidadNacido;
    }
    private void setVive(Localidad p_localidadVive){
        this.localidadVive = p_localidadVive;
    }
    public int getHistoria(){
        return this.historiaClinica;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDomicilio(){
        return this.nombre;
    }
    public Localidad getNacido(){
        return this.localidadNacido;
    }
    public Localidad getVive(){
        return this.localidadVive;
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