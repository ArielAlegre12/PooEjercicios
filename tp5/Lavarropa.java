/**
 * Clase que hereda de ArtefactoHogar algunas caracteristicas
 * esta clase representa las caracteristicas y modos de pago de un lavarropa
 */
public class Lavarropa extends ArtefactoHogar{
    private int programas;
    private float kilos;
    private boolean automatico;
    
    /**
     * Constructor que inicializa las caracteristicas de un lavarropa.
     * @param p_programas representa la cantidad de programas del lavarropa.
     * @param p_kilos representa los kilos soportados por el lavarropa.
     * @param p_automatico decide si el lavarropa es automatico o no.
     */
    public Lavarropa(int p_programas, float p_kilos, boolean p_automatico, String p_marca, float p_precio, int p_stock){
        super(p_marca, p_precio, p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
    }
    
    //setters
    private void setProgramas(int p_programas){this.programas = p_programas;}
    private void setKilos(float p_kilos){this.kilos = p_kilos;}
    private void setAutomatico(boolean p_automatico){this.automatico = p_automatico;}
    
    //getters
    public int getProgramas(){return this.programas;}
    public float getKilos(){return this.kilos;}
    public boolean getAutomatico(){return this.automatico;}
    
    /**
     * método para calcular el credito con adicional.
     * si no es automatico, tendrá un descuento del 2%.
     */
    public float creditoConAdicional(int p_cuotas, float p_interes){
        if(this.getAutomatico()){
            return (super.cuotaCredito(p_cuotas, p_interes) * 2) / 100;
        }else{
            return super.cuotaCredito(p_cuotas, p_interes);
        }
    }
    
    /**
     * método que imprime las caracteristicas del lavarropa
     */
    public void imprimir(){
        System.out.println("\n**** Lavarropas ****");
        super.imprimir();
        System.out.println("Programas: " + this.getProgramas());
        System.out.println("Kilos: " + this.getKilos());
        
    }
}