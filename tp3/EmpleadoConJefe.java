import java.util.Calendar;
/**
 * Clase del tipo empleado con jefe
 */
public class EmpleadoConJefe{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private EmpleadoConJefe jefe;
    
    /**
     * Constructor que inicializa con fecha de ingreso y empleado con jefe
     * @param p_cuil cuil del empleado
     * ..........
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha, EmpleadoConJefe p_jefe){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
    }
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
    }
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
    
    public int antiguedad(){
        Calendar hoy = Calendar.getInstance();
        return hoy.get(Calendar.YEAR) - getAnioIngreso();
    }
    
    private double descuento(){
        return ((getSueldoBasico() * 2) / 100) + 1500;    
    }
    
    private double adicional(){
        double adicional = 0;
        if(antiguedad() < 2){
                    adicional = getSueldoBasico() * 2 / 100;
            }else if(antiguedad() >= 10 && antiguedad() < 10){
                adicional = getSueldoBasico() * 4 / 100;
            }else{
                adicional = getSueldoBasico() * 6 / 100;
            }
            return adicional;
    }
    
    public double sueldoNeto(){
        return (getSueldoBasico() - descuento());
    }
    //obtener nombre y apellido
    public String nomYape(){
        return getNombre() + " " + getApellido();
    }
    //obtener apellido y nombre
    public String apeYnom(){
        return getApellido() + ", " + getNombre();
    }
    
    public String mostrarLinea(){
        return getCuil() + "\t" + apeYnom() + "\t........ $" + sueldoNeto();  
    }
    
    public void mostrarPantalla(){
        System.out.println("Nombre y Apellido: " + nomYape());
        System.out.println("CUIL: " + getCuil() + " Antiguedad: " + antiguedad() + " Años de servicio.");
        System.out.println("Sueldo Neto: $" + sueldoNeto());
        if(getJefe() != null){
            System.out.println("Responde a " + getJefe().apeYnom());
        }else{
            System.out.println("GERENTE GENERAL");
        }
    }
    
    
}