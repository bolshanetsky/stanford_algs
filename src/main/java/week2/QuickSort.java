package week2;

import org.apache.commons.lang3.mutable.MutableLong;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;
import week1.MergeSortInversion;

public class QuickSort {

	private MutableLong comparisonCounter;

	public QuickSort() {
		comparisonCounter = new MutableLong(0);
	}

	public long getComparisonCounterValue() {
		return comparisonCounter.longValue();
	}

	/**
	 * Sorts array using Quick Sort algorithm.
	 *
	 * @return sorted array.
	 */
	public int[] quickSort(int[] arrayToSort, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return arrayToSort;
		}

		comparisonCounter.add(endIndex - startIndex);

		int pivotIndexBeforePartitioning = choosePivot(arrayToSort, startIndex, endIndex);

		int pivotIndexAfterPartitioning = performPartition(arrayToSort, pivotIndexBeforePartitioning, startIndex,
				endIndex);

		quickSort(arrayToSort, startIndex, pivotIndexAfterPartitioning - 1);
		quickSort(arrayToSort, pivotIndexAfterPartitioning + 1, endIndex);

		return arrayToSort;
	}

	private int performPartition(int[] arrayToPivot, int pivotIndex, int startIndex, int endIndex) {

		// move pivot into the beginning of array
		if (pivotIndex != startIndex) {
			Utils.swapArrayValues(arrayToPivot, pivotIndex, startIndex);
		}

		int pivotValue = arrayToPivot[startIndex];

		int i = startIndex + 1;
		int j = startIndex + 1;

		while (j <= endIndex) {

			if (arrayToPivot[j] < pivotValue) {

				Utils.swapArrayValues(arrayToPivot, i, j);
				i++;
			}
			j++;
		}

		// swap pivot number to it's index in array.
		Utils.swapArrayValues(arrayToPivot, i - 1, startIndex);

		return i - 1;
	}

	/**
	 * Choosing pivot number using "Media of three approach"
	 * @return index of pivot number.
	 */
	private int choosePivot(int[] arrayToSort, int startIndex, int endIndex) {
		int[] array = new int[3];

		array[0] = arrayToSort[startIndex];
		array[1] = arrayToSort[endIndex];
		array[2] = arrayToSort[startIndex + (endIndex - startIndex)/2];

		Map orderMap = new HashMap<Integer, Integer>();
		orderMap.put(array[0], startIndex);
		orderMap.put(array[1], endIndex);
		orderMap.put(array[2], startIndex + (endIndex - startIndex)/2);

		int result = new MergeSortInversion().mergeSort(array)[1];
		return (int)orderMap.get(result);
	}
}
