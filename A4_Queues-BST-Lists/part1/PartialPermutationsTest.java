
public class PartialPermutationsTest {

    private static boolean formatted=false; // indicates printing will be done 10 words per line
    private static boolean verbose=true; // indicates printing will show all words
    
 /**
  * if in verbose mode, it prints the words in allWords
  * @param allWords is a String of words separated by ;
  */
 public static void print(String allWords) {
  if (verbose) {
   if (formatted) {
    String[] word = allWords.split(";");
    for (int i=0; i<word.length;i++) {
     if ((i%10==0) && (i>0)) System.out.println();
     System.out.print(word[i]+";");
    }
    System.out.println();
   }
   else 
    System.out.println(allWords);
  }
 }
 
 /**
  * 
  * Checks that the strings s1 and s2 match 
  * @param s1 is the first string
  * @param s2 is the second string
  */
 public static void check(String s1, String s2) {
  if (s1.equals(s2))
   System.out.println("test OK\n");
  else 
   System.out.println("test ERROR!\n");
 }
 
 /**
  * Test1 checks that the default values for PartialPermutations produce the correct output
  */
 public static void Test1() {
  // test default generation
  PartialPermutations perm=new PartialPermutations(); 
  String allWords=perm.generateWords();
  print(allWords);
  String correctWords="<empty>;a;b;c;d;ab;ac;ad;ba;bc;bd;ca;cb;cd;da;db;dc;abc;abd;acb;acd;adb;adc;bac;bad;bca;bcd;bda;bdc;cab;cad;cba;cbd;cda;cdb;dab;dac;dba;dbc;dca;dcb;";
     check(allWords,correctWords);
  
 }

 /**
  * Test2 uses an alphabet of 5 numbers and performs 3 tests on PartialPermutations,
  * each test using a different Mode for Generation
  *
  */
 public static void Test2() {
  // test other generations
  
  PartialPermutations perm=new PartialPermutations(); 
  char[] alphabet={'1','2','3','4','5'};
  
  perm.setAlphabet(alphabet);
  perm.setMode(PartialPermutations.Mode.UPTOSIZE);
  perm.setSize(3);
  String allWords=perm.generateWords();
  print(allWords);
  String correctWords="<empty>;1;2;3;4;5;12;13;14;15;21;23;24;25;31;32;34;35;41;42;43;45;51;52;53;54;123;124;125;132;134;135;142;143;145;152;153;154;213;214;215;231;234;235;241;243;245;251;253;254;312;314;315;321;324;325;341;342;345;351;352;354;412;413;415;421;423;425;431;432;435;451;452;453;512;513;514;521;523;524;531;532;534;541;542;543;"; 
  check(allWords,correctWords);
  
  
  perm.setMode(PartialPermutations.Mode.MAXSIZE);
  allWords=perm.generateWords();
  print(allWords);
  correctWords="12345;12354;12435;12453;12534;12543;13245;13254;13425;13452;13524;13542;14235;14253;14325;14352;14523;14532;15234;15243;15324;15342;15423;15432;21345;21354;21435;21453;21534;21543;23145;23154;23415;23451;23514;23541;24135;24153;24315;24351;24513;24531;25134;25143;25314;25341;25413;25431;31245;31254;31425;31452;31524;31542;32145;32154;32415;32451;32514;32541;34125;34152;34215;34251;34512;34521;35124;35142;35214;35241;35412;35421;41235;41253;41325;41352;41523;41532;42135;42153;42315;42351;42513;42531;43125;43152;43215;43251;43512;43521;45123;45132;45213;45231;45312;45321;51234;51243;51324;51342;51423;51432;52134;52143;52314;52341;52413;52431;53124;53142;53214;53241;53412;53421;54123;54132;54213;54231;54312;54321;";
  check(allWords,correctWords);
  
  perm.setMode(PartialPermutations.Mode.FIXEDSIZE);
  perm.setSize(4);
  allWords=perm.generateWords();
  print(allWords);
  correctWords="1234;1235;1243;1245;1253;1254;1324;1325;1342;1345;1352;1354;1423;1425;1432;1435;1452;1453;1523;1524;1532;1534;1542;1543;2134;2135;2143;2145;2153;2154;2314;2315;2341;2345;2351;2354;2413;2415;2431;2435;2451;2453;2513;2514;2531;2534;2541;2543;3124;3125;3142;3145;3152;3154;3214;3215;3241;3245;3251;3254;3412;3415;3421;3425;3451;3452;3512;3514;3521;3524;3541;3542;4123;4125;4132;4135;4152;4153;4213;4215;4231;4235;4251;4253;4312;4315;4321;4325;4351;4352;4512;4513;4521;4523;4531;4532;5123;5124;5132;5134;5142;5143;5213;5214;5231;5234;5241;5243;5312;5314;5321;5324;5341;5342;5412;5413;5421;5423;5431;5432;";
  check(allWords,correctWords);
 }
 

 
 /**
  * main performs the basic tests, first in verbose formatted mode (so we see the partial permutations produced)
  * next in silence mode (for a quick diagnostics of correctness)
  * 
  * @param args
  */
 public static void main(String[] args) {
  
  formatted=true; // formatted true prints 10 words per row
  verbose=true;
  Test1();
  Test2();
  
  System.out.println("\n*** Nonverbose Check***\n");
  verbose=false;
  Test1();
  Test2();
 }

}

