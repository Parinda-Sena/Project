package GUI;
import java.awt.*;
import javax.swing.*;

public class Welcome {
    public Welcome(){
        /*JFrame Welcome = new JFrame("Meow Ordering");
		//Login.setLocationRelativeTo(null);
		Welcome.setLayout(null);
		Welcome.setSize(400, 700);
        Welcome.setIconImage(new ImageIcon("Logo.png").getImage());
        Welcome.setBackground(new Color(255, 255, 204));
		Container cp = Welcome.getContentPane();*/

        JFrame Welcome = new JFrame("Meow Ordering");
        Welcome.setLayout(null);
        Welcome.setSize(400, 700);
        Welcome.setIconImage(new ImageIcon("Logo.png").getImage());
        Welcome.getContentPane().setBackground(new Color(255, 255, 204));
        Welcome.setLocationRelativeTo(null);
        

        ImageIcon icon = new ImageIcon("Logo.png");
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(41, 0, 300, 300);
        Welcome.add(label);
        
        JLabel welcome = new JLabel("Welcome");
        welcome.setBounds(120, 150, 200, 200);
        welcome.setFont(new Font("Arial", Font.BOLD, 36));
        Welcome.add(welcome);

        JLabel meow = new JLabel("Meow Ordering");
        meow.setBounds(120, 200, 200, 200);
        meow.setFont(new Font("Arial", Font.BOLD, 20));
        Welcome.add(meow);

        JButton Login = new JButton("Login");
        Login.setBounds(95, 375, 200, 50);
        Welcome.add(Login);

        JButton Signin = new JButton("Sign Up");
        Signin.setBounds(95, 450, 200, 50);
        Welcome.add(Signin);

        Welcome.setVisible(true);
        Welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
