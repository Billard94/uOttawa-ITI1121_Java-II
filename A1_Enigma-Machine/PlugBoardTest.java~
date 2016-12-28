import static org.junit.Assert.*;

import org.junit.Test;

/** JUnit test for class PlugBoard
 *  
 *  Tests the basic functionality for PlugBoard
 *  
 * @author Lucia Moura
 *
 */

public class PlugBoardTest {

	@Test
	public void plugTest() {
		// Tests plugging is correct after 3 correct plugs 
		PlugBoard plugBoard=new PlugBoard();
		
		plugBoard.plug('A','Z');
		plugBoard.plug('B','Y');
		plugBoard.plug('C','X');
		
		char c='C';
		for (int i=0; i<20; i++) {
			c++;
			assertEquals("plugTest:\n",c,plugBoard.outLetter(c));
		}
		
	}
	
	@Test
	public void wrongPlugAttemptTest() {
		// Tests that trying to replug the same letter is not allowed
		
		PlugBoard plugBoard=new PlugBoard();
		
		plugBoard.plug('A','Z'); // this should be ok
		plugBoard.plug('A','B'); // this should have no effect

		// testing that second plug was not allowed
		
		
		assertEquals("wrongPlugAttemptTest: A must be pluged with Z\n",'Z',plugBoard.outLetter('A'));

		char c='A'; 
		for (int i=0; i<24; i++) {
			c++;
			assertEquals("wrongPlugAttemptTest:\n",c,plugBoard.outLetter(c));
		}
	}
	
	
}
