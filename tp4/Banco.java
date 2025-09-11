import java.util.*;
/**
 * Clase Banco que representa la administracón de sus empleados y sus sueldos. puede agregar o quitar empleados.
 */
public class Banco{
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList empleados;
    /**
     * Constructor que sólo recibe un empleado.
     * @param  p_nombre nombre del banco.
     * @param p_localidad localidad del banco.
     * @param p_nroSucursal numero de la sucursal.
     * @param p_empleado empleado.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList());
        this.agregarEmpleado(p_empleado);
    }
    /**
     * Constructor que recibe una lista de empleados.
     * @param  p_nombre nombre del banco.
     * @param p_localidad localidad del banco.
     * @param p_nroSucursal numero de la sucursal.
     * @param p_empleados del tipo array contiene empleados.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
    }
    /**
     * Métodos setters y getters.
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setLocalidad(Localidad p_localidad){this.localidad = p_localidad;}
    private void setNroSucursal(int p_nroSucursal){this.nroSucursal = p_nroSucursal;}
    private void setEmpleados(ArrayList p_empleados){this.empleados = p_empleados;}
    
    public String getNombre(){return this.nombre;}
    public Localidad getLocalidad(){return this.localidad;}
    public int getNroSucursal(){return this.nroSucursal;}
    public ArrayList getEmpleados(){return this.empleados;}
    /**
     * Métodos para agregar y quitar elementos.
     */
    public boolean agregarEmpleado(Empleado p_empleado){
        return this.getEmpleados().add(p_empleado);
    }
    public boolean quitarEmpleado(Empleado p_empleado){
        return this.getEmpleados().remove(p_empleado);
    }
    /**
     * Método que lista los sueldos de los empleados, recorriendo el array.
     */
    public void listarSueldos(){
        for(Object unEmpleado: this.getEmpleados()){
            System.out.println(((Empleado)unEmpleado).mostrarLinea());
        }
    }
    /**
     * Método que va sumando los sueldos de los empleados y luego lo retorna.
     */
    public double sueldosAPagar(){
        double sueldos = 0.0;
        for(Object unEmpleado: this.getEmpleados()){
            sueldos += ((Empleado) unEmpleado).sueldoNeto();
        }
        return sueldos;
    }
    /**
     * Método para visualizar los datos del banco y sus empleados.
     */
    public void mostrar(){
        System.out.println("BANCO: " + this.getNombre() + "\tSucursal: " +this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar() + "\n");
        this.listarSueldos();
        System.out.println("\nTotal a Pagar----------------------------------$" + this.sueldosAPagar());
    }
}