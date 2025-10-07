package GUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Maincouse {
    public Maincouse() {
        JFrame Maincouse = new JFrame("Meow Ordering");
        Maincouse.setSize(400, 700);
        Maincouse.setIconImage(
                new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());

        // ตั้งสีพื้นหลังของ JFrame
        Maincouse.getContentPane().setBackground(new Color(255, 255, 204));
        Maincouse.setLayout(null);
        Maincouse.setResizable(false);
        Maincouse.setLocationRelativeTo(null);

        // Panel สำหรับใส่ component ทั้งหมด
        JPanel contentPanel = new JPanel(null);
        contentPanel.setBackground(new Color(255, 255, 204)); // ✅ ตั้งสีพื้นหลัง
        contentPanel.setPreferredSize(new Dimension(380, 1200)); // ✅ กำหนดขนาดที่ต้องการให้ใหญ่กว่า JFrame

        // Label "Main course"
        JLabel mainLabel = new JLabel("Main course", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(150, 50, 40));
        mainLabel.setSize(150, 40);
        int x = (Maincouse.getWidth() - mainLabel.getWidth()) / 2;
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
                        Maincouse.dispose();

                }
        });

        // JScrollPane เฉพาะแนวตั้ง
        JScrollPane scrollPane = new JScrollPane(contentPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(new Color(255, 255, 204)); // ✅ ให้ viewport เป็นสีเดียวกัน
        scrollPane.setBorder(null); // ถ้าไม่อยากให้มีขอบ

        //1.ไข่เจียว
        JButton omrBTN = new JButton();
        omrBTN.setBounds(20, 100, 150, 100);
        ImageIcon omricon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ข้าวไข่เจียว.png");
        Image getOMR = omricon.getImage();
        Image setOMR = getOMR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        omrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        omrBTN.setVerticalAlignment(SwingConstants.CENTER);
        omrBTN.setIcon(new ImageIcon(setOMR));
        JLabel omrLB = new JLabel("<html>Omelette<br>30 Baht</html>");
        omrLB.setBounds(20, 70, 300, 300);
        omrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        omrBTN.setBorderPainted(false);
        omrBTN.setFocusPainted(false);
        contentPanel.add(omrLB);
        contentPanel.add(omrBTN);

        //2.ข้าวผัดทะเล
        JButton sfrBTN = new JButton();
        sfrBTN.setBounds(205, 100, 150, 100);
        ImageIcon sfricon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ข้าวผัดทะเล.png");
        Image getSFR = sfricon.getImage();
        Image setSFR = getSFR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        sfrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        sfrBTN.setVerticalAlignment(SwingConstants.CENTER);
        sfrBTN.setIcon(new ImageIcon(setSFR));
        JLabel sfrLB = new JLabel("<html>Seafood Fried Rice<br>70 Baht</html>");
        sfrLB.setBounds(205, 70, 300, 300);
        sfrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        sfrBTN.setBorderPainted(false);
        sfrBTN.setFocusPainted(false);
        contentPanel.add(sfrLB);
        contentPanel.add(sfrBTN);

        //3.แกงเขียวหวาน
        JButton gcrBTN = new JButton();
        gcrBTN.setBounds(20, 260, 150, 100);
        ImageIcon gcricon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\แกงเขียวหวาน.png");
        Image getGCR = gcricon.getImage();
        Image setGCR = getGCR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        gcrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        gcrBTN.setVerticalAlignment(SwingConstants.CENTER);
        gcrBTN.setIcon(new ImageIcon(setGCR));
        JLabel gcrLB = new JLabel("<html>Green Curry<br>60 Baht</html>");
        gcrLB.setBounds(20, 230, 300, 300);
        gcrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        gcrBTN.setBorderPainted(false);
        gcrBTN.setFocusPainted(false);
        contentPanel.add(gcrLB);
        contentPanel.add(gcrBTN);

        //4.ต้มยำกุ้ง
        JButton tygBTN = new JButton();
        tygBTN.setBounds(205, 260, 150, 100);
        ImageIcon tygicon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ต้มยำกุ้ง.png");
        Image getTYG = tygicon.getImage();
        Image setTYG = getTYG.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        tygBTN.setHorizontalAlignment(SwingConstants.CENTER);
        tygBTN.setVerticalAlignment(SwingConstants.CENTER);
        tygBTN.setIcon(new ImageIcon(setTYG));
        JLabel tygLB = new JLabel("<html>Tom Yum Goong<br>60 Baht</html>");
        tygLB.setBounds(205, 230, 300, 300);
        tygLB.setFont(new Font("Arial", Font.PLAIN, 14));
        tygBTN.setBorderPainted(false);
        tygBTN.setFocusPainted(false);
        contentPanel.add(tygLB);
        contentPanel.add(tygBTN);

        //5.ผัดกะเพราหมูสับ
        JButton pwsBTN = new JButton();
        pwsBTN.setBounds(20, 420, 150, 100);
        ImageIcon porkwbasilicon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ผัดกะเพรา.png");
        Image getPWS = porkwbasilicon.getImage();
        Image setPWS = getPWS.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        pwsBTN.setHorizontalAlignment(SwingConstants.CENTER);
        pwsBTN.setVerticalAlignment(SwingConstants.CENTER);
        pwsBTN.setIcon(new ImageIcon(setPWS));
        JLabel pwsLB = new JLabel("<html>Stir-Fried Minced Pork<br>with Basil<br>60 Baht</html>");
        pwsLB.setBounds(20, 400, 300, 300);
        pwsLB.setFont(new Font("Arial", Font.PLAIN, 14));
        pwsBTN.setBorderPainted(false);
        pwsBTN.setFocusPainted(false);
        contentPanel.add(pwsLB);
        contentPanel.add(pwsBTN);

        //6.ผัดกะเพราไก่
        JButton cwsBTN = new JButton();
        cwsBTN.setBounds(205, 420, 150, 100);
        ImageIcon cwsicon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ผัดกะเพราไก่.png");
        Image getCWS = cwsicon.getImage();
        Image setCWS = getCWS.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        cwsBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cwsBTN.setVerticalAlignment(SwingConstants.CENTER);
        cwsBTN.setIcon(new ImageIcon(setCWS));
        JLabel cwsLB = new JLabel("<html>Stir-Fried Chicken<br>with Basil<br>55 Baht</html>");
        cwsLB.setBounds(205, 400, 300, 300);
        cwsLB.setFont(new Font("Arial", Font.PLAIN, 14));
        cwsBTN.setBorderPainted(false);
        cwsBTN.setFocusPainted(false);
        contentPanel.add(cwsLB);
        contentPanel.add(cwsBTN);

        //7.ผัดกะเพราหมูกรอบ
        JButton crippyBTN = new JButton();
        crippyBTN.setBounds(20, 590, 150, 100);
        ImageIcon crippyicon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ผัดกะเพราหมูกรอบ.png");
        Image getCRIPPY = crippyicon.getImage();
        Image setCRIPPY = getCRIPPY.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        crippyBTN.setHorizontalAlignment(SwingConstants.CENTER);
        crippyBTN.setVerticalAlignment(SwingConstants.CENTER);
        crippyBTN.setIcon(new ImageIcon(setCRIPPY));
        JLabel crippyLB = new JLabel("<html>Stir-Fried Crispy Pork<br>with Basil<br>65 Baht</html>");
        crippyLB.setBounds(20, 570, 300, 300);
        crippyLB.setFont(new Font("Arial", Font.PLAIN, 14));
        crippyBTN.setBorderPainted(false);
        crippyBTN.setFocusPainted(false);
        contentPanel.add(crippyLB);
        contentPanel.add(crippyBTN);

        //8.ปูผัดผงกะหรี่
        JButton tccBTN = new JButton();
        tccBTN.setBounds(205, 590, 150, 100);
        ImageIcon tccicon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\ปูผัดผงกะหรี่.png");
        Image getTCC = tccicon.getImage();
        Image setTCC = getTCC.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        tccBTN.setHorizontalAlignment(SwingConstants.CENTER);
        tccBTN.setVerticalAlignment(SwingConstants.CENTER);
        tccBTN.setIcon(new ImageIcon(setTCC));
        JLabel tccLB = new JLabel("<html>Thai Crab Curry<br>450 Baht</html>");
        tccLB.setBounds(205, 560, 300, 300);
        tccLB.setFont(new Font("Arial", Font.PLAIN, 14));
        tccBTN.setBorderPainted(false);
        tccBTN.setFocusPainted(false);
        contentPanel.add(tccLB);
        contentPanel.add(tccBTN);

        //9.ผัดหอยลาย
        JButton stirclamsBTN = new JButton();
        stirclamsBTN.setBounds(20, 770, 150, 100);
        ImageIcon stirclamsicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Maincouse\\ผัดหอยลาย.png");
        Image getSTIRCLAMS = stirclamsicon.getImage();
        Image setSTIRCLAMS = getSTIRCLAMS.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        stirclamsBTN.setHorizontalAlignment(SwingConstants.CENTER);
        stirclamsBTN.setVerticalAlignment(SwingConstants.CENTER);
        stirclamsBTN.setIcon(new ImageIcon(setSTIRCLAMS));
        JLabel stirclamsLB = new JLabel("<html>Stir-fried Clams<br>with Chilli Paste<br>400 Baht</html>");
        stirclamsLB.setBounds(20, 750, 300, 300);
        stirclamsLB.setFont(new Font("Arial", Font.PLAIN, 14));
        stirclamsBTN.setBorderPainted(false);
        stirclamsBTN.setFocusPainted(false);
        contentPanel.add(stirclamsLB);
        contentPanel.add(stirclamsBTN);

        //10.ผัดผักบุ้ง
        JButton smgBTN = new JButton();
        smgBTN.setBounds(205, 770, 150, 100);
        ImageIcon smgicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Maincouse\\ผัดผักบุ้ง.png");
        Image getSMG = smgicon.getImage();
        Image setSMG = getSMG.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        smgBTN.setHorizontalAlignment(SwingConstants.CENTER);
        smgBTN.setVerticalAlignment(SwingConstants.CENTER);
        smgBTN.setIcon(new ImageIcon(setSMG));
        JLabel smgLB = new JLabel("<html>Stir-Fried Chinese<br>Morning Glory<br>100 Baht</html>");
        smgLB.setBounds(205, 750, 300, 300);
        smgLB.setFont(new Font("Arial", Font.PLAIN, 14));
        smgBTN.setBorderPainted(false);
        smgBTN.setFocusPainted(false);
        contentPanel.add(smgLB);
        contentPanel.add(smgBTN);

        //11.แกงมัสมั่นไก่
        JButton cmmBTN = new JButton();
        cmmBTN.setBounds(20, 940, 150, 100);
        ImageIcon cmmicon = new ImageIcon(
                        ".\\Frontend\\Photo\\Maincouse\\แกงมัสมั่นไก่.png");
        Image getCMM = cmmicon.getImage();
        Image setCMM = getCMM.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        cmmBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cmmBTN.setVerticalAlignment(SwingConstants.CENTER);
        cmmBTN.setIcon(new ImageIcon(setCMM));
        JLabel cmmLB = new JLabel("<html>Chicken Massaman<br>220 Baht</html>");
        cmmLB.setBounds(20, 920, 300, 300);
        cmmLB.setFont(new Font("Arial", Font.PLAIN, 14));
        cmmBTN.setBorderPainted(false);
        cmmBTN.setFocusPainted(false);
        contentPanel.add(cmmLB);
        contentPanel.add(cmmBTN);

        //12.ผัดไท
        JButton ptBTN = new JButton();
        ptBTN.setBounds(205, 940, 150, 100);
        ImageIcon pticon = new ImageIcon(
                        ".\\Frontend\\Photo\\Maincouse\\ผัดไท.png");
        Image getPT = pticon.getImage();
        Image setPT = getPT.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        ptBTN.setHorizontalAlignment(SwingConstants.CENTER);
        ptBTN.setVerticalAlignment(SwingConstants.CENTER);
        ptBTN.setIcon(new ImageIcon(setPT));
        JLabel ptLB = new JLabel("<html>Pad Thai<br>70 Baht</html>");
        ptLB.setBounds(205, 920, 300, 300);
        ptLB.setFont(new Font("Arial", Font.PLAIN, 14));
        ptBTN.setBorderPainted(false);
        ptBTN.setFocusPainted(false);
        contentPanel.add(ptLB);
        contentPanel.add(ptBTN);

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
        Maincouse.setContentPane(scrollPane);

        // กดแล้วไปหน้า CartUI
        cartBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new CartUI();
                        Maincouse.dispose();

                }
        });

        Maincouse.setVisible(true);
        Maincouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}