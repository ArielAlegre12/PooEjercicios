/**
 * Clase que representa una etiqueta común.
 */
public class Comun extends Etiqueta{
    private double plus;
    
    /**
     * Constructor que inicializa la prenda comun, con el plus.
     * @param p_plus plus que se agrega al precio.
     */
    public Comun(double p_plus, double p_costo){
        super(p_costo);
        this.setPlus(p_plus);
    }
    
    //setters
    private void setPlus(double p_plus){this.plus = p_plus;}
    
    //getters 
    public double getPlus(){return this.plus;}
    
    /**
     * método para obtener el precio de la prenda.
     */
    @Override
    public double precio(int q){
        return (super.getCosto() * q) + this.getPlus();
    }
    
    /**
     * método para retornar el tipo de etiqueta
     */
    @Override
    protected String tipo(){
        return "Común";
    }
    
    /**
     * método para obtener el descuento.
     */
    private double descuento(int q){
        double descuento = 0.0;
        if(q > 0 && q < 11){
            descuento = this.precio(q) * 0.0;
        }else if(q > 10 && q < 51){
            descuento = this.precio(q) * 0.2;
        }else{
            descuento = this.precio(q) * ((q / 10) * 0.1);
        }
        return descuento;
    }
    
    /**
     * redefino el método que devuelve una cadena.
     */
    public String toString(){
        return super.toString() + " diseño: " + this.getPlus();
    }
}