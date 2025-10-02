/**
 * Representa una cuenta corriente bancaria, con saldo, titular y límite de descubierto.
 * Permite realizar depósitos y controlar extracciones según el saldo disponible.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class CuentaCorriente extends CuentaBancaria{
    private double limiteDescubierto;
    
    /**
     * Constructor que inicializa la cuenta con número y titular.
     * El saldo se establece en cero.
     * @param p_nroCuenta Número identificador de la cuenta.
     * @param p_titular Persona titular de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular){
        super(p_nroCuenta, p_titular);
        this.setLimiteDescubierto(500.0);
    }
    /**
     * Constructor que inicializa la cuenta con número, titular y saldo inicial.
     * @param p_nroCuenta Número identificador de la cuenta.
     * @param p_titular Persona titular de la cuenta.
     * @param p_saldo Saldo inicial de la cuenta.
     */
    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo){
        super(p_nroCuenta, p_titular, p_saldo);
        this.setLimiteDescubierto(500.0);
    }
    
    /**
     * Establece el limite de descubierto de la cuenta
     * @param p_limite es el permitido para retirar si la cuenta no posee el saldo suficiente
     */
    private void setLimiteDescubierto(double p_limite){this.limiteDescubierto = p_limite;}
    
    /**
     * Devuelve el límite de descubierto permitido.
     * @return Monto máximo permitido en negativo.
     */
    public double getLimiteDescubierto(){return this.limiteDescubierto;}
    
    /**
     * método que decide si puede o no retirar dinero 
     * @return true o fasle
     */
    @Override
    public boolean puedeExtraer(double p_importe){
        if(p_importe <= this.getSaldo() + this.getLimiteDescubierto()){
            return true;
        }else{
            return false;
        }
    }
    
    private void extraccion(double p_importe){
        if(p_importe <= 0)return;
        double saldoActual = this.getSaldo();
        double descubiertoActual = this.getLimiteDescubierto();
        
        if(p_importe <= saldoActual){
            super.actualizarSaldo(saldoActual - p_importe);
        }else{
            double excedente = p_importe - saldoActual;
            super.actualizarSaldo(0);
            this.setLimiteDescubierto(descubiertoActual - excedente);
        }
    }
    
    /**
     * método que actua dependiendo si se puede o no retirar el dinero
     * @param p_importe monto que desea extraer
     */
    @Override
    public boolean extraer(double p_importe){
        if(this.puedeExtraer(p_importe)){
            this.extraccion(p_importe);
            return true;
        }else{
            System.out.println(xQNoPuedeExtraer(p_importe));
            return false;
        }
    }
    
    /**
     * visualiza los datos de la cuenta
     */
    @Override
    public void mostrar(){
        System.out.println("-   Cuenta Corriente –");
        super.mostrar();
        System.out.println("Descubierto: " + this.getLimiteDescubierto());
    }  
    
    /**
     * Desarrollo el método que explica porque no puede extraer.
     */
    @Override
    public String xQNoPuedeExtraer(double p_importe){
        return "No puede Extraer porque supera el limite descubierto!.";
    }
}