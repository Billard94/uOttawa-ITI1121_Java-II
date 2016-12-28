
/**
 * The class <code>PlugBoard</code> implements the plugboard of 
 * an Enigma machine. Pairs of letters in the plugboard may 
 * get connected by a plug, making a letter get its value spapped
 * by the letter it is plugged to when it passes through the plugboard.
 * 
 * @author Lucia Moura
 *
 */
public class PlugBoard {
	
	// ADD YOUR PRIVATE VARIABLES HERE (here are mine)
	
	private char[] swaps; // this array stores the permutation done by the plugboard
	
	/**
	 * the constructor creates an instance of <code>PlugBoard</code>
	 * without any plugs.
	 */
	public PlugBoard() {
	  // before all plugs the permutation does nothing (swap['A']='A',etc, swap['Z']='Z')
	  String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  swaps = alphabet.toCharArray(); 
	}
	
	/**
	 * Method <code>plug</code> connects two letters via a plug if they
	 * have not been plugged to any other letter. If any of the two letter 
	 * has already been plugged it does nothing.
	 * 
	 * @param c1 is one of the letters to be plugged to the other.
	 * @param c2 is one of the letters to be plugged to the other.
	 */
	public void plug (char c1, char c2) {
		int posc1=Util.letterToIndex(c1),
		    posc2=Util.letterToIndex(c2);
		
		if ((swaps[posc1]==c1)&&(swaps[posc2]==c2)) {
			// swap the two letters in the permutation (only if they have not been pluged before)
			swaps[posc1]=c2;
			swaps[posc2]=c1;
		}
	}
	
	/**
	 * Method <code>outLetter</code> returns the letter than comes out the 
	 * plugboard after the given letter enters the plugboard (if the letter 
	 * has been previously plugged to another its value will be changed to
	 * the value of that other letter; otherwise it will be left unchanged)
	 * 
	 * @param letter is the letter that enters the plugboard
	 * @return is the letter that  exits the plugboard
	 */
	public char outLetter(char letter) {
		return swaps[Util.letterToIndex(letter)]; //return permuted letter
	}
	
		
	 /**
     * This method overrides java.lang.Object.toString() and 
     * returns a string representation of this <code>PlugBoard</code>.
     * 
     * @return a string representation of this <code>PlugBoard</code>
     */	
	
	public String toString() {
		// Here you must conform to the following standard return string:
		// return the string "Plugboard:" concatenated with a a string 
	    // of 26 characters corresponding to letters 'A'..'Z' that has '*' 
	    // at positions that are not plugged and has the corresponding
	    // plugged letter at positions that are plugged.
		
		String s = new String("");
		for (int i=0; i<26; i++) {
			if (swaps[i]==Util.indexToLetter(i))
				s = s+'*';
			else
				s = s+swaps[i];
		}

		return "Plugboard:"+s;
	}
};

