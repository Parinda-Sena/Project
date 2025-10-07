package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CartUI {
    public CartUI(){
        JFrame CartUI = new JFrame("Meow Ordering");
        CartUI.setSize(400, 700);
        CartUI.setIconImage(
                new ImageIcon(
                        ".\\Frontend\\Photo\\Logo\\LogoJFrame.png")
                        .getImage());

        // ตั้งสีพื้นหลังของ JFrame
        CartUI.getContentPane().setBackground(new Color(255, 255, 204));
        CartUI.setLayout(null);
        CartUI.setResizable(false);
        CartUI.setLocationRelativeTo(null);

        // Label "Cart"
        JLabel mainLabel = new JLabel("Cart", SwingConstants.CENTER);
        mainLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setOpaque(true);
        mainLabel.setBackground(new Color(150, 50, 40));
        mainLabel.setSize(150, 40);
        int x = (CartUI.getWidth() - mainLabel.getWidth()) / 2;
        int y = 20;
        mainLabel.setLocation(x, y);
        CartUI.add(mainLabel);

        // ปุ่มย้อนกลับ
        JButton backBTN = new JButton();
        backBTN.setBounds(10, 20, 40, 40);
        ImageIcon backicon = new ImageIcon(".\\Frontend\\Photo\\other\\Back.png");
        Image getBack = backicon.getImage().getScaledInstance(100, 100,
                Image.SCALE_SMOOTH);
        backBTN.setIcon(new ImageIcon(getBack));
        backBTN.setBackground(Color.WHITE); // ✅ ให้ปุ่มเข้ากับพื้นหลัง
        backBTN.setHorizontalAlignment(SwingConstants.CENTER);
        CartUI.add(backBTN);
        // กดแล้วไปหน้า Mainmenu
        backBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        // เปิดหน้า CartUI
                        new MainMenu();
                        CartUI.dispose();

                }
        });


        //ชื่อ
        JLabel nameLabel = new JLabel("Name : ");
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setSize(100, 30);
        nameLabel.setLocation(18, 80);
        CartUI.add(nameLabel);


        //รายการอาหาร
        JPanel itemPanal = new JPanel();
        itemPanal.setBounds(18,120,350,250);
        itemPanal.setBackground(new Color(255, 128, 0));
        CartUI.add(itemPanal);
        JLabel itemLabel = new JLabel("Item 1");
        itemLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        itemLabel.setForeground(Color.BLACK);
        itemLabel.setSize(100, 30);
        itemLabel.setLocation(25, 80);
        itemPanal.add(itemLabel);

        //โปรโมชัน
        JPanel promoPanal = new JPanel();
        promoPanal.setBounds(18,390,350,50);
        promoPanal.setBackground(new Color(255, 128, 0));
        promoPanal.setLayout(null);
        CartUI.add(promoPanal);

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
        totalPanal.setBounds(18,460,350,130);
        totalPanal.setBackground(new Color(255, 128, 0));
        totalPanal.setLayout(null);
        CartUI.add(totalPanal);

        //Subtotal
        JLabel totalLabel = new JLabel("Subtotals for order : ");
        totalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        totalLabel.setForeground(Color.BLACK);
        totalLabel.setSize(200, 30);
        totalLabel.setBounds(10, 10, 200, 30);
        totalPanal.add(totalLabel);

        //Discount
        JLabel discountLabel = new JLabel("Discount : ");
        discountLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        discountLabel.setForeground(Color.BLACK);
        discountLabel.setSize(200, 30);
        discountLabel.setBounds(10, 50, 200, 30);
        totalPanal.add(discountLabel);

        //Total
        JLabel finalLabel = new JLabel("Total : ");
        finalLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        finalLabel.setForeground(Color.BLACK);
        finalLabel.setSize(200, 30);
        finalLabel.setBounds(10, 90, 200, 30);
        totalPanal.add(finalLabel);

        //ปุ่มคำนวณเงิน
        JButton totalBTN = new JButton("Checkout");
        totalBTN.setBounds(100, 610, 200, 40);
        totalBTN.setBackground(new Color(150, 50, 40));
        totalBTN.setForeground(Color.WHITE);
        totalBTN.setFont(new Font("SansSerif", Font.BOLD, 18));
        CartUI.add(totalBTN);

    

        CartUI.setVisible(true);
        CartUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }
    
}
