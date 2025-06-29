import java.util.Scanner;

public class Forecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    // Iterative version to generate year-wise forecast
    public static void displayForecastTable(double presentValue, double rate, int years) {
        System.out.println("\nYear-wise Forecast:");
        System.out.println("----------------------------");
        System.out.printf("%-6s | %-15s\n", "Year", "Future Value (₹)");
        System.out.println("----------------------------");

        for (int i = 0; i <= years; i++) {
            double futureValue = calculateFutureValue(presentValue, rate, i);
            System.out.printf("%-6d | ₹%-15.2f\n", i, futureValue);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter present value (₹): ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (%): ");
        double ratePercent = scanner.nextDouble();
        double rate = ratePercent / 100.0;

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();

        // Final future value
        double futureValue = calculateFutureValue(presentValue, rate, years);
        System.out.printf("\nPredicted Future Value after %d years: ₹%.2f\n", years, futureValue);

        // Show full table
        displayForecastTable(presentValue, rate, years);

        scanner.close();
    }
}
