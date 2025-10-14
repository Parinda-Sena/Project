package Backend;
import Backend.Discount.*;

public class Test {
    public static void main(String[] args) throws Exception {

        // 1. Prepare food menu manually
        Food omelette = new Food("09", "Omelette", 30.0);
        Food lemonIceCream = new Food("25", "Lemon Ice Cream", 29.0);
        Food water = new Food("33", "Water", 15.0);

        // 2. Create AllFood stub (skip CSV)
        AllFood menu = new AllFood() {
            @Override
            public Food getFoodByID(String foodID) throws ProductNotFoundException {
                return switch (foodID) {
                    case "09" -> omelette;
                    case "25" -> lemonIceCream;
                    case "33" -> water;
                    default -> throw new ProductNotFoundException("Food not found");
                };
            }
        };

        // 3. Create PricingService and add discounts
        PricingService pricing = new PricingService();
        pricing.addDiscountStrategy(new Getone());         // Buy 1 Get 1
        pricing.addDiscountStrategy(new OnehundredOff());  // 100 off if total >= 250
        pricing.addDiscountStrategy(new NewUser(null)); // NewUser get 10% off

        // 4. Create a FoodCart
        FoodCart cart = new FoodCart(menu, pricing);
        try {
            cart.addFood("09", 3);  // 3 Omelettes
            cart.addFood("25", 2);  // 2 Lemon Ice Creams
            cart.addFood("33", 5);  // 5 Waters
        } catch (ProductNotFoundException e) {
            System.out.println("Error adding food: " + e.getMessage());
        }

        // 5. Print original price
        System.out.println("Original price: " + cart.getOriginalPrice());

        // 6. Print final price after discounts
        System.out.println("Final price after discounts: " + cart.getFinalPrice());

    }
}

