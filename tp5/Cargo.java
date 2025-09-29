/**
 * Clase Cargo, que representa el cargo que puede tener un profesor.
 * Sólo puede tener hasta 3.
 */
import java.util.Calendar;

public class Cargo{
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;
    
    /**
     * Constructor que inicializa el cargo con los datos recibidos.
     * @param p_nombreCargo nombre del cargo asignado.
     * @param p_sueldoBasico monto del sueldo basico.
     * @param p_anioIngreso año de ingreso.
     * @param p_horasDeDocencia horas de docencia
     */
    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia){
        setNombreCargo(p_nombreCargo);
        setSueldoBasico(p_sueldoBasico);
        setAnioIngreso(p_anioIngreso);
        setHorasDocencia(p_horasDeDocencia);
    }
    
    /**
     * Métodos setters y getters.
     */
    private void setNombreCargo(String p_nombreCargo){this.nombreCargo = p_nombreCargo;}
    private void setSueldoBasico(double p_sueldoBasico){this.sueldoBasico = p_sueldoBasico;}
    private void setAnioIngreso(int p_anioIngreso){this.anioIngreso = p_anioIngreso;}
    private void setHorasDocencia(int p_horasDeDocencia){this.horasDeDocencia = p_horasDeDocencia;}
    
    public String getNombreCargo(){return this.nombreCargo;}
    public double getSueldoBasico(){return this.sueldoBasico;}
    public int getAnioIngreso(){return this.anioIngreso;}
    public int getHorasDocencia(){return this.horasDeDocencia;}
    
    /**
     * Método que retorna la antiguedad del cargo.
     */
    public int antiguedad(){
        return Calendar.getInstance().get(Calendar.YEAR) - this.getAnioIngreso();
    }
    
    /**
     * Método que calcula el adicional del 1% por cada año de antiguedad.
     */
    private double adicionalXAntiguedad(){
        double adicional = this.antiguedad();
        return adicional * this.getSueldoBasico() / 100;
    }
    
    /**
     * Método que calcula el sueldo del cargo.
     */
    public double sueldoCargo(){
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
    }
    
    /**
     * Método para visualizar los datos del cargo.
     */
    public void mostrarCargo(){
        System.out.println("\n" + this.getNombreCargo() + " - Sueldo Basico: " + this.getSueldoBasico() + 
                            " - Sueldo Cargo: " + this.sueldoCargo() + " - Antiguedad: " + this.antiguedad() + " Años\n" + 
                            " Horas Docencias: " + this.getHorasDocencia());
    }
}