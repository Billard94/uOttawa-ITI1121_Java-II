import static org.junit.Assert.*;

import org.junit.Test;


public class EnigmaMachineTest {

	@Test
	public void testEnigmaNoPlugNoStepping1() {
		
		EnigmaMachine enigmaMachine=new EnigmaMachine(3,2,1,1,'A','A','A');
		
		enigmaMachine.disableStepping();
		
		assertEquals("testEnigmaNoPlugNoStepping1","UEJOBTPZWCNSRKDGVMLFAQIYXH",enigmaMachine.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

		
	}

	@Test
	public void testEnigmaNoPlugNoStepping2() {
		
		EnigmaMachine enigmaMachine=new EnigmaMachine(3,4,5,1,'Z','M','A');
		
		enigmaMachine.disableStepping();
		
		assertEquals("testEnigmaNoPlugNoStepping2","CYAFLDPMJITEHZUGWVXKORQSBNCYA",enigmaMachine.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZABC"));

		
	}
	
	@Test
	public void testEnigmaNoPlugYesStepping1() {
		
		EnigmaMachine enigmaMachine=new EnigmaMachine(3,2,1,1,'D','Z','A');
		
		enigmaMachine.enableStepping();
		
		assertEquals("testEnigmaNoPlugYesStepping1", "RKSSACASAOTAQDJZCFXNWNIGMAGSM",enigmaMachine.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZABC"));

		
	}
	
	@Test
	public void testEnigmaNoPlugYesStepping2() {
		
		EnigmaMachine enigmaMachine=new EnigmaMachine(3,4,5,1,'Z','M','A');
		
		enigmaMachine.enableStepping();
		
		assertEquals("testEnigmaNoPlugYesStepping2","ZXPEAGKWEGQGOMLCRZKIKYDWJMJLE",enigmaMachine.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZABC"));

		
	}
	
	@Test
	public void testEnigmaNoPlugYesStepping3() {
		
		EnigmaMachine enigmaMachine=new EnigmaMachine(3,4,5,1,'D','I','B');
		
		enigmaMachine.enableStepping();
		
		assertEquals("testEnigmaNoPlugYesStepping3","GYNWVRDBVYRRABRYDUGZESOMESPTV",enigmaMachine.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZABC"));

		
	}
	
	@Test
	public void testEnigmaYesPlugYesStepping() {
		EnigmaMachine enigmaMachine=new EnigmaMachine(3,4,5,1,'Z','M','A');
		
		
		
		enigmaMachine.enableStepping();
		
		enigmaMachine.plug('A','C');
		enigmaMachine.plug('Z','X');
		
		assertEquals("testEnigmaNoPlugYesStepping2","XZPECGKWEGQGOMLARXKIKYDWJMJLE",enigmaMachine.encrypt("CBADEFGHIJKLMNOPQRSTUVWZYXCBA"));
	
		
	}
	
	
	
	
}

