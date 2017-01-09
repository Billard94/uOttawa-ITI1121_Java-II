import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {
  
    // Creates and returns a TestSuite object.

    private static Test suite() {

        TestSuite suite = new TestSuite();
  
        suite.addTestSuite( TestFindAndReplace.class );

        return suite;
    }

    /**
     * Runs the test suite using the textual runner.
     *
     * @param args reference to an array of arguments passed to the program on the command line
     */
    
    public static void main( String[] args ) {

        StudentInfo.display();

        junit.textui.TestRunner.run( suite() );
    }
}