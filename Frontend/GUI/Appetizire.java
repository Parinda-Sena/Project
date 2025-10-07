package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Appetizire 
{
    public Appetizire()
    {
        JFrame Appetizier = new JFrame("Meow Ordering");
        Appetizier.setSize(400, 700);
        Appetizier.setIconImage(
                new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());

        // ตั้งสีพื้นหลังของ JFrame
        Appetizier.getContentPane().setBackground(new Color(255, 255, 204));
        Appetizier.setLayout(null);
        Appetizier.setResizable(false);
        Appetizier.setLocationRelativeTo(null);
        

        // Panel สำหรับใส่ component ทั้งหมด
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(new Color(255, 255, 204)); // ✅ ตั้งสีพื้นหลัง
        contentPanel.setPreferredSize(new Dimension(380, 1200)); // ✅ กำหนดขนาดที่ต้องการให้ใหญ่กว่า JFrame

        // Label "Appetizier"
        JLabel mainLabel = new JLabel("Appetizier", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(150, 50, 40));
        mainLabel.setSize(150, 40);
        int x = (Appetizier.getWidth() - mainLabel.getWidth()) / 2;
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

        // กดแล้วไปหน้า Mainmenu
        backBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new MainMenu();
                        Appetizier.dispose();

                }
        });


        

        // JScrollPane เฉพาะแนวตั้ง
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(255, 255, 204)); // ✅ ให้ viewport เป็นสีเดียวกัน
        scrollPane.setBorder(null); // ถ้าไม่อยากให้มีขอบ

        //เฟรนฟราย
        JButton fryBTN = new JButton();
        fryBTN.setBounds(20, 100, 150, 100);
        ImageIcon fryicon = new ImageIcon(
                ".\\Frontend\\Photo\\Appetizier\\เฟรนฟราย.png");
        Image getFRY = fryicon.getImage();
        Image setFRY = getFRY.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        fryBTN.setHorizontalAlignment(SwingConstants.CENTER);
        fryBTN.setVerticalAlignment(SwingConstants.CENTER);
        fryBTN.setIcon(new ImageIcon(setFRY));
        JLabel fryLB = new JLabel("<html>French Fries<br>39 Baht</html>");
        fryLB.setBounds(20, 70, 300, 300);
        fryLB.setFont(new Font("Arial", Font.PLAIN, 14));
        fryBTN.setBorderPainted(false);
        fryBTN.setFocusPainted(false);
        contentPanel.add(fryLB);
        contentPanel.add(fryBTN);

        //ไก่ป๊อบ
        JButton cpBTN = new JButton();
        cpBTN.setBounds(205, 100, 150, 100);
        ImageIcon cpicon = new ImageIcon(
                ".\\Frontend\\Photo\\Appetizier\\ไก่ป๊อบ.png");
        Image getCP = cpicon.getImage();
        Image setCP = getCP.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        cpBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cpBTN.setVerticalAlignment(SwingConstants.CENTER);
        cpBTN.setIcon(new ImageIcon(setCP));
        JLabel cpLB = new JLabel("<html>Chicken Pop<br>39 Baht</html>");
        cpLB.setBounds(205, 70, 300, 300);
        cpLB.setFont(new Font("Arial", Font.PLAIN, 14));
        cpBTN.setBorderPainted(false);
        cpBTN.setFocusPainted(false);
        contentPanel.add(cpLB);
        contentPanel.add(cpBTN);

        // นักเก็ต
        JButton cnBTN = new JButton();
        cnBTN.setBounds(20, 260, 150, 100);
        ImageIcon gcricon = new ImageIcon(
                ".\\Frontend\\Photo\\Appetizier\\นักเก็ต.png");
        Image getCN = gcricon.getImage();
        Image setCN = getCN.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        cnBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cnBTN.setVerticalAlignment(SwingConstants.CENTER);
        cnBTN.setIcon(new ImageIcon(setCN));
        JLabel cnLB = new JLabel("<html>Chicken Nugget<br>39 Baht</html>");
        cnLB.setBounds(20, 230, 300, 300);
        cnLB.setFont(new Font("Arial", Font.PLAIN, 14));
        cnBTN.setBorderPainted(false);
        cnBTN.setFocusPainted(false);
        contentPanel.add(cnLB);
        contentPanel.add(cnBTN);

        // ไก่ไม่มีกระดูก
        JButton blcBTN = new JButton();
        blcBTN.setBounds(205, 260, 150, 100);
        ImageIcon blcicon = new ImageIcon(
                ".\\Frontend\\Photo\\Appetizier\\ไก่ไม่มีกระดูก.png");
        Image getBLC = blcicon.getImage();
        Image setBLC = getBLC.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        blcBTN.setHorizontalAlignment(SwingConstants.CENTER);
        blcBTN.setVerticalAlignment(SwingConstants.CENTER);
        blcBTN.setIcon(new ImageIcon(setBLC));
        JLabel blcLB = new JLabel("<html>Boneless Chicken<br>39 Baht</html>");
        blcLB.setBounds(205, 230, 300, 300);
        blcLB.setFont(new Font("Arial", Font.PLAIN, 14));
        blcBTN.setBorderPainted(false);
        blcBTN.setFocusPainted(false);
        contentPanel.add(blcLB);
        contentPanel.add(blcBTN);

        // เห็ดเข็มทองทอด
        JButton enokiBTN = new JButton();
        enokiBTN.setBounds(20, 420, 150, 100);
        ImageIcon enokiicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Appetizier\\เห็ดเข็มทองทอด.png");
        Image getENOKI = enokiicon.getImage();
        Image setENOKI = getENOKI.getScaledInstance(200, 180, Image.SCALE_SMOOTH);
        enokiBTN.setHorizontalAlignment(SwingConstants.CENTER);
        enokiBTN.setVerticalAlignment(SwingConstants.CENTER);
        enokiBTN.setIcon(new ImageIcon(setENOKI));
        JLabel enokiLB = new JLabel("<html>Crispy Deep Fried<br>Enoki Mushroom<br>49 Baht</html>");
        enokiLB.setBounds(20, 400, 300, 300);
        enokiLB.setFont(new Font("Arial", Font.PLAIN, 14));
        enokiBTN.setBorderPainted(false);
        enokiBTN.setFocusPainted(false);
        contentPanel.add(enokiLB);
        contentPanel.add(enokiBTN);

        //กุ้งเทมปุระ
        JButton shrimptempBTN = new JButton();
        shrimptempBTN.setBounds(205, 420, 150, 100);
        ImageIcon shrimptempicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Appetizier\\กุ้งเทมปุระ.png");
        Image getSHRIMPTEMP = shrimptempicon.getImage();
        Image setSHRIMPTEMP = getSHRIMPTEMP.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        shrimptempBTN.setHorizontalAlignment(SwingConstants.CENTER);
        shrimptempBTN.setVerticalAlignment(SwingConstants.CENTER);
        shrimptempBTN.setIcon(new ImageIcon(setSHRIMPTEMP));
        JLabel shrimptempLB = new JLabel("<html>Shrimp Tempura<br>59 Baht</html>");
        shrimptempLB.setBounds(205, 400, 300, 300);
        shrimptempLB.setFont(new Font("Arial", Font.PLAIN, 14));
        shrimptempBTN.setBorderPainted(false);
        shrimptempBTN.setFocusPainted(false);
        contentPanel.add(shrimptempLB);
        contentPanel.add(shrimptempBTN);

        //onion ring
        JButton onionBTN = new JButton();
        onionBTN.setBounds(20, 590, 150, 100);
        ImageIcon onionicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Appetizier\\Onions ring.png");
        Image getONION = onionicon.getImage();
        Image setONION = getONION.getScaledInstance(205, 215, Image.SCALE_SMOOTH);
        onionBTN.setHorizontalAlignment(SwingConstants.CENTER);
        onionBTN.setVerticalAlignment(SwingConstants.CENTER);
        onionBTN.setIcon(new ImageIcon(setONION));
        JLabel onionLB = new JLabel("<html>Onions Ring<br>59 Baht</html>");
        onionLB.setBounds(20, 565, 300, 300);
        onionLB.setFont(new Font("Arial", Font.PLAIN, 14));
        onionBTN.setBorderPainted(false);
        onionBTN.setFocusPainted(false);
        contentPanel.add(onionLB);
        contentPanel.add(onionBTN);

        //ไส้กรอกแดงทอด
        JButton rssBTN = new JButton();
        rssBTN.setBounds(205, 590, 150, 100);
        ImageIcon rssicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Appetizier\\ไส้กรอกแดงทอด.png");
        Image getRSS = rssicon.getImage();
        Image setRSS = getRSS.getScaledInstance(230, 230, Image.SCALE_SMOOTH);
        rssBTN.setHorizontalAlignment(SwingConstants.CENTER);
        rssBTN.setVerticalAlignment(SwingConstants.CENTER);
        rssBTN.setIcon(new ImageIcon(setRSS));
        JLabel rssLB = new JLabel("<html>Red Sausage Fried<br>30 Baht</html>");
        rssLB.setBounds(205, 560, 300, 300);
        rssLB.setFont(new Font("Arial", Font.PLAIN, 14));
        rssBTN.setBorderPainted(false);
        rssBTN.setFocusPainted(false);
        contentPanel.add(rssLB);
        contentPanel.add(rssBTN);

        // ปุ่มตะกร้าสินค้า
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
        Appetizier.setContentPane(scrollPane);

        // กดแล้วไปหน้า CartUI
        cartBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new CartUI();
                        Appetizier.dispose();

                }
        });


        Appetizier.setVisible(true);
        Appetizier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
