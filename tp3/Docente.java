/**
 * Creo la clase Docente el caul representa a uno, con datos como 
 * nombre, grado a cargo, sueldo básico y asignación familiar.
 * Esta clase permite acceder a estos datos y modificarlos, también
 * calcula el sueldo a través de sus métodos.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Docente{
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;
    
    /**
     * Creo el constructor que incializa al docente con sus respectivos datos.
     * @param p_nombre nombre del docente.
     * @param p_grado grado a cargo del docente.
     * @param p_sueldoBasico sueldo básico del docente.
     * @param p_asiFamiliar monto de asignación familiar del docente.
     */
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asiFamiliar){
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAsiFamiliar(p_asiFamiliar);
    }
    /**
     * Métodos setters
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setGrado(String p_grado){
        this.grado = p_grado;
    }
    private void setSueldoBasico(double p_sueldoBasico){
        this.sueldoBasico = p_sueldoBasico;
    }
    private void setAsiFamiliar(double p_asiFamiliar){
        this.asignacionFamiliar = p_asiFamiliar;
    }
    /**
     * Métodos getters
     */
    public String getNombre(){
        return this.nombre;
    }
    public String getGrado(){
        return this.grado;
    }
    public double getSueldoBasico(){
        return this.sueldoBasico;
    }
    public double getAsiFamiliar(){
        return this.asignacionFamiliar;
    }
    /**
     * Método que calcula el sueldo, sumando sueldoBasico + asignacionFamiliar
     */
    public double calcularSueldo(){
        return this.getSueldoBasico() + this.getAsiFamiliar();
    }
}