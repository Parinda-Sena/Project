package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.util.List;
import Backend.AllFood;
import Backend.Food;

public class AdminUI {
    private JFrame frame; // หน้าต่างของโปรแกรม
    private JTable table; // ตารางแสดงรายชื่ออาหาร
    private DefaultTableModel model; // ตัวควบคุม JTable
    private List<Food> foods; // รายการอาหารทั้งหมดใน AllFood

    public AdminUI() {
        frame = new JFrame("Meow Ordering(Admin Panel)");
        frame.setIconImage(
                new ImageIcon(".\\Frontend\\Photo\\Logo\\LogoJFrame.png").getImage());
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(255, 255, 204));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("🍔 Food List from AllFood", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setBackground(new Color(150, 50, 40));
        title.setBounds(0, 10, 500, 40);
        frame.add(title);

        //แสดงรายชื่ออาหาร
        String[] cols = { "Food Name", "Price", "Status" };
        model = new DefaultTableModel(cols, 0); // DefaultTableModel ช่วยให้เพิ่ม/ลดได้สะดวก
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 70, 400, 200);
        frame.add(scrollPane);

        // ✅ โหลดข้อมูลจาก AllFood
        AllFood allFood = new AllFood();
        foods = allFood.getAllFoods(); // allFood ดึงรายการอาหารจาก AllFood ใน csv มาเก็บใน foods 
        updateTable(); // เติมข้อมูลลงตาราง

        JButton toggleBtn = new JButton("Disable/Enable Status");
        toggleBtn.setBounds(140, 290, 200, 40);
        toggleBtn.setBackground(new Color(150, 50, 40));
        toggleBtn.setForeground(Color.WHITE);
        toggleBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
        frame.add(toggleBtn);

        toggleBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a food!");
                return;
            }

            Food f = foods.get(row); // ดึงอาหารที่เลือก
            f.setAvailable(!f.isAvailable()); // ควบคุมการเปลี่ยนสถานะ
            updateTable(); // อัปเดตตาราง

            // บันทึกสถานะกลับ csv
            allFood.saveFoodToCSV(foods);
        });

        frame.setVisible(true);
    }

    // เคลียร์ตารางแล้วแสดงข้อมูลใหม่จาก foods
    private void updateTable() {
        model.setRowCount(0);
        for (Food f : foods) {
            model.addRow(new Object[] {
                    f.getfoodName(),
                    f.getPrice(),
                    f.isAvailable() ? "✅ Available" : "❌ Disabled"
            });
        }
    }

    // บันทึกการกดลง csv
    private void saveToCSV() {
        try (FileWriter writer = new FileWriter("./FileCSV/Food.csv")) {
            writer.write("ID,Name,Price,Available\n");
            for (Food f : foods) {
                writer.write(String.format("%s,%s,%.2f,%s\n",
                        f.getfoodID(), f.getfoodName(), f.getPrice(), f.isAvailable()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error saving to CSV!");
        }
    }
}