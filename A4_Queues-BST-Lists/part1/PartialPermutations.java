
public class PartialPermutations {
 
 // the three types of generation
 public enum Mode {UPTOSIZE,FIXEDSIZE,MAXSIZE}
 
 // mode stores the selected type of generation
 // initialized to default value UPTOSIZE
 Mode mode=Mode.UPTOSIZE;
 
 // parameter size indicates the maximum size of permutations printed in modes UPTOSIZE and FIXEDSIZE
 // initialize to default value 3
 int size=3;
 
 // alphabet specifies the alphabet; initalized to default value {a,b,c,d}
 char alphabet[]={'a','b','c','d'};
 
 
 /**
  * Sets the mode of generation
  * @param mode is one of the 3 possible modes of generation
  */
 public void setMode(Mode mode) {
  this.mode=mode; 
 }
 
 
 /**
  * Gets the mode of generation
  * @return the current mode of generation (one of 3 possible modes)
  */
 public Mode getMode() {
  return mode; 
 }

 /**
  * 
  * Sets the size parameter used in modes UPTOSIZE and FIXEDSIZE
  * @param size must be smaller than equal the length of the alphabet
  */
 public void setSize(int size) {
  this.size=size; 
 }
 
 /**
  * Gets the size paramter used in modes UPTOSIZE and FIXEDSIZE
  * @return
  */
 public int getSize() {
  return size; 
 }
 
 /**
  * 
  * Sets the alphabet to be use in the generation
  * @param a is an array of characters given the letters of the alphabet in the desired order
  */
 public void setAlphabet( char[] a) {
  
  alphabet=new char[a.length]; 
  System.arraycopy(a,0, alphabet, 0, a.length);
    
 }
 
 /**
  * printMode prints the current mode of generation
  */
 private void printMode() {
  switch (mode) {
  case UPTOSIZE: 
   System.out.println("Output Mode UPTOSIZE size="+size+" alphabet size="+ alphabet.length);
   break;
  case FIXEDSIZE:
   System.out.println("Output Mode FIXEDSIZE size="+size+" alphabet size="+ alphabet.length);
   break;
  case MAXSIZE:
   System.out.println("Output Mode MAXSIZE alphabet size="+ alphabet.length);
   break;
  }
 }
 
 
 /**
  * visit will be called from generateWords() to "process" a word
  * @param word
  * @return a String which will be the word if this is a word to be in the output of the current type of generation
  * (note that the empty string is retrned as the String "<empty>")
  * if the word is not supposed to be in the output of the current type of generation returns ""
  * 
  */
 private String visit(String word) {
  
  // you must implement this method - currently it is a dummy method that returns ""
  
  boolean toPrint=false;
  switch (mode) {
  case UPTOSIZE: 
   if (word.length()<=size)  toPrint=true;
   break;
  case FIXEDSIZE:
   if (word.length()==size)  toPrint=true;
   break;
  case MAXSIZE:
   if (word.length()==alphabet.length) toPrint=true;
  }
  if (toPrint) {
   if (word.length()==0) 
    word="<empty>";
   return word+";";
  }
  else return "";
  
 }
 
 /**
  * generateWords will generate all partial permutations according to the desired mode and parameters
  * @return a String where all the desired partial permutations of the current type are separated by ; without extra spaces.
  *
  */
 public String generateWords() {
  Queue<String> wordQueue = new LinkedQueue<String>(); // auxiliary queue to help you with the generation of 
                // the desired partial permutations
  
  // this is the main algorithm implemented by you; this makes use of method visit() above
  // currently it is retruning a dummy empty string
  
  int maxSize;
  if (mode==Mode.MAXSIZE) maxSize=alphabet.length;
  else maxSize= size;
  
  String allWords="";
  
  printMode();
  
  wordQueue.enqueue("");
  
  while (!wordQueue.isEmpty()) {
   String s=wordQueue.dequeue();
   allWords=allWords+visit(s);
   if (s.length()<maxSize) 
          for (int i=0; i< alphabet.length; i++) {
           if (s.indexOf(alphabet[i])==-1)
         wordQueue.enqueue(s+alphabet[i]);
       
          }
  }
  
  return allWords;
 }

}
