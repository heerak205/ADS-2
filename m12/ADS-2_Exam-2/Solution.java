/**
 * {scanner import}.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * {main method that drives the program}.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner s = new Scanner(System.in);
        int vertices = Integer.parseInt(s.nextLine());
        int edges = Integer.parseInt(s.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(vertices);
        int k = edges;
        while (k > 0) {
            String[] ofEdges = s.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(ofEdges[0]),
                Integer.parseInt(ofEdges[1]),
                Integer.parseInt(ofEdges[2]));
            ewg.addEdge(edge);
            k--;
        }
        String caseToGo = s.nextLine();
        switch (caseToGo) {
        case "Graph":
            System.out.println(ewg);
            break;
        case "DirectedPaths":
            // Handle the case of DirectedPaths,
            // where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found.".
            String[] directedPaths = s.nextLine().split(" ");
            int m = Integer.parseInt(directedPaths[0]);
            int n = Integer.parseInt(directedPaths[1]);
            DijkstraUndirectedSP sp = new DijkstraUndirectedSP(ewg, m);
            if (sp.hasPathTo(n)) {
                System.out.println(sp.distTo(n));
            } else {
                System.out.println("No Path Found.");
            }
            break;
        case "ViaPaths":
            // Handle the case of ViaPaths,
            // where three integers are given.
            // First is the source and second is the via is the.
            // one where path should pass through.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found.".
            String[] viaPaths = s.nextLine().split(" ");
            m = Integer.parseInt(viaPaths[0]);
            int via = Integer.parseInt(viaPaths[1]);
            n = Integer.parseInt(viaPaths[viaPaths.length - 1]);
            DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(ewg, m);
            if (dsp.hasPathTo(n)) {
                for (Edge e : dsp.pathTo(via)) {
                    System.out.print(e + "   ");
                }
                DijkstraUndirectedSP two = new DijkstraUndirectedSP(ewg, via);
                for (Edge e : two.pathTo(n)) {
                    System.out.print(e + "   ");
                }
                System.out.println(dsp.distTo(n));
            } else {
                System.out.println("No Path Found.");
            }
            break;
        default:
            break;
        }
    }
}
