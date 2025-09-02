import java.util.*;
import java.util.Scanner;
/**
 * La clase {@code Empleado} modela los datos y comportamientos asociados a un empleado de la empresa.
 * <p>
 * Contiene información como CUIL, nombre, apellido, sueldo básico y fecha de ingreso.
 * Permite calcular la antigüedad, el sueldo neto, descuentos, adicionales y verificar si hoy es su aniversario laboral.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Empleado{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy  = fechaHoy.get(Calendar.YEAR);
    private Calendar fechaIngreso;
    
    Scanner teclado = new Scanner(System.in);
   /**
     * Constructor que inicializa un empleado con año de ingreso.
     *
     * @param p_cuil       CUIL del empleado.
     * @param p_apellido   Apellido del empleado.
     * @param p_nombre     Nombre del empleado.
     * @param p_importe    Sueldo básico del empleado.
     * @param p_anio       Año de ingreso del empleado.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldo(p_importe);
        this.setAnioIngreso(p_anio);
    }
   /**
    * Constructor que inicializa un empleado con fecha completa de ingreso.
    *
    * @param p_cuil         CUIL del empleado.
    * @param p_apellido     Apellido del empleado.
    * @param p_nombre       Nombre del empleado.
    * @param p_importe      Sueldo básico del empleado.
    * @param p_fechaIngreso Fecha de ingreso del empleado.
    */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fechaIngreso){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldo(p_importe);
        this.setFechaIngreso(p_fechaIngreso);
    }
    //setters
    private void setCuil(long p_cuil){
        this.cuil = p_cuil;
    }
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setSueldo(double p_importe){
        this.sueldoBasico = p_importe;
    }
    private void setAnioIngreso(int p_anio){
    this.fechaIngreso = Calendar.getInstance();
    this.fechaIngreso.set(Calendar.YEAR, p_anio);
    }

    private void setFechaIngreso(Calendar p_fechaIngreso){
        this.fechaIngreso = p_fechaIngreso;
    }
    //getters
    public long getCuil(){
        return this.cuil;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getNombre(){
        return this.nombre;
    }
    public double getSueldo(){
        return this.sueldoBasico;
    }
    public int getAnioIngreso(){
        return this.fechaIngreso.get(Calendar.YEAR);
    }
    public Calendar getFechaIngreso(){return this.fechaIngreso;}
    
    /**
     * Metodo {@code antiguedad()} que devuelve la cantidad de años trabajados
     */
    public int antiguedad(){
        return anioHoy - this.getAnioIngreso();
    }
    /**
     * Método {@code descuento()} que devuelve la cantidad descontada del sueldo neto
     */
    private double descuento(){
        return ((this.getSueldo() * 2) / 100) + 1500;    
    }
    /**
     * Método {@code adicional()} que devuelve la cantidad de adicional dependiendo 
     * de su antiguedad en el trabajo.
     */
    private double adicional(){
        double adicional = 0;
        if(antiguedad() < 2){
                    adicional = this.getSueldo() * 2 / 100;
            }else if(antiguedad() >= 10 && antiguedad() < 10){
                adicional = this.getSueldo() * 4 / 100;
            }else{
                adicional = this.getSueldo() * 6 / 100;
            }
            return adicional;
    }
    /**
     * Método {@code sueldoNeto()} que devuelve el sueldo ya con el descuento de la obra social
     * y el seguro de vida.
     */
    public double sueldoNeto(){
        return (this.getSueldo() - descuento());
    }
    //obtener nombre y apellido
    public String nomYape(){
        return this.getNombre() + " " + this.getApellido();
    }
    //obtener apellido y nombre
    public String apeYnom(){
        return this.getApellido() + ", " + this.getNombre();
    }
    //visualizar datos
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYape());
        System.out.println("CUIL: " + this.getCuil() + "\tAntiguedad: " + antiguedad() + " Años de servicio");
        System.out.println("Sueldo neto: $" + sueldoNeto());
    }
    public String mostrarLinea(){
        return this.getCuil() + "\t" + apeYnom() + "\t........ $" + sueldoNeto();  
    }
    
    /**
     * Verifica si hoy se cumple un nuevo aniversario desde la fecha de ingreso.
     *
     * @return {@code true} si el día y mes de hoy coinciden con los de la fecha de ingreso, {@code false} en caso contrario.
     */
   public boolean esAniversario(){
    if(this.getFechaIngreso() == null) return false;
    Calendar hoy = Calendar.getInstance();
    return hoy.get(Calendar.DAY_OF_MONTH) == this.getFechaIngreso().get(Calendar.DAY_OF_MONTH) &&
           hoy.get(Calendar.MONTH) == this.getFechaIngreso().get(Calendar.MONTH);
}

}