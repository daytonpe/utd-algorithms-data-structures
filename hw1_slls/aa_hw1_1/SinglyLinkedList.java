//Patrick Dayton
//1 FEB 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

package aa_hw1_1;


public class SinglyLinkedList {
    
    Node head;  // head of list
  
    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next=null; } // Constructor
    }
    
    /* This function prints contents of linked list starting from head */
    public void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" --> ");
            n = n.next;
        }
        System.out.println("null");
    }
    
    /*Delete a node by name (not value) recursively*/
    public static void deleteNodeRecursive(Node tmp, Node n){
        if(tmp.next == null){
            System.out.println("\nNode not found");
        }
        else if(tmp.next == n){ //found it!
//            System.out.println("Deleted "+n.data + " from unsorted side");
            tmp.next = n.next;
        }
        else{
            deleteNodeRecursive(tmp.next, n);
        }
    }
    
    /*print nodes (for testing)*/
    public static void printNodes(Node tmp){
        while(tmp!=null){
            System.out.print(tmp.data+" --> ");
            tmp = tmp.next;
        }
    }
    
    //find largest value, recursively, SLL
    public static Node largestRecursive(Node tmp){ //presume tmp is head
        if(tmp == null){
//            System.out.println("error");
            return null;
        }
        else if (tmp.next == null){
            return tmp;
        }
        else{
            if (Math.max(tmp.data, largestRecursive(tmp.next).data)==tmp.data){
                return tmp;
            }
            else{
                return largestRecursive(tmp.next);
            }
        }
    }
       
    
//*****************************************************************************
//*****************************Algorithm 1*************************************
//*****************************************************************************    
    public static Node recursiveSelectionSort(Node head_node, Node wall){
        //head_node always points to front
        //wall is the first unsorted element
        //tmp is the runner
        
        //empty list or one node list. No need to sort
        if (head_node==null || head_node.next == null) { 
            System.out.println("NOTHING TO SORT");
            return head_node;
        }
        
        //first time through when head == wall
        else if (head_node == wall){ 
            Node largest = largestRecursive(wall);
            deleteNodeRecursive(wall, largest);
            Node tmp = largest;
            largest.next = wall;
            head_node = tmp; 
            recursiveSelectionSort(head_node, wall);
      
        }
        
        //we have sorted through the end and are done
        else if (wall.next == null){
            System.out.println("DONE SORTING");
            return head_node;
        }
        
        //if our wall node is the largest remaining in the unsorted list
        //we don't actually have to unlink/move anything.
        else if (largestRecursive(wall) == wall){
            return recursiveSelectionSort(head_node, wall.next);
        }
        
        //otherwise we locate and move the largest node.
        else{
            
            //find one before wall
            Node tmp = head_node;
            while (tmp.next != wall){
                tmp = tmp.next;
            } 

            //find the new biggest ( can move this up top)
            Node largest = largestRecursive(wall);
            
            //unlink/delete the biggest
            deleteNodeRecursive(wall, largest);
            
            //relink on the sorted side
            tmp.next = largest;
            largest.next = wall;
            
            //shift wall if necessary and recurse
            return recursiveSelectionSort(head_node, wall);
                    
        }
        return head_node;
    }
    
}
