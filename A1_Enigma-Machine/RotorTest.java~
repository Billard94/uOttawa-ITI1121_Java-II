import static org.junit.Assert.*;

import org.junit.Test;

/** JUnit test for class Rotor 
 *  Test individual methods with many possible combinations of rotors and operations
 *  
 *  Note: if you wish to add more tests, please do not use the
 *  same rotors stored in rotor array (rotor[0],...,rotor[4]).
 *  Instead create new rotors. 
 *  If your tests would change these rotor positions, 
 *  the current assertions in the given tests wouldn't be correct
 *  
 * @author Lucia Moura
 *
 */
public class RotorTest {
	
	private final static String[] WIRING_OPTION = {
		"EKMFLGDQVZNTOWYHXUSPAIBRCJ",
		"AJDKSIRUXBLHWTMCQGZNPYFVOE",
		"BDFHJLCPRTXVZNYEIWGAKMUSQO",
		"ESOVPZJAYQUIRHXLNFTGKDCMWB",
		"VZBRGITYUPSDNHLXAWMJQOFECK" 
	};
	
	private final Rotor[] rotor = new Rotor[5];
	
	
	public RotorTest() {
		// initialize 5 rotors to the 5 types of rotors possible in different initial positions
		rotor[0]=new Rotor(1,'C');
		rotor[1]=new Rotor(2,'Z');
		rotor[2]=new Rotor(3,'G');
		rotor[3]=new Rotor(4,'G');
		rotor[4]=new Rotor(5,'G');
		
	}

	
	@Test
	public void rotor1EncodingForwardNoStepTest() {
		// Test rotor type I, forward encoding,  no step
		assertEquals("outLetter: Rotor I, no step, forward\n", 'K',rotor[0].outLetter('A', true));
	};
	
	@Test
	public void rotor1EncodingBackwardNoStepTest() {
		// Test rotor type I, forward encoding, no step
		assertEquals("outLetter: Rotor I, no step, backward\n", 'A',rotor[0].outLetter('K', false));
	};
	
	@Test
	public void rotor1EncodingForwardYesStepTest() {
		// Test rotor type I, forward encoding, step
		rotor[0].step();
		assertEquals("outLetter: Rotor I, no step, forward\n", 'C',rotor[0].outLetter('A', true));
	};
	
	@Test
	public void rotor4EncodingBackwardYesStepTest() {
		// Test rotor type IV, backward encoding, step
		rotor[3].step();
		assertEquals("outLetter: Rotor IV, step, backward\n", 'M',rotor[3].outLetter('Z', false));
	};

	@Test
	public void getWiringTest() {
		// Test whether the wiring employed is correct; it will stop at the first incorrect one
		for (int i=0; i<5; i++) {
		    assertEquals("getWiring"+i+"not matching\n", WIRING_OPTION[i],rotor[i].getWiring());
		}
	}
	
	@Test
	public void rotor5stepTest() {
		// step 5 times and check it went from 'G' to 'L'
		for (int i=0; i<5; i++) 
			rotor[4].step();
		assertEquals("rotor IV, step, getCurrentPosition (L)\n",'L',rotor[4].getCurrentPosition());
		// step beyond full cycle and check it went from 'L' to 'M'
		for (int i=0; i<27; i++) 
			rotor[4].step();
		assertEquals("rotor IV, step, getCurrentPosition (full cycle)\n",'M',rotor[4].getCurrentPosition());
		
	}
	
	
	@Test
	public void rotor2PositionMethodsTest() {
		// rotor type II started at position Z; check methods
		assertEquals("getInitialPositon, rotor II (Z)\n", 'Z', rotor[1].getInitialPosition());
		assertEquals("getCurrentPositon, rotor II (Z)\n", 'Z', rotor[1].getCurrentPosition());
		// change initial position to B; check methods
		rotor[1].setInitialRotorPosition('B');
		assertEquals("getInitialPositon, rotor II (B)\n", 'B', rotor[1].getInitialPosition());
		assertEquals("getCurrentPositon, rotor II,(B)\n", 'B', rotor[1].getCurrentPosition());	
		// step 3 times to change current postion to E, check methods
		for (int i=0; i<3; i++)
			rotor[1].step();
		assertEquals("getInitialPositon, rotor II (B)\n", 'B', rotor[1].getInitialPosition());
		assertEquals("getCurrentPositon, rotor II,(B)\n", 'E', rotor[1].getCurrentPosition());
		// reset rotor position (goes now to initial position) 'B'
		rotor[1].resetRotorPosition();
		assertEquals("reset, rotor II (back to B)\n",'B',rotor[1].getCurrentPosition());
	}
	
	@Test
	public void rotor3NotchTest() {
		rotor[2].setInitialRotorPosition('W');
		assertTrue("atNotch must be true (rotor III,W)\n",rotor[2].atNotch());
	}
	    
	@Test
	public void outLetterForwardYesSteppingTest1() {
		Rotor myRotor=new Rotor(3,'A');
		String s="";
		for (int i=0; i<24; i++) {
			s=s+myRotor.outLetter('A',true);	
			myRotor.step();		
		}
		assertEquals("outLetterForwardYesSteppingTest1\n","BCDEFGWIJKNKNAKPSFOHQRYV",s);
	}
	
	@Test
	public void outLetterForwardYesSteppingTest2() {
		Rotor myRotor=new Rotor(1,'A');
		String s="";
		for (int i=0; i<30; i++) {
			s=s+myRotor.outLetter('R',true);
			myRotor.step();
		}
		assertEquals("outLetterForwardYesSteppingTest2 (beyond full loop)\n","URNXEWLVBVABTYSOAEHUZTABJYURNX",s);
	}
	
	/*@Test
	  public void test() {
	 	fail("Not yet implemented");
	}
	*/

}
