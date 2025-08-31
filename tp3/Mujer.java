/**
 * Clase Mujer que representa los datos personales y el estado civil de una mujer.
 * Incluye nombre, apellido, edad, estado civil y referencia al esposo (objeto Hombre).
 */
public class Mujer{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Hombre esposo;
    /**
     * Constructor que inicializa una mujer como soltera, sin esposo asignado.
     * 
     * @param p_nombre   Nombre de la mujer.
     * @param p_apellido Apellido de la mujer.
     * @param p_edad     Edad de la mujer.
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad){
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.estadoCivil = "Soltera";
    }
    /**
     * Constructor que inicializa una mujer con esposo asignado.
     * 
     * @param p_nombre   Nombre de la mujer.
     * @param p_apellido Apellido de la mujer.
     * @param p_edad     Edad de la mujer.
     * @param p_esposo   Objeto Hombre que representa al esposo.
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad, Hombre p_esposo){
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposo(p_esposo);
    }
    /**
     * Métodos setters y getters
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setApellido(String p_apellido){this.apellido = p_apellido;}
    private void setEdad(int p_edad){this.edad = p_edad;}
    public void setEsposo(Hombre p_esposo){this.esposo = p_esposo;}
    public void setEstadoCivil(String p_estado){this.estadoCivil = p_estado;}
    
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public int getEdad(){return edad;}
    public Hombre getEsposo(){return esposo;}
    public String getEstadoCivil(){return estadoCivil;}
    
    /**
     * lleva a cabo el casamiento, si ambos están solteros.
     * Actualiza el estado civil y los vínculos mutuos.
     * 
     * @param p_hombre Objeto Hombre con quien se desea casar.
     */
    public void casarseCon(Hombre p_hombre){
        if(p_hombre != null && this.getEsposo() == null && p_hombre.getEsposa() == null){
            this.setEsposo(p_hombre);
            this.setEstadoCivil("Casada");
            p_hombre.setEsposa(this);
            p_hombre.setEstadoCivil("Casado");
        }
    }
    
    /**
     * Rompe el vínculo matrimonial si la mujer está casada.
     * Actualiza el estado civil y elimina la referencia mutua con el esposo.
     */
    public void divorcio() {
    if (this.getEsposo() != null) {
        Hombre ex = this.getEsposo();
        this.setEsposo(null);
        this.setEstadoCivil("Divorciada");
        ex.divorcio();
    }
    }
    /**
     * Devuelve una cadena con los datos personales de la mujer.
     * 
     * @return Nombre, apellido y edad en formato legible.
     */
    public String datos(){
        return getNombre() + " " + getApellido() + " de " + getEdad() + " años";
    }
    /**
     * Muestra por pantalla los datos personales y el estado civil actual.
     */
    public void mostrarEstadoCivil(){
        System.out.println(this.datos() + " - " + this.getEstadoCivil()); 
    }
    /**
     * Muestra con quién está casada la mujer, si corresponde.
     * Si no está casada, informa que no tiene esposo.
     */
    public void casadaCon(){
        if(this.getEstadoCivil() == "Casada"){
            System.out.println(this.datos() + " está casada con " + this.getEsposo().datos());
        }else{
            System.out.println(getNombre() + " no está casada!(por suerte).\n");
        }
    }
    }