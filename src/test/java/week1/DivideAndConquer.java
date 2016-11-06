package week1;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import utils.Utils;

/**
 * Created by olsha on 11/5/2016.
 */
public class DivideAndConquer {

	private static String TEST_DATA_FILE = "src/main/resources/IntegerArray.txt";

	@Test
	public void arrayLoadTest() throws IOException {
		int[] array = Utils.loadArrayFromFile(100000, TEST_DATA_FILE);
		Assert.assertTrue(array.length > 0);
	}

	@Test
	public void mergeSortTest() throws IOException {
		int[] array = Utils.loadArrayFromFile(100000, TEST_DATA_FILE);

		MergeSortInversion sortInversion = new MergeSortInversion();
		int[] sorted = sortInversion.mergeSort(array);

		System.out.println(sortInversion.getInversionsCount());
		Assert.assertTrue(sortInversion.getInversionsCount() != 0);
	}
}