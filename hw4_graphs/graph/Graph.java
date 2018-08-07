//Patrick Dayton
//24 FEB 2018
//UT-Dallas
//CS-5343
//Prof. Gupta


/*
1. Create a graph of at least 10 nodes and 20 edges. You may use any representation we have discussed

       Print the nodes and the edges.

2. Do a DFS traversal of the graph.  Print the nodes in the order visited.

3. Do a BFS traversal.  Use the same node to start as in 2 above.
*/


package graph;
import java.io.*;
import java.util.*;

public class Graph extends LinkedList{
    
    int vertices;
    LinkedList[] adjList;
    
    /*
    Constructor for the graph
    Vertices are delineated by integer values. All need to be unique.
    */
    Graph(int Vertices){
        
        /*Define the number of vertices*/
        vertices = Vertices; 
        
        /*
        Create a linked list for each vertex and place in an array.
        This array is the adjacency list. 
        */
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList();
        }
    }
    
    /*Print the graph via its adjacency list*/
    void printGraph(){
        
        for (int i = 0; i < vertices; i++) {
            adjList[i].printList();
            System.out.println();
        }
    }
    
    /*Add Edge between two vertexes*/
    void addEdge(int v1, int v2){
        for (int i = 0; i < vertices; i++) {
            if (adjList[i].head.data == v1 ){
                adjList[i].pushEnd(v2);
                return;
            }
        }
    } 
    
    /*DFS Traversal*/
    void dfs(Node vertex){
        /*
        Basic Idea in my head...
        1. Pick starting node and push it to stack and visit it and mark as visited
        2. Look at the adjacent vertices in alpha order (or whatever order)
        3. Push the first one onto the stack and visit it and mark as visited
        4. Repeat process with whatever is now on top of stack
        5. Only continue visiting ones that are UNVISITED
        6. If there’s nowhere to go, pop it off the stack.
        */
        
        System.out.println("\nDFS TRAVERSAL");
        /*Initialize our Stack*/
        ArrayList<Node> stack = new ArrayList<Node>();
        
        /*Initialize our visited array*/     
        //+1 so we can use consistent naming for vertices
        boolean[] visited = new boolean[vertices+1]; 
        
        //Push vertex to stack
        stack.add(vertex);
        
        
        //While we still have vertices in the stack
        while (!stack.isEmpty()){
            
            /*Point current vertex to the top of the stack*/
            int stackTopVal = stack.get(stack.size()-1).data;
            vertex = adjList[stackTopVal-1].head;
            
            /*Print if not visited*/
            if(visited[vertex.data] == false){
                /*Visit vertex*/
                System.out.print(vertex.data+" ");
            }
            
            /*Mark the vertex as visited*/
            visited[vertex.data] = true;
                     
            /*Find next adjacent from vertex*/
            Node temp = vertex.next;
            while(true){
                
                /*Everything in linked list was visited*/
                if (temp == null){
                    /*pop the top node off the stack*/
                    stack.remove(stack.size()-1);

                    /*
                    //Debugging code to print Stack
                    System.out.println("");
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.print("|"+stack.get(i).data);
                    }
                    System.out.println("");
                    */
                    
                    break;
                }
                
                /*Found an unvisited node*/
                if(visited[temp.data]==false){
                    //Push temp to stack
                    stack.add(temp);
                    
                    /*
                    //Debugging code to print Stack
                    System.out.println("");
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.print("|"+stack.get(i).data);
                    }
                    System.out.println("");
                    */
                    
                    break;
                }                            
                temp = temp.next;
            }                  
        }   
        System.out.println("\n");  
    }  
    
    /*BFS Traversal*/
    void bfs(Node vertex){
        /*
        Basic Idea in my head...
        1. Pick starting node, visit it
        2. Look at the adjacent nodes and add the unvisited ones to queue in alpha order marking them visited as you do so
        3. once done, mark the head of the queue as your newly active node
        */
        
        System.out.println("BFS TRAVERSAL");
        /*Initialize our Queue*/
        ArrayList<Node> queue = new ArrayList<Node>();
        
        /*Initialize our visited array*/     
        //+1 so we can use consistent naming for vertices
        boolean[] visited = new boolean[vertices+1]; 
        
        //Push vertex to Queue
        queue.add(vertex);
        
        
        //While we still have vertices in the queue
        while (!queue.isEmpty()){
            
            /*Point current vertex to the top of the queue*/
            int queueFrontVal = queue.get(0).data;
            vertex = adjList[queueFrontVal-1].head;
            
            /*Print if not visited*/
            if(visited[vertex.data] == false){
                /*Visit vertex*/
                System.out.print(vertex.data+" ");
            }
            
            /*Mark the vertex as visited*/
            visited[vertex.data] = true;
                     
            /*Find next adjacent from vertex*/
            Node temp = vertex.next;
            while(true){
                
                /*Everything in linked list was visited*/
                if (temp == null){
                    /*pop the top node off the queue*/
                    queue.remove(0);

                    
                    /*
                    //Debugging code to print Queue
                    System.out.println("");
                    for (int i = 0; i < queue.size(); i++) {
                        System.out.print("|"+queue.get(i).data);
                    }
                    System.out.println("");
                    */
                    
                    
                    break;
                }
                
                /*Found an unvisited node*/
                if(visited[temp.data]==false){
                    //Push temp to queue
                    queue.add(temp);
                    
                    /*
                    //Debugging code to print Queue
                    System.out.println("");
                    for (int i = 0; i < queue.size(); i++) {
                        System.out.print("|"+queue.get(i).data);
                    }
                    System.out.println("");
                    */
                    
                    
                }                            
                temp = temp.next;
            }                  
        }   
        System.out.println("\n");  
    }  
}
