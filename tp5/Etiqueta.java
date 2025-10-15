/**
 * Clase abstracta que representa la etiqueta de una prenda.
 */
public abstract class Etiqueta{
    private double costo;
    
    /**
     * Constructor que inicializa la etiqueta con un costo.
     * @param p_costo
     */
    public Etiqueta(double p_costo){
        this.setCosto(p_costo);
    }
    
    //setters
    private void setCosto(double p_costo){this.costo = p_costo;}
    
    //getters
    public double getCosto(){return this.costo;}
    
    //métodos abstractos.
    public abstract double precio(int q);
    protected abstract String tipo();
    
    /**
     * método para retornar detalles de la prenda.
     */
    public String toString(){
        return "tipo " + this.tipo() + " - Costo: $" + this.getCosto();
    }
    
    
}