package graph2Assignment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//A class to store a graph edge
class Edge3 {
	public final int src, dest, weight;

	private Edge3(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	// Factory method for creating an immutable instance of `Edge`
	public static Edge3 of(int a, int b, int c) {
		return new Edge3(a, b, c); // calls private constructor
	}
}

//A BFS Node
class Node3 {
	int vertex, depth, weight;

	Node3(int vertex, int depth, int weight) {
		this.vertex = vertex;
		this.depth = depth;
		this.weight = weight;
	}
}

//A class to represent a graph object
class Graph3 {
	// A list of lists to represent an adjacency list
	List<List<Edge3>> adjList = new ArrayList<>();

	// Graph Constructor
	public Graph3(List<Edge3> edges, int n) {
		// resize the list to `n` elements of type `List<Edge>`
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge3 e : edges) {
			adjList.get(e.src).add(e);
		}
	}
}

public class Q3 {
	/*
	 * Q3. Given a weighted digraph (directed graph), find the least-cost path from
	 * a given source to a given destination with exactly m edges.
	 */

	// Perform BFS on graph `g` starting from vertex `v`
	public static int findLeastCost(Graph3 g, int src, int dest, int m) {
		// create a queue for doing BFS
		Queue<Node3> q = new ArrayDeque<>();

		// enqueue source vertex
		q.add(new Node3(src, 0, 0));

		// stores least-cost from source to destination
		int minCost = Integer.MAX_VALUE;

		// loop till queue is empty
		while (!q.isEmpty()) {
			// dequeue front node
			Node3 node = q.poll();

			int v = node.vertex;
			int depth = node.depth;
			int cost = node.weight;

			// if the destination is reached and BFS depth is equal to `m`,
			// update the minimum cost calculated so far
			if (v == dest && depth == m) {
				minCost = Math.min(minCost, cost);
			}

			// don't consider nodes having a BFS depth more than `m`.
			// This check will result in optimized code and handle cycles
			// in the graph (otherwise, the loop will never break)
			if (depth > m) {
				break;
			}

			// do for every adjacent edge of `v`
			for (Edge3 edge : g.adjList.get(v)) {
				// push every vertex (discovered or undiscovered) into
				// the queue with depth as +1 of parent and cost equal
				// to the cost of parent plus the current edge weight
				q.add(new Node3(edge.dest, depth + 1, cost + edge.weight));
			}
		}

		// return least-cost
		return minCost;
	}

	public static void main(String[] args) {
		// List of graph edges as per the above diagram
		List<Edge3> edges = Arrays.asList(Edge3.of(0, 6, -1), Edge3.of(0, 1, 5), Edge3.of(1, 6, 3), Edge3.of(1, 5, 5),
				Edge3.of(1, 2, 7), Edge3.of(2, 3, 8), Edge3.of(3, 4, 10), Edge3.of(5, 2, -1), Edge3.of(5, 3, 9),
				Edge3.of(5, 4, 1), Edge3.of(6, 5, 2), Edge3.of(7, 6, 9), Edge3.of(7, 1, 6));

		// total number of nodes in the graph (labelled from 0 to 7)
		int n = 8;

		// build a graph from the given edges
		Graph3 g = new Graph3(edges, n);

		int src = 0, dest = 3, m = 4;

		// Perform modified BFS traversal from source vertex `src`
		System.out.print(findLeastCost(g, src, dest, m));
	}
}
