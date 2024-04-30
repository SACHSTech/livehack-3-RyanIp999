

class Problem1 extends ConsoleProgram {

  /**
  * checks if username is valid and creats a password based on info given
  * @author: Ryan Ip 
  */
  
  public void run() {
    // getting all data from user
    System.out.println("***** Student Account registration *****");
    String strFirstName = readLine("Enter Your First Name: ");
    String strLastName = readLine("Enter Your Last Name: ");
    String strStudentNumber = readLine("Enter your student number: ");
    String strUsername = readLine("Enter a new username: ");
    
    System.out.println(" ");
    System.out.println("Valid username: " + validateUsername(strUsername));
    System.out.println("Your password is:" + createPassword(strFirstName, strLastName, strStudentNumber));
  }
  
  
  // valide username
  private boolean validateUsername(String strUsername){
    // find length of username
    int intLength = strUsername.length();

    // checking if more than 7 long
    if (intLength < 7){
      return false;
    }
    
    // checking for at least one digits
    
    int intNumberCounter = 0;
    for (int intCounter = 0; intCounter < intLength; intCounter++){
      // gets character in the string
      char charCharacter = strUsername.charAt(intCounter);
        
      // checks for digits in password
      if(Character.isDigit(charCharacter) == false){
        intNumberCounter += 1;
      }
      if (intNumberCounter < 1){
        return false;
      }
    }
    
  
    // checks for if their are digets and numbers only 
   for (int intCounter2 = 0; intCounter2 < intLength; intCounter2++){
      // gets character in the string
      char chrCharacter = strUsername.charAt(intCounter2);
      
      // checks to make sure the character is a digit or a letter
      if (Character.isDigit(chrCharacter) == false){
        if(Character.isLetter(chrCharacter) == false){
          return false;
        }
      }
    }
    
    
    return true;
  }
  
  private String createPassword(String strFirst, String strLast, String strStudentNumber){
    // variables
    int intLastLength = strLast.length();
    int intStudentLength = strStudentNumber.length();
    String strPassword = "";
    
    // adds lower case first 4 characters of last name 
    for (int intCounter = 0; intCounter < 4; intCounter++){
      char chrCharacter = strLast.charAt(intCounter);
      strPassword += Character.toLowerCase(chrCharacter);
    }

    // adds upper case first inital 
    char chrCharacter = strFirst.charAt(0);
    strPassword += Character.toUpperCase(chrCharacter);

    // checks student number 
    for (int intCounter = 0; intCounter < intLastLength; intCounter++){
       char chrNumber = strStudentNumber.charAt(intCounter);
       if(intStudentLength < 9 || Character.isDigit(chrNumber) == false){
        throw new IllegalArgumentException("Student number must contain only digits and have at least 9 numbers.");
       }
    }
    
    // adds student middle number 
    for (int intCounter = 3; intCounter < 6; intCounter++){
       char chrNumber = strStudentNumber.charAt(intCounter);
      strPassword += chrNumber;
    }
    return strPassword;
  
  }
    
}
