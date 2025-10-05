import java.util.Scanner;

public class OneHundredDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the original price from the user
        System.out.print("Enter the original price of the item: ");
        double originalPrice = scanner.nextDouble();

        // Define the 100% discount rate
        double discountPercentage = 100.0;

        // Calculate the discount amount
        double discountAmount = originalPrice * (discountPercentage / 100);

        // Calculate the final price after the discount
        double finalPrice = originalPrice - discountAmount;

        // Print the results
        System.out.println("\nOriginal Price: $" + originalPrice);
        System.out.println("Discount Percentage: " + discountPercentage + "%");
        System.out.println("Discount Amount: $" + discountAmount);
        System.out.println("Final Price: $" + finalPrice);

        scanner.close();
    }
}


