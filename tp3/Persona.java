import java.util.*;
/**
 * Esta clase representa a una persona con nombre, apellido, DNI y 
 * fecha de nacimiento.
 * 
 * Permite calcular la edad actual y mostrar los datos personales.
 */
public class Persona{
    private int nroDni;
    private String nombre;
    private String apellido;
    private int anioNacimiento;
    
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);
    
    /**
     * Crea una nueva persona con los datos espicificados.
     * @param p_dni Número de DNI
     * @param p_nombre Nombre de la persona
     * @param p_apellido apellido de la persona 
     * @param p_anio Año de nacimiento pues
     * 
     * @author Ariel
     * @version 1.0
     */
    public Persona(int p_nroDni, String p_nombre, String p_apellido, int p_anio){
        setDni(p_nroDni);
        setNombre(p_nombre);
        setApellido(p_apellido);
        setAnioNacimiento(p_anio);
    }
    /**
     * Métodos setters y getters para encapsular el acceso a los atributos privados.
     */
    private void setDni(int p_nroDni){
        nroDni = p_nroDni;
    }
    
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        apellido = p_apellido;
    }
    
    private void setAnioNacimiento(int p_anio){
        anioNacimiento = p_anio;
    }
    
    public int getDNI(){
        return nroDni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public int getAnioNacimiento(){
        return anioNacimiento;
    }
    
    /**
     * defino el método que retorna la edad.
     */
    public int edad(){
        return anioHoy - getAnioNacimiento();
    }
    
    /**
     * defino el método que retorna el nombre y apellido
     */
    public String nomYape(){
        return getNombre() + " " + getApellido();
    }
    
    /**
     * defino el método que retorna el apellido y nombre;
     */
    public String apeYnom(){
        return getApellido() + ", " + getNombre();
    }
    
    /**
     * defino el método que muestra la info de una persona
     */
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYape());
        System.out.println("DNI: " + getDNI() + "\t" + "Edad: " + edad() + " Años");
    }
}
