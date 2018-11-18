/**
 * Class for score of.
 */
public class score{
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
