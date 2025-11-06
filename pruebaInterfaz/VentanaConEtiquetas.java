import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * ventana con etiquetas, prueba.
 */
public class VentanaConEtiquetas extends JFrame{
    public VentanaConEtiquetas(){
        this.setTitle("Etiquetas");
        this.setSize(300,150);
        this.addWindowListener(new ManejadorConInterfaz());
        JPanel miPanel = new JPanel();
        miPanel.setLayout(new GridLayout(2,2));
        Container miPanelContenedor = this.getContentPane();
        miPanelContenedor.add(miPanel);
        //se crea una etiqueta, y con el setText se le asigna un texto.
        JLabel etique1 = new JLabel();
        etique1.setText("Etiqueta 1");
        miPanel.add(etique1);
        //Se crea una etiqueta, y en el constructor se le pasa un texto.
        //Con su método setFont se cambia la fuente.
        JLabel etique2 = new JLabel("Etiqueta 2");
        etique2.setFont(new Font("Helvetica", Font.BOLD, 18));
        miPanel.add(etique2);

    }
}
