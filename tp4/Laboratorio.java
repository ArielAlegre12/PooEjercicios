/**
 * Esta clase representa un laboratorio farmaceutico que comercializa productos.
 * <p>
 * Contiene información como nombre, domnicilio, teléfono, compra minima y dia de entrega.
 * Permite modifcar ciertos datos mediante métodos públicos.
 * 
 * @Author Alegre Ariel, Antoniow Agustín.
 * @version 1.0
 * 
 */
public class Laboratorio{
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;
    /**
     * Contructor completo de Laboratorio.
     * @param p_nombre nombre (del lab).
     * @param p_domicilio (del lab).
     * @param p_teléfono (del lab).
     * @param p_compraMinima la compra de menor precio en el lab.
     * @param p_diaEnt dia de la entrega de productos.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, int p_diaEnt){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(p_compraMin);
        this.setDiaEntrega(p_diaEnt);
    }
    /**
     * Constructor parcial de Laboratorio
     * @param p_nombre nombre (del lab).
     * @param p_domicilio (del lab).
     * @param p_teléfono (del lab).
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setDomicilio(String p_domicilio){
        this.domicilio = p_domicilio;
    }
    private void setTelefono(String p_telefono){
        this.telefono = p_telefono;
    }
    private void setCompraMinima(int p_compraMin){
        this.compraMinima = p_compraMin;
    }
    private void setDiaEntrega(int p_diaEnt){
        this.diaEntrega = p_diaEnt;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getDomicilio(){
        return this.domicilio;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public int getCompraMinima(){
        return this.compraMinima;
    }
    public int getDiaEntrega(){
        return this.diaEntrega;
    }
    /**
     * En caso de que se necesite actualizar la compra minima
     * @param p_compraMin contiene el nuevo valor
     */
    public void nuevaCompraMinima(int p_compraMin){
        this.setCompraMinima(p_compraMin);
    }
    /**
     * En caso de que se necesite actualizar nuevo dia de entrega
     * @param p_diaEnt contiene el nuevo dia
     */
    public void nuevoDiaEntrega(int p_diaEnt){
        this.setDiaEntrega(p_diaEnt);
    }
    /**
     * si se quiere devolver los datos del laboratorio
     */
    public String mostrar(){
        return "Laboratorio: " + this.getNombre() + "\n" + 
                "Domicilio: " + this.getDomicilio() + "- " + "Teléfono: " + this.getTelefono();
    }
}