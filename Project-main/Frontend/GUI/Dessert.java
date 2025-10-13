package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dessert {
    public Dessert(){
        JFrame Dessert = new JFrame("Meow Ordering");
        Dessert.setSize(400, 700);
        Dessert.setIconImage(
                new ImageIcon(".\\\\Frontend\\\\Photo\\\\Logo\\\\LogoJFrame.png").getImage());

        // ตั้งสีพื้นหลังของ JFrame
        Dessert.getContentPane().setBackground(new Color(255, 255, 204));
        Dessert.setLayout(null);
        Dessert.setResizable(false);
        Dessert.setLocationRelativeTo(null);

        // Panel สำหรับใส่ component ทั้งหมด
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(new Color(255, 255, 204)); // ✅ ตั้งสีพื้นหลัง
        contentPanel.setPreferredSize(new Dimension(380, 1200)); // ✅ กำหนดขนาดที่ต้องการให้ใหญ่กว่า JFrame

        // Label "Dessert"
        JLabel mainLabel = new JLabel("Dessert", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(150, 50, 40));
        mainLabel.setSize(150, 40);
        int x = (Dessert.getWidth() - mainLabel.getWidth()) / 2;
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
                        Dessert.dispose();

                }
        });

        // JScrollPane เฉพาะแนวตั้ง
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(255, 255, 204)); // ✅ ให้ viewport เป็นสีเดียวกัน
        scrollPane.setBorder(null); // ถ้าไม่อยากให้มีขอบ

        //1.ไอติมช็อกโกแลต
        JButton chocBTN = new JButton();
        chocBTN.setBounds(20, 100, 150, 100);
        ImageIcon chocicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\ไอติมช็อกโกแลต.png");
        Image getCHOC = chocicon.getImage();
        Image setCHOC = getCHOC.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        chocBTN.setHorizontalAlignment(SwingConstants.CENTER);
        chocBTN.setVerticalAlignment(SwingConstants.CENTER);
        chocBTN.setIcon(new ImageIcon(setCHOC));
        JLabel chocLB = new JLabel("<html>Chocolate Ice Cream<br>29 Baht</html>");
        chocLB.setBounds(20, 70, 300, 300);
        chocLB.setFont(new Font("Arial", Font.PLAIN, 14));
        chocBTN.setBorderPainted(false);
        chocBTN.setFocusPainted(false);
        contentPanel.add(chocLB);
        contentPanel.add(chocBTN);

        //2.โดนัท
        JButton donutBTN = new JButton();
        donutBTN.setBounds(205, 100, 150, 100);
        ImageIcon donuticon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\โดนัท.png");
        Image getDONUT = donuticon.getImage();
        Image setDONUT = getDONUT.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        donutBTN.setHorizontalAlignment(SwingConstants.CENTER);
        donutBTN.setVerticalAlignment(SwingConstants.CENTER);
        donutBTN.setIcon(new ImageIcon(setDONUT));
        JLabel donutLB = new JLabel("<html>Double Donut<br>49 Baht</html>");
        donutLB.setBounds(205, 70, 300, 300);
        donutLB.setFont(new Font("Arial", Font.PLAIN, 14));
        donutBTN.setBorderPainted(false);
        donutBTN.setFocusPainted(false);
        contentPanel.add(donutLB);
        contentPanel.add(donutBTN);

        //3.ไอติมสตรอว์เบอร์รี่
        JButton strawBTN = new JButton();
        strawBTN.setBounds(20, 260, 150, 100);
        ImageIcon strawicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\ไอติมสตรอวเบอรี่.png");
        Image getSTRAW = strawicon.getImage();
        Image setSTRAW = getSTRAW.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        strawBTN.setHorizontalAlignment(SwingConstants.CENTER);
        strawBTN.setVerticalAlignment(SwingConstants.CENTER);
        strawBTN.setIcon(new ImageIcon(setSTRAW));
        JLabel strawLB = new JLabel("<html>Strawberry Ice Cream<br>29 Baht</html>");
        strawLB.setBounds(20, 230, 300, 300);
        strawLB.setFont(new Font("Arial", Font.PLAIN, 14));
        strawBTN.setBorderPainted(false);
        strawBTN.setFocusPainted(false);
        contentPanel.add(strawLB);
        contentPanel.add(strawBTN);

        //4.ชีทเค้ก
        JButton cheeseBTN = new JButton();
        cheeseBTN.setBounds(205, 260, 150, 100);
        ImageIcon cheeseicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\ชีทเค้ก.png");
        Image getCHEESE = cheeseicon.getImage();
        Image setCHEESE = getCHEESE.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        cheeseBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cheeseBTN.setVerticalAlignment(SwingConstants.CENTER);
        cheeseBTN.setIcon(new ImageIcon(setCHEESE));
        JLabel cheeseLB = new JLabel("<html>Cheesecake<br>69 Baht</html>");
        cheeseLB.setBounds(205, 230, 300, 300);
        cheeseLB.setFont(new Font("Arial", Font.PLAIN, 14));
        cheeseBTN.setBorderPainted(false);
        cheeseBTN.setFocusPainted(false);
        contentPanel.add(cheeseLB);
        contentPanel.add(cheeseBTN);

        //5.ไอติมมะนาว
        JButton limeBTN = new JButton();
        limeBTN.setBounds(20, 420, 150, 100);
        ImageIcon limeicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\ไอติมมะนาว.png");
        Image getLIME = limeicon.getImage();
        Image setLIME = getLIME.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        limeBTN.setHorizontalAlignment(SwingConstants.CENTER);
        limeBTN.setVerticalAlignment(SwingConstants.CENTER);
        limeBTN.setIcon(new ImageIcon(setLIME));
        JLabel limeLB = new JLabel("<html>Lemon Ice Cream<br>29 Baht</html>");
        limeLB.setBounds(20, 400, 300, 300);
        limeLB.setFont(new Font("Arial", Font.PLAIN, 14));
        limeBTN.setBorderPainted(false);
        limeBTN.setFocusPainted(false);
        contentPanel.add(limeLB);
        contentPanel.add(limeBTN);

        //6.โทสต์
        JButton honeyBTN = new JButton();
        honeyBTN.setBounds(205, 420, 150, 100);
        ImageIcon honeyicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\โทสต์.png");
        Image getHONEY = honeyicon.getImage();
        Image setHONEY = getHONEY.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        honeyBTN.setHorizontalAlignment(SwingConstants.CENTER);
        honeyBTN.setVerticalAlignment(SwingConstants.CENTER);
        honeyBTN.setIcon(new ImageIcon(setHONEY));
        JLabel honeyLB = new JLabel("<html>Honey Toast<br>79 Baht</html>");
        honeyLB.setBounds(205, 400, 300, 300);
        honeyLB.setFont(new Font("Arial", Font.PLAIN, 14));
        honeyBTN.setBorderPainted(false);
        honeyBTN.setFocusPainted(false);
        contentPanel.add(honeyLB);
        contentPanel.add(honeyBTN);

        //7.ไอติมวนิลา
        JButton vanilaBTN = new JButton();
        vanilaBTN.setBounds(20, 590, 150, 100);
        ImageIcon vanilaicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\ไอติมวนิลา.png");
        Image getVANILA = vanilaicon.getImage();
        Image setVANILA = getVANILA.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        vanilaBTN.setHorizontalAlignment(SwingConstants.CENTER);
        vanilaBTN.setVerticalAlignment(SwingConstants.CENTER);
        vanilaBTN.setIcon(new ImageIcon(setVANILA));
        JLabel vanilaLB = new JLabel("<html>Vanila Ice Cream<br>29 Baht</html>");
        vanilaLB.setBounds(20, 565, 300, 300);
        vanilaLB.setFont(new Font("Arial", Font.PLAIN, 14));
        vanilaBTN.setBorderPainted(false);
        vanilaBTN.setFocusPainted(false);
        contentPanel.add(vanilaLB);
        contentPanel.add(vanilaBTN);

        //8.บราวนี่
        JButton brownBTN = new JButton();
        brownBTN.setBounds(205, 590, 150, 100);
        ImageIcon brownicon = new ImageIcon(
                ".\\Frontend\\Photo\\Dessert\\บราวนี่.png");
        Image getBROWN = brownicon.getImage();
        Image setBROWN = getBROWN.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        brownBTN.setHorizontalAlignment(SwingConstants.CENTER);
        brownBTN.setVerticalAlignment(SwingConstants.CENTER);
        brownBTN.setIcon(new ImageIcon(setBROWN));
        JLabel brownLB = new JLabel("<html>Brownies<br>49 Baht</html>");
        brownLB.setBounds(205, 565, 300, 300);
        brownLB.setFont(new Font("Arial", Font.PLAIN, 14));
        brownBTN.setBorderPainted(false);
        brownBTN.setFocusPainted(false);
        contentPanel.add(brownLB);
        contentPanel.add(brownBTN);

        // 9.แพนเค้ก
        JButton pancakeBTN = new JButton();
        pancakeBTN.setBounds(20, 770, 150, 100);
        ImageIcon pancakeicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Dessert\\แพนเค้ก.png");
        Image getPANCAKE = pancakeicon.getImage();
        Image setPANCAKE = getPANCAKE.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        pancakeBTN.setHorizontalAlignment(SwingConstants.CENTER);
        pancakeBTN.setVerticalAlignment(SwingConstants.CENTER);
        pancakeBTN.setIcon(new ImageIcon(setPANCAKE));
        JLabel pancakeLB = new JLabel("<html>Pancake<br>49 Baht</html>");
        pancakeLB.setBounds(20, 750, 300, 300);
        pancakeLB.setFont(new Font("Arial", Font.PLAIN, 14));
        pancakeBTN.setBorderPainted(false);
        pancakeBTN.setFocusPainted(false);
        contentPanel.add(pancakeLB);
        contentPanel.add(pancakeBTN);

        // 10.สตรอว์เบอร์รี่ชีสเค้ก
        JButton strawcheeseBTN = new JButton();
        strawcheeseBTN.setBounds(205, 770, 150, 100);
        ImageIcon strawcheeseicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Dessert\\Strawberry Cheesecake Ice Cream.png");
        Image getSTRAWCHEESE = strawcheeseicon.getImage();
        Image setSTRAWCHEESE = getSTRAWCHEESE.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        strawcheeseBTN.setHorizontalAlignment(SwingConstants.CENTER);
        strawcheeseBTN.setVerticalAlignment(SwingConstants.CENTER);
        strawcheeseBTN.setIcon(new ImageIcon(setSTRAWCHEESE));
        JLabel strawcheeseLB = new JLabel("<html>Strawberry Cheesecake<br>Ice Cream<br>89 Baht</html>");
        strawcheeseLB.setBounds(205, 750, 300, 300);
        strawcheeseLB.setFont(new Font("Arial", Font.PLAIN, 14));
        strawcheeseBTN.setBorderPainted(false);
        strawcheeseBTN.setFocusPainted(false);
        contentPanel.add(strawcheeseLB);
        contentPanel.add(strawcheeseBTN);

        // 11.ไอติมมิ้นช็อกโกแลต
        JButton mintchocBTN = new JButton();
        mintchocBTN.setBounds(20, 940, 150, 100);
        ImageIcon mintchocicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Dessert\\ไอติมมิ้นช้อก.png");
        Image getMINTCHOC = mintchocicon.getImage();
        Image setMINTCHOC = getMINTCHOC.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        mintchocBTN.setHorizontalAlignment(SwingConstants.CENTER);
        mintchocBTN.setVerticalAlignment(SwingConstants.CENTER);
        mintchocBTN.setIcon(new ImageIcon(setMINTCHOC));
        JLabel mintchocLB = new JLabel("<html>Mint Chocolate<br>Ice Cream<br>39 Baht</html>");
        mintchocLB.setBounds(20, 920, 300, 300);
        mintchocLB.setFont(new Font("Arial", Font.PLAIN, 14));
        mintchocBTN.setBorderPainted(false);
        mintchocBTN.setFocusPainted(false);
        contentPanel.add(mintchocLB);
        contentPanel.add(mintchocBTN);

        // 12.ไอติมมะม่วง
        JButton mangoBTN = new JButton();
        mangoBTN.setBounds(205, 940, 150, 100);
        ImageIcon mangoicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Dessert\\ไอติมมะม่วง.png");
        Image getMANGO = mangoicon.getImage();
        Image setMANGO = getMANGO.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        mangoBTN.setHorizontalAlignment(SwingConstants.CENTER);
        mangoBTN.setVerticalAlignment(SwingConstants.CENTER);
        mangoBTN.setIcon(new ImageIcon(setMANGO));
        JLabel mangoLB = new JLabel("<html>Mango Ice Cream<br>39 Baht</html>");
        mangoLB.setBounds(205, 920, 300, 300);
        mangoLB.setFont(new Font("Arial", Font.PLAIN, 14));
        mangoBTN.setBorderPainted(false);
        mangoBTN.setFocusPainted(false);
        contentPanel.add(mangoLB);
        contentPanel.add(mangoBTN);

        // ปุ่มตะกร้าสินค้า
        JButton cartBTN = new JButton();
        cartBTN.setBounds(310, 20, 40, 40);
        cartBTN.setBackground(Color.WHITE); // ✅ ให้ปุ่มเข้ากับพื้นหลัง
        ImageIcon carticon = new ImageIcon(
                        "./Frontend/Photo/other/ตะกร้าสินค้า.png");
        Image getCART = carticon.getImage();
        Image setCART = getCART.getScaledInstance(cartBTN.getWidth(), cartBTN.getHeight(), Image.SCALE_SMOOTH);
        cartBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cartBTN.setVerticalAlignment(SwingConstants.CENTER);
        cartBTN.setIcon(new ImageIcon(setCART));
        cartBTN.setBorderPainted(false);
        cartBTN.setFocusPainted(false);

        contentPanel.add(cartBTN);
        Dessert.setContentPane(scrollPane);

        // กดแล้วไปหน้า CartUI
        cartBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new CartUI();
                        Dessert.dispose();

                }
        });

        Dessert.setVisible(true);
        Dessert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
