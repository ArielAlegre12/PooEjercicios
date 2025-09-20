/**
 * Clase comercio
 */
import java.util.*;
public class Comercio{
    private String nombre;
    private HashMap<Long, Empleado> empleados;
    /**
     * Constructor que sólo recibe el nombre del comercio.
     */
    public Comercio(String p_nombre){
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long,Empleado> ());
    }
    /**
     * Constructor que recibe el nombre del comercio y los empleados.
     */
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados){
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }
    /**
     * setters y getters.
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setEmpleados(HashMap<Long, Empleado> p_empleados){this.empleados = p_empleados;}
    
    public String getNombre(){return this.nombre;}
    public HashMap<Long, Empleado> getEmpleados(){return this.empleados;}
    /**
     * Método para agregar un empleado.
     */
    public void altaEmpleado(Empleado p_empleado){
        this.getEmpleados().put(new Long(p_empleado.getCuil()), p_empleado);
    }
    /**
     * Método para quitar un empleado.
     */
    public Empleado bajaEmpleado(Long p_cuil){
        return this.getEmpleados().remove(new Long(p_cuil));
    }
    /**
     * método para concocer la cantiadad de empĺeados
     */
    public int cantidadEmpleados(){
        return this.getEmpleados().size();
    }
    /**
     * Método para saber si es empleado o no.
     */
    public boolean esEmpleado(Long p_cuil){
        return this.getEmpleados().containsKey(new Long(p_cuil));
    }
    /**
     * Método para buscar un empleado
     */
    public Empleado buscarEmpleado(Long p_cuil){
        //No estoy seguro si es necesario castear acá, ya que el HashMap ya espera recibir un valor tipo Empleado.
        return (Empleado)this.getEmpleados().get(new Long(p_cuil));
    }
    /**
     * Método para mostrar el sueldo neto de un empleado dependiendo de su cuil
     */
    public void sueldoNeto(Long p_cuil){
        if(this.esEmpleado(p_cuil)){
            System.out.println("Sueldo Neto: " + this.buscarEmpleado(p_cuil).sueldoNeto());
        }
    }
    /**
     * nomina de los empleados que muestra sus datos.
     */
    public void nomina(){
        System.out.println("\n*** Nomina de Empleados de " + this.getNombre() + " ***");
        for(Map.Entry<Long, Empleado> unEmpleado: this.getEmpleados().entrySet()){
            System.out.println(unEmpleado.getKey() + " " + unEmpleado.getValue().nomYape() + "------------ $" + unEmpleado.getValue().sueldoNeto());
        }
    }
}