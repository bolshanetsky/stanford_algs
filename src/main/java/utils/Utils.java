package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by olsha on 11/5/2016.
 */
public class Utils {

	public static int[] loadArrayFromFile(int arraySize, String fileName) throws IOException {

		int[] resultArray = new int[arraySize];
		int i = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			for (String line; (line = br.readLine()) != null;) {
				resultArray[i] = Integer.parseInt(line);
				i++;
			}
		}

		return resultArray;
	}
}
