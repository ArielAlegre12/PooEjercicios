/**
 * Clase Hombre que representa los datos personales y el estado civil de un hombre.
 * Incluye nombre, apellido, edad, estado civil y referencia a la esposa (objeto Mujer).
 * Permite gestionar vínculos matrimoniales y emitir información sobre su situación.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Hombre{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Mujer esposa;
    /**
     * Contructor el cual inicializa al hombre sin esposa.
     * @param p_nombre nombre del hombre.
     * @param p_apellido apellido del hombre.
     * @param p_edad edad del hombre.
     * Coloca el estado civil del hombre en Soltero.
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad){
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("soltero");
    }
    /**
     * Constructor el cual inicializa al hombre ya con esposa.
     * @param p_nombre nombre del hombre.
     * @param p_apellido apellido del hombre.
     * @param p_edad edad del hombre.
     * @param p_esposa esposa del hombre.
     * Coloca el estado civil del hombre en Casado.
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad, Mujer p_esposa){
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposa(p_esposa);
        this.setEstadoCivil("Casado");
    }
    /**
     * Métodos setters y getters
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setApellido(String p_apellido){this.apellido = p_apellido;}
    private void setEdad(int p_edad){this.edad = p_edad;}
    private void setEsposa(Mujer p_esposa){this.esposa = p_esposa;}
    private void setEstadoCivil(String p_estadoCivil){this.estadoCivil = p_estadoCivil;}
    
    public String getNombre(){return this.nombre;}
    public String getApellido(){return this.apellido;}
    public int getEdad(){return this.edad;}
    public Mujer getEsposa(){return this.esposa;}
    public String getEstadoCivil(){return this.estadoCivil;}
    
    /**
     * Establece el matrimonio con una mujer, si ambos están solteros.
     * Actualiza el estado civil y los vínculos mutuos.
     * 
     * @param p_mujer Objeto Mujer con quien se desea casar.
     */
    public void casarseCon(Mujer p_mujer){
        if(this.getEsposa() == null){
            this.setEsposa(p_mujer);
            this.setEstadoCivil("Casado");
            p_mujer.casarseCon(this);
        }
        
    }
    
    /**
     * Rompe el vínculo matrimonial si el hombre está casado.
     * Actualiza el estado civil y elimina la referencia mutua con la esposa.
     */
    public void divorcio() {
    if (this.getEsposa() != null) {
        Mujer ex = this.getEsposa();
        this.setEsposa(null);
        this.setEstadoCivil("Divorciado");
        ex.divorcio();
        }
    }
    
    public String datos(){
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
        }
    
    public void mostrarEstadoCivil(){
        System.out.println(this.datos() + " - " + this.getEstadoCivil()); 
    }
    /**
     * Muestra con quién está casado el hombre, si corresponde.
     * Si no está casado, informa que no tiene esposa.
     */
     public void casadoCon(){
         if(this.getEstadoCivil() == "Casado"){
             System.out.println(this.datos() + " está casado con " + this.getEsposa().datos());
         }else{
             System.out.println(this.getNombre() + " no está casado!(por suerte).\n");
         }
        
    }

}