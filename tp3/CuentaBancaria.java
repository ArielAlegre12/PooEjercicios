/**
 * Representa una cuenta bancaria con número de cuenta, saldo y titular.
 * Permite realizar depósitos, extracciones y mostrar información asociada.
 */
public class CuentaBancaria{
    private int nroCuenta;
    private double saldo;
    Persona titular;
    
    /**
     * Constructor que inicializa la cuenta con número y titular.
     * El saldo se inicializa en 0.
     *
     * @param p_nroCuenta Número de cuenta
     * @param p_titular Persona titular de la cuenta
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
    }
    /**
     * Constructor que inicializa la cuenta con número, titular y saldo.
     *
     * @param p_nroCuenta Número de cuenta
     * @param p_titular Persona titular de la cuenta
     * @param p_saldo Saldo inicial
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }
    /**
     * Asigna el número de cuenta.
     *
     * @param p_nroCuenta Número de cuenta
     */
    private void setNroCuenta (int p_nroCuenta){
        this.nroCuenta = p_nroCuenta;
    }
    /**
     * Asigna el titular de la cuenta.
     *
     * @param p_titular Persona titular
     */
    private void setTitular(Persona p_titular){
        this.titular = p_titular;
    }
    /**
     * Asigna el saldo de la cuenta.
     *
     * @param p_saldo Monto a asignar como saldo
     */
    private void setSaldo(double p_saldo){
        this.saldo = p_saldo;
    }
    /**
     * Devuelve el número de cuenta.
     *
     * @return Número de cuenta
     */
    public int getNroCuenta(){
        return this.nroCuenta;
    }
    /**
     * Devuelve el titular de la cuenta.
     *
     * @return Persona titular
     */
    public Persona getTitular(){
        return this.titular;
    }
    /**
     * Devuelve el saldo actual de la cuenta.
     *
     * @return Saldo disponible
     */
    public double getSaldo(){
        return this.saldo;
    }
    /**
     * Realiza un depósito en la cuenta.
     * Si el importe es negativo, la operación se cancela.
     *
     * @param p_importe Monto a depositar
     * @return Saldo resultante luego del depósito
     */
    public double depositar(double p_importe){
        if(p_importe >= 0){
            p_importe +=  this.getSaldo();
            this.setSaldo(p_importe);
            return this.getSaldo();
        }else{
            return this.getSaldo();
        }
    }
    /**
     * Realiza una extracción del saldo.
     * Si el importe supera el saldo disponible, la operación se cancela.
     *
     * @param p_importe Monto a extraer
     * @return Saldo resultante luego de la extracción
     */
    public double extraer(double p_importe){
        if(p_importe <= this.getSaldo()){
            p_importe = this.getSaldo() - p_importe;
            this.setSaldo(p_importe);
            return this.getSaldo();   
        }else{
            return this.getSaldo(); 
        }
    }
    /**
     * Método que permite mostrar los datos del titular
     */
    public void mostrar(){
        System.out.println("-Cuenta Bancaria-");
        System.out.println("Titular: " + this.getTitular().nomYape() + "(" + this.getTitular().edad() + " Años)");
        System.out.println("Saldo: " + this.getSaldo());
        
    }
    /**
     * Devuelve una cadena con los datos tabulados de la cuenta:
     * número de cuenta, nombre del titular y saldo.
     *
     * @return Cadena con los datos de la cuenta
     */
    public String toStrinf(){
        return this.getNroCuenta() + " " + this.getTitular().nomYape() + " " + this.getSaldo();
    }
}