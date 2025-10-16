package Backend.Discount;
import Backend.FoodCart;
import Backend.TotalFood;

public  class OnehundredOff implements DiscountStrategy {

    @Override
    public double calculatePrice(TotalFood food) {
        return applyDiscount(food.getTotalPrice());
    }

    @Override
    public double applyDiscount(double originalPrice) {
        final double MINIMUM_PURCHASE = 250.0; //ราคาสั่งซื้อขั้นต่ำ
        final double DISCOUNT_AMOUNT = 100.0; //ส่วนลด 100 บาท
        if (originalPrice >= MINIMUM_PURCHASE) {
            // คืนค่าราคาหลังหักส่วนลด 100 บาท
            return originalPrice - DISCOUNT_AMOUNT;
        } else {
            // ซื้อไม่ถึง 250 บาท ไม่ได้ส่วนลด
            return originalPrice;
        }
    }

    @Override
    public double calculatePrice(FoodCart cart) {
        double originalPrice = cart.getOriginalPrice();
        return applyDiscount(originalPrice);
    }
}
