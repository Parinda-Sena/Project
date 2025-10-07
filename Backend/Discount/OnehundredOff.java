package Backend.Discount;
import Backend.FoodCart;
import Backend.TotalFood;

public  class OnehundredOff implements DiscountStrategy {

    @Override
    public double calculatePrice(TotalFood food) {
        return applyDiscount(food.getTotalPrice());
    }

    @Override
    public double applyDiscount(double total) {
        final double MINIMUM_PURCHASE = 250.0;
        final double DISCOUNT_AMOUNT = 100.0;
        if (total >= MINIMUM_PURCHASE) {
            // คืนค่าราคาหลังหักส่วนลด 100 บาท
            return total - DISCOUNT_AMOUNT;
        } else {
            // ซื้อไม่ถึง 250 บาท ไม่ได้ส่วนลด
            return total;
        }
    }

    @Override
    public double calculatePrice(FoodCart food) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePrice'");
    }
}
