/**
 * Clase circulo, el cual representa uno estableciendo su radio y el centro.
 * esta clase es una herencia de la clase elipse, se utiliza la generalización
 * @Author Alegre Ariel, Antoniow Agustín.
 * 
 */
public class Circulo extends Elipse{
    
    /**
     * Constructor que incializa con todos los datos de un circulo
     * manda atraves de la seudovariable super los parametros para inicializarlas.
     * @param p_radio radio del circulo.
     * @param p_centro centro del radio.
     */
    public Circulo(double p_radio, Punto p_centro){
        super(p_radio, p_radio, p_centro);
    }
    
    /**
     * método que muestra el nombre de la figura.
     */
    public String nombreFigura(){
        return super.nombreFigura();
    }
}
