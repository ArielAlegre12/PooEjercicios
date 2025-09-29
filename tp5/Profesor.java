/**
 * Clase Profesor que administra de 1 hasta 3 cargos.
 */
import java.util.*;
public class Profesor extends Persona{
    private String titulo;
    private ArrayList<Cargo> cargos;
    
    /**
     * Constructor que inicializa al profesor con el array de cargos. y con la fecha de tipo Calendar
     * @param p_titulo titulo del profesor.
     * @param p_cargos arrays de cargos.
     */
    public Profesor(String p_titulo, ArrayList<Cargo> p_cargos, int p_dni, String p_nombre, String p_apellido, Calendar p_fecha){
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setTitulo(p_titulo);
        this.setCargos(p_cargos);
    }
    
    /**
     * Constructor que recibe el array de los cargos y sólo el año de nacimiento.
     */
    public Profesor(String p_titulo, ArrayList<Cargo> p_cargos, int p_dni, String p_nombre, String p_apellido, int p_anioNacimiento){
        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
        this.setTitulo(p_titulo);
        this.setCargos(p_cargos);
    }
    
    /**
     * Constructor que inicaliza sólo con un cargo. y con la fecha de tipo Calendar
     */
    public Profesor(String p_titulo, Cargo p_cargo, int p_dni, String p_nombre, String p_apellido, Calendar p_fecha){
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setTitulo(p_titulo);
        this.setCargos(new ArrayList<Cargo>());
        this.agregarCargo(p_cargo);
    }
    
    /**
     * Constructo que recibe solo un cargo y sólo el año de nacimiento.
     */
    public Profesor(String p_titulo, Cargo p_cargo, int p_dni, String p_nombre, String p_apellido, int p_anioNacimiento){
        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
        this.setTitulo(p_titulo);
        this.setCargos(new ArrayList<Cargo>());
        this.agregarCargo(p_cargo);
    }
    
    /**
     * setters y getters.
     */
    private void setTitulo(String p_titulo){this.titulo = p_titulo;}
    private void setCargos(ArrayList<Cargo> p_cargos){this.cargos = p_cargos;}
    
    public String getTitulo(){return this.titulo;}
    public ArrayList<Cargo> getCargos(){return this.cargos;}
    
    /**
     * Método para agregar un cargo.
     * verifica que el profesor no supere la cantidad de cargos posibles.
     */
    public boolean agregarCargo(Cargo p_cargo){
        if(this.getCargos().size() > 3){
            return false;
        }else{
            return this.getCargos().add(p_cargo);
        }
    }
    
    /**
     * Método que permite quitar cargos, pero evitando que el profesor quede sin cargos
     */
    public boolean quitarCargo(Cargo p_cargo){
        if(this.getCargos().size() >= 1){
            return this.getCargos().remove(p_cargo);
        }else{
            return false;
        }
    }
    
    /**
     * Método que permite ver los distintos cargos del profesor.
     */
    public void mostrar(){
        super.mostrar();
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("-***** Cargos Asignados *****-");
        listarCargos();
    }
    
    /**
     * método para listar los cargos del profesor.
     */
    public void listarCargos(){
        for(Cargo unCargo: this.getCargos()){
            System.out.println("-----------------------------");
            unCargo.mostrarCargo();
         }
         System.out.println("** Sueldo Total: " + this.sueldoTotal() + " **");
    }
    
    /**
     * Calcular el sueldo total del profesor.
     */
    public double sueldoTotal(){
        double total = 0.0;
        for(Cargo unCargo: this.getCargos()){
            total += unCargo.sueldoCargo();
         }
         return total;
    }
    
    /**
     * Método para proveer una cadena con los datos del profesor.
     */
    public String mostrarLinea(){
        return "DNI: " + super.getDNI()  + " - Nombre: " + super.nomYape()  + " - Sueldo Total: " + this.sueldoTotal();
    }
}