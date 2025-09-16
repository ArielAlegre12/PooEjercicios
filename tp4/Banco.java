 import java.util.*;
/**
 * Clase Banco que representa la administracón de sus empleados y sus sueldos. puede agregar o quitar empleados.
 */
public class Banco{
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList empleados;
    private ArrayList cuentasBancarias;
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
        this.setCuentasBancarias(new ArrayList());
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
        this.setCuentasBancarias(new ArrayList());
    }
    /**
     * Método que recibe una o muchas cuentas bancarias.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados, ArrayList p_cuentasBancarias){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuentasBancarias);
    }
    /**
     * Métodos setters y getters.
     */
    private void setNombre(String p_nombre){this.nombre = p_nombre;}
    private void setLocalidad(Localidad p_localidad){this.localidad = p_localidad;}
    private void setNroSucursal(int p_nroSucursal){this.nroSucursal = p_nroSucursal;}
    private void setEmpleados(ArrayList p_empleados){this.empleados = p_empleados;}
    private void setCuentasBancarias(ArrayList p_cuentasBancarias){this.cuentasBancarias = p_cuentasBancarias;}
    
    public String getNombre(){return this.nombre;}
    public Localidad getLocalidad(){return this.localidad;}
    public int getNroSucursal(){return this.nroSucursal;}
    public ArrayList getEmpleados(){return this.empleados;}
    public ArrayList getCuentasBancarias(){return this.cuentasBancarias;}
    
    /**
     * Métodos para agregar y quitar elementos.
     */
    public boolean agregarEmpleado(Empleado p_empleado){
        return this.getEmpleados().add(p_empleado);
    }
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuentaBancaria){
        return this.getCuentasBancarias().add(p_cuentaBancaria);
    }
    public boolean quitarEmpleado(Empleado p_empleado){
        if(this.getEmpleados().size() == 1){
            return false;
        }else{
            return this.getEmpleados().remove(p_empleado);
        }
    }
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuentaBancaria){
        return this.getCuentasBancarias().add(p_cuentaBancaria);
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
    /**
     * Método para listar cuentas con saldos igual a cero.
     */
    public void listarCuentasConSaldoCero(){
        System.out.println("Cuentas sin saldo:");
        System.out.println("---Cuenta--------------------Apellido y Nombre----------------");
        for(Object unaCuenta: this.getCuentasBancarias()){
            if(((CuentaBancaria)unaCuenta).getSaldo() <= 0){
                System.out.println(((CuentaBancaria)unaCuenta).getNroCuenta() + "                    " + ((CuentaBancaria)unaCuenta).getTitular().nomYape());
            }
        }
    }
    /**
     * Método que devuelve la cantidad de cuentas con saldo activo.
     */
    private int cuentasSaldoActivo(){
        int cantCuentasConSaldo = 0;
        for(Object unaCuenta: this.getCuentasBancarias()){
            if(((CuentaBancaria)unaCuenta).getSaldo() > 0){
                cantCuentasConSaldo ++;
            }
        }
        return cantCuentasConSaldo;
    }
    /**
     * Método que devuelve la cantidad de titulares sin repetirse a traves de la propiedad HashSet
     */
    public HashSet<Persona> listaDeTitulares(){
        HashSet<Persona> titulares = new HashSet<>();
        for(Object unaCuenta: this.getCuentasBancarias()){
            titulares.add(((CuentaBancaria)unaCuenta).getTitular());
        }
        return titulares;
    }
    /**
     * Nuevo método para emitir el resumen del banco.
     * int cuentasSaldoCero = this.getCuentasBancarias().size() - cuentasSaldoActivo();
     */
    public void mostrarResumen(){
        int cuentasSaldoCero = 0;
        for(Object unaCuenta: this.getCuentasBancarias()){
            if(((CuentaBancaria)unaCuenta).getSaldo() <= 0){
                cuentasSaldoCero ++;
            }
        }
        System.out.println("BANCO: " + this.getNombre() + "\tSucursal: " +this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar() + "\n");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("****************************\n");
        int todasLasCuentas = this.cuentasSaldoActivo() + cuentasSaldoCero;
        System.out.println("Número total de Cuentas Bancarias: " + todasLasCuentas);
        System.out.println("Cuentas Activas: " + this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo cero: " + cuentasSaldoCero);
        System.out.println("-----------------------------------------");
        this.listarCuentasConSaldoCero();
        System.out.println("-----------------------------------------");
        System.out.print("Listado de clientes: (");
        int contador = 0; //contador para saber cuando es el final de la lista y poner el ;
        int total = this.listaDeTitulares().size(); //sabemos el total de elementos de la lista
        for(Object unTitular: this.listaDeTitulares()){
            System.out.print(((Persona)unTitular).apeYnom());
            contador++;
            if(contador < total){
                System.out.print("; ");
            }
        }
        System.out.print(")\n");
    }
}