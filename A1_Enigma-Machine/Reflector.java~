
/**
 * A <code>Reflector</code> is a device of an enigma machine that is used
 * to swap the values between pairs of letters according to the way
 * its wires are setup. 
 * 
 * This implementation provides 2 types of reflectors B and C
 * representing the possible reflectors used in the enigma M3 machine. 
 * 
 * It is called reflector because letters are permuted in pairs (for example, 
 * in reflector type B you noticed that an entering letter 'A' gets changed 
 * to letter 'Y' and an entering letter 'Y' gets changed to letter 'A')
 * 
 * @author Lucia Moura
 *
 */
public class Reflector {

	
	/**
	 * A class constant providing an array with the 2 types of reflector.
	 * Reflector option at positions 0 and 1 correspond to reflector
	 * types B and C, respectively.
	 */
	private final static String [] REFLECTOR_OPTION = {
		"YRUHQSLDPXNGOKMIEBFZCWVJAT",
		"FVPJIAOYEDRZXWGCTKUQSBNMHL"};

	// ADD YOUR PRIVATE VARIABLES HERE (I added mine below)
	private final char reflectorType; // stores type of reflector 1,2 to represent types B, C
	
	private final char[] reflector; // stores the wiring of the reflector
	
	/**
	 * A constructor of arity 1 that specifies the reflector type.
	 * 
	 * @param rotorType is an integer 1 or 2 specifying types B and C,
	 * respectively.
	 */
	public Reflector(int typeReflector) {
		
		switch (typeReflector) {
		case 1: reflectorType = 'B'; break;
		case 2: reflectorType = 'C'; break;
		default: reflectorType = 'B'; typeReflector=1; // should neve be reached
				
		}
		reflector=REFLECTOR_OPTION[typeReflector-1].toCharArray();
	}
	
	
	/**
	 * Method <code>outLetter</code> produces the output letter obtained
	 * after the given letter enters the reflector. 
	 *  
	 * @param inputLetter is the letter entering the reflector
	 * @return the letter that comes out of the reflector
	 */
	public char outLetter(char inputLetter) {
		int position=Util.letterToIndex(inputLetter);
		return reflector[position];
	}
	
	/**
	 * Method <code>getType</code> returns the type of this reflector.
	 * 
	 * @return the type of this reflector (B or C)
	 */
	public char getType() {
		return reflectorType; 	
	}
	
	/**
	 * Method <code>getWiring</code> returns a string representing 
	 * the wiring of this reflector.
	 * @return a string of 26 letters representing the wiring of this reflector.
	 */
	public String  getWiring() {
		return String.valueOf(reflector);
	}

	 /**
     * This method overrides java.lang.Object.toString() and 
     * returns a string representation of this <code>Reflector</code>.
     * 
     * @return a string representation of this <code>Reflector</code>
     */	
	public String toString() {
		// here we have provided a standard output format uniform for 
		// all students; please do not alter this format.
		return "Reflector type " + getType() +
				", Wiring: "+ getWiring();
	}
}
