import static org.junit.Assert.*;

import org.junit.Test;


public class ReflectorTest {
	
	private final static String [] REFLECTOR_OPTION = {
		"YRUHQSLDPXNGOKMIEBFZCWVJAT",
		"FVPJIAOYEDRZXWGCTKUQSBNMHL"};



	@Test
	public void getWiringTest() {
		Reflector reflector;
		
		reflector= new Reflector(1);
		assertEquals("getWiring 1 not matching\n", REFLECTOR_OPTION[0], reflector.getWiring());
	
		reflector= new Reflector(2);
		assertEquals("getWiring 2 not matching\n", REFLECTOR_OPTION[1], reflector.getWiring());
	}
	
	
	
	@Test
	public void outLetterReflectorBTest() {
		Reflector reflector= new Reflector(1);
		String s="";
		char c='A';
		for (int i=0; i<26; i++) {
			s=s+reflector.outLetter(c);
			c++;
		}
		assertEquals("outLetterReflectorBTest\n",REFLECTOR_OPTION[0],s);
	}
	
	@Test
	public void outLetterReflectorCTest() {
		Reflector reflector= new Reflector(2);
		String s="";
		char c='A';
		for (int i=0; i<26; i++) {
			s=s+reflector.outLetter(c);
			c++;
		}
		assertEquals("outLetterReflectorBTest\n",REFLECTOR_OPTION[1],s);
	}


}
