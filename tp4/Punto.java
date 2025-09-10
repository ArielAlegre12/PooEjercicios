/**
 * La clase {@code Punto} representa un punto en el plano cartesiano,
 * definido por sus coordenadas {@code x} e {@code y}.
 * <p>
 * Esta clase permite crear puntos, obtener sus coordenadas, desplazarlos
 * y mostrar su ubicación. Es útil como base para trabajar con figuras geométricas.
 * 
 * @Author Alegre Ariel, Antoniow Agustín.
 */
public class Punto{
    private double x;
    private double y;
    
    /**
     * Constructor por defecto.
     * Inicializa el punto en el origen (0,0).
     */
    public Punto(){
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Constructor parametrizado.
     * Inicializa el punto con las coordenadas dadas.
     *
     * @param p_x coordenada X del punto
     * @param p_y coordenada Y del punto
     */
    public Punto(double p_x, double p_y){
        this.setX(p_x);
        this.setY(p_y);
    }
    
    /**
     * Establece la coordenada X del punto.
     *
     * @param p_x nuevo valor para X
     */
    private void setX(double p_x){
        this.x = p_x;
    }
    
     /**
     * Establece la coordenada Y del punto.
     *
     * @param p_y nuevo valor para Y
     */
    private void setY(double p_y){
        this.y = p_y;
    }
    
     /**
     * Devuelve la coordenada X del punto.
     *
     * @return valor de X
     */
    public double getX(){
        return this.x;
    }
    
    /**
     * Devuelve la coordenada Y del punto.
     *
     * @return valor de Y
     */
    public double getY(){
        return this.y;
    }
    
     /**
     * Desplaza el punto en el plano según los valores dados.
     *
     * @param p_dx desplazamiento en X
     * @param p_dy desplazamiento en Y
     */
    public void desplazar(double p_dx, double p_dy){
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }
    
    /**
     * Muestra las coordenadas del punto por consola.
     */
    public void mostrar(){
        System.out.println("Punto.X " + this.getX() + " Y: " + this.getY());
    }
    
     /**
     * Devuelve una representación textual de las coordenadas del punto.
     *
     * @return cadena con el formato "(x y)"
     */ 
    public String coordenadas(){
        return "(" + this.getX() + " " + this.getY() + ")";
    }
    
    
    /**
     * Calcula la distancia entre un punto y otro punto dado.
     * 
     * Utiliza la fórmula de Pitágoras para calcular la distancia entre dos puntos
     * en el plano cartesiano: √((x2 - x1)² + (y2 - y1)²).
     * 
     * @param p_ptoDistante el punto al cual se desea calcular la distancia desde este punto
     * @return la distancia entre este punto y el punto recibido como parámetro
     */
    public double distanciaA(Punto p_ptoDistante){
        double dx  = p_ptoDistante.getX() - this.getX();
        double dy = p_ptoDistante.getY() - this.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}