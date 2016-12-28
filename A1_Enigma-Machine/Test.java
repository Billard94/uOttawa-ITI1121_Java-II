
public class Test {

	private static boolean verbose=false;
	
	/**
	 * This creates an enigma machine, given its characteristics.
	 * 
	 * @param r1 is the type of rotor 1 (right rotor)
	 * @param r2 is the type of rotor 2 (middle rotor)
	 * @param r3 is the type of rotor 3 (left rotor)
	 * @param refl is the type of the reflector
	 * @param startPos1 is the start position of rotor 1
	 * @param startPos2 is the start position of rotor 1
	 * @param startPos3 is the start position of rotor 1
	 * @param stepping specifies if rotors step (true is the default position
	 * and the only one that can matych the behaviour of the mentioned
	 * emulator; setting stepping to false allows you to test the rotors
	 * independently of your machine doing the stepping correctly.
	 * @return an EnigmaMachine with the given characteristics
	 */
	public static EnigmaMachine buildEnigmaMachine(int r1, int r2, int r3, int refl,  
			char startPos1, char startPos2, char startPos3,boolean stepping) {
	
		EnigmaMachine M3 = new EnigmaMachine( r1, r2, r3, refl,
				 startPos1, startPos2, startPos3);
		if (stepping)
			M3.enableStepping();
		else 
			M3.disableStepping();
		return M3;
	}
	
	/**
	 * Tests an EnigmaMachine with a given plaintext. It first encodes the 
	 * plaintext into a cyphertext. Then it runs the cyphertext into the
	 * enigma machine obtaining a decyphered text which is verified if it
	 * matches with the original plaintext; the result of this verification
	 * is returned. If in verbose mode, it prints the enigma machine before
	 * and after encoding as well as the plaintext, cyphertext, decyphertext.
	 * 
	 * @param M3 is an enigma machine
	 * @param plainText is a plaintext
	 * @return true if and only if M3 encodes and decodes compatibly
	 * (i.e. M3 applied to result of M3 applied to plaintext equals plaintext)
	 */
	public static boolean testEnigmaMachine(EnigmaMachine M3, String plainText) {

		M3.resetRotorPositions();
		if (verbose) System.out.println(M3);
		String cypherText=M3.encrypt(plainText);
		if (verbose) System.out.println(M3);
		M3.resetRotorPositions();
		String decypherText=M3.encrypt(cypherText);
	
		boolean match=plainText.equals(decypherText);
		if (verbose) {
			if (match) 
				System.out.println("Matching texts:");
			else 
				System.out.println("ERROR -unmatching texts:");
			System.out.println(plainText+"\n"+cypherText+"\n"+decypherText);
		}
		return match;
			
	}
	
	
	// Some basic testing has been provided below.
	// A more complete testing will be used for marking.
	// Feel free to use this skeleton to test different functionality 
	// of your classes, comparing to the output of the Enigma Machine
	// Emulator found at: http://enigma.louisedade.co.uk/index.html
	// Our implementation does not use ring setting which is available
	// in the emulator; this means you must set "Ringstellung" to AAA
	// when using the Enigma Machine Emulator.
	//
	
	/**
	 * Provides a basic set of testing for the <code>EnigmaMachine</code> class.
	 * @param args
	 */
	public static void main(String[] args) {
		
		StudentInfo.display();
		
		boolean allFine=true; verbose=true;
		boolean match;
		
		// verbose=false; remove this to disable verbose mode
		
		EnigmaMachine enigmaMachine;
		enigmaMachine=
				buildEnigmaMachine(3,2,1,1,'A','A','A',false);
		
		// This test tests rotors without stepping and reflector
		match=testEnigmaMachine(enigmaMachine,"AAAAA");
		
		allFine = allFine && match;
		
		// This test tests rotors (with stepping) and reflector
		enigmaMachine.enableStepping();
		
		enigmaMachine.setInitialRotorPositions('Z','A','A');
			
		match=testEnigmaMachine(enigmaMachine,"AAAAA");
		
		allFine = allFine && match;
		
		// This test tests now also tests the plugboard
		
		enigmaMachine.resetRotorPositions();
		enigmaMachine.plug('A','B');
		
		match=testEnigmaMachine(enigmaMachine,"AAAAA");
		
		allFine = allFine && match;
		
		
		// This tests a different machine setting with different plugs
		
		enigmaMachine= new EnigmaMachine(4,3,5,2,'R','X','M');
		enigmaMachine.enableStepping();
		enigmaMachine.plug('A', 'B');
		enigmaMachine.plug('E', 'R');
		enigmaMachine.plug('H', 'C');
		
		match=testEnigmaMachine(enigmaMachine,"ABCDE");
		
		allFine = allFine && match;
		
		// This tests stepping more thoroughly for many long strings
		// turns verbose off 
		
		verbose=false;
		
		System.out.println("\nTesting longer strings now...\n");
		
		for (int i=0;i<26;i++) {
			char c= (char) ((int)'A'+(i%26)); // goes varying the letter
			// makes a string s with 10,000 letters equal to c
			String s=new String("");
			for (int j=0; j<10000; j++)
				s+=c;
			enigmaMachine.resetRotorPositions();
			match=testEnigmaMachine(enigmaMachine,s);
			allFine = allFine && match;
			if (!match) 
				System.out.println("\nTest doesn't match for 10,000"+c+"'s\n");
			else
				System.out.print("Ok for 10,000 "+c+"'s,");
				
		}


		
		if (allFine) 
			System.out.println("\n\nAll tests have compatible encode-decode!");
		else
			System.out.println("\n\nAt least one test have incompatible encode-decode!");
			
	}
	
};
