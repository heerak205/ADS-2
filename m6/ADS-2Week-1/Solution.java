import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
class PageRank {
	int outDeg;
	int inDeg;
	Digraph digraph;
	HashMap<Integer, ArrayList<Integer>> newVertices;
	HashMap<Integer, Double> values;
	HashMap<Integer, Double> ranks;
	PageRank(Digraph digraph, Integer vertex) {
		this.outDeg = digraph.outdegree(vertex);
		this.inDeg = digraph.indegree(vertex);
		this.digraph = digraph;
		newVertices = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < digraph.V(); i++) {
			for (Integer k : digraph.adj(i)) {
				if (newVertices.containsKey(k)) {
					ArrayList<Integer> list = newVertices.get(k);
					list.add(i);
					newVertices.put(k, list);
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					newVertices.put(k, list);
				}
			}
		}
	}
	double getPagrnk(int vertex) {
		if (digraph.outdegree(vertex) == 0) {
			return 0.0;
		}
		values = new HashMap<Integer, Double>();
		for (int i = 0; i < digraph.V(); i++) {
			values.put(i , 1.0 / digraph.V());
		}
		double rank = 0.0;
		for (int i = 0; i < 1000; i++) {
			for (Integer k : newVertices.keySet()) {
				System.out.println("K" + k);
				ArrayList<Integer> vert = newVertices.get(k);
				System.out.println("vert: " + vert);
				for(int j = 0; j < vert.size(); j++) {
					int key = vert.get(j);
					System.out.println("Key: "+ values.get(key));
					rank = values.get(key) / digraph.outdegree(key);
					values.put(key , rank); 
				}
			}
		}
		return rank;
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices

		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		
		
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case 
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		Scanner scan = new Scanner(System.in);
		int vertices = Integer.parseInt(scan.nextLine());
		Digraph digraph = new Digraph(vertices);
		int vertices1 = vertices;
		while(vertices1 > 0 ) {
			String[] ofvertex = scan.nextLine().split(" ");
			int v = Integer.parseInt(ofvertex[0]);
			for(int i = 1; i < ofvertex.length; i++) {
				digraph.addEdge(v, Integer.parseInt(ofvertex[i]));
			}
			vertices1--;
		}
		ArrayList<PageRank> pagrnkLst = new ArrayList<>();
		System.out.println(digraph.V() + " vertices, "+ digraph.E() + " edigraphes ");
		for (int i = 0; i < vertices; i++) {
			System.out.print(i + ": ");
			PageRank pr = new PageRank(digraph, i);
			pagrnkLst.add(pr);
			for (Integer k : digraph.adj(i)) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}