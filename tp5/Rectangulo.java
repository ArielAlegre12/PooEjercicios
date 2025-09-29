/**
 * La clase {@code Rectangulo} representa una figura geométrica rectangular,
 * definida por su origen (esquina inferior izquierda) de tipo {@code Punto},
 * su ancho y su alto.
 * <p>
 * Permite consultar sus características, calcular superficie y perímetro,
 * desplazar su posición, comparar con otros rectángulos y calcular distancias.
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Rectangulo{
    private Punto origen;
    private double ancho;
    private double alto;
    /**
     * Constructor que crea un rectángulo con origen, ancho y alto especificados.
     * 
     * @param p_origen punto de origen del rectángulo
     * @param p_ancho ancho del rectángulo
     * @param p_alto alto del rectángulo
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto){
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    /**
     * Constructor que crea un rectángulo con origen en (0,0) y dimensiones dadas.
     * 
     * @param p_ancho ancho del rectángulo
     * @param p_alto alto del rectángulo
     */
    public Rectangulo(double p_ancho, double p_alto){
        this.setOrigen(new Punto(0,0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }
    //setters
    private void setOrigen(Punto p_origen){
        this.origen = p_origen;
    }
    private void setAncho(double p_ancho){
        this.ancho = p_ancho;
    }
    private void setAlto(double p_alto){
        this.alto = p_alto;
    }
    //getters 
    public Punto getOrigen(){
        return this.origen;
    }
    public double getAncho(){
        return this.ancho;
    }
    public double getAlto(){
        return this.alto;
    }
    /**
     * Desplaza el rectángulo en el plano, modificando su punto de origen.
     * 
     * @param p_dx desplazamiento en X
     * @param p_dy desplazamiento en Y
     */
    public void desplazar(double p_dx, double p_dy){
        this.getOrigen().desplazar(p_dx, p_dy);
    }
    /**
     * Muestra por pantalla las características principales del rectángulo:
     * origen, dimensiones, superficie y perímetro.
     */
    public void caracateristicas(){
        System.out.println("****** Rectangulo ******");
        System.out.println("Orgien: " + this.getOrigen().coordenadas() + " - Alto: "+ this.getAlto() + " - Ancho: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " - Perímetro: " + this.perimetro());
    }
    /**
     * Calcula la superficie del rectángulo.
     * 
     * @return superficie (alto × ancho)
     */
    public double superficie(){
       return this.getAlto() * this.getAncho();
    }
    /**
     * Calcula el perímetro del rectángulo.
     * 
     * @return perímetro (2 × (alto + ancho))
     */
    public double perimetro(){
        return 2 * (this.getAlto() + this.getAncho());
    }
    /**
     * Calcula la distancia entre este rectángulo y otro,
     * medida entre sus puntos de origen.
     * 
     * @param otroRectangulo rectángulo con el que se compara
     * @return distancia entre orígenes
     */
    public double distanciaA(Rectangulo otroRectangulo){
        double distancia = this.getOrigen().distanciaA(otroRectangulo.getOrigen());
        return distancia;
    }
     /**
     * Compara este rectángulo con otro y devuelve el que tiene mayor superficie.
     * 
     * @param otroRectangulo rectángulo con el que se compara
     * @return el rectángulo con mayor superficie
     */

    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if(this.superficie() > otroRectangulo.superficie()){
            return this ;
        }else{
            return otroRectangulo;
        }
    }
    
}