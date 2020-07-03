package nz.co.latitude.stock;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class StockValueAnalyserTest {

    @Test
    public void getMaxProfit_originalList() {
        int[] stockValues = {10, 7, 5, 8, 11, 9};
        Assert.assertEquals(6, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_zeroValues() {
        int[] stockValues = {0, 0, 0, 0, 0, 0};
        Assert.assertEquals(0, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_minValueAtTheEnd() {
        int[] stockValues = {1, 1, 1, 1, 1, 0};
        Assert.assertEquals(0, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_maxValueAtTheStart() {
        int[] stockValues = {1, 0, 0, 0, 0, 0};
        Assert.assertEquals(0, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_ascendingList() {
        int[] stockValues = {5, 6, 7, 8, 9, 10};
        Assert.assertEquals(5, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_negativeNumberList() {
        int[] stockValues = {5, 6, 7, -8, 9, 10};
        Assert.assertEquals(5, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_descendingList() {
        int[] stockValues = {10, 9, 8 , 7, 6, 5};
        Assert.assertEquals(0, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_withDuplicateValueList() {
        int[] stockValues = {26, 45, 19, 32, 4, 28, 28, 13, 4};
        Assert.assertEquals(24, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_withSmallestValueInThMiddleList() {
        int[] stockValues = {6, 28, 12, 29, 13, 3, 19, 25, 31};
        Assert.assertEquals(28, StockValueAnalyser.getMaxProfit(stockValues));
    }

    @Test
    public void getMaxProfit_randomList() {
        int[] stockValues = {generateRandom(), generateRandom(), generateRandom(), generateRandom(), generateRandom(), generateRandom(), generateRandom(), generateRandom(), generateRandom()};
        System.out.println(Arrays.asList(stockValues));
        Assert.assertTrue(StockValueAnalyser.getMaxProfit(stockValues) >= 0);
    }

    /**
     * Randomizer method. Will generate random number from 0 to 50
     *
     * @return random int.
     */
    private int generateRandom() {
        Double randomValue = Math.random() * 50 - 1;
        return randomValue.intValue();
    }
}