import java.util.*;
/**
 * Esta clase representa a una persona con nombre, apellido, DNI y 
 * fecha de nacimiento.
 * 
 * Permite calcular la edad actual y mostrar los datos personales.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Persona{
    private int nroDni;
    private String nombre;
    private String apellido;
    //private int anioNacimiento;
    private Calendar fechaNacimiento;
    
    
    /**
     * Constructor alternativo que permite crear una Persona solo con el año de nacimiento.
     * @param p_dni Número de DNI.
     * @param p_nombre Nombre.
     * @param p_apellido Apellido.
     * @param p_anio Año de nacimiento.
     */
public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
    this.setDni(p_dni);
    this.setNombre(p_nombre);
    this.setApellido(p_apellido);
    setAnioNacimiento(p_anio);
}
public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha) {
    this.setDni(p_dni);
    this.setNombre(p_nombre);
    this.setApellido(p_apellido);
    this.setFechaNacimiento(p_fecha);
}


    /**
     * Métodos setters y getters para encapsular el acceso a los atributos privados.
     */
    private void setDni(int p_nroDni){
       this. nroDni = p_nroDni;
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    
    private void setFechaNacimiento(Calendar p_fecha){
        this.fechaNacimiento = p_fecha;
    }
    
    private void setAnioNacimiento(int p_anio){
        this.fechaNacimiento.set(Calendar.YEAR, p_anio);
    }
    
    public int getAnioNacimiento(){
        return this.getFechaNacimiento().get(Calendar.YEAR);
    }
    
    public int getDNI(){
        return this.nroDni;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public Calendar getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    
    /**
     * defino el método que retorna la edad.
     */
    public int edad(){
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - getFechaNacimiento().get(Calendar.YEAR);
        //verifico que no haya cumplido años aún
        if(hoy.get(Calendar.MONTH) < this.getFechaNacimiento().get(Calendar.MONTH) ||
            (hoy.get(Calendar.MONTH) == this.getFechaNacimiento().get(Calendar.MONTH) &&
                hoy.get(Calendar.DAY_OF_MONTH) < this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH))){
                    edad--;
                }
                return edad;
    }
    
    /**
     * defino el método que retorna el nombre y apellido
     */
    public String nomYape(){
        return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * defino el método que retorna el apellido y nombre;
     */
    public String apeYnom(){
        return this.getApellido() + ", " + this.getNombre();
    }
    
    /**
     * defino el método que muestra la info de una persona
     */
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYape());
        System.out.println("DNI: " + this.getDNI() + "\t" + "Edad: " + edad() + " Años");
    }
    /**
     * Verifica si hoy es el cumpleaños de la persona.
     * @return true si hoy es el cumpleaños, false en caso contrario o si la fecha no está definida.
     */
    public boolean esCumpleaños(){
        if(getFechaNacimiento() == null) return false;
        Calendar hoy = Calendar.getInstance();
        return hoy.get(Calendar.DAY_OF_MONTH) == this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH) &&
               hoy.get(Calendar.MONTH) == this.getFechaNacimiento().get(Calendar.MONTH);
    }
}
