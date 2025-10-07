package Backend;
import java.util.ArrayList;

import Backend.Discount.DefaultPrice;
import Backend.Discount.DiscountStrategy;
import Backend.Discount.Getone;
import Backend.Discount.OnehundredOff;

// คำนวณราคาทั้งหมดพร้อมส่วนลด
public class PricingService {

    //เก็บส่วนลดที่มี
    private record CalculateDiscount(DiscountStrategy strategy) {}

    //เก็บแก๊งส่วนลดทั้งหลายๆแบบ
    private final ArrayList<CalculateDiscount> discountStrategies = new ArrayList<>();
    
    //ไม่มีส่วนลด
    private final DiscountStrategy defaultStrategy = new DefaultPrice();

    //เพิ่มส่วนลดใหม่มาคำนวณด้วย
    public void addDiscountStrategy(DiscountStrategy strategy) {
        discountStrategies.add(new CalculateDiscount(strategy));
    }

    //คำนวณราคาทั้งหมดก่อนใช้ส่วนลด
    public double calculateOriginalPrice(FoodCart cart) {
        double total = 0.0;
        for (TotalFood food : cart.foods) {
            total += defaultStrategy.calculatePrice(food);
        }
        return total;
    }

    //คำนวณราคาทั้งหมดหลังใช้ส่วนลด
    // คำนวณราคาหลังใช้ส่วนลดทั้งหมด
    public double calculateFinalPrice(FoodCart cart) {
        double total = 0.0;

        if (!discountStrategies.isEmpty()) {
            // ถ้ามีส่วนลด ให้ใช้ตัวแรกที่รองรับการคำนวณ (รองรับแบบซื้อ 1 แถม 1)
            for (CalculateDiscount cd : discountStrategies) {
                DiscountStrategy strategy = cd.strategy();

                try {
                    // ลองใช้ method calculatePrice(FoodCart) ถ้าทำได้
                    total = strategy.calculatePrice(cart);
                    break; // ใช้แค่ตัวแรกที่ใช้ได้
                } catch (UnsupportedOperationException e) {
                    // ถ้าใช้ไม่ได้ (เช่น strategy นั้นไม่รองรับ calculatePrice(FoodCart))
                    // ให้ใช้ราคาปกติ แล้ว applyDiscount กับยอดรวม
                    total = calculateOriginalPrice(cart);
                    total = strategy.applyDiscount(total);
                }
            }
        } else {
            // ไม่มีส่วนลด → ราคาเต็ม
            total = calculateOriginalPrice(cart);
        }

        return total;
    }
        
    
}
