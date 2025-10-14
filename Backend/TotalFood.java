package Backend;

// อาหาร 1 อย่างสั่งกี่จานพร้อมคำนวณราคารวมของอาหาร
public class TotalFood {
    private Food food; // อาหาร 1 อย่าง
    private int quantity; // จำนวนอาหารที่สั่ง

    public TotalFood(Food food, int quantity) {
        this.food = food; // แทนอาหารนั้น
        this.quantity = quantity;// จำนวน
    }

    /**
     * @return อาหาร
     */
    public Food getFood() {
        return food;
    }

    /**
     * @return จำนวนที่สั่ง
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * เพิ่มจำนวนที่สั่ง
     * 
     * @param amount จำนวนที่ต้องการเพิ่ม
     */
    public void addQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount to add must be greater than zero.");
        }
        this.quantity += amount;
    }
    
    /**
     * @return ราคาทั้งหมดของอาหารนี้ (ราคาอาหาร * จำนวน)
     */
    public double getTotalPrice() {
        return food.getPrice() * quantity;
    }

    
}
