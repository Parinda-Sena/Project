package Backend.Discount;

import Backend.FoodCart;
import Backend.TotalFood;

public class Getone implements DiscountStrategy {

    @Override
    public double calculatePrice(TotalFood item) {
        int quantity = item.getQuantity();
        double price = item.getFood().getPrice();
        int quantityToPay = (quantity / 2) + (quantity % 2);
        return price * quantityToPay;
    }

    @Override
    public double applyDiscount(double total) {
        return total;
    }

    @Override
    public double calculatePrice(FoodCart food) {
        double total = 0;
        for (TotalFood item : food.getFoods()) {
            total += calculatePrice(item); // ใช้ logic ซื้อ 1 แถม 1
        }
        return total;
    }
    
}