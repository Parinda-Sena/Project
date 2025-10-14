package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Login {
	public Login() {
		JFrame Login = new JFrame("Meow Ordering");
		// Login.setLocationRelativeTo(null);
		Login.setLayout(null);
		Login.setSize(400, 700);
		Login.setIconImage(new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
		Login.getContentPane().setBackground(new Color(255, 255, 204));
		Login.setResizable(false);
		Login.setLocationRelativeTo(null);

		ImageIcon icon = new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoLoginSignin.png");
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

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputName = name.getText().trim();
				String inputPassword = new String(password.getPassword()).trim();
				boolean found = false;

				try (BufferedReader reader = new BufferedReader(new FileReader(".\\FileCSV\\User.csv"))) {
					String line;

					while ((line = reader.readLine()) != null) {
						String[] data = line.split(",");

						if (data.length >= 2) {
							String storedName = data[0].trim();
							String storedPassword = data[3].trim();

							if (inputName.equals(storedName) && inputPassword.equals(storedPassword)) {
								found = true;
								break;
							}
						}
					}
					if (inputName.equals("admin") && inputPassword.equals("123")) {
						JOptionPane.showMessageDialog(Login, "Login successful!", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						new AdminUI();
						Login.dispose();
					}
					else if (found) {
						JOptionPane.showMessageDialog(Login, "Login successful!", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						String username = inputName;
						new MainMenu(username);
						Login.dispose();
					}

					else {
						JOptionPane.showMessageDialog(Login, "Invalid name or password.", "Login Failed",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(Login, "Unable to read user data: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		Login.setVisible(true);
		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
