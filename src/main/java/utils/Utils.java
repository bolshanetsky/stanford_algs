package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import week3.UndirectedGraphMinCut;

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

	public static void swapArrayValues(int[] arrayToUpdate, int index1, int index2) {
		int temp = arrayToUpdate[index2];
		arrayToUpdate[index2] = arrayToUpdate[index1];
		arrayToUpdate[index1] = temp;
	}


	public static UndirectedGraphMinCut loadDataIntoGraphFromFile(String fileName) throws IOException {
		UndirectedGraphMinCut graph = new UndirectedGraphMinCut();

		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			for (String line; (line = br.readLine()) != null;) {

				ArrayList<Integer> list = new ArrayList<>();
				Arrays.asList(line.split("\t")).forEach(string -> list.add(Integer.valueOf(string)));
				Integer primaryVertexIndex = list.get(0);
				list.remove(0);

				// Add vertices
				graph.addVertex(primaryVertexIndex, list);

				// Add edges
				list.forEach(adjacentVertexIndex -> graph.addEdge(primaryVertexIndex, adjacentVertexIndex));
			}
		}

		return graph;
	}
}
