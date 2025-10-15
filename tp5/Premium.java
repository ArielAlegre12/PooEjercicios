/**
 * Clase premium que representa una etiqueta.
 */
public class Premium extends Etiqueta{
    private int colores;
    
    /**
     * constructor que inicializa la etiqueta con los colores.
     */
    public Premium(int p_colores, double p_costo){
        super(p_costo);
        this.setColores(p_colores);
    }
    
    //setters
    private void setColores(int p_colores){this.colores = p_colores;}
    
    //getters
    public int getColores(){return this.colores;}
    
    /**
     * método que retorna el precio de la prenda de mierda esta.
     */
    @Override
    public double  precio(int q){
        double newPrecio = super.getCosto() + this.adicional();
        return newPrecio;
    }
    
    /**
     * método que retorna el tipo de etiqueta
     */
    @Override
    protected String tipo(){return "Premium";}
    
    /**
     * método para obtener el adicional de la etiqueta.
     */
    private double adicional(){
        double adicional = 0.0;
        switch(this.getColores()){
            case 1:
                adicional = super.getCosto() * 0.0;
                break;
            case 2:
                adicional = super.getCosto() * 0.5;
                break;
            case 3:
                adicional = super.getCosto() * 0.7;
                break;
            default:
                adicional = super.getCosto() * (this.getColores() * 0.3);
        }
        return adicional;
    }
    
    /**
     * método para retornar una linea con los detalles de la etiqueta.
     */
    public String toString(){
        return super.toString() + " - Colores: " + this.getColores();
    }
}