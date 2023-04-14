import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mission09Luke
{

   public static void main (String[] args)
   {
   
      //Initialize variables
      boolean error = false;
      String fileName = "";
      String directoryPath = System.getProperty("user.dir");
      String cryptoInput = "";
      String lineEntry = "";
      char ch = ' ';
      
      //Initialize files and tool objects
      Scanner in = new Scanner (System.in);
      File f;
      Scanner fileIn;
      
      //get the file name from the user to build the file object
      System.out.println("Please enter the name of the file.\nBe sure to include file extension (.txt, .docx, etc.):");
      fileName = in.nextLine();
      if (fileName.contains("\\")){/*do nothing*/}
      else{ fileName = directoryPath + "\\" + fileName;}
      
      System.out.println(fileName);
      
      
      /*******************************************************************************
      *******************Main Body of Code*******************************************/

      do
      {
         try
         {
            //Build the File and attatch a Scanner to it
            f = new File (fileName); 
            fileIn = new Scanner (f);
            
            error = false;
            
            //prompt user to encrypt or decrypt file
            System.out.println("Would you like to encrypt or decrypt?");
            cryptoInput = in.nextLine();
            
            /****************************************************************************************
            ***********************Section 1: Encryption********************************************/
            //encryption process
            if(cryptoInput.equalsIgnoreCase("encrypt") || cryptoInput.equalsIgnoreCase("encryption"))
            {
               PrintWriter fileOut = new PrintWriter("Encryption.txt");
               
               while (fileIn.hasNext())
               {
                  //read in each line
                  lineEntry = fileIn.nextLine();
                  
                  //iterate through each character of line to encrypt
                  for (int i = 0; i < lineEntry.length(); i++)
                  {
                     ch = lineEntry.charAt(i);
                      
                     if (Character.isLetter (ch))
                     {
                        ch++;
                        fileOut.print(ch);
                     }
                     
                     else
                     {
                        
                        fileOut.print(ch);
                     }
                     
                     //for formatting / readability purposes
                     if (i == lineEntry.length()-1 )
                     {
                        fileOut.print("\r\n");
                     }
                     
                  }//end of ENCRYPTION for loop
               }// end of ENCRYPTION while loop
                
               //close file to save contents and output statement to user
               fileOut.close();
               System.out.println("File has been encrypted to Encryption.txt");                 
               
            }// end of ENCRYPTION process
            
            
            
            /********************************************************************************************
            *********************Section 2: Decryption**************************************************/
            //decryption process
            else if(cryptoInput.equalsIgnoreCase("decrypt") || cryptoInput.equalsIgnoreCase("decryption"))
            {
               PrintWriter fileOut = new PrintWriter("Decryption.txt");
               
               while (fileIn.hasNext())
               {
                  //read in line
                  lineEntry = fileIn.nextLine();
                  
                  //create for loop to iterate through ea. char and perform decryption process
                  for (int i = 0; i < lineEntry.length(); i++)
                  {
                     ch = lineEntry.charAt(i);
                     
                     if (Character.isLetter (ch))
                     {
                        ch--;
                        fileOut.print(ch);
                     }
                     
                     else
                     {
                        if (ch == '{')
                        {
                           ch--;
                        }
                        if (ch == '[')
                        {
                           ch--;
                        }

                        fileOut.print(ch);
                     }
                     
                     //for formatting / readability purposes
                     if (i == lineEntry.length()-1 )
                     {
                        fileOut.print("\r\n");
                     }
                     
                  }//end of DECRYPTION for loop
                  
               }//end of DECRYPTION while loop
               
               //close file to save its contents and output statement to user
               fileOut.close();
               System.out.println("File has been decrypted to Decryption.txt");
               
            }//end of DECRYPTION process
            
            
            /*******************************************************************************
            ********************Section 3: Incorrect Entries*******************************/
            //Process for incorrect crypto entry
            else
            {
               System.out.println("Invalid entry, enter encrypt or decrypt.");
               error = true;
            }
            
         }//end of try 
         /************************************************************************************
         *************************************************************************************
         ************************************************************************************/
         
         catch (FileNotFoundException e)
         {
            System.out.println("Invalid entry, file not found");
            
            
         }//end of catch
      
      }while (error);//end of do / while loop
      
   }//end of main method

}//end of class