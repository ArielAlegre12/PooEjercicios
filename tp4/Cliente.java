/**
 * Una clase Cliente el cual representa la cuenta de una persona.
 * <p>
 * Aquí se puede actualizar, modificar o visualizar el saldo a traves
 * de los distintos métodos.
 * @author Alegre Ariel, Agustín Antoniow
 * @version 1.0
 */
public class Cliente{
    private int nroDni;
    private String apellido;
    private String nombre;
    private double saldo;
    /**
     * Constructor de Cliente :)
     * @param nroDni (del cliente).
     * @param apellido (del cliente).
     * @param nombre (del cliente).
     * @param p_importe importe inicial del saldo del cliente.
     */
    public Cliente(int p_nroDni, String p_apellido, String p_nombre, Double p_importe){
        setNroDni(p_nroDni);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSaldo(p_importe);
    }
    private void setNroDni(int p_nroDni){
        nroDni = p_nroDni;
    }
    private void setApellido(String p_apellido){
        apellido = p_apellido;
    }
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    private void setSaldo(double p_importe){
        saldo = p_importe;
    }
    public int getNroDni(){
        return nroDni;
    }
    public String getApellido(){
        return apellido;
    }
    public String getNombre(){
        return nombre;
    }
    public double getSaldo(){
        return saldo;
    }
    
    //método para visualizar datos del cliente
    public void mostrar(){
        System.out.println("Nombre y apellido: " + nomYape() + "(" + getNroDni() + ")");
        System.out.println("Saldo: $" + getSaldo());
    }
    //método para obtener el apellido y nombre
    public String apeYnom(){
        return getApellido() + ", " + getNombre();
    }
    //método para obtener el nombre y apellido
    public String nomYape(){
        return getNombre() + " " + getApellido();
    }
    /**
     * Remplaza el saldo actual por el importe y devuelve el nuevo saldo
     * @param p_importe (el importe ingresado)
     * @return saldo actualizado
     */
    public double nuevoSaldo(double p_importe){
        setSaldo(p_importe);
        return getSaldo();
    }
    /**
     * Agrega el saldo, luego devuelve la actualización.
     */
    public double agregaSaldo(double p_importe){
        double nuevoSaldo = p_importe + getSaldo();
        setSaldo(nuevoSaldo);
        return getSaldo();
    }
}