package Services;
     /*
     * ราคาปกติไม่มีส่วนลด
     */
public class DefualtDiscount implements Discount{

    @Override
    public double applyDiscount(double totalPrice) {
       return totalPrice;
    }
}

