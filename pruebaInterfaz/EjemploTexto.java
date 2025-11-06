import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class EjemploTexto extends JFrame{
    JTextField campo1, campo2;
    
    public EjemploTexto(){
        Container miContenedor = this.getContentPane();
        miContenedor.setLayout(new BoxLayout(miContenedor, BoxLayout.Y_AXIS));
        campo1 = new JTextField("Ingrese el texto y presione enter", 20);
        campo1.addActionListener(new TextFieldListener());
        //asigna un borde color negro.
        campo1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        campo2 = new JTextField(20);
        //asigna un borde color azul
        campo2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JButton miBoton = new JButton("Limbiar");
        
        //Agrega un "oyente" a la acción de este botón
        miBoton.addActionListener(new ButtonListener());
        miContenedor.add(campo1); //agrega campo 1
        miContenedor.add(campo2); //agrega campo 2
        miContenedor.add(Box.createVerticalGlue());
        miContenedor.add(miBoton);
    }
    
    //Clase oyente Campo de Texto
    class TextFieldListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            campo2.setText(e.getActionCommand());
        }
    }
    //Clase oyente del botón
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //limpia los campos de texto
            campo1.setText("");
            campo1.requestFocus(); //toma el foco
            campo2.setText("");
        }
    }
}