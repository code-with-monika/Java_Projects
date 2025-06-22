import java.util.Scanner;

public class BillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        final int MAX_ITEMS = 100;
        String[] productNames = new String[MAX_ITEMS];
        int[] quantities = new int[MAX_ITEMS];
        double[] prices = new double[MAX_ITEMS];
        double[] totalPerItem = new double[MAX_ITEMS];

        System.out.println("----- Welcome to Billing System -----");
        System.out.print("Enter number of products you want to bill: ");
        int itemCount = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < itemCount; i++) {
            System.out.println("\nEnter details for item " + (i + 1) + ":");

            System.out.print("Product Name: ");
            productNames[i] = scanner.nextLine();

            System.out.print("Quantity: ");
            quantities[i] = scanner.nextInt();

            System.out.print("Price per item: ");
            prices[i] = scanner.nextDouble();
            scanner.nextLine();  

            totalPerItem[i] = quantities[i] * prices[i];
        }

        
        System.out.println("\n\n------------ Final Bill ------------");
        double grandTotal = 0;
        System.out.printf("%-20s %-10s %-15s %-15s\n", "Product", "Qty", "Price/Item", "Total");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%-20s %-10d %-15.2f %-15.2f\n",
                    productNames[i], quantities[i], prices[i], totalPerItem[i]);
            grandTotal += totalPerItem[i];
        }

        System.out.println("-----------------------------------------------");
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        System.out.println("Thank you for shopping with us!");
    }
}