/****** the expected output once PartialPermutations is implemeted is given next ***********************************
Output Mode UPTOSIZE size=3 alphabet size=4
<empty>;a;b;c;d;ab;ac;ad;ba;bc;
bd;ca;cb;cd;da;db;dc;abc;abd;acb;
acd;adb;adc;bac;bad;bca;bcd;bda;bdc;cab;
cad;cba;cbd;cda;cdb;dab;dac;dba;dbc;dca;
dcb;
test OK

Output Mode UPTOSIZE size=3 alphabet size=5
<empty>;1;2;3;4;5;12;13;14;15;
21;23;24;25;31;32;34;35;41;42;
43;45;51;52;53;54;123;124;125;132;
134;135;142;143;145;152;153;154;213;214;
215;231;234;235;241;243;245;251;253;254;
312;314;315;321;324;325;341;342;345;351;
352;354;412;413;415;421;423;425;431;432;
435;451;452;453;512;513;514;521;523;524;
531;532;534;541;542;543;
test OK

Output Mode MAXSIZE alphabet size=5
12345;12354;12435;12453;12534;12543;13245;13254;13425;13452;
13524;13542;14235;14253;14325;14352;14523;14532;15234;15243;
15324;15342;15423;15432;21345;21354;21435;21453;21534;21543;
23145;23154;23415;23451;23514;23541;24135;24153;24315;24351;
24513;24531;25134;25143;25314;25341;25413;25431;31245;31254;
31425;31452;31524;31542;32145;32154;32415;32451;32514;32541;
34125;34152;34215;34251;34512;34521;35124;35142;35214;35241;
35412;35421;41235;41253;41325;41352;41523;41532;42135;42153;
42315;42351;42513;42531;43125;43152;43215;43251;43512;43521;
45123;45132;45213;45231;45312;45321;51234;51243;51324;51342;
51423;51432;52134;52143;52314;52341;52413;52431;53124;53142;
53214;53241;53412;53421;54123;54132;54213;54231;54312;54321;
test OK

Output Mode FIXEDSIZE size=4 alphabet size=5
1234;1235;1243;1245;1253;1254;1324;1325;1342;1345;
1352;1354;1423;1425;1432;1435;1452;1453;1523;1524;
1532;1534;1542;1543;2134;2135;2143;2145;2153;2154;
2314;2315;2341;2345;2351;2354;2413;2415;2431;2435;
2451;2453;2513;2514;2531;2534;2541;2543;3124;3125;
3142;3145;3152;3154;3214;3215;3241;3245;3251;3254;
3412;3415;3421;3425;3451;3452;3512;3514;3521;3524;
3541;3542;4123;4125;4132;4135;4152;4153;4213;4215;
4231;4235;4251;4253;4312;4315;4321;4325;4351;4352;
4512;4513;4521;4523;4531;4532;5123;5124;5132;5134;
5142;5143;5213;5214;5231;5234;5241;5243;5312;5314;
5321;5324;5341;5342;5412;5413;5421;5423;5431;5432;
test OK


*** Nonverbose Check***

Output Mode UPTOSIZE size=3 alphabet size=4
test OK

Output Mode UPTOSIZE size=3 alphabet size=5
test OK

Output Mode MAXSIZE alphabet size=5
test OK

Output Mode FIXEDSIZE size=4 alphabet size=5
test OK

****/
 
