import java.util.Scanner;
/**
 * { Solution for class }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        Scanner scan = new Scanner(System.in);
        TST<Integer> tst = new TST<Integer>();
        String prefix = scan.nextLine();
        int k = 0;
        for (String word : words) {
            SuffixArray sa = new SuffixArray(word);
            for (int a = 0; a < word.length(); a++) {
                tst.put(sa.select(a), k++);
            }
        }
        for (String word : tst.keysWithPrefix(prefix)) {
            System.out.println(word);
        }
    }
    /**
     * Loads words.
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        return words;
    }
}
