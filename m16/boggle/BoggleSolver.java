import java.util.HashSet;
/**
 * Class for boggle solver.
 */
public class BoggleSolver {
    // Initializes the data structure using
    // the given array of strings as the dictionary.
    // (You can assume each word in the dictionary
    // contains only the uppercase letters A through Z.)
    private TrieSET dict;
    /**
     * Constructs the object.
     *
     * @param      dictionary  The dictionary
     */
    public BoggleSolver(final String[] dictionary) {
        dict = new TrieSET();
        for (String word : dictionary) {
            dict.add(word);
        }
    }

    // Returns the set of all valid words in
    // the given Boggle board, as an Iterable.

    /**
     * Gets all valid words.
     *
     * @param      board  The board
     *
     * @return     All valid words.
     */
    public Iterable<String> getAllValidWords(final BoggleBoard board) {
        if (board == null) {
            throw new NullPointerException("board is null");
        }

        HashSet<String> validWords = new HashSet<String>();

        int r = board.rows();
        int c = board.cols();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                boolean[][] visited = new boolean[r][c];
                collect(board, i, j, visited, "", validWords);
            }
        }
        return validWords;
    }
    private void collect(final BoggleBoard board, final int row,
                         final int col, final boolean[][] visited,
                         final String prefix, final HashSet<String> set) {
        if (visited[row][col]) {
            return;
        }

        char letter = board.getLetter(row, col);
        String word = prefix;

        if (letter == 'Q') {
            word += "QU";
        } else {
            word += letter;
        }

        if (!dict.hasPrefix(word)) {
            return;
        }

        if (word.length() > 2 && dict.contains(word)) {
            set.add(word);
        }

        visited[row][col] = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0)
                        && (col + j < board.cols())) {
                    collect(board, row + i, col + j, visited, word, set);
                }
            }
        }

        visited[row][col] = false;
    }
    // Returns the score of the given word if i
    // t is in the dictionary, zero otherwise.
    // (You can assume the word contains only
    //  the uppercase letters A through Z.)
    /**
     * {to determine score}.
     *
     * @param      word  The word
     *
     * @return     {int}.
     */
    public int scoreOf(String word) {
        if (word.length() == 3 || word.length() == 4) {
            return 1;
        } else if (word.length() == 5) {
            return 2;
        } else if (word.length() == 6) {
            return 3;
        } else if (word.length() == 7) {
            return 5;
        } else if (word.length() >= 8) {
            return 11;
        }
        return 0;
    }
}
