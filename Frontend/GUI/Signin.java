package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Signin {
    public Signin() {
        JFrame Signin = new JFrame("Meow Ordering");
        Signin.setLayout(null);
        Signin.setResizable(false);
        Signin.setSize(400, 700);
        Signin.setIconImage(new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
        Signin.getContentPane().setBackground(new Color(255, 255, 204));
        Signin.setLocationRelativeTo(null);

        // โลโก้
        ImageIcon icon = new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoLoginSignin.png");
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(41, 0, 300, 300);
        Signin.add(label);

        // Label หัวข้อ
        JLabel create = new JLabel("Create");
        create.setBounds(130, 145, 200, 200);
        create.setFont(new Font("Arial", Font.BOLD, 36));
        Signin.add(create);
        JLabel account = new JLabel("new account");
        account.setBounds(80, 150, 300, 300);
        account.setFont(new Font("Arial", Font.BOLD, 36));
        Signin.add(account);

        // ช่องกรอกข้อมูล
        JTextField name = new JTextField();
        name.setBounds(150, 350, 150, 25);
        Signin.add(name);
        JLabel n = new JLabel("Name : ");
        n.setBounds(50, 350, 80, 25);
        Signin.add(n);

        JTextField phone = new JTextField();
        phone.setBounds(150, 400, 150, 25);
        Signin.add(phone);
        JLabel ph = new JLabel("Phone : ");
        ph.setBounds(50, 400, 80, 25);
        Signin.add(ph);

        JTextField email = new JTextField();
        email.setBounds(150, 450, 150, 25);
        Signin.add(email);
        JLabel e = new JLabel("Email : ");
        e.setBounds(50, 450, 80, 25);
        Signin.add(e);

        // ใช้ JPasswordField เพื่อความปลอดภัย
        JPasswordField password = new JPasswordField();
        password.setBounds(150, 500, 150, 25);
        Signin.add(password);
        JLabel p = new JLabel("Password : ");
        p.setBounds(50, 500, 80, 25);
        Signin.add(p);

        JPasswordField cpassword = new JPasswordField();
        cpassword.setBounds(150, 550, 150, 25);
        Signin.add(cpassword);
        JLabel cp = new JLabel("Confirmed Password : ");
        cp.setBounds(10, 550, 150, 25);
        Signin.add(cp);

        // ปุ่ม Sign Up
        JButton b = new JButton("Sign Up");
        b.setBounds(135, 600, 100, 30);
        Signin.add(b);

        Signin.setVisible(true);
        Signin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // เมื่อกดปุ่ม Sign Up
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText().trim();
                String phoneText = phone.getText().trim();
                String emailText = email.getText().trim();
                String passwordText = new String(password.getPassword());
                String confirmedText = new String(cpassword.getPassword());

                // ตรวจสอบช่องว่าง
                if (nameText.isEmpty() || phoneText.isEmpty() || emailText.isEmpty()
                        || passwordText.isEmpty() || confirmedText.isEmpty()) {
                    JOptionPane.showMessageDialog(Signin, "Please complete the filed", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // ตรวจสอบรหัสผ่านตรงกัน
                if (!passwordText.equals(confirmedText)) {
                    JOptionPane.showMessageDialog(Signin, "Password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // เขียนไฟล์แบบ append ไม่ลบข้อมูลเก่าออก
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(".\\FileCSV\\User.csv", true))) {
                    writer.write(nameText + "," + phoneText + "," + emailText + "," + passwordText);
                    writer.newLine();

                    JOptionPane.showMessageDialog(Signin, "Success", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    Signin.dispose();
                    new MainMenu();

                    // เคลียร์ช่อง
                    name.setText("");
                    phone.setText("");
                    email.setText("");
                    password.setText("");
                    cpassword.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Signin, "Unable to write to file", "File Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
