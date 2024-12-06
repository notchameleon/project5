package dailySalesFigures;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Project5 {
	public static void main(String[] args) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File("stores.txt"));
        StoresSales lowestAverageStore = new StoresSales();
        double lowestAverage = 99999.0;

        // Read number of stores
        int numberOfStores = Integer.parseInt(fileInput.nextLine().trim());

        for (int i = 0; i < numberOfStores; i++) {
            // Read store name
            String storeName = fileInput.nextLine().trim();
            StoresSales store = new StoresSales(storeName);

            // Read sales data line
            Scanner salesData = new Scanner(fileInput.nextLine().trim());
            while (salesData.hasNextInt()) {
                store.addDailySales(salesData.nextInt());
            }

            // Print store data
            System.out.println(store);
            System.out.printf("The %s store averages %.2f transactions per day.%n", storeName, store.calculateAverageSales());
            System.out.printf("The worst day was Day %d with %d transactions.%n\n", store.getLowestSalesDay(), store.getSalesForDay(store.getLowestSalesDay()));

            // Track store with lowest average sales
            double averageSales = store.calculateAverageSales();
            if (averageSales < lowestAverage) {
                lowestAverage = averageSales;
                lowestAverageStore = store;
            }
        }

        // Print store with the lowest average sales
        if (!lowestAverageStore.isEmpty()) {
            System.out.printf("The store with the fewest average transactions is %s with %.2f transactions per day.%n",
                    lowestAverageStore.getLocation(), lowestAverage);
        }
       
	}
}
