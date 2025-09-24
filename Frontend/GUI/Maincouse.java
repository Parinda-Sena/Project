package GUI;
import java.awt.*;
import javax.swing.*;

public class Maincouse {
    public Maincouse(){
        JFrame Maincouse = new JFrame("Meow Ordering");
        // Signin.setLocationRelativeTo(null);
        Maincouse.setLayout(null);
        Maincouse.setSize(400, 700);
        Maincouse.setIconImage(new ImageIcon("Logo.png").getImage());
        Maincouse.getContentPane().setBackground(new Color(255, 255, 204));

        
        
        Maincouse.setVisible(true);
        Maincouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}