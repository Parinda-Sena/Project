package Services;
public class NewUserDiscount extends Discount  {
    /*
     * ส่วนลด 10% สำหรับลูกค้าใหม่
     */
    private final double discountAmount;

    public NewUserDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discountAmount; // ลดราคาตามจำนวนที่กำหนด
    }
}

