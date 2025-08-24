import java.util.Scanner;
/**
 * Clase Producto
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
    
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab){
        setCodigo(p_codigo);
        setRubro(p_rubro);
        setDescripcion(p_desc);
        setCosto(p_costo);
        setPorcPtoRepo(p_porcPtoRepo);
        setExistMinima(p_existMinima);
        setLaboratorio(p_lab);
                    }
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab){
        setCodigo(p_codigo);
        setRubro(p_rubro);
        setDescripcion(p_desc);
        setCosto(p_costo);
        setLaboratorio(p_lab);
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
        stock = p_stock;
    }
    
    public int getStock(){
        return stock;
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
    
    void mostrar(){
        lab.mostrar();
        System.out.println("Rubro: " + this.getRubro());
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println("Precio costo: " + this.getCosto());
        System.out.println("Stock: " + getStock() + " Stock valorizado: $" + stockValorizado());
    }
    
    public void ajuste(int p_cantidad){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea quitar o agregar el stock?(1-agregar, 2-quitar): ");
        int opcion = teclado.nextInt();
        if(opcion  == 1){
            this.setStock(this.getStock() + p_cantidad);
            return;
        }else if(opcion ==  2){
            this.setStock(this.getStock() - p_cantidad);
            return;
        }else{
            System.out.println("Opcion incorrecta!");
            return;
        }
    }
    
    public double stockValorizado(){
        return this.getStock() * (this.getCosto() + (this.getCosto() * 12 / 100));
    }
    
    public double precioLista(){
        return this.getCosto() * 1.12; 
    }
    
    public double precioContado(){
        return this.precioLista() - (this.precioLista() * 5) / 100;
    }
    
    public String mostrarLinea(){
        return this.getDescripcion() + " " + precioLista() + " " + precioContado();
    }
    
    public void ajustarPtoRepo(double p_porce){
        this.porcPtoRepo = p_porce;
    }
    
    public void ajustarExistMin(int p_cantidad){
        this.existMinima = p_cantidad;
    }
    
    
}
    
        
                    