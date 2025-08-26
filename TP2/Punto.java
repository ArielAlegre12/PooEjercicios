/**
 * La clase {@code Punto} representa un punto en el plano cartesiano,
 * definido por sus coordenadas {@code x} e {@code y}.
 * <p>
 * Esta clase permite crear puntos, obtener sus coordenadas, desplazarlos
 * y mostrar su ubicación. Es útil como base para trabajar con figuras geométricas.
 * </p>
 */
public class Punto{
    private double x;
    private double y;
    
    /**
     * Constructor por defecto.
     * Inicializa el punto en el origen (0,0).
     */
    public Punto(){
        x = 0;
        y = 0;
    }
    
    /**
     * Constructor parametrizado.
     * Inicializa el punto con las coordenadas dadas.
     *
     * @param p_x coordenada X del punto
     * @param p_y coordenada Y del punto
     */
    public Punto(double p_x, double p_y){
        setX(p_x);
        setY(p_y);
    }
    
    /**
     * Establece la coordenada X del punto.
     *
     * @param p_x nuevo valor para X
     */
    private void setX(double p_x){
        x = p_x;
    }
    
     /**
     * Establece la coordenada Y del punto.
     *
     * @param p_y nuevo valor para Y
     */
    private void setY(double p_y){
        y = p_y;
    }
    
     /**
     * Devuelve la coordenada X del punto.
     *
     * @return valor de X
     */
    public double getX(){
        return x;
    }
    
    /**
     * Devuelve la coordenada Y del punto.
     *
     * @return valor de Y
     */
    public double getY(){
        return y;
    }
    
     /**
     * Desplaza el punto en el plano según los valores dados.
     *
     * @param p_dx desplazamiento en X
     * @param p_dy desplazamiento en Y
     */
    public void desplazar(double p_dx, double p_dy){
        x = x + p_dx;
        y = y + p_dy;
    }
    
    /**
     * Muestra las coordenadas del punto por consola.
     */
    public void mostrar(){
        System.out.println("Punto.X " + getX() + " Y: " + getY());
    }
    
     /**
     * Devuelve una representación textual de las coordenadas del punto.
     *
     * @return cadena con el formato "(x y)"
     */ 
    public String coordenadas(){
        return "(" + getX() + " " + getY() + ")";
    }
}