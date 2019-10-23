/**
 * Lab 5 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/25/2019)
 */

public class Account_Omoyola {

    
    protected String account_number;
    protected String account_name;
    protected double balance;
    protected double fees;
    
    
    // no argument constructor 
    public Account_Omoyola()
    {
        account_name = "";
        account_number = "";
        balance = 0.00; 
    }
    
    //Parameterized constructor 
    public Account_Omoyola(String name,String number, double bal) {
        this.account_number = number;
        this.account_name = name;
        this.balance = bal;
    }
    //ToString method
    public String toString() {
        return  ( "Account  Number: " +account_number + "\n" +
                 "Name: " +account_name + "\n" +
                 "End Balance: " +balance+ "\n");
    }
    
    public int compareTo(String targetKey)
    {
        return(account_number.compareTo(targetKey));
       
    }
    
    public Account_Omoyola deepCopy()
    {
        Account_Omoyola clone = new Account_Omoyola (account_name, account_number, balance);
                return clone;
    }
    
    public void setFees(double fees){
       fees = fees;
       }
    
       public double getFees(){
        return fees;
    }
    
    public String getNumber()
    {
        return account_number;
    }
    
    public void setNumber(String n)
    {
        account_number = n;
    }
}