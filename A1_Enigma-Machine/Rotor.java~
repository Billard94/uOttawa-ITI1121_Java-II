
/**
 * A <code>Rotor</code> is a rotating part of an <code>EnigmaMachine</code>.
 * This implementation provides 5 types of rotors which will be referred as
 * 1, 2, 3, 4, 5 representing the wirings of rotor types  I, II, III, IV, V 
 * used in the enigma M3 machine. Each rotor type has a specific wiring 
 * which represents a permutation and determines to which letter an
 * incoming letter will be encoded to. As the <code>Rotor</code> steps,
 * it changes the "rotor position" and so the position of the incoming 
 * letter with respect to the rotor wiring. The stepping of the rotor
 * is controlled via calls to the method <code>step</code> and affects 
 * the current rotor position.
 * 
 * @author Lucia Moura
 *
 */

public class Rotor {
	
	/**
	 * A class constant providing an array with the 5 types of
	 * wiring options. Wiring options at positions 0..4 correspond
	 * to the wirings of rotor types I..V
	 * Please do not change this constant declaration!
	 */
	private final static String[] WIRING_OPTION = {
		"EKMFLGDQVZNTOWYHXUSPAIBRCJ",
		"AJDKSIRUXBLHWTMCQGZNPYFVOE",
		"BDFHJLCPRTXVZNYEIWGAKMUSQO",
		"ESOVPZJAYQUIRHXLNFTGKDCMWB",
		"VZBRGITYUPSDNHLXAWMJQOFECK" 
	};

	/**
	 * A class constant providing an array with the notch positions
	 * for the corresponding 5 types of wiring options. 
	 * Notch position at positions 0..4 correspond the notch of rotor types I..V
	 * Please do not change this constant declaration!
	 */
	private final static char[] NOTCH_POSITION = {'R','F','W','K','A'};

	// ADD YOUR PRIVATE VARIABLES HERE	(mine are given below)
	
	// an array storing the wiring permutation:
	// wiring[0] indicates the output for letter 'A'
	// etc. wiring[25] indicated the output for letter 'Z'
	private final char [] wiring;  							

	// stores the position that this rotor must be to cause the next rotor to step
	private final char notch;

	// this stores rotor number (0..4) corresponding to rotor types (I..V)
	private final int number;

	// rotor initial position: set at the begining or later via a call to setRotorInitialPosition
	private int rotorInitialPosition; 

	// rotor current position
	// affected by changes in rotor initial position, resetRotorPosition, or step
	private int rotorPosition;

	/**
	 * A constructor of arity 1 that specifies the rotor type.
	 * The rotor position must be set to default initial position 'A'.
	 * 
	 * @param rotorType is a number 1..5 specifying types I..V
	 */
	public Rotor(int rotorType) {
		this(rotorType,'A');
	}

	/**
	 * A constructor of arity 2 that specifies the rotor type
	 * and initial position.
	 * 
	 * @param rotorType is a number 1..5 specifying types I..V
	 * @param startPosition is a capital letter 'A' to 'Z' specifying
	 * the initial rotor position 
	 */
	public Rotor(int rotorType, char startPosition) {
		
		// convert user rotor type 1-5 to my number 0-4
		if ((rotorType>=1)&&(rotorType<=5))
			number= rotorType-1;
		else number=0; // should never be reached
				
		// transfering characters of string one by one to char array
		// wiring = new char[26];
		// for (int i=0; i<26; i++)
		//	wiring[i] = WIRING_OPTION[number].charAt(i);
		// it can be done in one equivalent line as well as follows:
		wiring = WIRING_OPTION[number].toCharArray();

		notch = NOTCH_POSITION[number]; // initialize notch position

		// initialize intial and current rotor positions
		rotorInitialPosition=rotorPosition=Util.letterToIndex(startPosition);
	}

	
	/**
	 * Return the rotor type.
	 * @return the rotor type, a string containing a roman number which
	 * is one of "  I"," II","III"," IV","  V".
	 */
	public String getType() {
		String type;
		switch (number) {
			case 0: type="  I"; break;
			case 1: type=" II"; break;
			case 2: type="III"; break;
			case 3: type=" IV"; break;
			case 4: type="  V"; break;
			default: type="  ?";
		}
		return type;
	}
	
