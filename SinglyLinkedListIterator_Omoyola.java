/**
 * Lab 5 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/25/2019)
 */
public class SinglyLinkedListIterator_Omoyola
{
     private Node h; // List Header
     public Iterator i;
    
    public SinglyLinkedListIterator_Omoyola()
    {
        h = new Node();// Dummy node
        i = new Iterator();
        h.l = null;
        h.next = null;
    }
    
    public boolean insert(Account_Omoyola newAccount)
    {
            Node n = new Node();
            if(n == null){//Out of Memory
                System.out.println("Cannot open this account");
                return false;
            }
            else{
                n.next = h.next;
                h.next = n;
                n.l = newAccount.deepCopy();
                System.out.println("The account is inserted successfully");
                return true;
            }
    }
    
    public Account_Omoyola fetch(String targetKey)
    {   
            Node p = h.next;
            while(p !=null && !(p.l.compareTo(targetKey) == 0))
            {
                p = p.next;
            }
            
            if(p != null)
                return p.l.deepCopy();
            else
                return null;
    
    }
    
    public boolean delete(String targetKey)
    {      
        Node q = h;
        Node p = h.next;
        while(p !=null && !(p.l.compareTo(targetKey) == 0))
            {   
                q = p;
                p = p.next;
            }
        
            if(p != null){
                System.out.println("***Account is closed***");
                q.next = p.next;
                return true;
            }else{
                System.out.println("***Delete account failed***");
                return false;
               }
    
    }
    
    public boolean update(String targetKey, Account_Omoyola newAccount)
    {  
        if(delete(targetKey) == false)
            return false;
        else if(insert(newAccount) == false){
            System.out.println("Update not successfull"); 
            return false;
        }
            else{
                System.out.println("Update successfully"); 
        return true;
        }
    }
    
    public void showAll()
    {
        Node p = h.next;
        while(p != null)// Continue to traverse the list
        {
            System.out.println(p.l.toString());
            p = p.next;
        }
    }
    
    public class Node
    {   
        private Account_Omoyola l;
        private Node next;
        public Node()
        {}
    
    }// End of inner class node
    
    public class Iterator
    {
        private Node ip;
        public Iterator()
        {   
            ip = h;
        }
        
        public void reset()
        {   
            ip = h;
        
        }
        
        public boolean hasNext()
        {
            if(ip.next != null)
                return true;
            else
                return false;
         }
         
        public Account_Omoyola next()
        {
            ip = ip.next;
            return ip.l.deepCopy();
        }
   
        public void set(Account_Omoyola newAccount)
        {
            ip.l = newAccount.deepCopy();
        }
  } // End of Inner class Iterator
}