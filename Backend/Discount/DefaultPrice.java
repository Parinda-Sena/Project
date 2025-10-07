package Backend.Discount;
import Backend.FoodCart;
import Backend.TotalFood;

public class DefaultPrice implements DiscountStrategy {

    @Override
    public double calculatePrice(TotalFood food) {
        return food.getFood().getPrice() * food.getQuantity();
    }

    @Override
    public double applyDiscount(double total) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyDiscount'");
    }

    @Override
    public double calculatePrice(FoodCart food) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePrice'");
    }

    
}
