
/**
 * The class <code>EnigmaMachine</code> implements an enigma machine with 
 * three rotors known as enigma machine M3.
 * It is comprised of one plugboard, 3 rotors (out of 5 types of rotors)
 * and one reflector (out of two types of reflectors).
 * Below we call the Right, Middle and Left rotors as 
 * rotor1, rotor2 and rotor3, respectively.
 * 
 * @author Lucia Moura
 *
 */


public class EnigmaMachine {


	/**
	 * An array that stores rotors 1, 2, 3 in positions 0, 1, 2, respectively.
	 */
	private Rotor[] rotors;
	
	/**
	 * The reflector of this enigma machine.
	 */
	private Reflector reflector;
	

	/**
	 * The plugboard of this enigma machine.
	 */
	private PlugBoard plugBoard;
	
	/**
	 * An auxiliary boolean variable indicating if stepping is enabled.
	 */
	private boolean stepping=true;
	
	
	/**
	 * A constructor of arity 0 that sets the machine to default values:
	 * rotors RML are types I, II, III, reflector is type B
	 * rotor positions AAA
	 */
	public EnigmaMachine() {
		this(1,2,3,1,'A','A','A');	
	}
	
	/**
	 * A constructor of arity 4 that sets the machine to given 
	 * rotor and refletor types; rotor positions set to default values AAA.
	 * 
	 * @param rotor1Type is the type of the right  rotor (number 1..5)
	 * @param rotor2Type is the type of the middle rotor (number 1..5)
	 * @param rotor3Type is the type of the left   rotor (number 1..5)
	 * @param reflectorType is the type of reflector: 1 is type B, 2 is type C.
	 */
	public EnigmaMachine( int rotor1Type, int rotor2Type, int rotor3Type, 
			int reflectorType) {
		this(rotor1Type,rotor2Type,rotor3Type,reflectorType,
				'A','A','A');
	}
		
	
    /**
     * A constructor of arity 7 that sets the machine to given 
	 * rotor types, refletor type and rotor positions.
	 * 
     * @param rotor1Type is the type of the right  rotor (number 1..5)
     * @param rotor2Type is the type of the middle rotor (number 1..5)
     * @param rotor3Type is the type of the left   rotor (number 1..5)
     * @param reflectorType is the type of reflector: 1 is type B, 2 is type C.
     * @param startPos1 is the char position of the right rotor.
     * @param startPos2 is the char position of the middle rotor.
     * @param startPos3 is the char position of the left rotor.
     */
    public EnigmaMachine( int rotor1Type, int rotor2Type, int rotor3Type, 
    		int reflectorType, 
    		char startPos1, char startPos2, char startPos3) {
		
    	// creating machine elements: 
    	// 3 instances of Rotor, 1 instance of Reflector, 1 instance of Plugboard
		rotors=new Rotor[3];
		rotors[0]=new Rotor(rotor1Type,startPos1);
		rotors[1]=new Rotor(rotor2Type,startPos2);
		rotors[2]=new Rotor(rotor3Type,startPos3);
		reflector = new Reflector(reflectorType);
		plugBoard = new PlugBoard();
	}
	
	/**
	 * The method <code>enableStepping</code> sets the machine to allow the 
	 * rotors step according to the stepping rules. This should be the 
	 * default state of the machine.
	 */
	public void enableStepping() {
		stepping = true;
	}

	/**
	 * The method <code>disableStepping</code> sets the machine to disallow 
	 * the rotors stepping. This is used for testing purposes only so that 
	 * rotor encoding can be tested independently of the stepping mechanism.
	 */
	public void disableStepping() {
		stepping = false;
	}
	
	/**
	 * The method <code>setInitialRotorPositions</code> initializes the 
	 * initial position of the rotors for the next encoding to be as given.
	 * Historically in WWW2, rotor and reflector types where changed daily
	 * while rotor positions where changed for each message transmitted.
	 * 
	 * @param letter1 is the initial position for the right rotor (rotor1)
	 * @param letter2 is the initial position for the middle rotor (rotor2)
	 * @param letter3 is the initial position for the left rotor (rotor3)
	 */
	public void setInitialRotorPositions(char letter1, char letter2, char letter3) {
			rotors[0].setInitialRotorPosition(letter1);	
			rotors[1].setInitialRotorPosition(letter2);
			rotors[2].setInitialRotorPosition(letter3);
	}
	
