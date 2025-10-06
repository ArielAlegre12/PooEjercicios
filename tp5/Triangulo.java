
/**
 * clase triangulo que hereda algunos metodos de FiguraGeometrica.
 */
public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;
    
    /**
     * Constructor que inicaliza el triangulo con sus valores.
     */
    public Triangulo(double p_base, double p_altura, Punto p_origen){
        super(p_origen);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }
    
    //setters y getters
    private void setBase(double p_base){this.base = p_base;}
    private void setAltura(double p_altura){this.altura = p_altura;}
    
    public double getBase(){return this.base;}
    public double getAltura(){return this.altura;}
    
    //método que retorna el nombre de la figura
    @Override
    public String nombreFigura(){return "Triángulo";}
    
    //método que devuelve la superficie del triángulo.
    @Override
    public double superficie(){return ((this.getBase() * this.getAltura()) / 2);}
}