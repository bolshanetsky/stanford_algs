package week3;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import utils.Utils;

/**
 * Created by olsha on 11/20/2016.
 */
public class GraphMinimumCut {

	private static String TEST_DATA_FILE = "src/main/resources/kargerMinCut.txt";

	@Test
	public void graphLoadVerify() throws IOException {
		UndirectedGraphMinCut graph = Utils.loadDataIntoGraphFromFile(TEST_DATA_FILE);

		Assert.assertEquals(graph.getVerticiesCount(), 200);

		final int[] linksCounter = {0};
		graph.getAdjacencyList().forEach( (index, list) -> linksCounter[0] += list.size());

		Assert.assertEquals(linksCounter[0]/2, graph.getEdges().size());
	}

	@Test
	public void minimumCount() throws IOException {

		int i = 0;
		final int[] min = {99999};
		while (i < 25000) {
			UndirectedGraphMinCut graph = Utils.loadDataIntoGraphFromFile(TEST_DATA_FILE);

			while (graph.getEdges().size() > 2) {
				Edge edgeToRemove = graph.getRandomEdge();
				graph.contractEdge(edgeToRemove);
			}

			graph.getAdjacencyList().forEach((key, list) -> {
				if (min[0] > list.size()) {
					min[0] = list.size();

				}
			});
			i++;
		}

		System.out.println("Final: " + min[0]);
	}
}
