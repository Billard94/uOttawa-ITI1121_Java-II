import junit.framework.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestFindAndReplace extends TestCase {
  
    public static void testInIsNull() {
 String[] query = { "I" };
 String[] replacement = { "You" };
 Assert.assertNull( Utils.findAndReplace( null, query, replacement ) );
    }

    public static void testQueryIsNull() {
 String[] text = { "I", "understand" };
 String[] replacement = { "You" };
 Assert.assertNull( Utils.findAndReplace( text, null, replacement ) );
    }

    public static void testReplacementIsNull() {
 String[] text = { "I", "understand" };
 String[] query = { "I" };
 Assert.assertNull( Utils.findAndReplace( text, query, null ) );
    }

    public static void testInAndQueryAreNull() {
 String[] replacement = { "You" };
 Assert.assertNull( Utils.findAndReplace( null, null, replacement ) );
    }

    public static void testInAndReplacementreNull() {
 String[] query = { "I" };
 Assert.assertNull( Utils.findAndReplace( null, query, null ) );
    }

    public static void testQueryAndReplacementreNull() {
 String[] text = { "I", "understand" };
 Assert.assertNull( Utils.findAndReplace( text, null, null ) );
    }

    public static void testAllNull() {
 Assert.assertNull( Utils.findAndReplace( null, null, null ) );
    }

    public static void testNotSameLength() {
 String[] text = { "I", "understand" };
 String[] query = { "I" };
 String[] replacement = { "You", "They" };
 Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

    public static void testNullInIn() {
 String[] text = { "I", null };
 String[] query = { "I" };
 String[] replacement = { "You" };
 Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

    public static void testNullInQuery() {
 String[] text = { "I", "understand" };
 String[] query = { "I", null };
 String[] replacement = { "You", "They" };
 Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

    public static void testNullInReplacement() {
 String[] text = { "I", "understand" };
 String[] query = { "I", "We" };
 String[] replacement = { null, "They" };
 Assert.assertNull( Utils.findAndReplace( text, query, replacement ) );
    }

     public static void testNoChange1() {
 String[] text = { "I", "understand" };
 String[] query = { };
 String[] replacement = { };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( text[ i ], result[ i ] );
 }
    }

     public static void testNoChange2() {
 String[] text = { "I", "understand" };
 String[] query = { "You" };
 String[] replacement = { "I" };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( text[ i ], result[ i ] );
 }
    }

    public static void testChangeFirst1() {
 String[] text = { "I", "understand" };
 String[] query = { text[ 0 ] };
 String[] replacement = { "You" };
 String[] expected = { replacement[ 0 ], text[ 1 ] };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], result[ i ] );
 }
    }

    public static void testChangeFirst2() {
 String[] text = { "I", "understand" };
 String[] query = { new String( "I" ) };
 String[] replacement = { "You" };
 String[] expected = { "You", "understand" };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], result[ i ] );
 }
    }

    public static void testChangeLast() {
 String[] text = { "I", "understand" };
 String[] query = { new String( "understand" ) };
 String[] replacement = { "see" };
 String[] expected = { "I", "see" };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], result[ i ] );
 }
    }

    public static void testChangeLeft() {
 String[] text = { "I", "understand" };
 String[] query = { new String( "understand" ), new String( "understand" ) };
 String[] replacement = { "see", "grasp" };
 String[] expected = { "I", "see" };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], result[ i ] );
 }
    }

    public static void testMultipleChanges1() {
 String[] text = { "I", "like", "Java" };
 String[] query = { new String( "I" ), new String( "like" ), new String( "Java" ) };
 String[] replacement = { "You", "enjoy", "object-oriented programming" };
 String[] expected = { "You", "enjoy", "object-oriented programming" };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], result[ i ] );
 }
    }

    public static void testMultipleChanges2() {
 String[] text = { "I", "like", "Java" };
 String[] query = { new String( "I" ), new String( "Java" ), new String( "like" ) };
 String[] replacement = { "You", "object-oriented programming", "enjoy" };
 String[] expected = { "You", "enjoy", "object-oriented programming" };
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], result[ i ] );
 }
    }

    public static void testInIsUnchanged() {
 String[] text = { "I", "like", "Java" };
 String[] query = { new String( "I" ), new String( "Java" ), new String( "like" ) };
 String[] replacement = { "You", "object-oriented programming", "enjoy" };
 String[] expected = new String[ text.length ];
 System.arraycopy( text, 0, expected, 0, text.length );
 String[] result = Utils.findAndReplace( text, query, replacement );
 Assert.assertNotNull( result );
 Assert.assertFalse( text == result );
 Assert.assertTrue( text.length == result.length );
 for ( int i=0; i<text.length; i++ ) {
     Assert.assertEquals( expected[ i ], text[ i ] );
 }
    }

  
}