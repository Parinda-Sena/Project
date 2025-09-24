package GUI;

import java.awt.*;
import javax.swing.*;

public class MainMenu {
    public MainMenu() {
        JFrame mainmenu = new JFrame("Meow Ordering");
        //mainmenu.setLocationRelativeTo(null);
        mainmenu.setLayout(null);
        mainmenu.setSize(400, 700);
        mainmenu.setIconImage(new ImageIcon("Logo.png").getImage());
        mainmenu.getContentPane().setBackground(new Color(255, 255, 204));
        

        ImageIcon usericon = new ImageIcon("User.png");
        Image img = usericon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(-118, -100, 300, 300);
        mainmenu.add(label);

        JLabel n = new JLabel("Name");
        mainmenu.add(n);
        n.setBounds(60, 28, 80, 25);
        n.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel a = new JLabel("Address");
        mainmenu.add(a);
        a.setFont(new Font("Arial", Font.PLAIN, 12));
        a.setBounds(60, 48, 80, 25);

        // ไอคอนแจ้งเตือน
        ImageIcon notiicon = new ImageIcon("Notification.png");
        Image img2 = notiicon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel label2 = new JLabel(new ImageIcon(img2));
        label2.setBounds(200, -99, 300, 300);
        mainmenu.add(label2);

        JLabel search = new JLabel("What food do you want?");
        mainmenu.add(search);
        search.setBounds(20, -150, 500, 500);
        search.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField s = new JTextField(100);
        s.setForeground(Color.GRAY);
        s.setBounds(20, 115, 250, 25);
        mainmenu.add(s);
        JButton searchB = new JButton("Search");
        searchB.setBounds(290, 115, 80, 23);
        mainmenu.add(searchB);

        // Appetizier
        JButton Appetizier = new JButton();
        Appetizier.setBounds(30, 160, 55, 55);
        ImageIcon appeicon = new ImageIcon("Appetizier.png");
        Image getAppe = appeicon.getImage();
        Image setAppe = getAppe.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Appetizier.setHorizontalAlignment(SwingConstants.CENTER);
        Appetizier.setVerticalAlignment(SwingConstants.CENTER);
        Appetizier.setIcon(new ImageIcon(setAppe));
        JLabel appLabel = new JLabel("Appetizier");
        appLabel.setBounds(26, 80, 300, 300);
        appLabel.setFont(new Font("Arial", Font.BOLD, 13));
        mainmenu.add(appLabel);
        mainmenu.add(Appetizier);

        // Main couse
        JButton Maincouse = new JButton();
        Maincouse.setBounds(120, 160, 55, 55);
        ImageIcon maincouseicon = new ImageIcon("Maincouse.png");
        Image getMaincouse = maincouseicon.getImage();
        Image setMaincouse = getMaincouse.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Maincouse.setHorizontalAlignment(SwingConstants.CENTER);
        Maincouse.setVerticalAlignment(SwingConstants.CENTER);
        Maincouse.setIcon(new ImageIcon(setMaincouse));
        JLabel mainLabel = new JLabel("Main Couse");
        mainLabel.setBounds(113, 80, 300, 300);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 13));
        mainmenu.add(mainLabel);
        mainmenu.add(Maincouse);

        // Dessert
        JButton Dessert = new JButton();
        Dessert.setBounds(210, 160, 55, 55);
        ImageIcon desserticon = new ImageIcon("Dessert.png");
        Image getDessert = desserticon.getImage();
        Image setDessert = getDessert.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Dessert.setHorizontalAlignment(SwingConstants.CENTER);
        Dessert.setVerticalAlignment(SwingConstants.CENTER);
        Dessert.setIcon(new ImageIcon(setDessert));
        JLabel dessertLabel = new JLabel("Dessert");
        dessertLabel.setBounds(213, 80, 300, 300);
        dessertLabel.setFont(new Font("Arial", Font.BOLD, 13));
        mainmenu.add(dessertLabel);
        mainmenu.add(Dessert);

        // Beverage
        JButton Beverage = new JButton();
        Beverage.setBounds(300, 160, 55, 55);
        ImageIcon bevicon = new ImageIcon("Beverage.png");
        Image getBev = bevicon.getImage();
        Image setBev = getBev.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Beverage.setHorizontalAlignment(SwingConstants.CENTER);
        Beverage.setVerticalAlignment(SwingConstants.CENTER);
        Beverage.setIcon(new ImageIcon(setBev));
        JLabel beverageLabel = new JLabel("Beverage");
        beverageLabel.setBounds(298, 80, 300, 300);
        beverageLabel.setFont(new Font("Arial", Font.BOLD, 13));
        mainmenu.add(beverageLabel);
        mainmenu.add(Beverage);

        // Recommende Menu
        JLabel recommend = new JLabel("Recommened Menu");
        recommend.setBounds(20, 120, 300, 300);
        recommend.setFont(new Font("Arial", Font.PLAIN, 20));
        mainmenu.add(recommend);

        // ผัดกะเพรา
        JButton pwsBTN = new JButton();
        pwsBTN.setBounds(20, 290, 150, 100);
        ImageIcon porkwbasilicon = new ImageIcon("ผัดกะเพรา.png");
        Image getPWS = porkwbasilicon.getImage();
        Image setPWS = getPWS.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        pwsBTN.setHorizontalAlignment(SwingConstants.CENTER);
        pwsBTN.setVerticalAlignment(SwingConstants.CENTER);
        pwsBTN.setIcon(new ImageIcon(setPWS));
        JLabel pwsLB = new JLabel("<html>Stir-Fried Minced Pork<br>with Basil<br>60 Baht</html>");
        pwsLB.setBounds(20, 270, 300, 300);
        pwsLB.setFont(new Font("Arial", Font.PLAIN, 14));
        mainmenu.add(pwsLB);
        mainmenu.add(pwsBTN);

        // ข้าวผัดทะเล
        JButton sfrBTN = new JButton();
        sfrBTN.setBounds(220, 290, 150, 100);
        ImageIcon sfricon = new ImageIcon("ข้าวผัดทะเล.png");
        Image getSFR = sfricon.getImage();
        Image setSFR = getSFR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        sfrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        sfrBTN.setVerticalAlignment(SwingConstants.CENTER);
        sfrBTN.setIcon(new ImageIcon(setSFR));
        JLabel sfrLB = new JLabel("<html>Seafood Fried Rice<br>70 Baht</html>");
        sfrLB.setBounds(220, 270, 300, 300);
        sfrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        mainmenu.add(sfrLB);
        mainmenu.add(sfrBTN);

        // ต้มยำกุ้ง
        JButton tygBTN = new JButton();
        tygBTN.setBounds(20, 460, 150, 100);
        ImageIcon tygicon = new ImageIcon("ต้มยำกุ้ง.png");
        Image getTYG = tygicon.getImage();
        Image setTYG = getTYG.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        tygBTN.setHorizontalAlignment(SwingConstants.CENTER);
        tygBTN.setVerticalAlignment(SwingConstants.CENTER);
        tygBTN.setIcon(new ImageIcon(setTYG));
        JLabel tygLB = new JLabel("<html>Tom Yum Goong<br>60 Baht</html>");
        tygLB.setBounds(20, 430, 300, 300);
        tygLB.setFont(new Font("Arial", Font.PLAIN, 14));
        mainmenu.add(tygLB);
        mainmenu.add(tygBTN);

        // ไข่เจียว
        JButton omrBTN = new JButton();
        omrBTN.setBounds(220, 460, 150, 100);
        ImageIcon omricon = new ImageIcon("ข้าวไข่เจียว.png");
        Image getOMR = omricon.getImage();
        Image setOMR = getOMR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        omrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        omrBTN.setVerticalAlignment(SwingConstants.CENTER);
        omrBTN.setIcon(new ImageIcon(setOMR));
        JLabel omrLB = new JLabel("<html>Omlet Rice<br>30 Baht</html>");
        omrLB.setBounds(220, 430, 300, 300);
        omrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        mainmenu.add(omrLB);
        mainmenu.add(omrBTN);

        mainmenu.setVisible(true);
        mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
