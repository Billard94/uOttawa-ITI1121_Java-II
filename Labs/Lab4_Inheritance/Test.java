public class Test {

    /**
     * Displays the student name, id and laboratory section.
     */

    public static void displayStudentInfo( ) {

        System.out.println( "************************************************************" );
        System.out.println( "*    Student name: Alexandre Billard                                                      *" );
        System.out.println( "*    Student number: 6812210                                                      *" );
        System.out.println( "*    ITI1121X Lab 4                                                       *" );
        System.out.println( "*                                                          *" );
        System.out.println( "************************************************************" );
        System.out.println();
    
    }
  
    /*
     * This test class validates the implemenation of the class
     * Document. Never assume that a test set is exhaustive.
     */

    public static void main( String[] args ) {

        displayStudentInfo();

 MediaDocument[] mediaCentre;
 mediaCentre = new MediaDocument[ 5 ];

 mediaCentre[0] = new Movie( "The Matrix", "Mike Wazowski", 136, 9, 8 );
 mediaCentre[1] = new Movie( "Blade Runner", "Benjamin Linus", 117, 10, 8 );
 mediaCentre[2] = new Movie( "What Dreams May Come", "Ada Lovelace", 117, 8, 7 );
 mediaCentre[3] = new Audio( "Fandango", "Jack Skellington", 4, 9 );
 mediaCentre[4] = new Audio( "Mwembo", "George Orwell", 5, 9 );

 int sum = 0;

 for ( MediaDocument m : mediaCentre ) {
     sum += m.getRating();
 }

 System.out.println( "sum of ratings is " + sum );
    }

}
