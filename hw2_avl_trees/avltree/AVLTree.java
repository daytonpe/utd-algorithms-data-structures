/*
Write a program to implement AVL insert.

Use the algorithm discussed in the class to create AVL tree. Insert at least 15 nodes in random order.

After all the nodes are inserted, print the left and the right height of the last 
node inserted (should be 0 or can be 1 if a zigzag rotation happened after the last insert). 
Go all the way to the root to print left and right height.

Submit the code.

Submit screen shot of execution.

submit readme file giving steps to compile and run the program (what environment)
 */
package avltree;


public class AVLTree {
    
    Node root;  // root of the tree
    
    /*Constructor for Node*/
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        Node(int d)  { data = d;  left=null; right=null; int h = 0;} // Constructor
    }
    
    /* This function prints contents of AVL tree IN ORDER*/
    static void printList(Node root)
    {
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        printList(root.left);
        printList(root.right);
        
    }
    
    /* Function to compute height of a Node.*/
    static int height(Node root){
        if (root == null){
            return 0;           
        }    
        else {
            /* compute  height of each subtree */
            int l = height(root.left);
            int r = height(root.right);
             
            /* use the larger one */
            if (l > r){
                return(l+1);                
            }
            else return(r+1); 
        }
    }
    
    /* Function places the new node in it's initial spot (without rotations */
    static void initInsert(Node root, Node newNode){
        
        // Base Case Left (Insert on left side of node)
        if (newNode.data <= root.data && root.left == null){
            root.left = newNode;
            newNode.parent = root;
            System.out.println("Inserted node "+newNode.data);
            return;
        }
        
        // Base Case Right (Insert on right side of node)
        if (newNode.data > root.data && root.right == null){
            root.right = newNode;
            newNode.parent = root;
            System.out.println("Inserted node "+newNode.data);
            return;
        }
        
        // Recurse Case Left
        if (newNode.data <= root.data){
            initInsert (root.left, newNode);
        }
        
        // Recurse Case Right
        if (newNode.data > root.data){
            initInsert (root.right, newNode);
        }
    }
    
    /* Function traverses upward from inserted node to find imbalance*/
    static Node traverseUp(Node root, Node newNode){
        Node temp = newNode.parent; //copy of newNode that we can manipulate as we move up.
        
        //We've found the unbalanced node
        if (Math.abs(height(temp.left) - height(temp.right))>1){
            System.out.println("Unbalanced at: " + temp.data);
            return temp;
        }
        //Node is balanced
        if (temp == root){ 
            System.out.println("Balanced");
            System.out.println("");
            return null;
        }
        
        return traverseUp(root, temp);
        
    }
    
    /* Function to perform a Left Left Rotation */
    void leftLeftRotation(Node a, Node b, Node c){
        if (a.parent == null){ //we are rotating on the root
            System.out.println("Left Left Rotation (w/ Root) at "+ a.data);
            root = b;
            b.parent = null;
            if (b.right !=null) {
                a.left = b.right;
                b.right.parent = a;
            }
            else{
                a.left = null;
            }
            b.right = a;
            a.parent = b;           
            
        }
        else{ //we are working down a branch somewhere
            System.out.println("Left Left Rotation (w/o Root) at "+ a.data);
            System.out.println("");
            if (b.right !=null) {
                a.left = b.right;
                b.right.parent = a;
            }
            else{
                a.left = null;
            }
            if (a.parent.data>=a.data) {
                a.parent.left = b;
            }
            else {
                a.parent.right = b;
            }
            b.parent = a.parent;        
            a.parent = b;
            b.right = a;
        }
    }
    
    /* Function to perform a Left Left Rotation */
    void rightRightRotation(Node a, Node b, Node c){
        if (a.parent == null){ //we are rotating on the root
            System.out.println("Right Right Rotation (w/ Root) at "+ a.data);
            root = b;
            b.parent = null;
            if (b.left !=null) {
                a.right = b.left;
                b.left.parent = a;
            }
            else{
                a.right = null;
            }
            b.left = a;
            a.parent = b;           
            
        }
        else{ //we are working down a branch somewhere
            System.out.println("Right Right Rotation (w/o Root) at "+ a.data);
            System.out.println("");
            if (b.left !=null) {
                a.right = b.left;
                b.left.parent = a;
            }
            else{
                a.right = null;
            }
            if (a.parent.data>=a.data) {
                a.parent.left = b;
            }
            else {
                a.parent.right = b;
            }
            b.parent = a.parent;        
            a.parent = b;
            b.left = a;
        }
        

    }
    
    /* Function for testing the links of a node*/
    static void checkLinks(Node a){
        if (a.parent != null) {
            System.out.println(a.data + " parent is " + a.parent.data);
        }
        else {
            System.out.println(a.data + " parent is null");
        }
        if (a.left != null) {
            System.out.println(a.data + " left is " + a.left.data);
        }
        else {
            System.out.println(a.data + " left is null");
        }
        if (a.right != null) {
            System.out.println(a.data + " right is " + a.right.data);
        }
        else {
            System.out.println(a.data + " right is null");
        }
    }
    
    /* Function to perform a Left Right Rotation */
    void leftRightRotation(Node a, Node b, Node c){
        System.out.println("Left Right Rotation at "+ a.data);
        a.left = c;
        c.left = b;
        b.parent = c;
        b.right = null;
        c.parent = a;
        leftLeftRotation(a,c,b); //switched for more natural LL rotation      
    }
    
    /* Function to perform a Right Left Rotation */
    void rightLeftRotation(Node a, Node b, Node c){
        System.out.println("Right Left Rotation at "+ a.data);
        a.right = c;
        c.right = b;
        b.parent = c;
        b.left = null;
        c.parent = a;        
        rightRightRotation(a,c,b); // switched for more natural RR rotationå   
    }
          
    /* Function performs the rotations in the helper methods*/
    void rotate(Node a, Node newNode){
        // The three nodes necessary in the rotation, will be refered to as
        // a, b, and c in this function from top to bottom.
        
        //Find Node b
        if (newNode.data <= a.data) {
            Node b = a.left;
            if (newNode.data <= b.data) {
                Node c = b.left;  // Case 1: Left Left (Straight)
//                System.out.println("Node a: "+ a.data + " Node b: "+ b.data + " Node c: "+ c.data);
                leftLeftRotation(a,b,c);
            }
            else {
                Node c = b.right; // Case 2: Left Right (ZigZag)
//                System.out.println("Node a: "+ a.data + " Node b: "+ b.data + " Node c: "+ c.data);
                leftRightRotation(a,b,c);
            }
        }
        else {
            Node b = a.right;
            if (newNode.data <= b.data) {
                Node c = b.left; // Case 3: Right Left (ZigZag)
//                System.out.println("Node a: "+ a.data + " Node b: "+ b.data + " Node c: "+ c.data);
                rightLeftRotation(a,b,c);
            }
            else {
                Node c = b.right; // Case 4: Right Right (Straight)
//                System.out.println("Node a: "+ a.data + " Node b: "+ b.data + " Node c: "+ c.data);
                rightRightRotation(a,b,c);
            }
        }  
    }
    
    /* Function utilizes helper functions to complete 
    an insert and necessary rotations*/
    void fullInsert(Node newNode){
        initInsert(root,newNode);
        Node problemNode = traverseUp(root, newNode);
        
        if (problemNode != null) {
            rotate(problemNode, newNode);
        }
    }
    
    /* Function prints node heights as stated in problem*/
    static void printHeights(Node newNode){
        if (newNode.parent == null){
            System.out.println("    " + height(newNode.left) + "         " + 
                    newNode.data + "         " + height(newNode.right));
            System.out.println("***********Root Level***********");
        }
        else{
            System.out.println("    " + height(newNode.left) + "         " + 
                    newNode.data + "         " + height(newNode.right));
            printHeights(newNode.parent);
        }
    }
    
    /**************************************************************************/
    /**************************************************************************/
    // CITATION:https://www.geeksforgeeks.org/?p=2686
    // I modified these open-source functions to allow myself to visualize 
    // the array in BFS order, making debugging my AVL tree easier. See
    // citation above for original code.
    
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root); //should be 2 for my base case.
        int i;
        for (i=0; i<=h; i++)
            printGivenLevel(root, i);
    }
    
    /* Print nodes at the given level */
    static void printGivenLevel (Node root , int level)
    {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (level > 0)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
    /**************************************************************************/
    /**************************************************************************/
    
}
