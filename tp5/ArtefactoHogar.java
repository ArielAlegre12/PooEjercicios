/**
 * Clase ArtefactoHogar que maneja artefactos como cocina, lavarropa y heladera
 */
public abstract class ArtefactoHogar{
    private String marca;
    private float precio;
    private int stock;
    
    /**
     * Constructor que inicializa el artefacto
     * @param p_marca
     * @param p_precio
     * @param p_stock
     */
    public ArtefactoHogar(String p_marca, float p_precio, int p_stock){
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }
    
    //setters
    private void setMarca(String p_marca){this.marca = p_marca;}
    private void setPrecio(float p_precio){this.precio = p_precio;}
    private void setStock(int p_stock){this.stock = p_stock;}
    
    //getters
    public String getMarca(){return this.marca;}
    public float getPrecio(){return this.precio;}
    public int getStock(){return this.stock;}
    
    //método abstracto
    public abstract float creditoConAdicional(int p_cuotas, float p_interes);
    
    /**
     * método para calcular las cuotas del artefacto
     */
    public float cuotaCredito(int p_cuotas, float p_interes){
        return (this.getPrecio() + p_interes) / p_cuotas;
    }
    
    /**
     * Método para imprimir la info del artefacto
     */
    public void imprimir(){
        System.out.printf("Marca: %s     - Precio: %.2f - Stock: %d\n", this.getMarca(), this.getPrecio(), this.getStock());    
    }
}