package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import Backend.FoodCart;
import Backend.TotalFood;
import Backend.Discount.DiscountStrategy;
import Backend.Discount.Getone;
import Backend.Discount.OnehundredOff;
import Backend.Food;

public class CartUI {

    /*
     * หน้าหลักของตะกร้า
     */

    private final JFrame frame;
    private final FoodCart cart; // ตะกร้าที่เก็บอาหารทั้งหมด

    // ส่วนที่แสดงรายการสินค้า (เดิมคือ itemPanal)
    private final JPanel itemPanal; // ไว้แสดงรายการอาหารทั้งหมดที่สั่ง

    // Labels สำหรับแสดงยอด
    private final JLabel subtotalLabelValue; // Subtotals for order : "
    private final JLabel discountLabelValue; // Discount : "
    private final JLabel finalLabelValue; // Total :

    public CartUI(FoodCart cart, String username) { // cart รายการอาหารทั้งหมด username ชื่อจาก Login
        this.cart = cart;
        this.frame = new JFrame("Meow Ordering");

        // Initialize final fields to temporary values to avoid compile errors
        subtotalLabelValue = new JLabel("0.00");
        discountLabelValue = new JLabel("0.00");
        finalLabelValue = new JLabel("0.00");

        frame.setSize(400, 700);
        frame.setIconImage(new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());

        // ตั้งสีพื้นหลังของ JFrame
        frame.getContentPane().setBackground(new Color(255, 255, 204));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JLabel cat = new JLabel();
        cat.setBounds(270, 450, 300, 300);
        ImageIcon caticon = new ImageIcon(".\\Frontend\\Photo\\Logo\\แมว.png");
        Image getCAT = caticon.getImage();
        Image setCAT = getCAT.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        cat.setIcon(new ImageIcon(setCAT));
        frame.add(cat);

        // Label "Cart"
        JLabel mainLabel = new JLabel("Cart", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(150, 50, 40));
        mainLabel.setSize(150, 40);
        int x = (frame.getWidth() - mainLabel.getWidth()) / 2;
        int y = 20;
        mainLabel.setLocation(x, y);
        frame.add(mainLabel);

        // ปุ่มย้อนกลับ
        JButton backBTN = new JButton();
        backBTN.setBounds(10, 20, 40, 40);
        ImageIcon backicon = new ImageIcon(".\\Frontend\\Photo\\other\\Back.png");
        Image getBack = backicon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        backBTN.setIcon(new ImageIcon(getBack));
        backBTN.setBackground(Color.WHITE);
        backBTN.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(backBTN);
        backBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu(username);
                frame.dispose();
            }
        });

        // ชื่อ
        JLabel nameLabel = new JLabel("Name : " + username);
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setSize(300, 30);
        nameLabel.setLocation(18, 80);
        frame.add(nameLabel);

        // รายการอาหาร
        itemPanal = new JPanel();
        itemPanal.setBounds(18, 120, 350, 250);
        itemPanal.setBackground(new Color(255, 128, 0));
        // ใช้ BoxLayout แนวตั้งภายใน panel เพื่อวางรายการทีละแถว
        // (ไม่เปลี่ยนขนาด/ตำแหน่งของ panel)
        itemPanal.setLayout(new BoxLayout(itemPanal, BoxLayout.Y_AXIS)); // ใช้เรียงอาหารเป็นแนวตั้ง
        frame.add(itemPanal);
        // แต่ละบรรทัดจะถูกเพิ่มจาก refreshTable()

        // โปรโมชัน
        JPanel promoPanal = new JPanel();
        promoPanal.setBounds(18, 390, 350, 50);
        promoPanal.setBackground(new Color(255, 128, 0));
        promoPanal.setLayout(null);
        frame.add(promoPanal);

        // ใส่โปรโมชัน
        JTextField promoEnter = new JTextField("Enter Promotion Code");
        promoEnter.setFont(new Font("SansSerif", Font.PLAIN, 18));
        promoEnter.setBackground(new Color(255, 255, 204));
        promoEnter.setForeground(Color.GRAY);
        promoEnter.setSize(200, 30);
        promoEnter.setBounds(10, 10, 200, 30);
        promoPanal.add(promoEnter);

        promoEnter.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (promoEnter.getText().equals("Enter Promotion Code")) { // ถ้าคำบนกล่องกรอกโปรโมชันตรงกับ Enter
                                                                           // Promotion Code กดตรงกล่องแล้วจะหายไป
                    promoEnter.setText("");
                    promoEnter.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) { // เมื่อกดตรงอื่น Enter Promotion Code จะกลับมาเหมือนเดิม
                if (promoEnter.getText().isEmpty()) {
                    promoEnter.setForeground(Color.GRAY);
                    promoEnter.setText("Enter Promotion Code");
                }
            }
        });

        // ปุ่มใส่โปรโมชัน
        JButton promoBTN = new JButton("Apply");
        promoBTN.setBounds(260, 10, 80, 30);
        promoBTN.setBackground(new Color(255, 255, 204));
        promoBTN.setForeground(Color.BLACK);
        promoBTN.setFont(new Font("SansSerif", Font.BOLD, 16));
        promoBTN.setBorderPainted(false);
        promoBTN.setFocusPainted(false);
        promoPanal.add(promoBTN);

        promoBTN.addActionListener(e -> {
            int totalItems = 0;
            if (cart != null) {
                for (TotalFood tf : cart.getFoods()) {
                    totalItems += tf.getQuantity();
                }
            }
            String code = promoEnter.getText().trim().toUpperCase();
            DiscountStrategy strategy = null;
            switch (code) {
                case "GETONE":
                    if (totalItems >= 2) {
                        strategy = new Getone();
                        JOptionPane.showMessageDialog(frame, "Success");
                        promoEnter.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Cannot use this promo code");
                    }
                    break;
                case "100OFF":
                    strategy = new OnehundredOff();
                    JOptionPane.showMessageDialog(frame, "Success");
                    promoEnter.setText("");
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Invalid promo code");
                    if (cart != null) {
                        cart.pricingService.setDiscountStrategy(null);
                    }
                    break;

            }
            if (strategy != null && cart != null) {
                cart.pricingService.setDiscountStrategy(strategy); // โยน strategy ไปคำนวณกับ cart ใน pricingservice
                // ให้ PricingService คำนวณใหม่
            }
            updateTotalLabels(); // อัปเดตเงิน

        });

        // คำนวณเงิน
        JPanel totalPanal = new JPanel();
        totalPanal.setBounds(18, 460, 350, 130);
        totalPanal.setBackground(new Color(255, 128, 0));
        totalPanal.setLayout(null);
        frame.add(totalPanal);

        // Subtotal
        JLabel totalLabel = new JLabel("Subtotals for order : ");
        totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        totalLabel.setForeground(Color.BLACK);
        totalLabel.setSize(200, 30);
        totalLabel.setBounds(10, 10, 200, 30);
        totalPanal.add(totalLabel);

        subtotalLabelValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtotalLabelValue.setForeground(Color.BLACK);
        subtotalLabelValue.setBounds(220, 10, 120, 30);
        totalPanal.add(subtotalLabelValue);

        // Discount
        JLabel discountLabel = new JLabel("Discount : ");
        discountLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        discountLabel.setForeground(Color.BLACK);
        discountLabel.setSize(200, 30);
        discountLabel.setBounds(10, 50, 200, 30);
        totalPanal.add(discountLabel);

        discountLabelValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        discountLabelValue.setForeground(Color.BLACK);
        discountLabelValue.setBounds(220, 50, 120, 30);
        totalPanal.add(discountLabelValue);

        // Total
        JLabel finalLabel = new JLabel("Total : ");
        finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        finalLabel.setForeground(Color.BLACK);
        finalLabel.setSize(200, 30);
        finalLabel.setBounds(10, 90, 200, 30);
        totalPanal.add(finalLabel);

        finalLabelValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        finalLabelValue.setForeground(Color.BLACK);
        finalLabelValue.setBounds(220, 90, 120, 30);
        totalPanal.add(finalLabelValue);

        // ปุ่มคำนวณเงิน
        JButton totalBTN = new JButton("Checkout");
        totalBTN.setBounds(140, 610, 200, 40);
        totalBTN.setBackground(new Color(150, 50, 40));
        totalBTN.setForeground(Color.WHITE);
        totalBTN.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(totalBTN);

        // action: กดชำระเงิน
        totalBTN.addActionListener(e -> {
            if (cart != null) {
                double finalPrice = cart.getFinalPrice();
                JOptionPane.showMessageDialog(frame, String.format("Total to pay: %.2f", finalPrice)); // บอกจำนวนเงิน
            } else if (cart == null) {
                JOptionPane.showMessageDialog(frame, "Cart is empty or not connected.");
            }
            cart.clearCart(); // เคลียร์รายการอาหารในตะกร้าให้หมด
            itemPanal.removeAll(); // ลบทุกอย่างที่แสดงบน itemPanal
            itemPanal.revalidate(); // มีการวาง Layout ใหม่หลังจากที่ลบไปกับ removeAll แล้ว
            itemPanal.repaint(); // ทำให้ลบแบบ real-time
            updateTotalLabels(); // อัปเดตยอดเงินให้เป็น 0

        });

        // แสดงรายการจาก cart ครั้งแรก
        refreshTable(); // วาดรายการอาหารใหม่จาก cart
        updateTotalLabels(); // คำนวณ subtotal, discount, total แล้วอัปเดตที่หน้าจอ

        JButton deleteBTN = new JButton("Delete");
        deleteBTN.setBounds(20, 610, 100, 40);
        deleteBTN.setBackground(new Color(200, 80, 60));
        deleteBTN.setForeground(Color.WHITE);
        deleteBTN.setFont(new Font("SansSerif", Font.BOLD, 16));
        frame.add(deleteBTN);
        deleteBTN.addActionListener(e -> new DeleteJFrame(this)); // รับการทำงานจาก DeleteJFrame
                                                                  // ในการลบรายการอาหารทั้งหมดที่เลือกโดยใส่ชื่อ
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public CartUI(String username) {
        this(Backend.CartStore.getCart(), username);
    }

    // public เพื่อให้ MainMenu เรียกเมื่อมีการเพิ่มสินค้า
    public void refreshTable() { // วาดรายการอาหารใหม่จาก cart
        SwingUtilities.invokeLater(() -> {
            itemPanal.removeAll();
            for (TotalFood tf : new ArrayList<>(cart.getFoods())) { // copy ป้องกัน concurrent
                Food f = tf.getFood();
                int qty = tf.getQuantity();

                // สร้าง panel แถวเดียว (ไม่แตะขนาดหลักของหน้าตา)
                JPanel row = new JPanel();
                row.setLayout(new FlowLayout(FlowLayout.LEFT));
                row.setOpaque(false);

                JLabel name = new JLabel(f.getfoodName() + " x" + qty);
                name.setFont(new Font("SansSerif", Font.PLAIN, 16));
                row.add(name);

                JLabel price = new JLabel(String.format("  %.2f", f.getPrice() * qty));
                price.setFont(new Font("SansSerif", Font.PLAIN, 16));
                row.add(price);

                row.setAlignmentX(Component.LEFT_ALIGNMENT);
                itemPanal.add(Box.createVerticalStrut(6));
                itemPanal.add(row);
            }
            itemPanal.revalidate();
            itemPanal.repaint();
        });

    }

    public void updateTotalLabels() { // คำนวณ subtotal, discount, total แล้วอัปเดตที่หน้าจอ
        double subtotal = cart.getOriginalPrice();
        double total = cart.getFinalPrice();
        double discount = subtotal - total;

        subtotalLabelValue.setText(String.format("%.2f", subtotal));
        discountLabelValue.setText(String.format("%.2f", discount));
        finalLabelValue.setText(String.format("%.2f", total));
    }

}