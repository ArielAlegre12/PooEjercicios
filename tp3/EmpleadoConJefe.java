import java.util.Calendar;
/**
 * Representa a un empleado dentro de una estructura jerárquica empresarial.
 * Cada empleado puede tener asignado un jefe (otro objeto de tipo {@code EmpleadoConJefe}),
 * o ser el Gerente General si no tiene jefe asignado.
 */
public class EmpleadoConJefe{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private EmpleadoConJefe jefe;
    
     /**
     * Constructor completo que inicializa todos los atributos, incluyendo el jefe.
     *
     * @param p_cuil     CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre   Nombre del empleado
     * @param p_importe  Sueldo básico
     * @param p_fecha    Fecha de ingreso (tipo {@code Calendar})
     * @param p_jefe     Referencia al jefe del empleado (puede ser {@code null})
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha, EmpleadoConJefe p_jefe){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
    }
    /**
     * Constructor sin jefe asignado.
     *
     * @param p_cuil     CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre   Nombre del empleado
     * @param p_importe  Sueldo básico
     * @param p_fecha    Fecha de ingreso
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
    }
    /**
     * Constructor que inicializa la fecha de ingreso solo con el año.
     *
     * @param p_cuil     CUIL del empleado
     * @param p_apellido Apellido del empleado
     * @param p_nombre   Nombre del empleado
     * @param p_importe  Sueldo básico
     * @param p_anio     Año de ingreso
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
    }
    /**
     * mètodos getters y setters
     */
    private void setCuil(long p_cuil){
        this.cuil = p_cuil;
    }
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setSueldoBasico(double p_importe){
        this.sueldoBasico = p_importe;
    }
    private void setFechaIngreso(Calendar p_fecha){
        this.fechaIngreso = p_fecha;
    }
    private void setJefe(EmpleadoConJefe p_jefe){
        this.jefe = p_jefe;
    }
    private void setAnioIngreso(int p_anio){
        this.fechaIngreso = Calendar.getInstance();
        this.fechaIngreso.set(Calendar.YEAR, p_anio);
    }
    
    public long getCuil(){return this.cuil;}
    public String getApellido(){return this.apellido;}
    public String getNombre(){return this.nombre;}
    public double getSueldoBasico(){return this.sueldoBasico;}
    public Calendar getFechaIngreso(){return this.fechaIngreso;}
    public int getAnioIngreso(){return this.fechaIngreso.get(Calendar.YEAR);}
    public EmpleadoConJefe getJefe(){return this.jefe;}
    /**
     * Calcula la antigüedad del empleado en años.
     * @return cantidad de años desde la fecha de ingreso hasta el año actual
     */
    public int antiguedad(){
        Calendar hoy = Calendar.getInstance();
        return hoy.get(Calendar.YEAR) - this.getAnioIngreso();
    }
    /**
     * Calcula el descuento aplicado al sueldo básico.
     * El descuento incluye un 2% del sueldo básico más un monto fijo de $1500.
     *
     * @return monto total del descuento
     */
    private double descuento(){
        return ((this.getSueldoBasico() * 2) / 100) + 1500;    
    }
    /**
     * Calcula el adicional según la antigüedad del empleado.
     */
    private double adicional(){
        double adicional = 0;
        if(antiguedad() < 2){
                    adicional = this.getSueldoBasico() * 2 / 100;
            }else if(antiguedad() >= 10 && antiguedad() < 10){
                adicional = this.getSueldoBasico() * 4 / 100;
            }else{
                adicional = this.getSueldoBasico() * 6 / 100;
            }
            return adicional;
    }
    /**
     * Calcula el sueldo neto del empleado.
     * Se obtiene restando el descuento al sueldo básico.
     * @return sueldo neto
     */
    public double sueldoNeto(){
        return (this.getSueldoBasico() - descuento());
    }
    //obtener nombre y apellido
    public String nomYape(){
        return this.getNombre() + " " + this.getApellido();
    }
    //obtener apellido y nombre
    public String apeYnom(){
        return this.getApellido() + ", " + this.getNombre();
    }
    //muestra los datos concatenados.
    public String mostrarLinea(){
        return this.getCuil() + "\t" + apeYnom() + "\t........ $" + sueldoNeto();  
    }
    /**
     * Muestra por pantalla los datos completos del empleado.
     * Incluye nombre, CUIL, antigüedad, sueldo neto y jefe (si lo tiene).
     * Si no tiene jefe, se indica que es el Gerente General.
     */
    public void mostrarPantalla(){
        System.out.println("Nombre y Apellido: " + nomYape());
        System.out.println("CUIL: " + this.getCuil() + " Antiguedad: " + antiguedad() + " Años de servicio.");
        System.out.println("Sueldo Neto: $" + sueldoNeto());
        if(this.getJefe() != null){
            System.out.println("Responde a " + this.getJefe().apeYnom());
        }else{
            System.out.println("GERENTE GENERAL");
        }
    }
    
    
}