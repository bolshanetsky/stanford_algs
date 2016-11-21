package week3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class UndirectedGraphMinCut {

	private Map<Integer, List<Integer>> adjacencyList;
	private Set<Edge> edges;

	public Map<Integer, List<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public UndirectedGraphMinCut() {
		adjacencyList = new HashMap<>();
		edges = new HashSet<>();
	}

	public int getVerticiesCount() {
		return adjacencyList.size();
	}

	public void addVertex(Integer indexKey, List<Integer> adjacentVertecies) {
		adjacencyList.put(indexKey, adjacentVertecies);
	}

	public void addEdge(int firstVertexIndex, int secondVertexIndex) {
		edges.add(new Edge(firstVertexIndex, secondVertexIndex));
	}

	public Edge getRandomEdge() {

		int size = edges.size();
		int edgeIndex = new Random().nextInt(size);
		int i = 0;
		for (Edge edge : edges) {
			if (i == edgeIndex)
				return edge;
			i = i + 1;
		}

		return null;
	}

	public void contractEdge(Edge edge) {

		// Getting contracting vertices
		int firstVertexIndex = edge.getFirstVertexIndex();
		int secondVertexIndex = edge.getSecondVertexIndex();

		// Merging second vertex into first in adjacency list
		List<Integer> firstVertexLinks = adjacencyList.get(firstVertexIndex);
		List<Integer> secondVertexLinks = adjacencyList.get(secondVertexIndex);

		// Update links for all vertices connected to second(contracted) with first vertex index.
		for (int vertex : secondVertexLinks) {
			List<Integer> list = adjacencyList.get(vertex);
			Collections.replaceAll(list, secondVertexIndex, firstVertexIndex);
		}

		// Add second list links to first
		firstVertexLinks.addAll(secondVertexLinks);
		// Filter self references
		firstVertexLinks.removeIf(link -> link.equals(firstVertexIndex));

		// Remove second vertex from graph.
		adjacencyList.remove(secondVertexIndex);

		edges.remove(edge);

		Set<Edge> setToRemove = new HashSet<>();
		Set<Edge> setToAdd = new HashSet<>();
		for (Edge edgeToUpdate : edges) {
			if (edgeToUpdate.getFirstVertexIndex() == secondVertexIndex) {
				setToAdd.add(new Edge(firstVertexIndex, edgeToUpdate.getSecondVertexIndex()));
				setToRemove.add(edgeToUpdate);

			}

			if (edgeToUpdate.getSecondVertexIndex() == secondVertexIndex) {
				setToAdd.add(new Edge(edgeToUpdate.getFirstVertexIndex(), firstVertexIndex));
				setToRemove.add(edgeToUpdate);
			}
		}

		edges.removeAll(setToRemove);
		edges.addAll(setToAdd);
		edges.removeIf(edgeToRemove -> edgeToRemove.getFirstVertexIndex() == edgeToRemove.getSecondVertexIndex());
	}
}