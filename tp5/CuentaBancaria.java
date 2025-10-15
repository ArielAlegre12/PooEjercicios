/**
 * Cuenta bancaria que representa el manejo de una.
 */
public abstract class CuentaBancaria{
    private int nroCuenta;
    private double saldo;
    private Persona titular;
    
    /**
     * Constructor que incializa al titular sin saldo.
     * @param p_nroCuenta numero de la cuenta del titular.r.
     * qparam p_titular Objeto Persona que contiene al titular.
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular){
        setNrocuenta(p_nroCuenta);
        setTitular(p_titular);
        setSaldo(0.0);
    }
    
    /**
     * Constructor que inicaliza al titular con saldo
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_importe){
        setNrocuenta(p_nroCuenta);
        setTitular(p_titular);
        setSaldo(p_importe);
    }
    
    /**
     * setters y getters.
     */
    private void setNrocuenta(int p_nroCuenta){this.nroCuenta = p_nroCuenta;}
    protected void setSaldo(double p_importe){this.saldo = p_importe;}
    private void setTitular(Persona p_titular){this.titular = p_titular;}
    
    public int getNroCuenta(){return this.nroCuenta;}
    public double getSaldo(){return this.saldo;}
    public Persona getTitular(){return this.titular;}
    
    /**
     * Defino los métodos abstractos, en este caso seran lo de extraer, puedeExtraer y xQNoPuedeextraer
     * ya que trabajan distnto dependiendo de la cuenta en la que estén.
     */
    public abstract boolean extraer(double p_importe);
    public abstract boolean puedeExtraer(double p_importe);
    public abstract String xQNoPuedeExtraer(double p_importe);
    
    /**
     * método para depositar.
     */
    public double depositar(double p_importe){
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }
    
    /**
     * método para mostrar los datos del titular.
     */
    public void mostrar(){
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYape());
    }
}