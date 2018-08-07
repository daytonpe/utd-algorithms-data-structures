
//Patrick Dayton
//17 FEB 2018
//UT-Dallas
//CS-5343
//Prof. Gupta
package avltree;


public class AVLInsert extends AVLTree{
    public static void main(String[] args) {
        
        /* Test Tree #1 */
        AVLTree t = new AVLTree();
        Node n1 = new Node(50);
        Node n2 = new Node(25);
        Node n3 = new Node(15);
        Node n4 = new Node(75);
        Node n5 = new Node(60);
        Node n6 = new Node(8);
        Node n7 = new Node(12);
        Node n8 = new Node(100);
        Node n9 = new Node(125);
        Node n10 = new Node(68);
        Node n11 = new Node(4);
        Node n12 = new Node(2);
        Node n13 = new Node(10);
        Node n14 = new Node(16);
        Node n15 = new Node(18);
        
        t.root = n1;
        t.fullInsert(n2);
        t.fullInsert(n3);
        t.fullInsert(n4);
        t.fullInsert(n5);
        t.fullInsert(n6);
        t.fullInsert(n7);
        t.fullInsert(n8);
        t.fullInsert(n9);
        t.fullInsert(n10);
        t.fullInsert(n11);
        t.fullInsert(n12);
        t.fullInsert(n13);
        t.fullInsert(n14);
        t.fullInsert(n15);
        
        System.out.println("BFS Order");
        t.printLevelOrder();
        
        System.out.println("");
        System.out.println("");
        System.out.println("LeftHeight NodeValue RightHeight");
        printHeights(n15);
        
        
        /* Test Tree #2 */ 
//        AVLTree t = new AVLTree();
//        Node n1 = new Node(5);
//        Node n2 = new Node(4);
//        Node n3 = new Node(6);
//        Node n4 = new Node(7);
//        Node n5 = new Node(8);
//        Node n6 = new Node(97);
//        Node n7 = new Node(1);
//        Node n8 = new Node(13);
//        Node n9 = new Node(79);
//        Node n10 = new Node(34);
//        Node n11 = new Node(23);
//        Node n12 = new Node(11);
//        Node n13 = new Node(67);
//        Node n14 = new Node(72);
//        Node n15 = new Node(49);    
//        
//        t.root = n1;
//        t.fullInsert(n2);
//        t.fullInsert(n3);
//        t.fullInsert(n4);
//        t.fullInsert(n5);
//        t.fullInsert(n6);
//        t.fullInsert(n7);
//        t.fullInsert(n8);
//        t.fullInsert(n9);
//        t.fullInsert(n10);
//        t.fullInsert(n11);
//        t.fullInsert(n12);
//        t.fullInsert(n13);
//        t.fullInsert(n14);
//        t.fullInsert(n15);
//        
//        System.out.println("BFS Order");
//        t.printLevelOrder();
//
//        System.out.println("");
//        System.out.println("");
//        System.out.println("LeftHeight NodeValue RightHeight");
//        printHeights(n15);
        
    }
}
