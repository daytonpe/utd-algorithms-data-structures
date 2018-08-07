//Patrick Dayton
//1 FEB 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

package aa_hw1_1;


public class SelectionSort extends SinglyLinkedList {

    
    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        
        //CREATE LIST WITH RANDOM VALUES
        Node zeroth = new Node(8);
        llist.head  = zeroth;
        Node first = new Node(4);
        Node second = new Node(135);
        Node third  = new Node(17);
        Node fourth = new Node(41);
        Node fifth  = new Node(-45);
        Node sixth = new Node(39);
        Node seventh  = new Node(14);
        Node eighth = new Node(100);
        Node ninth  = new Node(17);
        
        zeroth.next = first; // Link head node with the first node
        first.next = second; // Link second node with the third node
        second.next = third; // And so on...
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        
        System.out.println("Testing on 10 Node List");
        llist.printList();
        llist.head = recursiveSelectionSort(zeroth, zeroth);
        llist.printList();
        System.out.println();
        
        System.out.println("Testing Single Node List");
        llist.head.next = null;
        llist.printList();
        llist.head = recursiveSelectionSort(llist.head, llist.head);
        llist.printList();
        
        //test that passing an empty list also works correctly.
        System.out.println("");
        System.out.println("Testing Empty List");
        llist.head = null;
        llist.head = recursiveSelectionSort(llist.head, llist.head);
        llist.printList();
        System.out.println("");
    }
    
}
