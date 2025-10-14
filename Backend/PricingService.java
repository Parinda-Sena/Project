package Backend;

import Backend.Discount.*;
public class PricingService {

    // เก็บส่วนลดที่เลือกใช้แค่ตัวเดียว
    private DiscountStrategy discountStrategy = null;

    // ไม่มีส่วนลด
    private final DiscountStrategy defaultStrategy = new DefaultPrice();

    // ตั้งส่วนลดใหม่ (หรือเคลียร์ถ้า null)
    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    // คำนวณราคาก่อนส่วนลด (ราคาเต็ม)
    public double calculateOriginalPrice(FoodCart cart) {
        double total = 0.0;
        for (TotalFood food : cart.getFoods()) {// วนลูปทุกเมนูในตะกร้า
            total += defaultStrategy.calculatePrice(food);
        }
        return total;
    }

    // คำนวณราคาหลังใช้ส่วนลด (ถ้ามี)
    public double calculateFinalPrice(FoodCart cart) {
        if (discountStrategy == null) {
            return calculateOriginalPrice(cart); // ถ้าไม่มีส่วนลดในคืนค่าราคาปกติ
        }
        try {
            // ลองคำนวณราคาจาก strategy ถ้ารองรับ
            return discountStrategy.calculatePrice(cart);
        } catch (UnsupportedOperationException e) {
            // ถ้าไม่รองรับ calculatePrice(FoodCart) ให้ใช้ applyDiscount กับราคาปกติแทน
            double originalPrice = calculateOriginalPrice(cart);
            return discountStrategy.applyDiscount(originalPrice);
        }
    }

    // คำนวณราคาของอาหารเดี่ยว (ใช้ defaultStrategy)
    public double calculatePrice(Food food, int quantity) {
        return defaultStrategy.calculatePrice(new TotalFood(food, quantity));
    }
}