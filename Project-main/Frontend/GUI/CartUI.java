package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Backend.FoodCart;
import Backend.TotalFood;
import Backend.Food;

public class CartUI {

    private final JFrame frame;
    private final FoodCart cart;

    // ส่วนที่แสดงรายการสินค้า (เดิมคือ itemPanal)
    private final JPanel itemPanal;

    // Labels สำหรับแสดงยอด
    private final JLabel totalLabelValue;    // แทนที่ "Subtotals for order : " ด้านบน
    private final JLabel discountLabelValue; // แทนที่ "Discount : "
    private final JLabel finalLabelValue;    // แทนที่ "Total : "

    public CartUI(FoodCart cart) {
        this.cart = cart;
        this.frame = new JFrame("Meow Ordering");

        frame.setSize(400, 700);
        frame.setIconImage(new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());

        // ตั้งสีพื้นหลังของ JFrame
        frame.getContentPane().setBackground(new Color(255, 255, 204));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

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
                new MainMenu();
                frame.dispose();
            }
        });

        //ชื่อ
        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setSize(100, 30);
        nameLabel.setLocation(18, 80);
        frame.add(nameLabel);

        //รายการอาหาร
        itemPanal = new JPanel();
        itemPanal.setBounds(18, 120, 350, 250);
        itemPanal.setBackground(new Color(255, 128, 0));
        // ใช้ BoxLayout แนวตั้งภายใน panel เพื่อวางรายการทีละแถว (ไม่เปลี่ยนขนาด/ตำแหน่งของ panel)
        itemPanal.setLayout(new BoxLayout(itemPanal, BoxLayout.Y_AXIS));
        frame.add(itemPanal);

        //โปรโมชัน
        JPanel promoPanal = new JPanel();
        promoPanal.setBounds(18, 390, 350, 50);
        promoPanal.setBackground(new Color(255, 128, 0));
        promoPanal.setLayout(null);
        frame.add(promoPanal);

        //ใส่โปรโมชัน
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
                if (promoEnter.getText().equals("Enter Promo Code")) {
                    promoEnter.setText("");
                    promoEnter.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (promoEnter.getText().isEmpty()) {
                    promoEnter.setForeground(Color.GRAY);
                    promoEnter.setText("Enter Promo Code");
                }
            }
        });

        //ปุ่มใส่โปรโมชัน
        JButton promoBTN = new JButton("Apply");
        promoBTN.setBounds(260, 10, 80, 30);
        promoBTN.setBackground(new Color(255, 255, 204));
        promoBTN.setForeground(Color.BLACK);
        promoBTN.setFont(new Font("SansSerif", Font.BOLD, 16));
        promoBTN.setBorderPainted(false);
        promoBTN.setFocusPainted(false);
        promoPanal.add(promoBTN);

        //คำนวณเงิน
        JPanel totalPanal = new JPanel();
        totalPanal.setBounds(18, 460, 350, 130);
        totalPanal.setBackground(new Color(255, 128, 0));
        totalPanal.setLayout(null);
        frame.add(totalPanal);

        //Subtotal 
        JLabel totalLabel = new JLabel("Subtotals for order : ");
        totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        totalLabel.setForeground(Color.BLACK);
        totalLabel.setSize(200, 30);
        totalLabel.setBounds(10, 10, 200, 30);
        totalPanal.add(totalLabel);

        totalLabelValue = new JLabel("0.00");
        totalLabelValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        totalLabelValue.setForeground(Color.BLACK);
        totalLabelValue.setBounds(220, 10, 120, 30);
        totalPanal.add(totalLabelValue);

        //Discount
        JLabel discountLabel = new JLabel("Discount : ");
        discountLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        discountLabel.setForeground(Color.BLACK);
        discountLabel.setSize(200, 30);
        discountLabel.setBounds(10, 50, 200, 30);
        totalPanal.add(discountLabel);

        discountLabelValue = new JLabel("0.00");
        discountLabelValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        discountLabelValue.setForeground(Color.BLACK);
        discountLabelValue.setBounds(220, 50, 120, 30);
        totalPanal.add(discountLabelValue);

        //Total 
        JLabel finalLabel = new JLabel("Total : ");
        finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        finalLabel.setForeground(Color.BLACK);
        finalLabel.setSize(200, 30);
        finalLabel.setBounds(10, 90, 200, 30);
        totalPanal.add(finalLabel);

        finalLabelValue = new JLabel("0.00");
        finalLabelValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        finalLabelValue.setForeground(Color.BLACK);
        finalLabelValue.setBounds(220, 90, 120, 30);
        totalPanal.add(finalLabelValue);

        //ปุ่มคำนวณเงิน
        JButton totalBTN = new JButton("Checkout");
        totalBTN.setBounds(100, 610, 200, 40);
        totalBTN.setBackground(new Color(150, 50, 40));
        totalBTN.setForeground(Color.WHITE);
        totalBTN.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(totalBTN);

        // action: กดชำระเงิน
        totalBTN.addActionListener(e -> {
            if (cart != null) {
                double finalPrice = cart.getFinalPrice();
                JOptionPane.showMessageDialog(frame, String.format("Total to pay: %.2f", finalPrice));
            } else {
                JOptionPane.showMessageDialog(frame, "Cart is empty or not connected.");
            }
        });

        // แสดงรายการจาก cart ครั้งแรก
        refreshTable();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CartUI() {
        this(Backend.CartStore.getCart());
    }

    // public เพื่อให้ MainMenu เรียกเมื่อมีการเพิ่มสินค้า
    public void refreshTable() {
        SwingUtilities.invokeLater(() -> {
            itemPanal.removeAll();

            if (cart == null || cart.getFoods().isEmpty()) {
                JLabel empty = new JLabel("No items in cart");
                empty.setFont(new Font("SansSerif", Font.PLAIN, 16));
                empty.setAlignmentX(Component.LEFT_ALIGNMENT);
                itemPanal.add(Box.createVerticalStrut(8));
                itemPanal.add(empty);
            } else {
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
            }

            // คำนวณยอด
            double subtotal = 0.0;
            double finalPrice = 0.0;
            double discount = 0.0;
            if (cart != null) {
                subtotal = cart.getOriginalPrice();
                finalPrice = cart.getFinalPrice();
                discount = subtotal - finalPrice;
            }

            totalLabelValue.setText(String.format("%.2f", subtotal));
            discountLabelValue.setText(String.format("%.2f", discount));
            finalLabelValue.setText(String.format("%.2f", finalPrice));

            itemPanal.revalidate();
            itemPanal.repaint();
        });
    }
}
