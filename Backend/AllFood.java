package Backend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// รวมอาหารทั้งหมดที่มีในเมนู
public class AllFood {
    private static final String CSV_FILE = "./FileCSV/Food.csv";
    public List<Food> readFoodFromCSV(){
        List<Food> foods = new ArrayList<>();
        String line;
        boolean isHeader = true; // Flag เพื่อข้ามบรรทัด Header
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; // ข้ามบรรทัดแรกที่เป็น Header
                    continue;
                }
                
                String[] data = line.split(",");

                // ตรวจสอบว่ามีข้อมูลครบ 4 คอลัมน์หรือไม่ (SKU, Name, Price, Stock)
                if (data.length == 3) {
                    try {
                        String ID = data[0].trim();
                        String Name = data[1].trim();
                        // แปลง String เป็น double
                        double Price = Double.parseDouble(data[2].trim());
                        Food food = new Food(ID, Price, Name);
                        foods.add(food);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping line due to invalid number format: " + line);
                    }
                }
            }
            System.out.println("Loaded " + foods.size() + " products from " + CSV_FILE);

        } catch (IOException e) {
            System.err.println("Could not read file " + CSV_FILE + ". Starting with empty inventory.");
            // หากไฟล์ไม่มีอยู่จริง ให้คืนค่ารายการว่าง
        }
        return foods;
    }
}
