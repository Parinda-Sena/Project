package GUI;

import java.awt.*;
import javax.swing.*;
import Backend.*;

public class DeleteJFrame {
    private JTextField foodnamefield; 
    private FoodCart cart; // ตะกร้าอาหารที่ใช้ทั่วทั้งโปรแกรม ที่อยู่ใน FoodCart
    private CartUI cartUI; // เชื่อมกับหน้า CartUI เพื่อให้ลบอาหารทันที

    public DeleteJFrame(CartUI cartUI) {
        this.cartUI = cartUI;
        this.cart = CartStore.getCart(); // ดึงตะกร้าที่อยู่ทั่วทั้งโปรแกรมผ่าน CartStore

        JFrame frame = new JFrame("Meow Ordering(Delete Item)");
        frame.setIconImage(
                new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(255, 255, 204));
        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel("Delete Item", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBackground(new Color(150, 50, 40));
        title.setBounds(125, 20, 150, 40);
        frame.add(title);

        JLabel nameLabel = new JLabel("Food name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBounds(20, 80, 120, 25);
        frame.add(nameLabel);

        foodnamefield = new JTextField();
        foodnamefield.setBounds(140, 80, 200, 25);
        frame.add(foodnamefield);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(150, 120, 100, 30);
        frame.add(deleteBtn);

        deleteBtn.addActionListener(e -> {
            String name = foodnamefield.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a food name!"); // ถ้าไม่กรอกชื่ออาหาร
                return;
            }

            boolean removed = false;
            for (int i = 0; i < cart.getFoods().size(); i++) { // วนดูรายชื่ออาหารไปเรื่อยๆ
                TotalFood tf = cart.getFoods().get(i);
                Food f = tf.getFood();
                if (f.getfoodName().equalsIgnoreCase(name)) {
                    cart.getFoods().remove(i);// ถ้าพบชื่อตรงกัน ให้ลบออก
                    removed = true; 
                    break;
                }
            }

            if (removed) {
                JOptionPane.showMessageDialog(frame, "Item deleted successfully!");
                cartUI.refreshTable(); // อัปเดตรายการอาหาร
                cartUI.updateTotalLabels(); // อัปเดตราคารวม
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Food not found in cart!");
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}