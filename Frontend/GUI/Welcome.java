package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome {
    public Welcome(){

        JFrame Welcome = new JFrame("Meow Ordering");
        Welcome.setLayout(null);
        Welcome.setSize(400, 700);
        Welcome.setIconImage(new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
        Welcome.getContentPane().setBackground(new Color(255, 255, 204));
        Welcome.setLocationRelativeTo(null);
        Welcome.setResizable(false);
        

        ImageIcon icon = new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoWelcome.png");
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(41, 10, 300, 300);
        Welcome.add(label);
        
        JLabel welcome = new JLabel("Welcome");
        welcome.setBounds(120, 200, 200, 200);
        welcome.setFont(new Font("Arial", Font.BOLD, 36));
        Welcome.add(welcome);


        JButton Login = new JButton("Login");
        Login.setBounds(95, 375, 200, 50);
        Welcome.add(Login);

        JButton Signin = new JButton("Sign Up");
        Signin.setBounds(95, 450, 200, 50);
        Welcome.add(Signin);

        // กดแล้วไปหน้า Login
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เปิดหน้า CartUI
                new Login();
                Welcome.dispose();
            }
        });

        // กดแล้วไปหน้า Signin
        Signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เปิดหน้า CartUI
                new Signin();
                Welcome.dispose();

            }
        });

        Welcome.setVisible(true);
        Welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
