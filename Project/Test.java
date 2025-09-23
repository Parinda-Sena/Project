
 import Services.FoodMenu;
import Services.Total;

import java.util.ArrayList;
import java.util.Scanner;

import Services.AllFood;
 import Services.FoodCart;

public class Test {
    public static void main(String[] args) {
        //Test Food
/*      FoodMenu Brownies1 = new FoodMenu("Brownies", 20);
        FoodMenu Brownies2 = new FoodMenu("Brownies", 20);

        System.out.println(Brownies1.equals(Brownies2)); // เงื่อนไขเป็น true เพราะชื่อเหมือนกันคือเมนูเดียวกัน
        System.out.println(Brownies1.getPrice());     
        System.out.println(Brownies2.getPrice());    
*/
        //Test All
/*      AllFood allFood = new AllFood();

        FoodMenu Omeletrice1 = new FoodMenu("Omelet rice", 30);
        FoodMenu Omeletrice2 = new FoodMenu("Omelet rice", 120); // Testชื่อซ้ำ
        FoodMenu Brownies = new FoodMenu("Brownies", 20);

        // เพิ่มเมนู
        allFood.addFood(Omeletrice1);
        allFood.addFood(Omeletrice2); // จะไม่ถูกเพิ่มเพราะชื่อซ้ำแสดงว่าเป็นเมนูเดียวกัน
        allFood.addFood(Brownies);

        // ค้นหาเมนู
        System.out.println("Omelet rice: " + allFood.findByName("Omelet rice").getPrice());
        System.out.println("Brownies: " + allFood.findByName("Brownies").getPrice());
        System.out.println("Sushi: " + allFood.findByName("Sushi")); // หาไม่เจอ = null
        */
      Scanner sc = new Scanner(System.in);

        FoodMenu[] menus = {
            new FoodMenu("Tom Yum Goong", 60),
            new FoodMenu("Cheesecake", 39),
            new FoodMenu("Water", 10),
            new FoodMenu("Kiwi Soda", 25)
        };

        String[] units = {"bowl", "piece", "bottle", "glass"};
        ArrayList<FoodCart> carts = new ArrayList<>();

        System.out.println("=== Welcome to Meow Ordering ===");

        for (int i = 0; i < menus.length; i++) {
            FoodMenu menu = menus[i];
            int qty = 0;

            while (true) {
                System.out.println("\nMenu: " + menu.getNameFood() + " (" + units[i] + ")");
                System.out.print("Enter + to add, - to remove, 0 to skip, or number directly: ");
                String input = sc.nextLine();

                if (input.equals("+")) {
                    qty++;
                    System.out.println("Current quantity: " + qty);
                } else if (input.equals("-")) {
                    if (qty > 0) qty--;
                    System.out.println("Current quantity: " + qty);
                } else if (input.equals("0")) {
                    break;
                } else {
                    try {
                        int num = Integer.parseInt(input);
                        if (num >= 0) {
                            qty = num;
                            System.out.println("Current quantity: " + qty);
                        } else {
                            System.out.println("Invalid input. Enter 0 or positive number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Use +, -, 0, or number.");
                    }
                }
            }

            if (qty > 0) {
                carts.add(new FoodCart(menu, qty));
            }
        }

        // แสดงตะกร้าอาหาร (ไม่คำนวณราคา)
        System.out.println("\n=== Your Cart ===");
        for (FoodCart cart : carts) {
            System.out.println(cart.getFoodMenu().getNameFood() + " x " + cart.getQuantity() +
                               " " + units[getMenuIndex(cart.getFoodMenu(), menus)]);
        }
    }

    private static int getMenuIndex(FoodMenu menu, FoodMenu[] menus) {
        for (int i = 0; i < menus.length; i++) {
            if (menus[i].equals(menu)) return i;
        }
        return -1;
    }
}
