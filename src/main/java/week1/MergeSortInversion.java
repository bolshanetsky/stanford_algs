package week1;

import org.apache.commons.lang3.mutable.MutableLong;

import java.util.Arrays;

public class MergeSortInversion {

	private MutableLong inversionsCounter;

	public MergeSortInversion() {
		inversionsCounter = new MutableLong(0);
	}

	public long getInversionsCount() {
		return inversionsCounter.getValue();
	}

	private int[] mergeAndCountInversions(int[] inputArray1, int[] inputArray2, MutableLong inversionsCounter) {

		int resultArraySize = inputArray1.length + inputArray2.length;
		int[] mergedArray = new int[resultArraySize];

		int i = 0;
		int j = 0;
		for (int k = 0; k < resultArraySize; k++) {

			if (inputArray1.length == i) {
				mergedArray[k] = inputArray2[j];
				j++;
				continue;
			}

			if (inputArray2.length == j) {
				mergedArray[k] = inputArray1[i];
				i++;
				continue;
			}

			if ((inputArray1[i] < inputArray2[j])) {
				mergedArray[k] = inputArray1[i];
				i++;
			} else {
				mergedArray[k] = inputArray2[j];
				inversionsCounter.add(inputArray1.length - i);
				j++;
			}
		}

		return mergedArray;
	}

	public int[] mergeSort(int[] inputArray) {
		if (inputArray.length > 1) {
			int[] splitArray1 = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
			int[] splitArray2 = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

			splitArray1 = mergeSort(splitArray1);
			splitArray2 = mergeSort(splitArray2);

			return mergeAndCountInversions(splitArray1, splitArray2, inversionsCounter);
		} else {
			return inputArray;
		}
	}
}