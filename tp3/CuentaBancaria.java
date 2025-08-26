/**
 * 
 */
public class CuentaBancaria{
    private int nroCuenta;
    private double saldo;
    Persona titular;
    
    /**
     * Constructor 1
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular){
        setNroCuenta(p_nroCuenta);
        setTitular(p_titular);
    }
    /**
     * Constructor 2
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo){
        setNroCuenta(p_nroCuenta);
        setTitular(p_titular);
        setSaldo(p_saldo);
    }
    /**
     * Defino los setters
     */
    private void setNroCuenta (int p_nroCuenta){
        nroCuenta = p_nroCuenta;
    }
    private void setTitular(Persona p_titular){
        titular = p_titular;
    }
    private void setSaldo(double p_saldo){
        saldo = p_saldo;
    }
    /**
     * Defino los getters
     */
    public int getNroCuenta(){
        return nroCuenta;
    }
    public Persona getTitular(){
        return titular;
    }
    public double getSaldo(){
        return saldo;
    }
    /**
     * Método que permite hacer un deposito, si el importe es menor a 0 se cancela
     * y devuelve el saldo actual.
     */
    public double depositar(double p_importe){
        if(p_importe >= 0){
            p_importe +=  getSaldo();
            setSaldo(p_importe);
            return getSaldo();
        }else{
            return getSaldo();
        }
    }
    /**
     * Método para extrar el sueldo, disminuyendo asi el monto actual
     * si el monto es superior al de la cuenta, se cancela la extraccón
     * y devuelve saldo actual
     */
    public double extraer(double p_importe){
        if(p_importe <= getSaldo()){
            p_importe = getSaldo() - p_importe;
            setSaldo(p_importe);
            return getSaldo();   
        }else{
            return getSaldo(); 
        }
    }
    /**
     * Método que permite mostrar los datos del titular
     */
    public void mostrar(){
        System.out.println("-Cuenta Bancaria-");
        System.out.println("Titular: " + getTitular().nomYape() + "(" + getTitular().edad() + " Años)");
        System.out.println("Saldo: " + getSaldo());
        
    }
    /**
     * Método que devuelve el datos concatenados del titular
     */
    public String toStrinf(){
        return getNroCuenta() + " " + getTitular().nomYape() + " " + getSaldo();
    }
}