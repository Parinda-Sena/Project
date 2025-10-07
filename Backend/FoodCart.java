package Backend;
import java.util.ArrayList;

// ตะกร้าใส่อาหารที่ลูกค้าสั่ง
public class FoodCart {
    ArrayList<TotalFood> foods;
    PricingService pricingService;
    AllFood allFood;

    public FoodCart() {
        this.allFood = new AllFood();
        this.pricingService = new PricingService();
        this.foods = new ArrayList<>();
    }

    public FoodCart(AllFood allFood, PricingService pricingService) {
        this.allFood = allFood;
        this.pricingService = pricingService;
        this.foods = new ArrayList<>();
    }

    public void addFood(TotalFood newfood) {
        for(TotalFood f : foods) {
            if(f.getFood().equals(newfood.getFood())){
                f.addQuantity(f.getQuantity() + newfood.getQuantity());
                return;
            }
        }
        foods.add(newfood);
    }

    //คืนค่ารายการอาหาร
    public ArrayList<TotalFood> getFoods() {
        return foods;
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (TotalFood tf : foods) {
            total += tf.getTotalPrice();
        }
        return total;
    }

    //คำนวณราคารวมทั้งหมดหลังหักส่วนลด
    public double calculateFinalPrice() {
        return pricingService.calculateFinalPrice(this);
    }

    // ✅ แสดงรายการอาหารทั้งหมด
    public void showCartDetails() {
        System.out.println("===== ITEMS IN CART =====");
        for (TotalFood tf : foods) {
            System.out.println(tf.getFood().getfoodName() + " x" + tf.getQuantity() + " = " + tf.getTotalPrice() + " BAHT");
        }
        System.out.println("---------------------------------");
        System.out.println("Subtotal (Before Discount): " + calculateTotalPrice() + " BAHT"); // "ราคารวม (ก่อนส่วนลด)"
        System.out.println("Final Price: " + calculateFinalPrice() + " BAHT"); // "ราคารวมสุทธิ"
    }

    // ✅ สำหรับกำหนดส่วนลดเพิ่มเติม (ถ้าต้องการ)
    public void addDiscount(Backend.Discount.DiscountStrategy discount) {
        pricingService.addDiscountStrategy(discount);
    }

    public TotalFood[] getItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems'");
    }
}

