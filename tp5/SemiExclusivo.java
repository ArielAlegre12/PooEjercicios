/**
 * Clase SemiExclusivo que permite al cargo cumplir hasta 10hs de investigación y minimamente 10hs de docencia.
 */
public class SemiExclusivo extends Cargo{
    private int horasDeInvestigacion;
    
    /**
     * Constructor que inicializa la clase-
     * @param p_horasDeInvestigacion Horas dedicada a la investigación.
     */  
    public SemiExclusivo(int p_horasDeInvestigacion ,String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia){
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDeDocencia);
        setHorasInvestigacion(p_horasDeInvestigacion);
    }
    
    /**
     * Métodos setters y getters.
     */
    private void setHorasInvestigacion(int p_horasDeInvestigacion){this.horasDeInvestigacion = p_horasDeInvestigacion;}
    
    public int getHorasInvestigacion(){return this.horasDeInvestigacion;}
    
    /**
     * método para mostrar el cargo de semiExclusivo.
     */
    public void mostrarCargo(){
        if((this.getHorasInvestigacion() + super.getHorasDocencia()) <= 20 && super.getHorasDocencia() >= 10){
            super.mostrarCargo();
            System.out.println("\n----Cargo de caracter SemiExclusivo----");
            System.out.println("Horas de investigacion: " + this.getHorasInvestigacion());
        }
    }
}