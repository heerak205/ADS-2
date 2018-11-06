/**
 * Files import.
 */
import java.io.File;
/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty Constructor.
    }
    /**
     * Main function.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  { exception_description }
     */
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        String synset = s.nextLine();
        String hypernyms = s.nextLine();
        try {
            WordNet wordnet = new WordNet(synset, hypernyms);
            String input = s.nextLine();
            if (wordnet.gethasCycle()) {
                System.out.println("Cycle detected");
                return;
            }

            if (input.equals("Graph")) {
                wordnet.checkMultipleRoots();
                if (wordnet.gethasMultipleRoots()) {
                    return;
                } else {
                    System.out.println(wordnet.getDigraph());
                }
            } 
            if (input.equals("Queries")) {
                while (s.hasNextLine()) {
                    String[] tokens = s.nextLine().split(" ");
                    try {
                        wordnet.sap(tokens[0], tokens[1]);
                        System.out.println("distance = "
                            + wordnet.distance(tokens[0], tokens[1])
                            + ", ancestor = " + wordnet.sap(tokens[0], tokens[1]));
                    } catch (Exception e) {
                        System.out.println("IllegalArgumentException");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
