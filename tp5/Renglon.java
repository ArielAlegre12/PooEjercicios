/**
 * clase renglon que permite mostrar los renglones con detalles de las etiquetas
 */
public class Renglon{
    private int cantidad;
    private double importe;
    private Etiqueta item;
    
    /**
     * constructor que incializa el renglon con el item.
     * @param p_cantidad cantidad de etiquetas.
     * @param p_importe importe de la prenda.
     * @param p_item item de la etiqueta, puede ser común o premium.
     */
    public Renglon(int p_cantidad, double p_importe, Etiqueta p_item){
        this.setCantidad(p_cantidad);
        this.setImporte(p_importe);
        this.setItem(p_item);
    }
    
    //setters
    private void setCantidad(int p_cantidad){this.cantidad = p_cantidad;}
    private void setImporte(double p_importe){this.importe = p_importe;}
    private void setItem(Etiqueta p_item){this.item = p_item;}
    
    //getters
    public int getCantidad(){return this.cantidad;}
    public double getImporte(){return this.importe;}
    public Etiqueta getItem(){return this.item;}
    
    /**
     * método para mostrar los renglones.
     */
    public void mostrar(){
        System.out.printf("%d Etiquetas de %s\n", this.getCantidad(), this.getItem().toString());
    }
}