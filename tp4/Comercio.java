/**
 * La clase {@code Comercio} representa un comercio que gestiona una nómina de empleados.
 * Permite agregar, quitar, buscar y consultar empleados, así como mostrar su información salarial.
 * 
 * Utiliza un {@code HashMap<Long, Empleado>} para almacenar los empleados, donde la clave es el CUIL del empleado.
 * 
 * @author Alegre Ariel, Agustín Antoniow.
 * @version 1.0
 */
import java.util.*;
public class Comercio{
    private String nombre;
    private HashMap<Long, Empleado> empleados;
    
    /**
     * Constructor que inicializa el comercio con un nombre y una lista vacía de empleados.
     * 
     * @param p_nombre Nombre del comercio.
     */
    public Comercio(String p_nombre){
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long,Empleado> ());
    }
    
    /**
     * Constructor que inicializa el comercio con un nombre y una lista de empleados.
     * 
     * @param p_nombre Nombre del comercio.
     * @param p_empleados Mapa de empleados con CUIL como clave.
     */
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados){
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }
    
    /**
     * Establece el nombre del comercio.
     * 
     * @param p_nombre Nombre del comercio.
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    
    /**
     * Establece el mapa de empleados del comercio.
     * 
     * @param p_empleados Mapa de empleados.
     */
    private void setEmpleados(HashMap<Long, Empleado> p_empleados){this.empleados = p_empleados;}
    
    /**
     * Obtiene el nombre del comercio.
     * 
     * @return Nombre del comercio.
     */
    public String getNombre(){return this.nombre;}
    
    /**
     * Obtiene el mapa de empleados.
     * 
     * @return Mapa de empleados.
     */
    public HashMap<Long, Empleado> getEmpleados(){return this.empleados;}
    
    /**
     * Agrega un nuevo empleado al comercio.
     * 
     * @param p_empleado Empleado a agregar.
     */
    public void altaEmpleado(Empleado p_empleado){
        this.getEmpleados().put(new Long(p_empleado.getCuil()), p_empleado);
    }
    
    /**
     * Elimina un empleado del comercio según su CUIL.
     * 
     * @param p_cuil CUIL del empleado a eliminar.
     * @return El empleado eliminado, o {@code null} si no existía.
     */
    public Empleado bajaEmpleado(Long p_cuil){
        return this.getEmpleados().remove(new Long(p_cuil));
    }
    
    /**
     * Devuelve la cantidad total de empleados registrados en el comercio.
     * 
     * @return Número de empleados.
     */
    public int cantidadEmpleados(){
        return this.getEmpleados().size();
    }
    
    /**
     * Verifica si un CUIL corresponde a un empleado registrado.
     * 
     * @param p_cuil CUIL a verificar.
     * @return {@code true} si el CUIL está registrado, {@code false} en caso contrario.
     */
    public boolean esEmpleado(Long p_cuil){
        return this.getEmpleados().containsKey(new Long(p_cuil));
    }
    
    /**
     * Busca y devuelve un empleado según su CUIL.
     * 
     * @param p_cuil CUIL del empleado.
     * @return Instancia del empleado, o {@code null} si no se encuentra.
     */
    public Empleado buscarEmpleado(Long p_cuil){
        //No estoy seguro si es necesario castear acá, ya que el HashMap ya espera recibir un valor tipo Empleado.
        return (Empleado)this.getEmpleados().get(new Long(p_cuil));
    }
    
    /**
     * Muestra por consola el sueldo neto de un empleado según su CUIL.
     * 
     * @param p_cuil CUIL del empleado.
     */
    public void sueldoNeto(Long p_cuil){
        if(this.esEmpleado(p_cuil)){
            System.out.println("Sueldo Neto: " + this.buscarEmpleado(p_cuil).sueldoNeto());
        }
    }
    
    /**
     * Muestra por consola la nómina completa de empleados del comercio,
     * incluyendo CUIL, nombre y apellido, y sueldo neto.
     */
    public void nomina(){
        System.out.println("\n*** Nomina de Empleados de " + this.getNombre() + " ***");
        for(Map.Entry<Long, Empleado> unEmpleado: this.getEmpleados().entrySet()){
            System.out.println(unEmpleado.getKey() + " " + unEmpleado.getValue().nomYape() + "------------ $" + unEmpleado.getValue().sueldoNeto());
        }
    }
}