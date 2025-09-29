/**
 * Clase Exclusivo que permite al cargo variar sus horas de docencia e invesigación.
 */
public class Exclusivo extends Cargo{
    private int horasDeInvestigación;
    private int horasDeExtencion;
    
    /**
     * Constructor que inicializa el cargo y los horarios
     * @param p_horasDeInvestigacion horas dedicadas a investigacion
     * @param p_horasDeExtencion horas dedicadas a la extension
     */
    public Exclusivo(int p_horasDeInvestigacion, int p_horasDeExtension,
                     String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia){
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDeDocencia);
        setHorasInvestigacion(p_horasDeInvestigacion);
        setHorasExtencion(p_horasDeExtension);
    }
    
    /**
     * métodos para acceder y modificar los horarios(setters y getters)
     */
    private void setHorasInvestigacion(int p_horasDeInvestigación){this.horasDeInvestigación = p_horasDeInvestigación;}
    private void setHorasExtencion(int p_horasDeExtension){this.horasDeExtencion = p_horasDeExtension;}
    
    public int getHorasInvestigacion(){return this.horasDeExtencion;}
    public int getHorasExtension(){return this.horasDeInvestigación;}
    
    public void mostrarCargo(){
        super.mostrarCargo();
        System.out.println("\n----Cargo de caracter Exclusivo----");
        System.out.println("Horas de investigacion: " + this.getHorasInvestigacion());
        System.out.println("Horas de extension: " + this.getHorasExtension());
    }
}