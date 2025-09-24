package Services;

import java.util.List;

    /*
     * ส่วนลดซื้อ 1 แถม 1
     */
public class GetOneDiscount extends Discount{

    public double applyDiscount(double totalPrice) {
        return totalPrice / 2;       
    }
    public double applyDiscountFromCart(List<FoodMenu> cart) {
        if(cart.size() < 2) {
            return getCartPrice(cart); //ถ้าไม่ถึง2ชิ้น จ่ายราคาเต็ม
        }
        
        //ซื้อทุก2ชิ้น จ่าย1ชิ้น
        double total = 0;
        for(int i=0;i<cart.size();i++) {
            if(i % 2 == 0) {
                total += cart.get(i).getPrice();
            }
        }
        return total;
    }
    private double getCartPrice(List<FoodMenu> cart) {
        double sum = 0;
        for(FoodMenu f : cart) {
            sum += f.getPrice();
        }
        return sum;
    }
}

