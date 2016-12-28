package solution;

public class StudentByGradeTest {

 static boolean verbose=true;
 
 public static void tryAdd(StudentByGrade course, String grade, String name) {
  if (course.add(grade, name)==false)
   System.out.println("Unable to add "+grade+" "+name);
 }
 
 public static void printResults(StudentByGrade course,String answer){
  
  String result=course.treeToString();
  
  if  (verbose) {
   System.out.println("Showing Tree Format:\n"+result);
   System.out.println("\nShowing list Format:\n"+course);
  }
  
  if (!result.equals(answer))
   System.out.println("Test ERROR!\nresult:\n"+result+"\nanswer must be:\n"+answer+"\n");
  else 
   System.out.println("Test OK.\n");
  
 }
 
 public static void main(String[] args){
   StudentByGrade mycourse = new StudentByGrade();
   
   
      // These tests require creating and inserting new object StudentListWithGrade into the BST
   System.out.println("1) Testing insertion of students with new letter grades\n");
   tryAdd(mycourse,"A+","Smith");
   tryAdd(mycourse,"B+","Curtis"); 
   tryAdd(mycourse,"B","Silva");   
   tryAdd(mycourse,"A-","Moura");
   tryAdd(mycourse,"F","Maradona");
   tryAdd(mycourse,"A","Bryan");
   tryAdd(mycourse,"C","Ryan");
   tryAdd(mycourse,"D", "Danny");
   tryAdd(mycourse,"E", "Newman");
   tryAdd(mycourse,"C+", "Harrison");
   
   printResults(mycourse,"((((()F[Maradona](((()E[Newman]())D[Danny]())C[Ryan](()C+[Harrison]())))B[Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Smith]())");  
   
   
      // These tests require inserting new student names into objects StudentListWithGrade already in BST
   System.out.println("2) Testing insertion of students with existing letter grades\n"); 
   
   tryAdd(mycourse,"A+","Black");  
   tryAdd(mycourse,"A+","Collins");
   tryAdd(mycourse,"B","Rosa");
   tryAdd(mycourse,"B","Pitt");
   tryAdd(mycourse,"C", "Lennon");
   
   printResults(mycourse,"((((()F[Maradona](((()E[Newman]())D[Danny]())C[Lennon,Ryan](()C+[Harrison]())))B[Pitt,Rosa,Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Black,Collins,Smith]())"); 
   
      // These tests require inserting new StudentListWithGrade into the BST
   System.out.println("3) Testing insertion of list of students with new letter grades\n");
   
   StudentListWithGrade DplusList=new StudentListWithGrade("D+");
   DplusList.add("Joseph");
   DplusList.add("Anderson");
   DplusList.add("Paterson");
   mycourse.add(DplusList);
   
   printResults(mycourse,"((((()F[Maradona](((()E[Newman]())D[Danny](()D+[Anderson,Joseph,Paterson]()))C[Lennon,Ryan](()C+[Harrison]())))B[Pitt,Rosa,Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Black,Collins,Smith]())"); 
  
  // These tests require merging new StudentListWithGrade into an existing one in BST
   System.out.println("4) Testing insertion of list of students with existing letter grades\n");
   
   StudentListWithGrade newList=new StudentListWithGrade("D+");
   newList.add("Carl");
   newList.add("Santos");  
   mycourse.add(newList);
  
   printResults(mycourse,"((((()F[Maradona](((()E[Newman]())D[Danny](()D+[Anderson,Carl,Joseph,Paterson,Santos]()))C[Lennon,Ryan](()C+[Harrison]())))B[Pitt,Rosa,Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Black,Collins,Smith]())"); 
  }

}

/************************ showing expected output *******************************************************************
 
1) Testing insertion of students with new letter grades

Showing Tree Format:
((((()F[Maradona](((()E[Newman]())D[Danny]())C[Ryan](()C+[Harrison]())))B[Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Smith]())

Showing list Format:
F[Maradona]
E[Newman]
D[Danny]
C[Ryan]
C+[Harrison]
B[Silva]
B+[Curtis]
A-[Moura]
A[Bryan]
A+[Smith]

Test OK.

2) Testing insertion of students with existing letter grades

Showing Tree Format:
((((()F[Maradona](((()E[Newman]())D[Danny]())C[Lennon,Ryan](()C+[Harrison]())))B[Pitt,Rosa,Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Black,Collins,Smith]())

Showing list Format:
F[Maradona]
E[Newman]
D[Danny]
C[Lennon,Ryan]
C+[Harrison]
B[Pitt,Rosa,Silva]
B+[Curtis]
A-[Moura]
A[Bryan]
A+[Black,Collins,Smith]

Test OK.

3) Testing insertion of list of students with new letter grades

Showing Tree Format:
((((()F[Maradona](((()E[Newman]())D[Danny](()D+[Anderson,Joseph,Paterson]()))C[Lennon,Ryan](()C+[Harrison]())))B[Pitt,Rosa,Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Black,Collins,Smith]())

Showing list Format:
F[Maradona]
E[Newman]
D[Danny]
D+[Anderson,Joseph,Paterson]
C[Lennon,Ryan]
C+[Harrison]
B[Pitt,Rosa,Silva]
B+[Curtis]
A-[Moura]
A[Bryan]
A+[Black,Collins,Smith]

Test OK.

4) Testing insertion of list of students with existing letter grades

Showing Tree Format:
((((()F[Maradona](((()E[Newman]())D[Danny](()D+[Anderson,Carl,Joseph,Paterson,Santos]()))C[Lennon,Ryan](()C+[Harrison]())))B[Pitt,Rosa,Silva]())B+[Curtis](()A-[Moura](()A[Bryan]())))A+[Black,Collins,Smith]())

Showing list Format:
F[Maradona]
E[Newman]
D[Danny]
D+[Anderson,Carl,Joseph,Paterson,Santos]
C[Lennon,Ryan]
C+[Harrison]
B[Pitt,Rosa,Silva]
B+[Curtis]
A-[Moura]
A[Bryan]
A+[Black,Collins,Smith]

Test OK.

*************** end of expected output ********************************************************************/
