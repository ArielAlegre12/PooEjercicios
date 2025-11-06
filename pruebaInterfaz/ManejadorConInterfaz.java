import javax.swing.*; 
import java.awt.event.*; 

class ManejadorConInterfaz implements WindowListener{
    public void windowClosing(WindowEvent e){
        System.out.println("Sali");
        System.exit(0);
    }
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
}