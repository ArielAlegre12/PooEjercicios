import java.util.*;
import java.util.Scanner;
/**
 * Clase {@code Empleado} que contiene distintos datos de un empleado.
 * <p>
 * En ella habra información como antiguedad, sueldo neto, etc
 * 
 */
public class Empleado{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;
    
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);
    
    Scanner teclado = new Scanner(System.in);
    
    /**
     * Creo el constructor correspondiente
     * @param p_cuil (cuil del empleado)
     * @param p_apellido (del empleado)
     * @param p_nombre (del empleado)
     * @param p_importe (Sueldo inicial del empleado)
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio){
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldo(p_importe);
        setAnioIngreso(p_anio);
    }
    //setters
    private void setCuil(long p_cuil){
        cuil = p_cuil;
    }
    private void setApellido(String p_apellido){
        apellido = p_apellido;
    }
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setSueldo(double p_importe){
        sueldoBasico = p_importe;
    }
    private void setAnioIngreso(int p_anio){
        anioIngreso = p_anio;
    }
    //getters
    public long getCuil(){
        return cuil;
    }
    public String getApellido(){
        return apellido;
    }
    public String getNombre(){
        return nombre;
    }
    public double getSueldo(){
        return sueldoBasico;
    }
    public int getAnioIngreso(){
        return anioIngreso;
    }
    /**
     * Metodo {@code antiguedad()} que devuelve la cantidad de años trabajados
     */
    public int antiguedad(){
        return anioHoy - getAnioIngreso();
    }
    /**
     * Método {@code descuento()} que devuelve la cantidad descontada del sueldo neto
     */
    private double descuento(){
        return ((getSueldo() * 2) / 100) + 1500;    
    }
    /**
     * Método {@code adicional()} que devuelve la cantidad de adicional dependiendo 
     * de su antiguedad en el trabajo.
     */
    private double adicional(){
        double adicional = 0;
        if(antiguedad() < 2){
                    adicional = getSueldo() * 2 / 100;
            }else if(antiguedad() >= 10 && antiguedad() < 10){
                adicional = getSueldo() * 4 / 100;
            }else{
                adicional = getSueldo() * 6 / 100;
            }
            return adicional;
    }
    /**
     * Método {@code sueldoNeto()} que devuelve el sueldo ya con el descuento de la obra social
     * y el seguro de vida.
     */
    public double sueldoNeto(){
        return (getSueldo() - descuento());
    }
    //obtener nombre y apellido
    public String nomYape(){
        return getNombre() + " " + getApellido();
    }
    //obtener apellido y nombre
    public String apeYnom(){
        return getApellido() + ", " + getNombre();
    }
    //visualizar datos
    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYape());
        System.out.println("CUIL: " + getCuil() + "\tAntiguedad: " + antiguedad() + " Años de servicio");
        System.out.println("Sueldo neto: $" + sueldoNeto());
    }
    public String mostrarLinea(){
        return getCuil() + "\t" + apeYnom() + "\t........ $" + sueldoNeto();  
    }
}