/**
 * Representa una cuenta corriente bancaria, con saldo, titular y límite de descubierto.
 * Permite realizar depósitos y controlar extracciones según el saldo disponible.
 */
public class CuentaCorriente{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;
    private Persona titular;
    
    /**
     * Constructor que inicializa la cuenta con número y titular.
     * El saldo se establece en cero.
     * @param p_nroCuenta Número identificador de la cuenta.
     * @param p_titular Persona titular de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.saldo = 0;
        this.limiteDescubierto = 500.0;
    }
    /**
     * Constructor que inicializa la cuenta con número, titular y saldo inicial.
     * @param p_nroCuenta Número identificador de la cuenta.
     * @param p_titular Persona titular de la cuenta.
     * @param p_saldo Saldo inicial de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.limiteDescubierto = 500.0;
    }
    /**
     * Establece el número de cuenta.
     * @param p_nroCuenta Número identificador.
     */
    private void setNroCuenta(int p_nroCuenta){
        nroCuenta = p_nroCuenta;
    }
    /**
     * Establece el titular de la cuenta.
     * @param p_titular Persona dueña de la cuenta
     */
    private void setTitular(Persona p_titular){
        titular = p_titular;
    }
    /**
     * Establece el saldo de la cuenta.
     * @param p_saldo saldo actual de la cuenta
     */
    private void setSaldo(double p_saldo){
        saldo = p_saldo;
    }
    /**
     * Establece el limite de descubierto de la cuenta
     * @param p_limite es el permitido para retirar si la cuenta no posee el saldo suficiente
     */
    private void setLimiteDescubierto(double p_limite){
        limiteDescubierto = p_limite;
    }
     /**
      * Devuelve el número de cuenta.
      * @return el número de cuenta del usuario.
      */
    public int getNroCuenta(){
        return nroCuenta;
    }
    /**
     * Devuelve el titular de la cuenta.
     * @return Objeto Persona que representa al titular.
     */
    public Persona getTitular(){
        return titular;
    }
    /**
     * Devuelve el saldo actual de la cuenta.
     * @return Saldo disponible.
     */
    public double getSaldo(){
        return saldo;
    }
    /**
     * Devuelve el límite de descubierto permitido.
     * @return Monto máximo permitido en negativo.
     */
    public double getLimiteDescubierto(){
        return limiteDescubierto;
    }
   /**
    * Realiza un depósito en la cuenta, sumando el importe al saldo actual.
    * @param p_importe Monto a depositar.
    */
    public void depositar(double p_importe){
        p_importe += getSaldo();
        setSaldo(p_importe);
    }
    /**
     * método que decide si puede o no retirar dinero 
     * @return true o fasle
     */
    private boolean puedeExtraer(double p_importe){
        if(p_importe <= getSaldo() + getLimiteDescubierto()){
            return true;
        }else{
            return false;
        }
    }
    /**
     * método que actua dependiendo si se puede o no retirar el dinero
     * @param p_importe monto que desea extraer
     */
    public void extraer(double p_importe){
        if(puedeExtraer(p_importe)){
            extraccion(p_importe);
        }else{
            System.out.println("El importe de extraccion sobrepasa el límite de descubierto");
        }
    }
    /**
     * genera la extracción del dinero dependiendo si tiene saldo en la cuenta o si todavia no supero el limite de descubierto.
     * primeramente se verifica el ingreso de un número negativo, de ser así sale del método.
     * asignamos los valores a unas var temporales para trabajar con ellas.
     * si el importe es menor o igual al saldo de la cuenta, se retira directamente de allí.
     * de no ser así, se guarda el excedente para así descontarlo al limite de descubierto.
     */
    private void extraccion(double p_importe){
        if(p_importe <= 0)return;
        double saldoActual = getSaldo();
        double descubiertoActual = getLimiteDescubierto();
        
        if(p_importe <= saldoActual){
            setSaldo(saldoActual - p_importe);
        }else{
            double excedente = p_importe - saldoActual;
            setSaldo(0);
            setLimiteDescubierto(descubiertoActual - excedente);
        }
    }
    /**
     * visualiza los datos de la cuenta
     */
    public void mostrar(){
        System.out.println("-   Cuenta Corriente –");
        System.out.println("Nro. Cuenta: " + getNroCuenta() + " -  Saldo: " + getSaldo());
        System.out.println("Titular: " + getTitular().nomYape());
        System.out.println("Descubierto: " + getLimiteDescubierto());
    }   
}