package Services;

import java.util.ArrayList;
import java.util.List;

public class Admin{
    /*
     * สำหรับแอดมินเอาไว้กำหนด Status ว่าเมนูนี้หมด หรือมีการอัปเดทราคาอาหารใหม่
     */
    private List<FoodMenu> foodMenuList;  // รายการเมนูอาหาร
    private List<Discount> discountList;  // รายการส่วนลด

    public Admin() {
        this.foodMenuList = new ArrayList<>();
        this.discountList = new ArrayList<>();
    }

    // เพิ่มเมนูอาหารใหม่
    public void addFoodMenu(String nameFood, double price) {
        FoodMenu newFood = new FoodMenu(nameFood, price);
        foodMenuList.add(newFood);
        System.out.println("Added new food: " + nameFood + " with price " + price);
    }

    // แสดงรายการเมนูอาหารทั้งหมด
    public void showAllFoodMenus() {
        System.out.println("All Food Menus:");
        for (FoodMenu foodMenu : foodMenuList) {
            System.out.println("Food: " + foodMenu.getNameFood() + ", Price: " + foodMenu.getPrice());
        }
    }

    // เพิ่มส่วนลดใหม่
    public void addDiscount(Discount discount) {
        discountList.add(discount);
        System.out.println("Added new discount");
    }

    // แสดงรายการส่วนลดทั้งหมด
    public void showAllDiscounts() {
        System.out.println("All Discounts:");
        for (Discount discount : discountList) {
            System.out.println(discount.getClass().getSimpleName());
        }
    }

    // คำนวณราคาหลังหักส่วนลดสำหรับทุกเมนู
    public void applyDiscountToAllFoodMenus(Discount discount) {
        System.out.println("Applying " + discount.getClass().getSimpleName() + " to all food menus:");
        for (FoodMenu foodMenu : foodMenuList) {
            double finalPrice = foodMenu.applyDiscount(discount);
            System.out.println(foodMenu.getNameFood() + " final price: " + finalPrice);
        }
    }
}
