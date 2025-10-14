package Backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Backend.Discount.ProductNotFoundException;

// รวมอาหารทั้งหมดที่มีในเมนู
public class AllFood {
    private static final String CSV_FILE = "./FileCSV/Food.csv";
    private List<Food> foods;

    public AllFood() {
        this.foods = readFoodFromCSV();
    }

    public static List<Food> readFoodFromCSV() {
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

                // ตรวจสอบว่ามีข้อมูลครบ 4 คอลัมน์หรือไม่ (ID, Name, Price, Available)
                if (data.length >= 3) {
                    try {
                        String ID = data[0].trim();
                        String Name = data[1].trim();
                        // แปลง String เป็น double
                        double Price = Double.parseDouble(data[2].trim());
                        boolean available = true;
                        if (data.length >= 4) {
                            available = Boolean.parseBoolean(data[3].trim());
                        }
                        Food food = new Food(ID, Name, Price);

                        foods.add(food);
                        food.setAvailable(available);
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

    public Food getFoodByID(String foodID) throws ProductNotFoundException { // ใช้ใน FoodCart หารหัสอาหาร
        for (Food food : readFoodFromCSV()) {
            if (food.getfoodID().equals(foodID)) {
                return food;
            }
        }
        throw new ProductNotFoundException("Food not found: " + foodID);
    }

    // ใช้ใน GUI เพื่อหา ID จากชื่ออาหาร
    public String getFoodIDByName(String name) throws ProductNotFoundException {
        for (Food food : readFoodFromCSV()) {
            if (food.getfoodName().equalsIgnoreCase(name)) {
                return food.getfoodID();
            }
        }
        throw new ProductNotFoundException("not found in menu");
    }

    public List<Food> getAllFoods() {
        return foods;
    }

    // บันทึกรายการอาหารลง csv(ใช้สำหรับเซ็ท Available)
    public void saveFoodToCSV(List<Food> foods) {
        try (FileWriter writer = new FileWriter("./FileCSV/Food.csv")) {
            writer.write("ID,Name,Price,Available\n");
            for (Food f : foods) {
                writer.write(String.format("%s,%s,%.2f,%s\n",
                    f.getfoodID(),
                    f.getfoodName(),
                    f.getPrice(),
                    f.isAvailable()));
            }
            
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
