package Backend;

import Backend.Discount.Getone;

class Test {

    public static void main(String[] args) {
        // สร้างอาหาร
        Food friedRice = new Food("Fried Rice", 50.0, "F001");
        Food padThai = new Food("Pad Thai", 60.0, "F002");
        
        // สร้าง TotalFood (อาหาร + จำนวน)
        TotalFood item1 = new TotalFood(friedRice, 3);  // 3 จาน
        TotalFood item2 = new TotalFood(padThai, 2);    // 2 จาน
        
        // สร้าง FoodCart และเพิ่มอาหาร
        FoodCart cart = new FoodCart();
        cart.addFood(item1);
        cart.addFood(item2);

        // สร้าง PricingService
        PricingService pricing = new PricingService();
        
        // คำนวณราคาแบบไม่ใช้ส่วนลด (original price)
        double originalPrice = pricing.calculateOriginalPrice(cart);
        System.out.println("Original Price (no discount): " + originalPrice);
        // Expected: (50*3) + (60*2) = 150 + 120 = 270
        
        // เพิ่มส่วนลด Getone (ซื้อ 2 จ่าย 1)
        pricing.addDiscountStrategy(new Getone());
        
        // คำนวณราคาหลังใช้ส่วนลด
        double discountedPrice = pricing.calculateFinalPrice(cart);
        System.out.println("Discounted Price (Getone): " + discountedPrice);
        // Expected:
        // Fried Rice 3 pcs -> pay for 2 (3/2=1 + 3%2=1 => 2 pcs) = 50*2=100
        // Pad Thai 2 pcs -> pay for 1 (2/2=1 + 2%2=0 => 1 pc) = 60*1=60
        // Total = 100 + 60 = 160
    }
}