package Backend;

public class CartStore {
    private static FoodCart cart;

    public static FoodCart getCart() {// สร้างตะกร้าโดยรับ AllFood และ PricingService
        if (cart == null) {
            cart = new FoodCart(new AllFood(), new PricingService());
        }
        return cart;
    }
}