import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        String[] keys = sc.nextLine().split(",");
        Newgraph graph = new Newgraph(vertices);
        while (sc.hasNext()) {
            String[] conn = sc.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(conn[0]),
                Integer.parseInt(conn[1]));
        }
        switch (type) {
            case "List":
            try {
                graph.display1(vertices, edges, keys);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case "Matrix":
            try {
                graph.display2(vertices, edges);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            default:
            break;
        }
    }
}

