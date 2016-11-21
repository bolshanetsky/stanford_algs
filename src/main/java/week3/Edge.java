package week3;


public class Edge {

  private int firstVertexIndex;

  public int getFirstVertexIndex() {
    return firstVertexIndex;
  }

  public int getSecondVertexIndex() {
    return secondVertexIndex;
  }

  private int secondVertexIndex;

	public Edge(int firstVertexIndex, int secondVertexIndex) {
		this.firstVertexIndex = firstVertexIndex;
		this.secondVertexIndex = secondVertexIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Edge edge = (Edge) o;

		if (firstVertexIndex == edge.firstVertexIndex && secondVertexIndex == edge.secondVertexIndex) {
			return true;
		}

		if ((firstVertexIndex == edge.secondVertexIndex && secondVertexIndex == edge.firstVertexIndex)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int res = 17;
		res = res * 31 + Math.min(firstVertexIndex, secondVertexIndex);
		res = res * 31 + Math.max(firstVertexIndex, secondVertexIndex);
		return res;
	}
}
