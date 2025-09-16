/**
 * Representa un producto comercializado por una droguería.
 * Cada producto tiene un código, rubro, descripción, costo, stock,
 * punto de reposición, existencia mínima y un laboratorio asociado.
 * El stock se inicia en 0 al momento de alta.
 * 
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Producto{
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio lab;
    
    /**
 * Constructor completo. Inicializa todos los atributos del producto.
 * @param p_codigo código del producto
 * @param p_rubro rubro al que pertenece
 * @param p_desc descripción del producto
 * @param p_costo precio de costo
 * @param p_porcPtoRepo porcentaje de punto de reposición
 * @param p_existMinima existencia mínima
 * @param p_lab laboratorio proveedor
 */ 
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab){
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_lab);
        }
    
        /**
        * Constructor alternativo. No incluye punto de reposición ni existencia mínima.
        * @param p_codigo código del producto
        * @param p_rubro rubro al que pertenece
        * @param p_desc descripción del producto
        * @param p_costo precio de costo
        * @param p_lab laboratorio proveedor
        */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab){
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setLaboratorio(p_lab);
        this.existMinima = 0;
        this.porcPtoRepo = 0;
        this.stock = 0;
    }
                    
    private void setCodigo(int p_codigo){
        this.codigo = p_codigo;
    }
    private void setRubro(String p_rubro){
        this.rubro = p_rubro;
    }
    private void setDescripcion(String p_desc){
        this.descripcion = p_desc;
    }
    private void setCosto(double p_costo){
        this.costo = p_costo;
    }
    private void setPorcPtoRepo(double p_porcPtoRepo){
        this.porcPtoRepo = p_porcPtoRepo;
    }
    private void setExistMinima(int p_existMinima){
        this.existMinima = p_existMinima;
    }
    private void setLaboratorio(Laboratorio p_lab){
        this.lab = p_lab;
    }
    private void setStock(int p_stock){
        this.stock = p_stock;
    }
    
    public int getStock(){
        return this.stock;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public String getRubro(){
        return this.rubro;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public double getCosto(){
        return this.costo;
    }
    public double getPorcPtoRepo(){
        return this.porcPtoRepo;
    }
    public int getExistMinima(){
        return this.existMinima;
    }
    public Laboratorio getLab(){
        return this.lab;
    }
    
    /**
    * Muestra los datos del producto y su stock valorizado.
    */
    void mostrar(){
        System.out.println(lab.mostrar()+ "\n");
        System.out.println("Rubro: " + this.getRubro());
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println("Precio costo: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + " Stock valorizado: $" + this.stockValorizado() + "\n");
    }
     
    /**
     * Modifica el stock del producto según una operación de inventario.
     * @param p_cantidad cantidad a ajustar (positiva o negativa)
     */
    public void ajuste(int p_cantidad){
        this.setStock(this.getStock() + p_cantidad);
    }
    
    /**
     * Calcula el valor del stock incluyendo una rentabilidad del 12%.
     * @return valor valorizado del stock
     */
    public double stockValorizado(){
        return this.getStock() * (this.getCosto() + (this.getCosto() * 12 / 100));
    }
    
    /**
     * Calcula el precio de lista del producto, agregando un 12% al costo.
     * @return precio de lista
     */
    public double precioLista(){
        return this.getCosto() * 1.12; 
    }
    
    /**
     * Calcula el precio al contado, aplicando un descuento del 5% sobre el precio de lista.
     * @return precio contado
     */
    public double precioContado(){
        return this.precioLista() - (this.precioLista() * 5) / 100;
    }
    
    /**
     * Devuelve una línea con la descripción, precio de lista y precio contado.
     * @return línea resumen del producto
     */
    public String mostrarLinea(){
        return this.getDescripcion() + " " + this.precioLista() + " " + this.precioContado();
    }
    
    /**
     * Ajusta el porcentaje de punto de reposición del producto.
     * @param p_porce nuevo porcentaje
     */
    public void ajustarPtoRepo(double p_porce){
        this.setPorcPtoRepo(p_porce);
    }
    
    /**
     * Ajusta la existencia mínima del producto.
     * @param p_cantidad nueva cantidad mínima
     */
    public void ajustarExistMin(int p_cantidad){
        this.setExistMinima(p_cantidad);
    }
    
    
}
    
        
                    