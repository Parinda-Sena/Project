package Backend.Discount;
import Backend.FoodCart;
import Backend.TotalFood;

public interface DiscountStrategy {
    /**
     * คำนวณราคาสุทธิสำหรับสินค้า 1 รายการ
     * 
     * @param food รายการสินค้าในตะกร้า
     * @return ราคาสุทธิหลังใช้โปรโมชัน
     */
    double calculatePrice(TotalFood food);
    double applyDiscount(double total);
    double calculatePrice(FoodCart food);
    
}
