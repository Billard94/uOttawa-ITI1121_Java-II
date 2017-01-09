public class Utils2 {

    private static boolean isIncreasing( Time2[] ts ) {
 boolean isIncreasing = true;

 for (int i=0; isIncreasing && i<ts.length-1; i++) {
     if (! ts[i].before(ts[i+1])) {
  isIncreasing = false;
     }
 }

 return isIncreasing;
    }

    public static void main(String[] args) {

 if ( args.length != 3 ) {
     System.err.println( "Usage: java Utils2 h m s" );
     System.exit( -1 );
 }

 int h, m, s;

 h = Integer.parseInt( args[0] );
 m = Integer.parseInt( args[1] );
 s = Integer.parseInt( args[2] );

 Time2 t;
 t = new Time2( h, m, s );

 Time2[] times;
 times = new Time2[5];

 times[0] = t;

 for (int i=1; i<5; i++) {
     times[i] = times[i-1].plus(times[0]);
 }

 System.out.println("the array of times is:");
 for (int i=0; i<5; i++) {
     System.out.println(times[i]);
 }

 System.out.println("the array is increasing: " + isIncreasing( times ) );
    }

}

// > java Utils1 1 2 3
// the array of times is:
// 1:2:3
// 2:4:6
// 3:6:9
// 4:8:12
// 5:10:15
// the array is increasing: true