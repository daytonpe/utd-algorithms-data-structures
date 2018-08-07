//Patrick Dayton
//24 FEB 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

package graph;

public class Main{
    /* create linked list and test functions*/
    public static void main(String[] args)
    {
        Graph g1 = new Graph(10);
        
        /*Add vertices to graph by setting heads of Adjacency Lists*/ 
        LinkedList.Node a = new LinkedList.Node(1);
        LinkedList.Node b = new LinkedList.Node(2);
        LinkedList.Node c = new LinkedList.Node(3);
        LinkedList.Node d = new LinkedList.Node(4);
        LinkedList.Node e = new LinkedList.Node(5);
        LinkedList.Node f = new LinkedList.Node(6);
        LinkedList.Node g = new LinkedList.Node(7);
        LinkedList.Node h = new LinkedList.Node(8);
        LinkedList.Node i = new LinkedList.Node(9);
        LinkedList.Node j = new LinkedList.Node(10);
              
        g1.adjList[0].head = a;
        g1.adjList[1].head = b;
        g1.adjList[2].head = c;
        g1.adjList[3].head = d;
        g1.adjList[4].head = e;
        g1.adjList[5].head = f;
        g1.adjList[6].head = g;
        g1.adjList[7].head = h;
        g1.adjList[8].head = i;
        g1.adjList[9].head = j;
        
        /*Add edges to graph*/
        //Node 1: A
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(1, 7);
        
        //Node 2: B
        g1.addEdge(2, 1);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);        
        
        //Node 3: C
        g1.addEdge(3, 1);
        g1.addEdge(3, 2);
        g1.addEdge(3, 5);
        g1.addEdge(3, 6);
        g1.addEdge(3, 9);
        g1.addEdge(3, 10);               
        
        //Node 4: D
        g1.addEdge(4, 1);
        g1.addEdge(4, 2);
        g1.addEdge(4, 5);
        g1.addEdge(4, 7);
        
        //Node 5: E
        g1.addEdge(5, 2);
        g1.addEdge(5, 3);
        g1.addEdge(5, 4);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        
        //Node 6: F
        g1.addEdge(6, 3);
        g1.addEdge(6, 5);
        g1.addEdge(6, 9);
        
        //Node 7: G
        g1.addEdge(7, 1);
        g1.addEdge(7, 4);
        g1.addEdge(7, 8);
        g1.addEdge(7, 9);
        
        //Node 8: H
        g1.addEdge(8, 5);
        g1.addEdge(8, 7);
        g1.addEdge(8, 9);
        
        //Node 9: I
        g1.addEdge(9, 3);       
        g1.addEdge(9, 6);
        g1.addEdge(9, 7);
        g1.addEdge(9, 8);
        g1.addEdge(9, 10);
               
        //Node 10: J        
        g1.addEdge(10, 3);
        g1.addEdge(10, 9);
        
        System.out.println("\nPatrick Dayton\n24 FEB 2018\nUTD CS-5343\nProf. Gupta");
        System.out.println("\nADJACENCY LIST FOR G1");
        System.out.println("Vertices = " + g1.vertices);
        System.out.println("Vertex | Edge connections...");
        g1.printGraph();
        System.out.println("**********************************");
        System.out.println("");
        
        g1.dfs(a);
        g1.bfs(a);
        
    }
}
