package Services;

public class FoodCart {
    /*
     * ตะกร้าอาหาร (1 เมนู + จำนวน)
     */
    private final FoodMenu menu;
    private int quantity;

    private void checkRep() {
        if (menu == null) {
            throw new RuntimeException("RI violated: menu is null");
        }
        if (quantity <= 0) {
            throw new RuntimeException("RI violated: quantity <= 0");
        }
    }

    public FoodCart(FoodMenu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
        checkRep();
    }

    public FoodMenu getFoodMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    // เพิ่มจำนวนสินค้า
    public void increaseQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
        checkRep();
    }
}
