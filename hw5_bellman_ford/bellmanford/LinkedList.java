//Patrick Dayton
//6 APR 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

/*
1. Create a graph of at least 10 nodes and 20 edges. You may use any representation we have discussed

       Print the nodes and the edges.

2. Do a DFS traversal of the graph.  Print the nodes in the order visited.

3. Do a BFS traversal.  Use the same node to start as in 2 above.
*/

package bellmanford;

//Singly Linked Lists

// A simple Java program to introduce a linked list
class LinkedList
{
    Node head;  // head of list

    /* Linked list Node.  This inner class is made static so that
       main() can access it */
    static class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next=null; } // Constructor
    }

   /* All of these classes are within the LinkedList class,
    thus they are called on a linkedList with dot notation.*/


    /* This function prints contents of linked list starting from head */
    public void printList()
    {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data+" --> ");
            n = n.next;
        }
        System.out.print("null");
    }

    /* This function prints contents of linked list starting from head */
    public static void printListFromNode(Node n)
    {
        while (n != null)
        {
            System.out.print(n.data+" --> ");
            n = n.next;
        }
        System.out.print("null");
    }

    /*Count Nodes*/
    public int countNodes(){
        Node tmp = head;
        int count = 0;
        while (tmp != null){
            tmp = tmp.next;
            count++;
        }
        System.out.println("\n"+count+" total nodes");
        return count;
    }

    /*Count Nodes Recursively*/
    public int countNodesRecursive(Node tmp){
        if (tmp == null){
            return 0;
        }
        else return 1+countNodesRecursive(tmp.next);
    }

    /*push a new node onto SLL as a new head*/
    public void pushFront(int value)
    {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(value);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /*push a new node to end of SLL*/
    public void pushEnd(int value){
        Node new_node = new Node(value);

        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = new_node;
    }

    /*push a new node to end of SLL*/
    public void pushNodeEnd(Node new_node){

        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = new_node;
    }

    /*Insert before a specific node*/
    public void insertBefore(Node B, int v){
        Node new_node = new Node(v);
        Node tmp = head;
        while(tmp.next != B){
            tmp = tmp.next;
        }
        new_node.next = B;
        tmp.next = new_node;
    }

    /*Insert before a specific node recursively*/
    public void insertBeforeRecursive(Node B, int v, Node tmp){
        if (tmp.next == B){ //we haven't found B
            Node new_node = new Node(v);
            new_node.next = B;
            tmp.next = new_node;

        }
        else{
            insertBeforeRecursive(B, v, tmp.next);
        }
    }

    /*Delete a node by name (not value) recursively*/
    public void deleteNodeRecursive(Node tmp, Node n){
        if(tmp.next == null){
            System.out.println("\nnode not found");
        }
        else if(tmp.next == n){ //found it!
            tmp.next = n.next;
        }
        else{
            deleteNodeRecursive(tmp.next, n);
        }
    }

    /*Count Nodes with specific value recursively*/
    public static int countVsRecursive(Node tmp, int v){
        if (tmp == null){
            return 0;
        }
        else if(tmp.data == v){
            return 1 + countVs(tmp.next, v);
        }
        else return countVs(tmp.next, v);
    }

    // Count Nodes with specific value NONrecursively
    public static int countVs(Node tmp, int v){
        int count = 0;
        while(tmp != null){
            if(tmp.data == v){
                count++;
            }
            tmp = tmp.next;
        }
        return count;
    }

     //find largest value, recursively, SLL
    public static int largestRecursive(Node tmp){ //presume tmp is head
        if(tmp == null){
            System.out.println("error");
            return -999;
        }
        else if (tmp.next == null){
            return tmp.data;
        }
        else return Math.max(tmp.data, largestRecursive(tmp.next));
    }

    //find the middle node, at least 3 nodes, SLL
    public static Node middle(Node tmp1, Node tmp2){ //presumably the head
        if (tmp1==null){
            return tmp1;
        }
        while (tmp2.next !=null && tmp2.next.next != null){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next.next;
        }
        System.out.println();
        System.out.println("Middle[ish] Node: " + tmp1.data);
        return tmp1;
    }
}
