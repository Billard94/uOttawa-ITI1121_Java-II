package solution;

public class StudentByGrade {
 
 // The letter grades and corresponding students are stored in a binary search tree
 // the values stored in the BinarySearchTree will be StudentListWithGrade, 
 // which implements Comparable<StudentListWithGrade>
 // The binary search tree "key" used to store the elements in order
 // is the letter grade, since the comparison between objects of
 // StudentListWithGrade is based solely on letter grades
 
 BinarySearchTree<StudentListWithGrade> tree;
 
 /**
  * The constructor simply initializes an empty binary search tree
  */
 public StudentByGrade() {
   tree= new BinarySearchTree<StudentListWithGrade>();
 }
 
 
 /**
  * Method add inserts information as student name with its letter grade.
  * 
  * If there is already a list of students with the same grade inserted into
  * the binary search tree, it simply adds this new student to the existing list
  * If there is no current list of students with this grade, it creates 
  * create an object of class StudentListWithGrade with the given grade
  * containing the given student name and insert into the binary search tree
  * 
  * @param grade is the grade of the student
  * @param name is the student name
  * @return true if the insertion was successful
  */
 public boolean add(String grade, String name) {
  
     // this method must be implemented by you
  // it currently does not do any insertion and simply returns true
  // Hint: requires previous implementation of "find" method for BinarySearchTree
 
  boolean result=true;
  
  StudentListWithGrade  myList=new StudentListWithGrade(grade);
  StudentListWithGrade treeList;
 
  
  treeList=tree.find(myList);
  
  if (treeList==null) {
   result=tree.add(myList);
   treeList=myList;
  }
  
  treeList.add(name);
  
  return result;
 }
 
 
 /**
  * Method add inserts information for a list of student names having the same letter grade 
  * 
  * If there is already a list of students with the same grade inserted into
  * the binary search tree, it simply merges this new student list into existing list
  * If there is no current list of students with this grade, it inserts the given list.
  * 
  * @param myList is a member of class StudentListWithGrade, which is a list of student
  * names as well as the letter grade for all these students
  * @return true if the insertion was successful
  * 
  */
 public boolean add(StudentListWithGrade myList) {
  
     // this method must be implemented by you
  // it currently does not do any insertion and simply returns true
  //  Hint: requires previous implementation of "find" method for BinarySearchTree
  //  
  boolean result=true;
  
  StudentListWithGrade treeList;
  treeList=tree.find(myList);
  
  if (treeList!=null) {
   treeList.merge(myList);
  }
  else
   tree.add(myList);
  
  return result;
  
 }
 
 /**
  * @return a string showing the data in "tree format"
  */
 public String treeToString() {

  return tree.toString();
 }
 

 
 /* 
  * The format of toString() is a format that shows in different lines
  * each grade and the corresponding list of students with that grade.
  * 
  * @see java.lang.Object#toString()
  */
 public String toString() {
  String s = tree.toString();
  String ans="";
  for (int i=0; i< s.length(); i++) {
   if ( (s.charAt(i)!=')') && (s.charAt(i)!='(' ) ) {
    ans=ans+s.charAt(i);
    if (s.charAt(i)==']') ans=ans+"\n";
   }
  }
  return ans;
 }


}
