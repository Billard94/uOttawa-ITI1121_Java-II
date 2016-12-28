
public class Util {
	
/**
 * Constant that can be used if needed.
 */
public final static int ALPHABET_OFFSET=(int)'A';

/**
 * Constant that can be used if needed.
 */
public final static char INVALIDLETTER_CODE='*';

/**
 * Performs conversion from letters 'A'..'Z' to integers 0..25
 * @param letter is the input letter, a capital letter ('A'..'Z')
 * @return the corresponding number (0..25)
 */
public static int letterToIndex(char letter) {
	int indexValue=(int)letter;
	indexValue=indexValue-ALPHABET_OFFSET;
	return indexValue;
}

/**
 * Performs conversion from integers 0..25 to letters 'A'..'Z'
 * @param index is the input integer (0..25)
 * @return the output letter ('A'..'Z')
 */
public static char indexToLetter(int index) {
	return (char) (index+ALPHABET_OFFSET);
}

/**
 * Checks whether the given character is a valid capital letter
 * @param c is an input character
 * @return true if and only if c is a capital letter ('A'..'Z')
 */
public static boolean validLetter(char c) {
	int indexValue=letterToIndex(c);
	return ((indexValue>=0)&&(indexValue<26));
}

};