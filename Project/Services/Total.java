package Services;

import java.util.ArrayList;
import java.util.List;

public class Total {
    /*
     * สรุปยอดว่าสั่งอะไรไป เท่าไหร่บ้าง
     */
    private List<FoodMenu> orderedFoodList; // รายการอาหารที่สั่ง
    private Discount appliedDiscount;        // ส่วนลดที่ใช้

    public Total() {
        this.orderedFoodList = new ArrayList<>();
        this.appliedDiscount = null; // เริ่มต้นไม่มีส่วนลด
    }

    // เพิ่มอาหารที่สั่ง
    public void addFood(FoodMenu food) {
        orderedFoodList.add(food);
    }

    // กำหนดส่วนลดที่ใช้
    public void applyDiscount(Discount discount) {
        this.appliedDiscount = discount;
    }

    // คำนวณยอดรวมก่อนและหลังหักส่วนลด
    public void showTotal() {
        double totalBeforeDiscount = 0;
        double totalAfterDiscount = 0;

        System.out.println("Ordered Food Items:");
        for (FoodMenu food : orderedFoodList) {
            System.out.println(food.getNameFood() + " - Price: " + food.getPrice());
            totalBeforeDiscount += food.getPrice();
        }

        // ถ้ามีส่วนลด ก็ให้คำนวณหลังจากหักส่วนลด
        if (appliedDiscount != null) {
            totalAfterDiscount = totalBeforeDiscount;
            for (FoodMenu food : orderedFoodList) {
                totalAfterDiscount = food.applyDiscount(appliedDiscount); // ใช้ส่วนลดกับแต่ละเมนู
            }
        } else {
            totalAfterDiscount = totalBeforeDiscount;
        }

        System.out.println("Total before discount: " + totalBeforeDiscount);
        System.out.println("Total after discount: " + totalAfterDiscount);
    }
}

