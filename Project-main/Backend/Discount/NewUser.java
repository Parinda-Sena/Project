package Backend.Discount;

import Backend.FoodCart;
import Backend.TotalFood;
import java.util.HashSet;
import java.util.Set;

public class NewUser implements DiscountStrategy {
    private static final Set<String> usedUsers = new HashSet<>(); // เก็บว่า user คนไหนเคยใช้คูปอง NewUser แล้วบ้าง 
    private static final double DISCOUNT_RATE = 0.10; // ส่วนลด 10%
    private final String userId; // รับ userId

    public NewUser(String userId) {
        this.userId = userId;
    }

    @Override
    public double calculatePrice(TotalFood food) { //คำนวณราคาของแต่ละรายการอาหาร
        return food.getFood().getPrice() * food.getQuantity(); //คืนค่าราคาต่อชิ้น * จำนวน
    }

    @Override
    public double applyDiscount(double total) { //
        return total * (1 - DISCOUNT_RATE); //คืนค่าราคาหลังหักส่วนลด10%
    }

    @Override
    public double calculatePrice(FoodCart cart) { //คำนวณราคาทั้งหมดในตะกร้า
        double total = 0;
        for (TotalFood f : cart.getFoods()) { //บวกราคาของแต่ละ TotalFood ลงใน total
            total += f.getFood().getPrice() * f.getQuantity();
        }

        // ตรวจสอบว่า user เคยใช้ส่วนลดหรือยัง
        if (!usedUsers.contains(userId)) {
            usedUsers.add(userId);
            return applyDiscount(total); // ถ้ายังไม่เคยใช้ add userId ลง usedUsers แล้วลดราคา คืนค่าราคาหลังหักส่วนลด 10%
        }
        return total; // ถ้าใช้แล้วคืนค่าราคาเต็ม
    }
}
