package GUI;
import java.awt.*;
import javax.swing.*;

public class Signin 
{
    public Signin()
    {
        JFrame Signin = new JFrame("Meow Ordering");
        //Signin.setLocationRelativeTo(null);
        Signin.setLayout(null);
        Signin.setSize(400, 700);
        Signin.setIconImage(new ImageIcon("Logo.png").getImage());
        Signin.getContentPane().setBackground(new Color(255,255,204));

        ImageIcon icon = new ImageIcon("Logo.png");
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img)); 
        label.setBounds(41, 0, 300, 300);
        Signin.add(label);

        JLabel create = new JLabel("Create");
        create.setBounds(130, 120, 200, 200);
        create.setFont(new Font("Arial", Font.BOLD, 36));
        Signin.add(create);
        JLabel account  = new JLabel("new account");
        account.setBounds(80, 130, 300, 300);
        account.setFont(new Font("Arial", Font.BOLD, 36));
        Signin.add(account);

        JTextField name = new JTextField();
        name.setBounds(150, 350, 150, 25);
        Signin.add(name);
        JLabel n = new JLabel("Name : ");
        Signin.add(n);
        n.setBounds(50, 350, 80, 25);

        JTextField phone = new JTextField();
        phone.setBounds(150, 400, 150, 25);
        Signin.add(phone);
        JLabel ph = new JLabel("Phone : ");
        Signin.add(ph);
        ph.setBounds(50, 400, 80, 25);

        JTextField email = new JTextField();
        email.setBounds(150, 450, 150, 25);
        Signin.add(email);
        JLabel e = new JLabel("Email : ");
        e.setBounds(50, 450, 80, 25);
        Signin.add(e);
        

        JPasswordField password = new JPasswordField();
        password.setBounds(150, 500, 150, 25);
        Signin.add(password);
        JLabel p = new JLabel("Password : ");
        p.setBounds(50, 500, 80, 25);
        Signin.add(p);
        
        JPasswordField cpassword = new JPasswordField();
        cpassword.setBounds(150, 550, 150, 25);
        Signin.add(cpassword);
        JLabel cp = new JLabel("Comfirmed Password : ");
        cp.setBounds(10, 550, 150, 25);
        Signin.add(cp);

        JButton b = new JButton("Sign Up");
        b.setBounds(135, 600, 100, 30);
        Signin.add(b);
        
        Signin.setVisible(true);
        Signin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
