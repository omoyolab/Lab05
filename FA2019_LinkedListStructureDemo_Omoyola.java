import java.util.*;

/**
 * Lab 5 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/25/2019)
 */
public class FA2019_LinkedListStructureDemo_Omoyola
{
     public static void main(String []args)
      {
         int userInput, userInput2;
         String accountName, accountNumber, choice,number;
         double accountBalance;
         
         Account_Omoyola account, fetched; 
         Account_Omoyola temp = null;
         SinglyLinkedList_Omoyola accountList = new SinglyLinkedList_Omoyola();
         SinglyLinkedListIterator_Omoyola accountIterator = new SinglyLinkedListIterator_Omoyola();
         LinkedList accountData = new LinkedList();
         ListIterator i = accountData.listIterator();
         
         Scanner keyboard = new Scanner(System.in);
         do{
             System.out.println(
                    " MAIN MENU LINKED LIST STRUCTURE – ABIMBOLA OMOYOLA \n"+
                    " 1. Singly Linked List Structure\n" + 
                    " 2. Singly Linked List Iterator Structure \n"+
                    " 3. Java Linked List With Iterator\n"+
                    " 0. Exit \n"   
                    );
            userInput = keyboard.nextInt();
            keyboard.nextLine();
            
            switch(userInput){
                case 1:
                //Singly Linked List Structure
                do{
                   System.out.println(
                    " MENU – SINGLY LINKED LIST STRUCTURE – ABIMBOLA OMOYOLA \n"+
                    " 1. Insert Account\n" + 
                    " 2. Read Account \n"+
                    " 3. Verify Encapsulation\n"+
                    " 4. Update One Account\n"+
                    " 5. Delete One Account\n"+
                    " 6. Show All\n"+
                    " 0. Exit \n"   
                    );
                   userInput2 = keyboard.nextInt();
                   keyboard.nextLine();
                   
                   switch(userInput2){
                       case 1:
                       // Insert Account
                       System.out.println("Enter an account Name");
                       accountName =keyboard.nextLine();
                       
                       System.out.println("Enter account Number");
                       accountNumber = keyboard.nextLine();
                       
                       System.out.println("Enter starting balance");
                       accountBalance = keyboard.nextDouble();
                       
                       account = new CheckingAccount_Omoyola(accountName,accountNumber,accountBalance);
                       accountList.insert(account);
                       System.out.println();
                       break;
                       
                       case 2:
                       try{
                       // Read Account
                            System.out.println("Enter the account number you want to read");
                            fetched = accountList.fetch(keyboard.nextLine());
                            System.out.println(fetched.toString());
                            System.out.println();
                    }catch(NullPointerException e){
                        System.out.println("*****There is no node in the Singly Linked List or account doesn't exist****");
                    }
                       break;
                       
                       case 3:
                       //Verify Encapsulation
                       System.out.println("Enter an account Name");
                       accountName =keyboard.nextLine();
                       
                       System.out.println("Enter account Number");
                       accountNumber = keyboard.nextLine();
                       
                       System.out.println("Enter starting balance");
                       accountBalance = keyboard.nextDouble();
                       
                       account = new CheckingAccount_Omoyola(accountName,accountNumber,accountBalance);
                       accountList.insert(account);
                       
                       System.out.println("Enter a New Minumum Amount: ");
                       account.setFees(keyboard.nextDouble());
                       
                       temp = accountList.fetch(accountNumber);
                       
                       System.out.println(account.toString());
                       System.out.println();
                       System.out.println(temp.toString());
                       System.out.println();
                       if(account.getFees() == temp.getFees()){
                           System.out.println("Singly Lnked List is not encapsulated");
                        }else{
                            System.out.println("Singly Lnked List is  encapsulated");
                        }
                       System.out.println();
                       break;
                       
                       case 4:
                       //Update One Account
                       System.out.println("Enter an account Name");
                       accountName =keyboard.nextLine();
                       
                       System.out.println("Enter account Number");
                       accountNumber = keyboard.nextLine();
                       
                       System.out.println("Enter starting balance");
                       accountBalance = keyboard.nextDouble();
                       
                       account = new CheckingAccount_Omoyola(accountName,accountNumber,accountBalance);
                       accountList.insert(account);
                       
                       System.out.println("Enter a New Minumum Amount: ");
                       account.setFees(keyboard.nextDouble());
                       
                       accountList.update(accountNumber,account);
                       System.out.println(account.toString());
                       System.out.println();
                       break;
                       
                       case 5:
                       //Delete one Account
                       System.out.println("Enter  the Account you wish to delete ");
                       choice= keyboard.nextLine();
                       accountList.delete(choice);
                       System.out.println();
                       break;
                       
                       case 6:
                       //Show All
                       accountList.showAll();
                       break;
                
                    }
                }while(userInput2 != 0);
                 System.out.println("Thank you, Taking you back to the main menu");
                break;
                case 2:
                //Singly Linked List Iterator Structure
                //-Allow users to insert 5 accounts (either Checking Account or Saving Account) to the Singly Linked List with Iterator
                //INSERT
                 for (int j = 0; j < 5; j++) {
                     
            
                     System.out.println("Enter your Account Name ");
                     accountName = keyboard.nextLine();
            
                     System.out.println("Enter Your Account Number");
                     accountNumber = keyboard.nextLine();
            
                     System.out.println("Enter a Starting balance ");
                     accountBalance = keyboard.nextDouble();
                     keyboard.nextLine();
            
                     account = new SavingAccount_Omoyola(accountName,accountNumber, accountBalance);
                     accountIterator.insert(account);
                         }
                         
                 // show all 5 accounts in the Singly Linked List with Iterator  
                  //FETCH
                   System.out.println("*********Inserted accounts******");
                   while(accountIterator.i.hasNext())
                   {
                      System.out.println(accountIterator.i.next()); 
                   }
                 //Each account numbers, add “19” at the beginning
                 //UPDATE
                 accountIterator.i.reset();
                 while(accountIterator.i.hasNext())
                   {
                      account = accountIterator.i.next();
                      number = account.getNumber();
                      number = "19"+number;
                      account.setNumber(number);
                      accountIterator.i.set(account);
                   }
                 accountIterator.i.reset();
                 //show all the accounts
                 System.out.println("*********Updated Account Numbers******");
                   while(accountIterator.i.hasNext())
                   {
                      System.out.println(accountIterator.i.next()); 
                   }
                 
                 accountIterator.i.reset();
                 //DELETE
                 //move iterator to the third account in the Singly Linked List with Iterator
                 for(int j = 0; j < 2 ; j++){
                    accountIterator.i.next();
                    }
                    
                 System.out.println("*********(the third account)******");  
                 account = accountIterator.i.next();
                 System.out.println(account);
                 number = account.getNumber();
                 accountIterator.delete(number);
                 
                 //show all accounts to verify the account is deleted
                 accountIterator.i.reset();
                 System.out.println("*********Updated accounts ( After deleting the third account)******");
                 while(accountIterator.i.hasNext())
                   {
                      System.out.println(accountIterator.i.next()); 
                   }
                break;
                
                case 3:
                //Java LinkedList With ListIterator
                //INSERT 5 Accounts
                
                for (int j = 0; j < 5; j++) {
                     
            
                     System.out.println("Enter your Account Name ");
                     accountName = keyboard.nextLine();
            
                     System.out.println("Enter Your Account Number");
                     accountNumber = keyboard.nextLine();
            
                     System.out.println("Enter a Starting balance ");
                     accountBalance = keyboard.nextDouble();
                     keyboard.nextLine();
            
                     account = new CheckingAccount_Omoyola(accountName,accountNumber, accountBalance);
                     i.add(account);
                    }
                   
                // reset Iterator to the front of the list
                while(i.hasPrevious()){
                    i.previous();
                }
                 //FECTH fisrt 2 accounts in Java Linked List
                System.out.println("*******First two accounts in Java Linked List******** ");
                for(int j = 0; j < 2; j++){
                      temp  = (Account_Omoyola) i.next();
                      System.out.println(temp); 
                    }
                
                // reset Iterator to the front of the list
                while(i.hasPrevious()){
                    i.previous();
                }
                 
                //UPDATE  
                //fetch the node at third location of iterator to variable temp
                for(int j = 0; j < 3; j++){
                      temp  = (Account_Omoyola) i.next();
                      
                    }
                System.out.println("*******Node at third location in Java Linked List******** ");
                System.out.println(temp);
                //change the minimum amount temp
                temp.setFees(300);
                i.set(temp);
                System.out.println("*******Updated Account******** ");
                System.out.println(temp);
                 // reset Iterator to the front of the list
                 while(i.hasPrevious()){
                    i.previous();
                }
                
                //SHOWALL
                System.out.println("********* All Accounts *********");
                while(i.hasNext())
                   {
                      temp  = (Account_Omoyola) i.next();
                      System.out.println(temp); 
                   }
                break;
            }
            }while(userInput != 0);
             keyboard.close();
             System.out.println("Thank you. The application is terminating.......");         
         }               
}