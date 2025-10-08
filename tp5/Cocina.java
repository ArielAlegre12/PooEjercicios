/**
 * Clase cocina que representa una
 */
public class Cocina extends ArtefactoHogar{
    private int hornallas;
    private int calorias;
    private String dimeniones;
    
    /**
     * Constructor que inicializa los valores de la cocina
     * @param p_hornallas numero de hornallas
     * @param p_calorias    calorias de la cocina
     * @param p_dimensiones cadena de string de las dimensiones de la cocina
     */
    public Cocina(int p_hornallas, int p_calorias, String p_dimensiones, String p_marca, float p_precio, int p_stock){
        super(p_marca, p_precio, p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }
    
    //setters
    private void setHornallas(int p_hornallas){this.hornallas = p_hornallas;}
    private void setCalorias(int p_calorias){this.calorias = p_calorias;}
    private void setDimensiones(String p_dimensiones){this.dimeniones = p_dimensiones;}
    
    //getters 
    public int getHornallas(){return this.hornallas;}
    public int getCalorias(){return this.calorias;}
    public String getDimensiones(){return this.dimeniones;}
    
    //metodo que devuelve el credito adicional
    public float creditoConAdicional(int p_cuotas, float p_interes){
        return super.cuotaCredito(p_cuotas, p_interes);
    }
    
    /**
     * método para imprimir los detalles de la cocina
     */
    public void imprimir(){
        System.out.println("\n***** Cocina *****");
        super.imprimir();
        System.out.println("Hornallas: " + this.getHornallas());
        System.out.println("Calorias: " + this.getCalorias());
        System.out.println("Dimensiones: " + this.getDimensiones());
    }
}