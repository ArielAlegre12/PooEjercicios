/**
 * Clase que representa una heladera y hereda las caracteristicas de ArtefactoHogar
 */
public class Heladera extends ArtefactoHogar{
    private int pies;
    private int puertas;
    private boolean compresor;
    
    /**
     * Constructor que inicializa las caracteristicas de la heladera
     * @param p_pies pies de la heladera.
     * @param p_puertas puertas de la heladera
     * @param p_compresor si tiene o no compresor la heladera.
     */
    public Heladera(int p_pies, int p_puertas, boolean p_compresor, String p_marca, float p_precio, int p_stock){
        super(p_marca, p_precio, p_stock);
        this.setPies(p_pies);
        this.setPuertas(p_puertas);
        this.setCompresor(p_compresor);
    }
    
    //setters
    private void setPies(int p_pies){this.pies = p_pies;}
    private void setPuertas(int p_puertas){this.puertas = p_puertas;}
    private void setCompresor(boolean p_compresor){this.compresor = p_compresor;}
    
    //getters
    public int getPies(){return this.pies;}
    public int getPuertas(){return this.puertas;}
    public boolean getCompresor(){return this.compresor;}
    
    /**
     * método que comprueba si la heladera debera pagar un adicional de $50
     * si posee compresor
     */
    public float creditoConAdicional(int p_cuotas, float p_interes){
        if(this.getCompresor()){
            return (super.cuotaCredito(p_cuotas, p_interes) + 50);
        }else{
            return super.cuotaCredito(p_cuotas, p_interes);
        }
    }
    
    /**
     * método para imprimir las caracteristicas del producto.
     */
    public void imprimir(){
        System.out.println("\n**** Heladera ****");
        super.imprimir();
        System.out.println("Pies: " + this.getPies());
        System.out.println("Puertas: " + this.getPuertas());
        if(this.getCompresor()){
            System.out.println("Compresor: si");
        }else{
            System.out.println("Compresor: no");
        }
    }
}