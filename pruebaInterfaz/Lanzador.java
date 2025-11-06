import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Lanzador {
    public static void main(String[] args) {
        EjemploTexto ventana = new EjemploTexto(); // Instanciás tu clase
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierre seguro
        ventana.setVisible(true); // Mostrás la ventana
    }
}
