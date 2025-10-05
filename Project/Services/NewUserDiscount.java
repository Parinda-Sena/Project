import java.util.Scanner;

public class NewUserDiscount {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Are you a new user? (yes/no): ");
        String isNewUser = input.nextLine().toLowerCase();

        System.out.print("Enter your purchase amount: $");
        double purchaseAmount = input.nextDouble();

        double finalAmount = purchaseAmount;
        double discountPercentage = 0.0;

        if (isNewUser.equals("yes")) {
            discountPercentage = 0.10; // 10% discount for new users
            double discountAmount = purchaseAmount * discountPercentage;
            finalAmount = purchaseAmount - discountAmount;
            System.out.println("Congratulations! You received a new user discount of " + (discountPercentage * 100) + "%.");
            System.out.println("Discount amount: $" + String.format("%.2f", discountAmount));
        } else {
            System.out.println("No new user discount applied.");
        }

        System.out.println("Original purchase amount: $" + String.format("%.2f", purchaseAmount));
        System.out.println("Final amount to pay: $" + String.format("%.2f", finalAmount));

        input.close();
    }
}
