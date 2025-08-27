/**
 * Creo la clase Docente
 */
public class Docente{
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;
    
    /**
     * Creo el constructor
     */
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asiFamiliar){
        setNombre(p_nombre);
        setGrado(p_grado);
        setSueldoBasico(p_sueldoBasico);
        setAsiFamiliar(p_asiFamiliar);
    }
    /**
     * Métodos setters
     */
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setGrado(String p_grado){
        grado = p_grado;
    }
    private void setSueldoBasico(double p_sueldoBasico){
        sueldoBasico = p_sueldoBasico;
    }
    private void setAsiFamiliar(double p_asiFamiliar){
        asignacionFamiliar = p_asiFamiliar;
    }
    /**
     * Métodos getters
     */
    public String getNombre(){
        return nombre;
    }
    public String getGrado(){
        return grado;
    }
    public double getSueldoBasico(){
        return sueldoBasico;
    }
    public double getAsiFamiliar(){
        return asignacionFamiliar;
    }
    /**
     * Método que calcula el sueldo, sumando sueldoBasico + asignacionFamiliar
     */
    public double calcularSueldo(){
        return getSueldoBasico() + getAsiFamiliar();
    }
}