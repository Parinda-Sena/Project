package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Backend.AllFood;
import Backend.CartStore;
import Backend.Food;
import Backend.FoodCart;
import Backend.PricingService;
import Backend.Discount.InvalidOperationException;
import Backend.Discount.ProductNotFoundException;

public class MainMenu {

    // สร้าง backend objects ที่จะใช้ร่วมทั้งหน้า
    public final AllFood allFood;
    public final PricingService pricingService;
    private final FoodCart cart = CartStore.getCart();

    public MainMenu(String username) {
        // สร้าง AllFood / PricingService / FoodCart
        this.pricingService = new PricingService();
        // ✅ โหลดข้อมูลอาหารจากคลาส AllFood (ซึ่งอ่าน CSV มาแล้ว)
        allFood = new AllFood();
        // ✅ ไม่ต้องสร้าง cart ใหม่ — ใช้ cart จาก CartStore
        FoodCart cart = CartStore.getCart();

        JFrame mainmenu = new JFrame("Meow Ordering");
        // mainmenu.setLocationRelativeTo(null);
        mainmenu.setLayout(null);
        mainmenu.setSize(400, 700);
        mainmenu.setIconImage(new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
        mainmenu.getContentPane().setBackground(new Color(255, 255, 204));
        mainmenu.setResizable(false);
        mainmenu.setLocationRelativeTo(null);

        ImageIcon usericon = new ImageIcon("./Frontend/Photo/other/User.png");
        Image img = usericon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(-118, -100, 300, 300);
        mainmenu.add(label);

        JLabel n = new JLabel("Name : " + username);
        mainmenu.add(n);
        n.setBounds(60, 39, 200, 25);
        n.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel a = new JLabel("Meow Shop");
        mainmenu.add(a);
        a.setFont(new Font("Arial", Font.PLAIN, 50));
        a.setBounds(65, -40, 300, 300);

        // Appetizier
        JButton Appetizier = new JButton();
        Appetizier.setBounds(30, 160, 55, 55);
        ImageIcon appeicon = new ImageIcon(".\\Frontend\\Photo\\Appetizier\\Appetizier.png");
        Image getAppe = appeicon.getImage();
        Image setAppe = getAppe.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Appetizier.setHorizontalAlignment(SwingConstants.CENTER);
        Appetizier.setVerticalAlignment(SwingConstants.CENTER);
        Appetizier.setIcon(new ImageIcon(setAppe));
        JLabel appLabel = new JLabel("Appetizier");
        appLabel.setBounds(26, 80, 300, 300);
        appLabel.setFont(new Font("Arial", Font.BOLD, 13));
        Appetizier.setBorderPainted(false);
        Appetizier.setFocusPainted(false);
        mainmenu.add(appLabel);
        mainmenu.add(Appetizier);
        // กดแล้วไปหน้า Appetizier
        Appetizier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เปิดหน้า Appetizire
                new Appetizire(username);
                mainmenu.dispose();

            }
        });

        // Main couse
        JButton Maincouse = new JButton();
        Maincouse.setBounds(120, 160, 55, 55);
        ImageIcon maincouseicon = new ImageIcon(
                ".\\Frontend\\Photo\\Maincouse\\Maincouse.png");
        Image getMaincouse = maincouseicon.getImage();
        Image setMaincouse = getMaincouse.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Maincouse.setIcon(new ImageIcon(setMaincouse));
        Maincouse.setHorizontalAlignment(SwingConstants.CENTER);
        Maincouse.setVerticalAlignment(SwingConstants.CENTER);
        JLabel mainLabel = new JLabel("Main Couse");
        mainLabel.setBounds(113, 80, 300, 300);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 13));
        Maincouse.setBorderPainted(false);
        Maincouse.setFocusPainted(false);
        mainmenu.add(mainLabel);
        mainmenu.add(Maincouse);
        // กดแล้วไปหน้า Maincouse
        Maincouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เปิดหน้า Maincouse
                new Maincouse(username);
                mainmenu.dispose();

            }
        });

        // Dessert
        JButton Dessert = new JButton();
        Dessert.setBounds(210, 160, 55, 55);
        ImageIcon desserticon = new ImageIcon(".\\Frontend\\Photo\\Dessert\\Dessert.png");
        Image getDessert = desserticon.getImage();
        Image setDessert = getDessert.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Dessert.setHorizontalAlignment(SwingConstants.CENTER);
        Dessert.setVerticalAlignment(SwingConstants.CENTER);
        Dessert.setIcon(new ImageIcon(setDessert));
        JLabel dessertLabel = new JLabel("Dessert");
        dessertLabel.setBounds(213, 80, 300, 300);
        dessertLabel.setFont(new Font("Arial", Font.BOLD, 13));
        Dessert.setBorderPainted(false);
        Dessert.setFocusPainted(false);
        mainmenu.add(dessertLabel);
        mainmenu.add(Dessert);
        // กดแล้วไปหน้า Dessert
        Dessert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เปิดหน้า Dessert
                new Dessert(username);
                mainmenu.dispose();

            }
        });

        // Beverage
        JButton Beverage = new JButton();
        Beverage.setBounds(300, 160, 55, 55);
        ImageIcon bevicon = new ImageIcon(".\\Frontend\\Photo\\Beverage\\Beverage.png");
        Image getBev = bevicon.getImage();
        Image setBev = getBev.getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        Beverage.setHorizontalAlignment(SwingConstants.CENTER);
        Beverage.setVerticalAlignment(SwingConstants.CENTER);
        Beverage.setIcon(new ImageIcon(setBev));
        JLabel beverageLabel = new JLabel("Beverage");
        beverageLabel.setBounds(298, 80, 300, 300);
        beverageLabel.setFont(new Font("Arial", Font.BOLD, 13));
        Beverage.setBorderPainted(false);
        Beverage.setFocusPainted(false);
        mainmenu.add(beverageLabel);
        mainmenu.add(Beverage);
        // กดแล้วไปหน้า Beverage
        Beverage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // เปิดหน้า Beverage
                new Beverage(username);
                mainmenu.dispose();

            }
        });

        // Recommende Menu
        JLabel recommend = new JLabel("Recommened Menu");
        recommend.setBounds(20, 120, 300, 300);
        recommend.setFont(new Font("Arial", Font.PLAIN, 20));
        mainmenu.add(recommend);

        // ผัดกะเพรา
        JButton pwsBTN = new JButton();
        pwsBTN.setBounds(20, 290, 150, 100);
        ImageIcon porkwbasilicon = new ImageIcon(".\\Frontend\\Photo\\Maincouse\\ผัดกะเพรา.png");
        Image getPWS = porkwbasilicon.getImage();
        Image setPWS = getPWS.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        pwsBTN.setHorizontalAlignment(SwingConstants.CENTER);
        pwsBTN.setVerticalAlignment(SwingConstants.CENTER);
        pwsBTN.setIcon(new ImageIcon(setPWS));
        JLabel pwsLB = new JLabel("<html>Stir-Fried Minced Pork<br>with Basil<br>60 Baht</html>");
        pwsLB.setBounds(20, 270, 300, 300);
        pwsLB.setFont(new Font("Arial", Font.PLAIN, 14));
        pwsBTN.setBorderPainted(false);
        pwsBTN.setFocusPainted(false);
        mainmenu.add(pwsLB);
        mainmenu.add(pwsBTN);

        // ติด listener ให้ปุ่มรูป (ใช้ ID เพื่อเพิ่มเข้า cart)
        pwsBTN.addActionListener(e -> {
            try {
                // ✅ ตรวจว่าสินค้านี้ปิดขายไหม ก่อนเพิ่มลงตะกร้า
                Food food = allFood.getFoodByID("13");
                if (food != null && !food.isAvailable()) {
                    JOptionPane.showMessageDialog(null,
                            food.getfoodName() + " is currently disabled by admin!",
                            "Unavailable",
                            JOptionPane.WARNING_MESSAGE);
                    return; // ❌ หยุด ไม่ให้เพิ่มลงตะกร้า
                }

                // ✅ ถ้าพร้อมขายค่อยเพิ่ม
                String foodId = allFood.getFoodIDByName("Stir-Fried Minced Pork with Basil");
                cart.addFood(foodId, 1);
                JOptionPane.showMessageDialog(null, "Added to cart.");

            } catch (ProductNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidOperationException ex) {
                JOptionPane.showMessageDialog(null, "Cannot add product: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ข้าวผัดทะเล
        JButton sfrBTN = new JButton();
        sfrBTN.setBounds(220, 290, 150, 100);
        ImageIcon sfricon = new ImageIcon(".\\Frontend\\Photo\\Maincouse\\ข้าวผัดทะเล.png");
        Image getSFR = sfricon.getImage();
        Image setSFR = getSFR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        sfrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        sfrBTN.setVerticalAlignment(SwingConstants.CENTER);
        sfrBTN.setIcon(new ImageIcon(setSFR));
        JLabel sfrLB = new JLabel("<html>Seafood Fried Rice<br>70 Baht</html>");
        sfrLB.setBounds(220, 270, 300, 300);
        sfrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        sfrBTN.setBorderPainted(false);
        sfrBTN.setFocusPainted(false);
        mainmenu.add(sfrLB);
        mainmenu.add(sfrBTN);

        sfrBTN.addActionListener(e -> {
            try {
                // ✅ ตรวจว่าสินค้านี้ปิดขายไหม ก่อนเพิ่มลงตะกร้า
                Food food = allFood.getFoodByID("10");
                if (food != null && !food.isAvailable()) {
                    JOptionPane.showMessageDialog(null,
                            food.getfoodName() + " is currently disabled by admin!",
                            "Unavailable",
                            JOptionPane.WARNING_MESSAGE);
                    return; // ❌ หยุด ไม่ให้เพิ่มลงตะกร้า
                }

                // ✅ ถ้าพร้อมขายค่อยเพิ่ม
                String foodId = allFood.getFoodIDByName("Seafood Fried Rice");
                cart.addFood(foodId, 1);
                JOptionPane.showMessageDialog(null, "Added to cart.");

            } catch (ProductNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidOperationException ex) {
                JOptionPane.showMessageDialog(null, "Cannot add product: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ต้มยำกุ้ง
        JButton tygBTN = new JButton();
        tygBTN.setBounds(20, 460, 150, 100);
        ImageIcon tygicon = new ImageIcon(".\\Frontend\\Photo\\Maincouse\\ต้มยำกุ้ง.png");
        Image getTYG = tygicon.getImage();
        Image setTYG = getTYG.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        tygBTN.setHorizontalAlignment(SwingConstants.CENTER);
        tygBTN.setVerticalAlignment(SwingConstants.CENTER);
        tygBTN.setIcon(new ImageIcon(setTYG));
        JLabel tygLB = new JLabel("<html>Tom Yum Goong<br>60 Baht</html>");
        tygLB.setBounds(20, 430, 300, 300);
        tygLB.setFont(new Font("Arial", Font.PLAIN, 14));
        tygBTN.setBorderPainted(false);
        tygBTN.setFocusPainted(false);
        mainmenu.add(tygLB);
        mainmenu.add(tygBTN);

        tygBTN.addActionListener(e -> {
            try {
                // ✅ ตรวจว่าสินค้านี้ปิดขายไหม ก่อนเพิ่มลงตะกร้า
                Food food = allFood.getFoodByID("12");
                if (food != null && !food.isAvailable()) {
                    JOptionPane.showMessageDialog(null,
                            food.getfoodName() + " is currently disabled by admin!",
                            "Unavailable",
                            JOptionPane.WARNING_MESSAGE);
                    return; // ❌ หยุด ไม่ให้เพิ่มลงตะกร้า
                }

                // ✅ ถ้าพร้อมขายค่อยเพิ่ม
                String foodId = allFood.getFoodIDByName("Tom Yum Goong");
                cart.addFood(foodId, 1);
                JOptionPane.showMessageDialog(null, "Added to cart.");

            } catch (ProductNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidOperationException ex) {
                JOptionPane.showMessageDialog(null, "Cannot add product: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ไข่เจียว
        JButton omrBTN = new JButton();
        omrBTN.setBounds(220, 460, 150, 100);
        ImageIcon omricon = new ImageIcon(".\\Frontend\\Photo\\Maincouse\\ข้าวไข่เจียว.png");
        Image getOMR = omricon.getImage();
        Image setOMR = getOMR.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
        omrBTN.setHorizontalAlignment(SwingConstants.CENTER);
        omrBTN.setVerticalAlignment(SwingConstants.CENTER);
        omrBTN.setIcon(new ImageIcon(setOMR));
        JLabel omrLB = new JLabel("<html>Omlet Rice<br>30 Baht</html>");
        omrLB.setBounds(220, 430, 300, 300);
        omrLB.setFont(new Font("Arial", Font.PLAIN, 14));
        omrBTN.setBorderPainted(false);
        omrBTN.setFocusPainted(false);
        mainmenu.add(omrLB);
        mainmenu.add(omrBTN);

        omrBTN.addActionListener(e -> {
            try {
                // ✅ ตรวจว่าสินค้านี้ปิดขายไหม ก่อนเพิ่มลงตะกร้า
                Food food = allFood.getFoodByID("09");
                if (food != null && !food.isAvailable()) {
                    JOptionPane.showMessageDialog(null,
                            food.getfoodName() + " is currently disabled by admin!",
                            "Unavailable",
                            JOptionPane.WARNING_MESSAGE);
                    return; // ❌ หยุด ไม่ให้เพิ่มลงตะกร้า
                }

                // ✅ ถ้าพร้อมขายค่อยเพิ่ม
                String foodId = allFood.getFoodIDByName("Omelette");
                cart.addFood(foodId, 1);
                JOptionPane.showMessageDialog(null, "Added to cart.");

            } catch (ProductNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InvalidOperationException ex) {
                JOptionPane.showMessageDialog(null, "Cannot add product: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ปุ่มตะกร้าสินค้า
        JButton cartBTN = new JButton();
        cartBTN.setBounds(310, 30, 40, 40);
        cartBTN.setBackground(Color.WHITE);
        ImageIcon carticon = new ImageIcon(
                "./Frontend/Photo/other/ตะกร้าสินค้า.png");
        Image getCART = carticon.getImage();
        Image setCART = getCART.getScaledInstance(cartBTN.getWidth(), cartBTN.getHeight(), Image.SCALE_SMOOTH);
        cartBTN.setHorizontalAlignment(SwingConstants.CENTER);
        cartBTN.setVerticalAlignment(SwingConstants.CENTER);
        cartBTN.setIcon(new ImageIcon(setCART));
        cartBTN.setBorderPainted(false);
        cartBTN.setFocusPainted(false);
        mainmenu.add(cartBTN);

        // กดแล้วไปหน้า CartUI
        cartBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ส่ง cart ที่อยู่ใน MainMenu เข้าไปให้ CartUI แสดง
                new CartUI(cart, username);
                mainmenu.dispose();
            }
        });

        mainmenu.setVisible(true);
        mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
