package solution;
public class StudentListWithGrade extends OrderedList<String> implements Comparable<StudentListWithGrade> {

 private String letterGrade;
 
 StudentListWithGrade(String grade) {
  letterGrade=grade;
 }
 
 @Override 
 public int compareTo(StudentListWithGrade arg0) {
  int comp=this.letterGrade.compareTo(arg0.letterGrade);
  if (comp == 0)
   return 0;
  else 
   if (this.letterGrade.charAt(0)>arg0.letterGrade.charAt(0)) return -1;
   else if (this.letterGrade.charAt(0)<arg0.letterGrade.charAt(0)) return 1;
   else {
    Integer second1=2; 
    if (this.letterGrade.length()>1)
     if (this.letterGrade.charAt(1)=='-') second1=1;
     else
     if (this.letterGrade.charAt(1)=='+') second1=3;
    Integer second2=2;
    if (arg0.letterGrade.length()>1)
     if (arg0.letterGrade.charAt(1)=='-') second2=1;
     else
     if (arg0.letterGrade.charAt(1)=='+') second2=3;
    return (second1.compareTo(second2));
   }
  
   
   
 }
 
 /**
  * getter method for letter grade
  * @return the letter grade associated with this list of student names
  */
 public String getLetterGrade() {
  return letterGrade;
 }
 
 /* Overides toString method returning concatenation of the letter grade and the ordered list
  * @see OrderedList#toString()
  */
 public String toString() {
  return getLetterGrade()+ super.toString();
 }
 
   
}
