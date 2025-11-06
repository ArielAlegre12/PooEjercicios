import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
public class Ventana extends JFrame implements ActionListener{
    // Se define el panel como variable de la clase (y no local de un método) para poder acceder a él          
    // desde cualquier método de la clase (por ej., en el actionPerformed)
    JPanel miPanel = new JPanel();
    private JButton bAzul;
    private JButton bRosa;
    private JButton bAmarillo;
    private JButton bVerde;
    
    public Ventana(){
        this.setTitle("Ventana de Prueba.");
        this.setSize(500,400);
        this.addWindowListener(new ManejadorConInterfaz());
        miPanel.setLayout(new BorderLayout());
        Container miPanelContenedor = this.getContentPane();
        miPanelContenedor.add(miPanel);
        miPanel.setBackground(Color.red);
        
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 100;
        
        //se incializa la variable azul
        bAzul = new JButton("Azul");
        //Se indica la ventana como gestor de los eventos del botón azul.
        bAzul.addActionListener(this);
        bAzul.setPreferredSize(d);
        
        //se inidializa la variable verde
        bVerde = new JButton("Verde");
        bVerde.addActionListener(this);
        bVerde.setPreferredSize(d);
        
        //se inicializa la variable amarilla
        bAmarillo = new JButton("Amarillo");
        bAmarillo.addActionListener(this);
        bAmarillo.setPreferredSize(d);
        
        //se inicializa la variable rosa
        bRosa = new JButton("Rosa");
        bRosa.addActionListener(this);
        bRosa.setPreferredSize(d);
        
        //se añaden los cuatros botones en el norte, sur, este y oeste del panel.
        miPanel.add(bAzul, BorderLayout.NORTH);
        miPanel.add(bVerde, BorderLayout.SOUTH);
        miPanel.add(bAmarillo, BorderLayout.EAST);
        miPanel.add(bRosa, BorderLayout.WEST);
    }
    
    public void actionPerformed(ActionEvent e){
        //se utiliza informacion encapsulado en el evento de tipo ActionEvent para saber
        // que boton se pulsó. Es decir la referencia al botón que se pulsó.
        Object fuente = e.getSource();
        
        //si la referencia es igual a la puntero que apunta
        if(fuente == bAzul){
            miPanel.setBackground(Color.blue);
        }
        if(fuente == bVerde){
            miPanel.setBackground(Color.green);
        }
        if(fuente == bAmarillo){
            miPanel.setBackground(Color.yellow);
        }
        if(fuente == bRosa){
            miPanel.setBackground(Color.pink);
        }
    }
}