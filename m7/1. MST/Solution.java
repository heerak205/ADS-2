/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int vertices = Integer.parseInt(s.nextLine());
        int edges = Integer.parseInt(s.nextLine());
        EdgeWeightedGraph edgegraph = new EdgeWeightedGraph(vertices);
        while (s.hasNextLine()) {
            String[] input = s.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]), Double.parseDouble(input[2]));
            edgegraph.addEdge(edge);
        }
        KruskalMST kruskal = new KruskalMST(edgegraph);
        System.out.format("%.5f", kruskal.weight());
    }
}


