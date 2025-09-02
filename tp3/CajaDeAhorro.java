/**
 * La clase {@code CajaDeAhorro} representa una cuenta bancaria que permite realizar depósitos y extracciones
 * con un límite de operaciones. Está asociada a un titular de tipo {@code Persona}, y mantiene control sobre
 * el saldo disponible y la cantidad de extracciones posibles.
 * <p>
 * Se puede instanciar con o sin saldo inicial, y por defecto se permiten hasta 10 extracciones.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class CajaDeAhorro{
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;
    /**
     * Constructor que inicializa la cuenta con número de cuenta y nombre de titular, el saldo incia en 0.
     * @param p_nroCuenta es el num de la cuenta del titular
     * @param p_titular de la cuenta
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.saldo = 0;
        this.extraccionesPosibles = 10;
    }
    /**
     * Constructor que inicializa la cuenta ya con un saldo establecido
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.extraccionesPosibles = 10;
    }
    /**
     * Establece el número de la cuenta
     * @param p_nroCuenta Num identificador.
     */
    private void setNroCuenta(int p_nroCuenta){
        this.nroCuenta = p_nroCuenta;
    }
    /**
     * Establece el títular de la cuenta
     * @param p_titular persona dueña de la cuenta.
     */
    private void setTitular(Persona p_titular){
        this.titular = p_titular;
    }
    /**
     * Establece el saldo de la cuenta
     * @param p_saldo es el que recibe por el usuario
     */
    private void setSaldo(double p_saldo){
        this.saldo =  p_saldo;
    }
    /**
     * establece la cantidad de extracciones que se pueden hacer
     * @param p_extracciones es la cantidad de extracciones posibles
     */
    private void setExtraccionesPosibles(int p_extracciones){
        this.extraccionesPosibles = p_extracciones;
    }
    /**
     * devuelve el nro de cuenta
     * @return la identificación de la cuenta
     */
    public int getNroCuenta(){
        return this.nroCuenta;
    }
    /**
     * devuelve el titular de la cuenta
     * @return a la persona dueña de la cuenta
     */
    public Persona getTitular(){
        return this.titular;
    }
    /**
     * devuelve el saldo de la cuenta
     * @return saldo 
     */
    public double getSaldo(){
        return this.saldo;
    }
    /**
     * devuelve la cantidad de extracciones permitidas
     * @return cantidad de extracciones que se pueden hacer
     */
    public int getExtraccionesPosibles(){
        return this.extraccionesPosibles;    
    }
    /**
     * método que verifica si es posible hacer una extracción.
     * devuelve true o false.
     */
    private boolean puedeExtraer(double p_importe){
        if(p_importe <= this.getSaldo() && this.getExtraccionesPosibles() > 0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * método que analiza si puede extraer o no el dinero, si lo hace luego descuenta la cantidad de extracciones restantes.
     * si no es posible, muestra porque no se pudo realizar la extracción.
     */
    public void extraer(double p_importe){
        if(puedeExtraer(p_importe)){
            extraccion(p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
        }else if(p_importe > this.getSaldo()){
            System.out.println("No puede extraer mas que el saldo!");
        }else{
            System.out.println("No tiene habilitadas mas extracciones!");
        }
    }
    /**
     * método que realiza la extracción.
     */
    private void extraccion(double p_importe){
        p_importe = this.getSaldo() - p_importe;
        this.setSaldo(p_importe);
    }
    /**
     * método que realiza el deposito a la cuenta bancaria del importe recibido.
     */
    public void depositar(double p_importe){
        this.setSaldo(this.getSaldo() + p_importe);
    }
    /**
     * método para visualizar los datos de la caja de ahorro del titular.
     */
    public void mostrar(){
        System.out.println("Caja de Ahorro--");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYape());
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }

}