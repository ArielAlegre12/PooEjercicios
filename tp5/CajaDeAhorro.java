/**
 * La clase {@code CajaDeAhorro} representa una cuenta bancaria que permite realizar depósitos y extracciones
 * con un límite de operaciones. Está asociada a un titular de tipo {@code Persona}, y mantiene control sobre
 * el saldo disponible y la cantidad de extracciones posibles.
 * <p>
 * Se puede instanciar con o sin saldo inicial, y por defecto se permiten hasta 10 extracciones.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class CajaDeAhorro extends CuentaBancaria{
    private int extraccionesPosibles;
    
    /**
     * Constructor que inicializa la cuenta con número de cuenta y nombre de titular, el saldo incia en 0.
     * @param p_nroCuenta es el num de la cuenta del titular
     * @param p_titular de la cuenta
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular){
        super(p_nroCuenta, p_titular);
        this.setExtraccionesPosibles(10);
    }
    /**
     * Constructor que inicializa la cuenta ya con un saldo establecido
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo){
        super(p_nroCuenta, p_titular, p_saldo);
        this.setExtraccionesPosibles(10);
    }
    
    private void setExtraccionesPosibles(int p_extraccionesPosibles){this.extraccionesPosibles = p_extraccionesPosibles;}
    
    /**
     * devuelve la cantidad de extracciones permitidas
     * @return cantidad de extracciones que se pueden hacer
     */
    public int getExtraccionesPosibles(){return this.extraccionesPosibles;}
    
    /**
     * método que verifica si es posible hacer una extracción.
     * devuelve true o false.
     */
    public boolean puedeExtraer(double p_importe){
        if(p_importe <= this.getSaldo() && this.getExtraccionesPosibles() > 0){
            return true;
        }else if(p_importe > this.getSaldo()){
            System.out.println("No puede extraer mas que el saldo!");
            return false;
        }else{
            System.out.println("No tiene habilitadas mas extracciones!");
            return false;
        }
    }
    /**
     * método que analiza si puede extraer o no el dinero, si lo hace luego descuenta la cantidad de extracciones restantes.
     * si no es posible, muestra porque no se pudo realizar la extracción.
     */
    public boolean extraer(double p_importe){
        if(puedeExtraer(p_importe)){
            super.actualizarSaldo(p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * método para saber porque no se puede realizar más extracciones.
     */
    
    public String xQNoPuedeExtraer(double p_importe){
        if(this.getExtraccionesPosibles() == 0){
            return "Se realizo todas las extracciones posibles";
        }else{
            return "El monto supera el saldo!.";
        }
    }
    
    /**
     * método para visualizar los datos de la caja de ahorro del titular.
     */
    
    public void mostrar(){
        System.out.println("Caja de Ahorro--");
        super.mostrar();
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }

}