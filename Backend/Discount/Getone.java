package Backend.Discount;

import Backend.FoodCart;
import Backend.TotalFood;


public class Getone implements DiscountStrategy {

    @Override
    public double calculatePrice(TotalFood item) { //อยู่ TotalFood

        if (item.getQuantity() >= 2) {
            int freeItems = item.getQuantity() / 2; // จำนวนสินค้าที่ได้ฟรี
            int payableItems = item.getQuantity() - freeItems; // จำนวนสินค้าที่ต้องจ่ายเงิน
            return payableItems * item.getFood().getPrice();
        } if(item.getQuantity() == 1) {
            return item.getQuantity() * item.getFood().getPrice();
        } else {
            return 0; //ไม่มีอาหารในตะกร้า
        }
        
    }

    @Override
    public double applyDiscount(double total) {
        return total; //อยู่ DiscountStrategy
    }

    @Override
    public double calculatePrice(FoodCart cart) { // ส่งไปคำนวณใน FoodCart ก่อนจะส่งไปคำนวณต่อใน PricingService
        double total = 0.0;
        for (TotalFood tf : cart.getFoods()) {
            total += calculatePrice(tf); // ใช้ method calculatePrice(TotalFood)
        }
        return total;
    }


}