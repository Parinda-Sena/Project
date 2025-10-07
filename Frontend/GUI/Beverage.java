package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Beverage {
    public Beverage() {
        JFrame Beverage = new JFrame("Meow Ordering");
        Beverage.setSize(400, 700);
        Beverage.setIconImage(
                new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());

        // ตั้งสีพื้นหลังของ JFrame
        Beverage.getContentPane().setBackground(new Color(255, 255, 204));
        Beverage.setLayout(null);
        Beverage.setResizable(false);
        Beverage.setLocationRelativeTo(null);
        

        // Panel สำหรับใส่ component ทั้งหมด
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(new Color(255, 255, 204)); // ✅ ตั้งสีพื้นหลัง
        contentPanel.setPreferredSize(new Dimension(380, 1200)); // ✅ กำหนดขนาดที่ต้องการให้ใหญ่กว่า JFrame

        // Label "Beverage"
        JLabel mainLabel = new JLabel("Beverage", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(150, 50, 40));
        mainLabel.setSize(150, 40);
        int x = (Beverage.getWidth() - mainLabel.getWidth()) / 2;
        int y = 20;
        mainLabel.setLocation(x, y);
        contentPanel.add(mainLabel);

        // ปุ่มย้อนกลับ
        JButton backBTN = new JButton();
        backBTN.setBounds(10, 20, 40, 40);
        ImageIcon backicon = new ImageIcon(".\\Frontend\\Photo\\other\\Back.png");
        Image getBack = backicon.getImage().getScaledInstance(100, 100,
                Image.SCALE_SMOOTH);
        backBTN.setIcon(new ImageIcon(getBack));
        backBTN.setBackground(Color.WHITE); // ✅ ให้ปุ่มเข้ากับพื้นหลัง
        backBTN.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(backBTN);
        // กดแล้วไปหน้า MainMenu
        // กดแล้วไปหน้า Mainmenu
        backBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new MainMenu();
                        Beverage.dispose();

                }
        });

        // JScrollPane เฉพาะแนวตั้ง
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(255, 255, 204)); // ✅ ให้ viewport เป็นสีเดียวกัน
        scrollPane.setBorder(null); // ถ้าไม่อยากให้มีขอบ

        //1.น้ำเปล่า
        JButton waterBTN = new JButton();
        waterBTN.setBounds(20, 100, 150, 100);
        ImageIcon watericon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\น้ำเปล่า.png");
        Image getWATER = watericon.getImage();
        Image setWATER = getWATER.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        waterBTN.setHorizontalAlignment(SwingConstants.CENTER);
        waterBTN.setVerticalAlignment(SwingConstants.CENTER);
        waterBTN.setIcon(new ImageIcon(setWATER));
        JLabel waterLB = new JLabel("<html>Water<br>15 Baht</html>");
        waterLB.setBounds(20, 70, 300, 300);
        waterLB.setFont(new Font("Arial", Font.PLAIN, 14));
        waterBTN.setBorderPainted(false);
        waterBTN.setFocusPainted(false);
        contentPanel.add(waterLB);
        contentPanel.add(waterBTN);

        //2.กาแฟ
        JButton coffeeBTN = new JButton();
        coffeeBTN.setBounds(205, 100, 150, 100);
        ImageIcon coffeeicon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\กาแฟเย็น.png");
        Image getCOFFEE = coffeeicon.getImage();
        Image setCOFFEE = getCOFFEE.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        coffeeBTN.setHorizontalAlignment(SwingConstants.CENTER);
        coffeeBTN.setVerticalAlignment(SwingConstants.CENTER);
        coffeeBTN.setIcon(new ImageIcon(setCOFFEE));
        JLabel coffeeLB = new JLabel("<html>Iced Coffee<br>69 Baht</html>");
        coffeeLB.setBounds(205, 70, 300, 300);
        coffeeLB.setFont(new Font("Arial", Font.PLAIN, 14));
        coffeeBTN.setBorderPainted(false);
        coffeeBTN.setFocusPainted(false);
        contentPanel.add(coffeeLB);
        contentPanel.add(coffeeBTN);

        //3.สตรอว์เบอร์รี่โซดา
        JButton strawsodaBTN = new JButton();
        strawsodaBTN.setBounds(20, 260, 150, 100);
        ImageIcon strawsodaicon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\สตรอว์เบอรี่โซดา.png");
        Image getSTRAWSODA = strawsodaicon.getImage();
        Image setSTRAWSODA = getSTRAWSODA.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        strawsodaBTN.setHorizontalAlignment(SwingConstants.CENTER);
        strawsodaBTN.setVerticalAlignment(SwingConstants.CENTER);
        strawsodaBTN.setIcon(new ImageIcon(setSTRAWSODA));
        JLabel strawsodaLB = new JLabel("<html>Strawberry Soda<br>55 Baht</html>");
        strawsodaLB.setBounds(20, 230, 300, 300);
        strawsodaLB.setFont(new Font("Arial", Font.PLAIN, 14));
        strawsodaBTN.setBorderPainted(false);
        strawsodaBTN.setFocusPainted(false);
        contentPanel.add(strawsodaLB);
        contentPanel.add(strawsodaBTN);

        //4.ช็อกโกแลตเย็น
        JButton icechocBTN = new JButton();
        icechocBTN.setBounds(205, 260, 150, 100);
        ImageIcon icechocicon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\ช็อกโกแลตเย็น.png");
        Image getICECHOC = icechocicon.getImage();
        Image setICECHOC = getICECHOC.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        icechocBTN.setHorizontalAlignment(SwingConstants.CENTER);
        icechocBTN.setVerticalAlignment(SwingConstants.CENTER);
        icechocBTN.setIcon(new ImageIcon(setICECHOC));
        JLabel icechocLB = new JLabel("<html>Iced Cocoa<br>69 Baht</html>");
        icechocLB.setBounds(205, 230, 300, 300);
        icechocLB.setFont(new Font("Arial", Font.PLAIN, 14));
        icechocBTN.setBorderPainted(false);
        icechocBTN.setFocusPainted(false);
        contentPanel.add(icechocLB);
        contentPanel.add(icechocBTN);

        //5.เลมอนโซดา
        JButton limesodaBTN = new JButton();
        limesodaBTN.setBounds(20, 420, 150, 100);
        ImageIcon limesodaicon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\เลมอนนโซดา.png");
        Image getLIMESODA = limesodaicon.getImage();
        Image setLIMESODA = getLIMESODA.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        limesodaBTN.setHorizontalAlignment(SwingConstants.CENTER);
        limesodaBTN.setVerticalAlignment(SwingConstants.CENTER);
        limesodaBTN.setIcon(new ImageIcon(setLIMESODA));
        JLabel limesodaLB = new JLabel("<html>Lemon Soda<br>55 Baht</html>");
        limesodaLB.setBounds(20, 400, 300, 300);
        limesodaLB.setFont(new Font("Arial", Font.PLAIN, 14));
        limesodaBTN.setBorderPainted(false);
        limesodaBTN.setFocusPainted(false);
        contentPanel.add(limesodaLB);
        contentPanel.add(limesodaBTN);

        //6.ชาไทย
        JButton thaiteaBTN = new JButton();
        thaiteaBTN.setBounds(205, 420, 150, 100);
        ImageIcon thaiteaicon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\ชาไทย.png");
        Image getTHAITEA = thaiteaicon.getImage();
        Image setTHAITEA = getTHAITEA.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        thaiteaBTN.setHorizontalAlignment(SwingConstants.CENTER);
        thaiteaBTN.setVerticalAlignment(SwingConstants.CENTER);
        thaiteaBTN.setIcon(new ImageIcon(setTHAITEA));
        JLabel thaiteaLB = new JLabel("<html>Iced Thai Tea<br>79 Baht</html>");
        thaiteaLB.setBounds(205, 400, 300, 300);
        thaiteaLB.setFont(new Font("Arial", Font.PLAIN, 14));
        thaiteaBTN.setBorderPainted(false);
        thaiteaBTN.setFocusPainted(false);
        contentPanel.add(thaiteaLB);
        contentPanel.add(thaiteaBTN);

        //7.ชาเขียวเย็น
        JButton greenteaBTN = new JButton();
        greenteaBTN.setBounds(20, 590, 150, 100);
        ImageIcon greenteaicon = new ImageIcon(
                ".\\Frontend\\Photo\\Beverage\\ชาเขียวเย็น.png");
        Image getGREENTEA = greenteaicon.getImage();
        Image setGREENTEA = getGREENTEA.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        greenteaBTN.setHorizontalAlignment(SwingConstants.CENTER);
        greenteaBTN.setVerticalAlignment(SwingConstants.CENTER);
        greenteaBTN.setIcon(new ImageIcon(setGREENTEA));
        JLabel greenteaLB = new JLabel("<html>Iced Green Tea<br>69 Baht</html>");
        greenteaLB.setBounds(20, 565, 300, 300);
        greenteaLB.setFont(new Font("Arial", Font.PLAIN, 14));
        greenteaBTN.setBorderPainted(false);
        greenteaBTN.setFocusPainted(false);
        contentPanel.add(greenteaLB);
        contentPanel.add(greenteaBTN);

        // 8.ไมโลปั่น
        JButton miloBTN = new JButton();
        miloBTN.setBounds(205, 590, 150, 100);
        ImageIcon miloicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Beverage\\ไมโลปั่น.png");
        Image getMILO = miloicon.getImage();
        Image setMILO = getMILO.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        miloBTN.setHorizontalAlignment(SwingConstants.CENTER);
        miloBTN.setVerticalAlignment(SwingConstants.CENTER);
        miloBTN.setIcon(new ImageIcon(setMILO));
        JLabel miloLB = new JLabel("<html>Milo Frappe<br>65 Baht</html>");
        miloLB.setBounds(205, 560, 300, 300);
        miloLB.setFont(new Font("Arial", Font.PLAIN, 14));
        miloBTN.setBorderPainted(false);
        miloBTN.setFocusPainted(false);
        contentPanel.add(miloLB);
        contentPanel.add(miloBTN);

        // 9.ลิ้นจี่โซดา
        JButton lyncheeBTN = new JButton();
        lyncheeBTN.setBounds(20, 770, 150, 100);
        ImageIcon lyncheeicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Beverage\\ลิ้นจี่โซดา.png");
        Image getLYNCHEE = lyncheeicon.getImage();
        Image setLYNCHEE = getLYNCHEE.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        lyncheeBTN.setHorizontalAlignment(SwingConstants.CENTER);
        lyncheeBTN.setVerticalAlignment(SwingConstants.CENTER);
        lyncheeBTN.setIcon(new ImageIcon(setLYNCHEE));
        JLabel lyncheeLB = new JLabel("<html>Lynchee Soda<br>55 Baht</html>");
        lyncheeLB.setBounds(20, 750, 300, 300);
        lyncheeLB.setFont(new Font("Arial", Font.PLAIN, 14));
        lyncheeBTN.setBorderPainted(false);
        lyncheeBTN.setFocusPainted(false);
        contentPanel.add(lyncheeLB);
        contentPanel.add(lyncheeBTN);

        // 10.น้ำมะพร้าวปั่น
        JButton coconutBTN = new JButton();
        coconutBTN.setBounds(205, 770, 150, 100);
        ImageIcon coconuticon = new ImageIcon(
                        ".\\Frontend\\Photo\\Beverage\\น้ำมะพร้วปั่น.png");
        Image getCOCONUT = coconuticon.getImage();
        Image setCOCONUT = getCOCONUT.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        coconutBTN.setHorizontalAlignment(SwingConstants.CENTER);
        coconutBTN.setVerticalAlignment(SwingConstants.CENTER);
        coconutBTN.setIcon(new ImageIcon(setCOCONUT));
        JLabel coconutLB = new JLabel("<html>Coconut Smoothie<br>55 Baht</html>");
        coconutLB.setBounds(205, 750, 300, 300);
        coconutLB.setFont(new Font("Arial", Font.PLAIN, 14));
        coconutBTN.setBorderPainted(false);
        coconutBTN.setFocusPainted(false);
        contentPanel.add(coconutLB);
        contentPanel.add(coconutBTN);

        // 11.สตรอว์เบอร์รี่โยเกิร์ตปั่น
        JButton strawyoBTN = new JButton();
        strawyoBTN.setBounds(20, 940, 150, 100);
        ImageIcon strawyoicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Beverage\\สตรอว์เบอร์รี่โยเกิร์ต.png");
        Image getSTRAWYO = strawyoicon.getImage();
        Image setSTRAWYO = getSTRAWYO.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        strawyoBTN.setHorizontalAlignment(SwingConstants.CENTER);
        strawyoBTN.setVerticalAlignment(SwingConstants.CENTER);
        strawyoBTN.setIcon(new ImageIcon(setSTRAWYO));
        JLabel strawyoLB = new JLabel("<html>Strawberry Yogurt<br>59 Baht</html>");
        strawyoLB.setBounds(20, 920, 300, 300);
        strawyoLB.setFont(new Font("Arial", Font.PLAIN, 14));
        strawyoBTN.setBorderPainted(false);
        strawyoBTN.setFocusPainted(false);
        contentPanel.add(strawyoLB);
        contentPanel.add(strawyoBTN);

        // 12.น้ำแตงโมปั่น
        JButton watermelonBTN = new JButton();
        watermelonBTN.setBounds(205, 940, 150, 100);
        ImageIcon watermelonicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Beverage\\น้ำแตงโมปั่น.png");
        Image getWATERMELON = watermelonicon.getImage();
        Image setWATERMELON = getWATERMELON.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        watermelonBTN.setHorizontalAlignment(SwingConstants.CENTER);
        watermelonBTN.setVerticalAlignment(SwingConstants.CENTER);
        watermelonBTN.setIcon(new ImageIcon(setWATERMELON));
        JLabel watermelonLB = new JLabel("<html>Watermelon Smoothie<br>65 Baht</html>");
        watermelonLB.setBounds(205, 920, 300, 300);
        watermelonLB.setFont(new Font("Arial", Font.PLAIN, 14));
        watermelonBTN.setBorderPainted(false);
        watermelonBTN.setFocusPainted(false);
        contentPanel.add(watermelonLB);
        contentPanel.add(watermelonBTN);

        //ปุ่มตะกร้าสินค้า
        JButton cartBTN = new JButton();
        cartBTN.setBounds(310, 20, 40, 40);
        cartBTN.setBackground(Color.WHITE); // ✅ ให้ปุ่มเข้ากับพื้นหลัง
        ImageIcon carticon = new ImageIcon(
                        ".\\Frontend\\Photo\\other\\ตะกร้าสินค้า.png");
        Image getCART = carticon.getImage();
        Image setCART = getCART.getScaledInstance(cartBTN.getWidth(), cartBTN.getHeight(), Image.SCALE_SMOOTH);
        cartBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cartBTN.setVerticalAlignment(SwingConstants.CENTER);
        cartBTN.setIcon(new ImageIcon(setCART));
        cartBTN.setBorderPainted(false);
        cartBTN.setFocusPainted(false);

        contentPanel.add(cartBTN);
        Beverage.setContentPane(scrollPane);

        // กดแล้วไปหน้า CartUI
        cartBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new CartUI();
                        Beverage.dispose();

                }
        });

        Beverage.setVisible(true);
        Beverage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
