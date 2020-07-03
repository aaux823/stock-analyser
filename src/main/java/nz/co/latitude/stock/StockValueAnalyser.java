package nz.co.latitude.stock;

/**
 *
 * This class will analyse the stock's values from previous trading day
 * and will return the max possible profit for that day
 *
 * @author arlyneauxilio
 */
public class StockValueAnalyser {

    public static void main(String[] args) {
        // This list will hold the stock values for the day.
        // The indices are the time in minutes past trade opening time, which was 10:00am local time.
        int[] stockValues = {10, 7, 5, 8, 11, 9};

        int maxProfit = getMaxProfit(stockValues);
        System.out.println("Highest possible profit is $" + maxProfit);
    }


    /**
     * Calculates the maximum difference from the list of stock values.
     * For negative values, it will simply ignore the number as it's not possible to have a negative stock value.
     *
     * This includes 2 for loops and will use 2 pointers:
     * 1. first one will traverse from the end
     * 2. second one will traverse from the beginning
     *
     * @param stockValues array of int
     * @return int maximum profit
     */
    public static int getMaxProfit(int[] stockValues) {

        // Initialise return variable
        int maxProfit = 0;

        // First loop: will traverse from the end of the array
        for (int endPointer = stockValues.length;  endPointer >= 0; endPointer--) {

            // Second loop: will traverse from the beginning of the array
            for (int iterator = 0; iterator < endPointer; iterator++) {
                int laterStockValue = stockValues[endPointer - 1];
                int earlyStockValue = stockValues[iterator];

                // Check if both integers are non-negative values
                if (laterStockValue >= 0 && earlyStockValue >= 0) {

                    // Take the difference
                    int profit = laterStockValue - earlyStockValue;

                    // Compare the difference with the maxProfit. If it's higher, save it as the new maxProfit
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
        }
        return maxProfit;
    };

}
