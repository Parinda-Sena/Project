package Services;

public class OneHundredOffDiscount extends Discount{
    /*
     * ส่วนลด 100 สำหรับการสั่งซื้อขั้นต่ำ 250 บาท
     */
    @Override
    public double applyDiscount(double price) {
        return Math.max(price - 100, 0); // ลด 100 บาท แต่ไม่ให้ราคาเป็นค่าลบ
    }
}
