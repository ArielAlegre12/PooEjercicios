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
        setNroCuenta(p_nroCuenta);
        setTitular(p_titular);
    }
    /**
     * Constructor que inicializa la cuenta con número, titular y saldo.
     *
     * @param p_nroCuenta Número de cuenta
     * @param p_titular Persona titular de la cuenta
     * @param p_saldo Saldo inicial
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo){
        setNroCuenta(p_nroCuenta);
        setTitular(p_titular);
        setSaldo(p_saldo);
    }
    /**
     * Asigna el número de cuenta.
     *
     * @param p_nroCuenta Número de cuenta
     */
    private void setNroCuenta (int p_nroCuenta){
        nroCuenta = p_nroCuenta;
    }
    /**
     * Asigna el titular de la cuenta.
     *
     * @param p_titular Persona titular
     */
    private void setTitular(Persona p_titular){
        titular = p_titular;
    }
    /**
     * Asigna el saldo de la cuenta.
     *
     * @param p_saldo Monto a asignar como saldo
     */
    private void setSaldo(double p_saldo){
        saldo = p_saldo;
    }
    /**
     * Devuelve el número de cuenta.
     *
     * @return Número de cuenta
     */
    public int getNroCuenta(){
        return nroCuenta;
    }
    /**
     * Devuelve el titular de la cuenta.
     *
     * @return Persona titular
     */
    public Persona getTitular(){
        return titular;
    }
    /**
     * Devuelve el saldo actual de la cuenta.
     *
     * @return Saldo disponible
     */
    public double getSaldo(){
        return saldo;
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
            p_importe +=  getSaldo();
            setSaldo(p_importe);
            return getSaldo();
        }else{
            return getSaldo();
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
     * Devuelve una cadena con los datos tabulados de la cuenta:
     * número de cuenta, nombre del titular y saldo.
     *
     * @return Cadena con los datos de la cuenta
     */
    public String toStrinf(){
        return getNroCuenta() + " " + getTitular().nomYape() + " " + getSaldo();
    }
}