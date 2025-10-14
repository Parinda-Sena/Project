package Backend;

import java.util.ArrayList;

import Backend.Discount.InvalidOperationException;
import Backend.Discount.ProductNotFoundException;

public class FoodCart {

    public ArrayList<TotalFood> foods; // เก็บรายการอาหารพร้อมจำนวนลงตะกร้า
    public PricingService pricingService; // ใช้คำนวณราคาอาหาร
    public AllFood allFood; // ดึงข้อมูลอาหารจาก csv

    // เชื่อม AllFood และ PricingService ผ่าน constructor
    public FoodCart(AllFood allFood, PricingService pricingService) {
        this.allFood = allFood;
        this.pricingService = pricingService;
        this.foods = new ArrayList<>(); // ตะกร้าว่าง
    }

    public void addFood(String foodID, int quantity) throws ProductNotFoundException {
        if (quantity <= 0) {
            throw new InvalidOperationException("Quantity must be greater than zero.");
        }

        // ดึงอาหารจาก CSV โดย AllFood
        Food foodToAdd = allFood.getFoodByID(foodID);
        if (foodToAdd == null) {
            throw new ProductNotFoundException("Food not found: " + foodID);
        }

        for (TotalFood tf : foods) { // ถ้ามีอาหารแล้ว ให้เพิ่มเข้าไป
            if (tf.getFood().getfoodID().equals(foodID)) {
                tf.addQuantity(quantity);
                return;
            }
        }

        foods.add(new TotalFood(foodToAdd, quantity));// ไม่มีอาหาร ให้บวกเพิ่มรายการใหม่
    }

    public void removeFood(String foodID) throws ProductNotFoundException {// หาอาหารด้วย FoodID
        if (foodID == null) { return;}

        TotalFood foodToRemove = null;
        for (TotalFood tf : foods) {
            if (tf.getFood().getfoodID().equals(foodID)) {
                foodToRemove = tf;
                break;
            }
        }
        if (foodToRemove != null) {
            foods.remove(foodToRemove);
        } else {
            throw new ProductNotFoundException("not found in cart");
        }
    }

    public double getOriginalPrice() { // เรียก pricingservice มาช่วยคำนวณราคา
        return pricingService.calculateOriginalPrice(this);
    }

    public double getFinalPrice() {
        return pricingService.calculateFinalPrice(this);
    }

    public ArrayList<TotalFood> getFoods() {
        return foods;
    }

    public int getFoodCount() {
        return foods.size();
    }

    public void clearCart() {
        foods.clear();
    }

}