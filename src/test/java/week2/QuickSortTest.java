package week2;

import org.testng.annotations.Test;

import java.io.IOException;

import utils.Utils;

public class QuickSortTest {

  private static String TEST_DATA_FILE = "src/main/resources/quickSort.txt";

  @Test
  public void quickSortTest() throws IOException {
    int[] testArray = {2, 6, 4, 3 , 1, 5, 7};

    QuickSort sortObject = new QuickSort();

    int[] resultArray = sortObject.quickSort(testArray, 0, testArray.length - 1);

    for (int i = 0; i < resultArray.length; i++) {
      System.out.println(resultArray[i]);
    }
  }

  @Test
  public void quickSortRealDataTest() throws IOException {

    int[] testArray = Utils.loadArrayFromFile(10000, TEST_DATA_FILE);

    QuickSort sortObject = new QuickSort();
    int[] resultArray = sortObject.quickSort(testArray, 0, testArray.length - 1);

    for (int i = 0; i < resultArray.length; i++) {
      System.out.println(resultArray[i]);
    }
  }

  @Test
  public void quickSortCountComparisonsTest() throws IOException {

    int[] testArray = Utils.loadArrayFromFile(10000, TEST_DATA_FILE);

    QuickSort sortObject = new QuickSort();
    int[] resultArray = sortObject.quickSort(testArray, 0, testArray.length - 1);

    System.out.println(sortObject.getComparisonCounterValue());

    // Answer for first elem pivot 162085
    // Answer for last elem pivot 164123
    // Answer for three median pivot 138382
  }
}