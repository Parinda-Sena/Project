package Backend;
import java.util.ArrayList;
import Backend.Discount.InvalidOperationException;
import Backend.Discount.ProductNotFoundException;

// ตะกร้าใส่อาหารที่ลูกค้าสั่ง
public class FoodCart {

    // ตัวแปร
    ArrayList<TotalFood> foods;
    PricingService pricingService;
    AllFood allFood;

    // สร้างตะกร้า
    public FoodCart(AllFood allFood, PricingService pricingService) {
        this.allFood = allFood;
        this.pricingService = pricingService;
        this.foods = new ArrayList<>();
    }

    // เพิ่มอาหารลงตะกร้า
    // ถ้ามีเหมือนกันจะเพิ่มจำนวน
    // @param foodID รหัสอาหาร
    // @param quantity จำนวนที่ต้องการเพิ่ม
    // @throws ProductNotFoundException ถ้าไม่พบอาหารที่มีรหัสตรงกัน
    public void addFood(String foodID, int quantity) throws ProductNotFoundException {
        if (quantity <= 0) { // จำนวนต้องมากกว่า 0
            throw new InvalidOperationException("Quantity must be greater than zero.");
        }

        Food foodToAdd = allFood.getFoodByID(foodID); // เก็บอาหารจากเมนูโดยใช้รหัส
        for (TotalFood tf : foods) {
            if (tf.getFood().equals(foodToAdd)) {
                tf.addQuantity(quantity);
                return;
            }
        }
        foods.add(new TotalFood(foodToAdd, quantity));
    }

    // ลบอาหารออกจากตะกร้าทั้งหมด
    // @param foodID รหัสอาหาร
    // @throws ProductNotFoundException ถ้าไม่พบอาหารที่มีรหัสตรงกัน
    public void removeFood(String foodID) throws ProductNotFoundException {
        if(foodID == null) { //ถ้าไม่ตรงกับรหัสก็ข้ามเลย
            return;
        }
        TotalFood foodToRemove = null; //เตรียมเก็บอาหารที่จะลบ
        for(TotalFood tf : foods) {
            if(tf.getFood().getfoodID().equals(foodID)) {
                foodToRemove = tf;
                break;
            }
        }
        if(foodToRemove != null) {
            foods.remove(foodToRemove);
        } else {
            throw new ProductNotFoundException("not found in cart"); //ถ้าไม่เจออาหารที่มีรหัสตรงกัน
        }    
    }

    public double getOriginalPrice() {
        return pricingService.calculateOriginalPrice(this);
    }

    public double getFinalPrice() {
        return pricingService.calculateFinalPrice(this);
    }

    // คืนค่ารายการอาหาร
    public ArrayList<TotalFood> getFoods() {
        return foods;
    }

    // คืนค่าจำนวนอาหาร
    public int getFoodCount() {
        return foods.size();
    }

    public void clearCart() { //เคลียร์ตะกร้า
        foods.clear();
    }

}

