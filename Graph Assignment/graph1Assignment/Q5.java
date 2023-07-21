package graph1Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//A class to store a graph edge
class Edge3 {
	int source, dest;

	public Edge3(int source, int dest) {
		this.source = source;
		this.dest = dest;
	}
}

//A class to represent a graph object
class Graph3 {
	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList;

	// Constructor
	Graph3(List<Edge3> edges, int n) {
		adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge3 edge : edges) {
			adjList.get(edge.source).add(edge.dest);
		}
	}
}

public class Q5 {
	/*
	 * Q5. A root vertex of a directed graph is a vertex u with a directed path from
	 * u to v for every pair of vertices (u, v) in the graph. In other words, all
	 * other vertices in the graph can be reached from the root vertex. A graph can
	 * have multiple root vertices. For example, each vertex in a strongly connected
	 * component is a root vertex. In such cases, the solution should return anyone
	 * of them. If the graph has no root vertices, the solution should return -1.
	 */

	// Utility function to perform DFS traversal on the graph
    public static void DFS(Graph3 graph, int v, boolean[] discovered)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // do for every edge (v, u)
        for (int u: graph.adjList.get(v))
        {
            // `u` is not discovered
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }
 
    // Function to find the root vertex of a graph
    public static int findRootVertex(Graph3 graph, int n)
    {
        // to keep track of all previously visited vertices in DFS
        boolean[] visited = new boolean[n];
 
        // find the last starting vertex `v` in DFS
        int v = 0;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                DFS(graph, i, visited);
                v = i;
            }
        }
 
        // reset the visited vertices
        Arrays.fill(visited, false);
 
        // perform DFS on the graph from the last starting vertex `v`
        DFS(graph, v, visited);
 
        // return -1 if all vertices are not reachable from vertex `v`
        for (int i = 0; i < n; i++)
        {
            if (!visited[i]) {
                return -1;
            }
        }
 
        // we reach here only if `v` is a root vertex
        return v;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
		List<Edge3> edges = Arrays.asList(new Edge3(0, 1), new Edge3(1, 2), new Edge3(2, 3), new Edge3(3, 0),
				new Edge3(4, 3), new Edge3(4, 5), new Edge3(5, 0));

		// total number of nodes in the graph (0 to 5)
		int n = 6;

		// build a directed graph from the given edges
		Graph3 graph = new Graph3(edges, n);
 
        // find the root vertex in the graph
        int root = findRootVertex(graph, n);
 
        if (root != -1) {
            System.out.println("The root vertex is " + root);
        }
        else {
            System.out.println("The root vertex does not exist");
        }
    }
}