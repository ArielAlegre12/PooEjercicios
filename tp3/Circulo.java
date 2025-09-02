/**
 * Clase circulo, el cual representa uno estableciendo su radio y el centro.
 */
public class Circulo{
    private double radio;
    private Punto centro;
    /**
     * Constructor que inicaliza el circulo con un radio y un centro.
     * @param p_radio radio del circulo.
     * @param p_centro centro del circulo de tipo Punto.
     */
    public Circulo(double p_radio, Punto p_centro){
        this.setCentro(p_centro);
        this.setRadio(p_radio);
    }
    /**
     * Constructor el cual inicializa el Circulo en 0.
     */
    public Circulo(){
        this.radio = 0;
        this.centro = new Punto(0, 0);
    }
    /**
     * Métodos setters y getters.
     */
    private void setCentro(Punto p_centro){
        this.centro = p_centro;
    }
    private void setRadio(double p_radio){
        this.radio = p_radio;
    }
    
    public Punto getCentro(){
        return this.centro;
    }
    public double getRadio(){
        return this.radio;
    }
    /**
     * Método el cual desplaza el centro del circulo sin cambiar su radio.
     * @param p_dx valor del eje x a mover.
     * @param p_dy valor del eje y a mover.
     */
    public void desplazar(double p_dx, double p_dy){
        this.getCentro().desplazar(p_dx, p_dy);
    }
    /**
     * Método el cual muestra las caractéristicas del circulo, mostrando los valores
     * del centro, el radio, la superficie y el perímetro.
     */
    public void caracteristicas(){
        System.out.println(" ****** Circulo ****** ");
        System.out.println("Centro: " + this.getCentro().coordenadas() + "  -Radio: " + this.getRadio());
        System.out.println(String.format("Superficie: %.2f -Perímetro: %.2f\n", superficie(), perimetro()));
    }
    /**
     * Método para obtener la superficie del circulo.
     */
    public double superficie(){
        return Math.PI * this.getRadio() * this.getRadio();
    }
    /**
     * Método para obtener el perímetro del circulo.
     */
    public double perimetro(){
        return 2 * Math.PI * this.getRadio();
    }
    /**
     * Conocer la distancia entre circulo, recibe otro objeto de tipo Circulo.
     */
    public double distanciaA(Circulo otroCirculo){
        return this.getCentro().distanciaA(otroCirculo.getCentro());
    }
    /**
 * Compara este círculo con otro y devuelve el que tiene mayor superficie.
 * Si ambos tienen la misma superficie, se devuelve el círculo recibido como parámetro.
 * @param otroCirculo el círculo con el que se desea comparar
 * @return el círculo con mayor superficie
 */

    public Circulo elMayor(Circulo otroCirculo){
        if(this.superficie() > otroCirculo.superficie()){
            return this;
        }else{
            return otroCirculo;
        }
    }
    
    
}