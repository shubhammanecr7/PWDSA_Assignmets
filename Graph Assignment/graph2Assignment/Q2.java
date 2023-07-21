package graph2Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//A class to store a graph edge
class Edge2 {
	int source, dest;

	public Edge2(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
}

//A class to represent a graph object
class Graph2 {
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// Constructor
	Graph2(List<Edge2> edges, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge2 edge : edges) {
			adjList.get(edge.source).add(edge.dest);
		}
	}
}

public class Q2 {
	/*
	 * Q2. Given a directed graph, check if it is a DAG (Directed Acyclic Graph) or
	 * not. A DAG is a digraph (directed graph) that contains no cycles. The
	 * following graph contains a cycle 0—1—3—0, so it’s not DAG. If we remove edge
	 * 3–0 from it, it will become a DAG.
	 */

	// Perform DFS on the graph and set the departure time of all
	// vertices of the graph
	private static int DFS(Graph2 graph, int v, boolean[] discovered, int[] departure, int time) {
		// mark the current node as discovered
		discovered[v] = true;

		// do for every edge (v, u)
		for (int u : graph.adjList.get(v)) {
			// if `u` is not yet discovered
			if (!discovered[u]) {
				time = DFS(graph, u, discovered, departure, time);
			}
		}

		// ready to backtrack
		// set departure time of vertex `v`
		departure[v] = time++;

		return time;
	}

	// Returns true if given directed graph is DAG
	public static boolean isDAG(Graph2 graph, int n) {
		// keep track of whether a vertex is discovered or not
		boolean[] discovered = new boolean[n];

		// keep track of the departure time of a vertex in DFS
		int[] departure = new int[n];

		int time = 0;

		// Perform DFS traversal from all undiscovered vertices
		// to visit all connected components of a graph
		for (int i = 0; i < n; i++) {
			if (!discovered[i]) {
				time = DFS(graph, i, discovered, departure, time);
			}
		}

		// check if the given directed graph is DAG or not
		for (int u = 0; u < n; u++) {
			// check if (u, v) forms a back-edge.
			for (int v : graph.adjList.get(u)) {
				// If the departure time of vertex `v` is greater than equal
				// to the departure time of `u`, they form a back edge.

				// Note that departure[u] will be equal to
				// departure[v] only if `u = v`, i.e., vertex
				// contain an edge to itself
				if (departure[u] <= departure[v]) {
					return false;
				}
			}
		}

		// no back edges
		return true;
	}

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
		List<Edge2> edges = Arrays.asList(new Edge2(0, 1), new Edge2(0, 3), new Edge2(1, 2), new Edge2(1, 3),
				new Edge2(3, 2), new Edge2(3, 4), new Edge2(3, 0), new Edge2(5, 6), new Edge2(6, 3));

		// total number of nodes in the graph (labelled from 0 to 6)
		int n = 7;

		// build a graph from the given edges
		Graph2 graph = new Graph2(edges, n);

		// check if the given directed graph is DAG or not
		if (isDAG(graph, n)) {
			System.out.println("The graph is a DAG");
		} else {
			System.out.println("The graph is not a DAG");
		}
	}
}
