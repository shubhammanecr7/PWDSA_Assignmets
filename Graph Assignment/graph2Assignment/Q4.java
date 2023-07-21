package graph2Assignment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//A class to store a graph edge
class Edge4
{
 int source, dest;

 public Edge4(int source, int dest)
 {
     this.source = source;
     this.dest = dest;
 }
}

//A BFS Node
class Node4
{
 // stores current vertex number and the current depth of
 // BFS (how far away from source current node is)
 int vertex, depth;

 public Node4(int vertex, int depth)
 {
     this.vertex = vertex;
     this.depth = depth;
 }
}

//A class to represent a graph object
class Graph4
{
 // A list of lists to represent an adjacency list
 List<List<Integer>> adjList = null;

 // Constructor
 Graph4(List<Edge4> edges, int n)
 {
     adjList = new ArrayList<>();
     for (int i = 0; i < n; i++) {
         adjList.add(new ArrayList<>());
     }

     // add edges to the directed graph
     for (Edge4 edge: edges) {
         adjList.get(edge.source).add(edge.dest);
     }
 }
}
public class Q4 {
	/*
	 * Q4. Given a digraph (directed graph), find the total number of routes to
	 * reach the destination from a given source with exactly m edges.
	 */
	
	// Perform BFS on graph `graph` starting from vertex `v`
    public static int findTotalPaths(Graph4 graph, int src, int dest, int m)
    {
        // create a queue for doing BFS
        Queue<Node4> q = new ArrayDeque<>();
 
        // enqueue source vertex
        q.add(new Node4(src, 0));
 
        // stores number of paths from source to destination
        // having exactly `m` edges
        int count = 0;
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node
            Node4 node = q.poll();
 
            int v = node.vertex;
            int depth = node.depth;
 
            // if the destination is reached and BFS depth is equal to `m`,
            // update count
            if (v == dest && depth == m) {
                count++;
            }
 
            // don't consider nodes having a BFS depth more than `m`.
            // This check will result in optimized code and handle cycles
            // in the graph (otherwise, the loop will never break)
            if (depth > m) {
                break;
            }
 
            // do for every adjacent vertex `u` of `v`
            for (int u: graph.adjList.get(v))
            {
                // push every vertex (discovered or undiscovered) into the queue
                q.add(new Node4(u, depth + 1));
            }
        }
 
        // return number of paths from source to destination
        return count;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge4> edges = Arrays.asList(
                new Edge4(0, 6), new Edge4(0, 1), new Edge4(1, 6), new Edge4(1, 5),
                new Edge4(1, 2), new Edge4(2, 3), new Edge4(3, 4), new Edge4(5, 2),
                new Edge4(5, 3), new Edge4(5, 4), new Edge4(6, 5), new Edge4(7, 6),
                new Edge4(7, 1));
 
        // total number of nodes in the graph
        int n = 8;
 
        // construct graph
        Graph4 graph = new Graph4(edges, n);
 
        int src = 0, dest = 3, m = 4;
 
        // Do modified BFS traversal from the source vertex src
        System.out.println(findTotalPaths(graph, src, dest, m));
    }
}
