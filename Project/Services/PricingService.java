package Services;

import java.util.ArrayList;

/**
 * จัดการโปรโมชันและคำนวณราคาโดยใช้ Strategy Pattern
 */
public class PricingService {

    private static class StrategyRule {
        private final String foodName;
        private final Discount strategy;

        public StrategyRule(String foodName, Discount strategy) {
            this.foodName = foodName;
            this.strategy = strategy;
        }

        public String getFoodName() {
            return foodName;
        }

        public Discount getStrategy() {
            return strategy;
        }
    }

    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final Discount defaultStrategy = new DefaultDiscount();

    /**
     * ลงทะเบียนกลยุทธ์ส่วนลดสำหรับอาหารชื่อที่กำหนด
     */
    public void addStrategy(String foodName, Discount strategy) {
        StrategyRule ruleToRemove = null;
        for (StrategyRule rule : strategies) {
            if (rule.getFoodName().equalsIgnoreCase(foodName)) {
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null) strategies.remove(ruleToRemove);
        strategies.add(new StrategyRule(foodName, strategy));
    }

    /**
     * คำนวณราคาสุทธิของอาหาร 1 รายการ
     */
    public double calculateItemPrice(FoodCart item) {
        String name = item.getFoodMenu().getNameFood();
        double price = item.getFoodMenu().getPrice() * item.getQuantity();

        for (StrategyRule rule : strategies) {
            if (rule.getFoodName().equalsIgnoreCase(name)) {
                return rule.getStrategy().applyDiscount(price);
            }
        }

        return defaultStrategy.applyDiscount(price);
    }

    /**
     * คำนวณราคาสุทธิรวมของตะกร้าอาหาร
     */
    public double calculateCartTotal(ArrayList<FoodCart> cart) {
        double total = 0;
        for (FoodCart item : cart) {
            total += calculateItemPrice(item);
        }
        return total;
    }
}
