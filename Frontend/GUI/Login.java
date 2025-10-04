package GUI;
import java.awt.*;
import javax.swing.*;

public class Login 
{
	public Login()
	{
		JFrame Login = new JFrame("Meow Ordering");
		//Login.setLocationRelativeTo(null);
		Login.setLayout(null);
		Login.setSize(400, 700);
		Login.setIconImage(new ImageIcon("C:\\Users\\sutti\\OneDrive\\Desktop\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
		Login.getContentPane().setBackground(new Color(255,255,204));;

		ImageIcon icon = new ImageIcon("C:\\Users\\sutti\\OneDrive\\Desktop\\Frontend\\Photo\\Logo\\LogoLoginSignin.png");
		Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(img));
		label.setBounds(39, 0, 300, 300);
		Login.add(label);

		JLabel log = new JLabel("Login");
		log.setBounds(140, 180, 200, 200);
		log.setFont(new Font("Arial", Font.BOLD, 36));
		Login.add(log);

		JTextField name = new JTextField();
		name.setBounds(150, 350, 150, 25);
		Login.add(name);
		JLabel n = new JLabel("Name : ");
		Login.add(n);
		n.setBounds(50, 350, 80, 25);

		JPasswordField password = new JPasswordField();
		password.setBounds(150, 400, 150, 25);
		Login.add(password);
		JLabel p = new JLabel("Password : ");
		Login.add(p);
		p.setBounds(50, 400, 80, 25);

		JButton b = new JButton("Login");
		b.setBounds(130, 450, 100, 30);
		Login.add(b);

		Login.setVisible(true);
		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
