package dailySalesFigures;
import java.util.*;

public class StoresSales {
	 	private String location;
	    private int[] sales;
	    private int daysRecorded;

	    // Default Constructor: Initializes store location to "Store Location" and sales array to hold up to 30 days of data
	    public StoresSales() {
	        this.location = "Store Location";
	        this.sales = new int[30];
	        this.daysRecorded = 0;
	    }

	    // Parameterized Constructor: Initializes store location with the provided name and sales array to hold up to 30 days of data
	    // @param location - The name of the store
	    public StoresSales(String location) {
	        this.location = location;
	        this.sales = new int[30];
	        this.daysRecorded = 0;
	    }

	    // Add daily sales: Adds sales data for a day if there's space available
	    // @param dailySales - Sales data for a day
	    public void addDailySales(int dailySales) {
	        if (daysRecorded < sales.length) {
	            sales[daysRecorded++] = dailySales;
	        }
	    }

	    // Get the day with the lowest sales (1-based). Finds the day with the minimum sales value
	    // @return The day number (1-based) with the lowest sales, or -1 if no data is recorded
	    public int getLowestSalesDay() {
	        if (daysRecorded == 0) return -1;
	        int minSales = sales[0];
	        int worstDay = 1;
	        for (int i = 1; i < daysRecorded; i++) {
	            if (sales[i] < minSales) {
	                minSales = sales[i];
	                worstDay = i + 1;
	            }
	        }
	        return worstDay;
	    }
	    
	    // Get sales for a specific day (1-based) Returns sales data for a given day
	    // @param day - The day number (1-based)
	    // @return Sales for the specified day, or -1 if the day is out of range
	    public int getSalesForDay(int day) {
	        if (day < 1 || day > daysRecorded) {
	            return -1;
	        }
	        return sales[day - 1];
	    }

	    // Calculate average sales: Computes the average sales across all recorded days
	    // @return The average sales as a double, or 0 if no sales data is recorded
	    public double calculateAverageSales() {
	        if (daysRecorded == 0) return 0;
	        int total = 0;
	        for (int i = 0; i < daysRecorded; i++) {
	            total += sales[i];
	        }
	        return (double) total / daysRecorded;
	    }

	    // toString method: Returns a string representation of the store location and its sales data
	    // @return A formatted string of the store location and sales data
	    @Override
	    public String toString() {
	        String result = location + ":\n";
	        for (int i = 0; i < daysRecorded; i++) {
	            result += sales[i];
	            if (i < daysRecorded - 1) {
	                result += ", ";
	            }
	        }
	        return result;
	    }

	    // Check if no sales data: Checks if the store has no recorded sales data
	    // @return True if no sales data is recorded, otherwise false
	    public boolean isEmpty() {
	        return daysRecorded == 0;
	    }
	    
	    public String getLocation() {
	    	return location;
	    }
	    }