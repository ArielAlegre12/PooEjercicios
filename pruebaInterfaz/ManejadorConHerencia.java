import javax.swing.*;
import java.awt.event.*;

class ManejadorConHerencia extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.out.println("sali");
        System.exit(0);
    }
}