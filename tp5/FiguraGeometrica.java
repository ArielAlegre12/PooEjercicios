/**
 * Clase abstracta que representa tipos de figuras.
 */
public abstract class FiguraGeometrica{
    private Punto origen;
    
    /**
     * Constructor que incializa la fig geometrica.
     */
    public FiguraGeometrica(Punto p_origen){
        
    }
    
    //setters y getters
    private void setOrigen(Punto p_origen){this.origen = p_origen;}
    
    public Punto getOrigen(){return this.origen;}
    
    //Métodos abstractos.
    public abstract String nombreFigura();
    public abstract double superficie();
    
    public void mostrarSuperficie(){
        System.out.printf("Superficie: %.2f", this.superficie());
}
}