	/**
	 * Method <code>getWiring</code> returns the wiring encoding of this rotor
	 * @return a string of 26 letters representing the wiring encoding of this rotor.
	 */
	public String getWiring() {
		return String.valueOf(wiring);
	}
	
	/**
	 * Method <code>getInitialPosition</code> returns the initial position
	 * of this rotor. 
	 * @return the initial position of this rotor (which is the initial
	 * position when it was creation or the one given by a call 
	 * to setInitialRotorPosition, whichever was last)
	 */
	public char getInitialPosition() {
		return Util.indexToLetter(rotorInitialPosition);
	}
	
	/**
	 * Method <code>getCurrentPosition</code> returns the current letter
	 * position of this rotor. 
	 * @return the current letter position of this rotor
	 */
	public char getCurrentPosition() {
		return Util.indexToLetter(rotorPosition);
	}
	


	/**
	 * Method <code>outLetter</code> produces the resulting letter obtained
	 * from the the given letter entering one of the sides of the rotor
	 *  
	 * @param inputLetter is the letter entering the rotor
	 * @param forward specifies the direction of the encoding; true specifies
	 * the usual direction and false specifies the opposite direction
	 * @return the letter that comes out of the rotor
	 */
	public char outLetter(char inputLetter, boolean forward) {
	
		if (forward) {
			// *** permutation of letters given by wiring ***
			// covert entering letter by offset given by rotor position 
			int letterToPos=(Util.letterToIndex(inputLetter)+rotorPosition)%26;
			// covert the result of the wiring output by the offset of rotor position
			int outputPos= (Util.letterToIndex(wiring[letterToPos]) - rotorPosition+26)%26 ;
			return Util.indexToLetter(outputPos);
		}	
		else {
			// *** permutation of letters given by the inverse of wiring permutation ***
			// covert entering letter by offset given by rotor position
			int letterPos = (Util.letterToIndex(inputLetter)+rotorPosition)%26;
			char displacedLetter= Util.indexToLetter(letterPos);
			// this loop searchs for letter i with wiring[i] = input letter after displacement
			for (int i=0; i<26; i++)
				if (wiring[i]==displacedLetter) {
					// convert the result from backward wiring by rotor position
					return Util.indexToLetter((i-rotorPosition+26)%26);
				}
			return Util.INVALIDLETTER_CODE; // should never be reached really
		}
	}

	/**
	 * Method <code>step</code> makes the rotor advance its position by one 
	 * letter of the alphabet (e.g. if its position was 'A' after stepping 
	 * it becomes 'B' and if it was 'Z' after stepping it becomes 'A')
	 */
	public void step() {
		rotorPosition=(rotorPosition+1)%26; // adds one to position (circularly)
	}
	

	/**
	 * Method <code>setInitialRotorPosition</code> sets both the rotor
	 * initial position and the rotor current position to the given letter.
	 * 
	 * @param letter is the new value for initial rotor position and current
	 * rotor position.
	 */
	public void setInitialRotorPosition(char letter) {
		rotorPosition = rotorInitialPosition = Util.letterToIndex(letter);
	}

	/**
	 * Method <code>resetRotorPosition</code> makes the current rotor
	 * position to go back to the initial rotor position.
	 */
	public void resetRotorPosition() {
		rotorPosition = rotorInitialPosition;
	}

	
	/**
	 * Method <code>atNotch</code> indicates whether the current rotor position
	 * is at the rotor notch (a special position that may make a rotor next 
	 * to this to step)
	 * 
	 * @return a boolean value indicating if the rotor is currently at its
	 * notch position 
	 */
	public boolean atNotch() {
		if (Util.indexToLetter(rotorPosition)==notch) return true;
		else return false;
	}
	
	/**
	 * Method <code>getNotch</code> returns the notch position of the rotor
	 * @return the notch position of the rotor
	 */
	public char getNotch() {
		return notch;
	}
	

    /**
     * This method overrides java.lang.Object.toString() and
     * returns a string representation of this <code>Rotor</code>.
     * 
     * @return a string representation of this <code>Rotor</code>
     */	
	public String toString() {
		// here we have provided a standard output format uniform for 
		// all students; please do not alter this format.
		return "Rotor type "+ getType()+", Wiring:"+ getWiring()
				+", Notch:"+ getNotch() 
				+", Initial position: "+getInitialPosition()
				+", Current position: "+getCurrentPosition();

	}

};