	/**
	 * The method resetRotorPositions brings the rotor positions to their
	 * initial rotor position values. This "initial rotor position" is set 
	 * at machine creation and may have been updated by a former call to 
	 * setInitialRotorPositions().
	 * This  has been provided to facilitate resending the same message 
	 * or testing the decoding of the last message sent.
	 * 
	 */	
	public void resetRotorPositions() {
		for (int i=0; i<3; i++) 
			rotors[i].resetRotorPosition();			
	}
	
	
	/**
	 * The method <code>plug</code> plugs the two given letters in the 
	 * plugboard.
	 * 
	 * @param letter1 is a letter to be plugged to the other letter given.
	 * @param letter2 is a letter to be plugged to the other letter given.
	 */
	public void plug(char letter1, char letter2) {
		plugBoard.plug(letter1, letter2);
	}

	

	/**
	 * This method <code>encrypt</code> performs the encoding of one letter
	 * going through the enigma machine, executing the letter trip through 
	 * the various machine elements, until it gets encoded as a new output 
	 * letter that is returned.
	 * Note: the stepping of the rotos is done before the character travels
	 * through the rotors.
	 * 
	 * @param letter is the input letter (a capital letter from 'A' to 'Z')
	 * @return the output encoded letter (a capital letter from 'A' to 'Z')
	 */
	public char encrypt(char letter) {
		
		// *** Enigma machine main encryption for 1 letter ****
		
		// letter passes through plugboard
		letter=plugBoard.outLetter(letter); 
		
		// all rotors step
		stepRotors();
		
		// letter passes through rotors 1, 2, 3 direction forward
		for (int i=0; i<3;i++) 
		   letter=rotors[i].outLetter(letter,true);
		
		// letter passes through the reflector
		letter = reflector.outLetter(letter);
		
		// letter passes through rotors 3, 2, 1 direction backward
		for (int i=2; i>=0;i--) 
			letter=rotors[i].outLetter(letter,false);
		
		// letter passes through the plugboard
		letter=plugBoard.outLetter(letter); 
		
		return letter;
	}

	
	/**
	 * This method <code>encrypt</code> performs the encoding of a whole
	 * text going through the Enigma machine, by successive calling the
	 * encoding of each of its individual letters.
	 * 
	 * @param text is the input text consisting only of capital letters ('A' to 'Z')
	 * @return is the output encoded text
	 */
	public String encrypt(String text){
		String output=new String("");
		for (int i=0; i<text.length();i++) 
			output = output + encrypt(text.charAt(i));
		return output;
		
	}
		

	
	/**
	 * The method <code>stepRotors</code> controls the stepping of
	 * the 3 rotors from right to left always stepping the right
	 * rotor (rotor1) and sometimes stepping rotors 2 and 3 depending
	 * on the position of the previous rotor relatively to their notch
	 * position. This method does nothing if stepping has been disabled.
	 */
	private void stepRotors() { 
		if (stepping) {
			boolean stepNextRotor=true; // always step 1st rotor
			for (int i=0; i<3; i++) {
				if (stepNextRotor) rotors[i].step();
				stepNextRotor=rotors[i].atNotch(); // decide if steps next rotor based on
												   // current rotor being at notch
			}
		
		}
	
	}
	
    /**
     * This method overrides java.lang.Object.toString() and 
     * returns a string representation of this <code>EnigmaMahine</code>.
     * 
     * @return a string representation of this <code>EnigmaMahine</code>
     */	
	
	public String toString() {
		// here we have provided a standard output format uniform for 
		// all students; please do not alter this format.
		
		return "EnigmaMachine:\n"+rotors[0]+"\n"+rotors[1]+"\n"+rotors[2]
			 +"\n"+reflector+"\n"+plugBoard+"\n";
	}
	
};
