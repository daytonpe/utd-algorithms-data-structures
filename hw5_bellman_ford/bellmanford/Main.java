//Patrick Dayton
//Due 6 APR 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

package bellmanford;

import java.util.Arrays;

public class Main{

    /*
    Write a program to implement Bellman Ford Algorithm as described in the class.

    1) run on the following data:
    # of nodes 5  --  s 1 2 3 4
    edges with weights -

    S->t = 6; S->y = 7
    t->x = 5; t->y = 8; t->z = -5
    x->t = -2
    y->x = -3; y->z = 9
    z->x = 7; z->s = 2

    2) Repeat the above exercise change y->x = -2;
    */

    static void bellmanFord(Graph g, LinkedList.Node srcNode){

        System.out.println("Bellman Ford Algorithm Called");

        LinkedList[] adjList = g.adjList;
        int nodeCount = adjList.length;

        /*initialize distances array*/
        int[] distances = new int[nodeCount];
        int infinity = 99999;
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].head.data==srcNode.data){
                /*if it's our starting point, set it to 0*/
                distances[i] = 0;
            }
            else{
                /*if not, set it to 'infinity'*/
                distances[i] = infinity;
            }
        }

        /*print initial distances array*/
        System.out.println("\nUpdating distances...");
        System.out.println(Arrays.toString(distances));

        /*outer loop -- we know we need to loop through the list nodes-1 time (at most)*/
        for (int i = 1; i < nodeCount; i++) {

            /*inner loop -- move through the array of nodes updating distances*/
            for (int j = 0; j < adjList.length; j++) {

                /*move each nodes adjacency SLL and update the distances array*/
                LinkedList currentLinkedList = adjList[j];
                LinkedList.Node currentNode = currentLinkedList.head;
                LinkedList.Node temp = currentNode.next;

                /* new distances will be currentNodeDistance + distance to each node in SLL (if less)*/
                int currentNodeDistance = distances[j];

                while (temp != null)
                {
                    /*find distance from currentNode to the next node on the SLL*/
                    int newDistance = currentNodeDistance + g.edgeWeights[currentNode.data-1][temp.data-1];

                    /*update if the new distance is shorter*/
                    if (newDistance < distances[temp.data-1]) {
                        distances[temp.data-1] = newDistance;
                        System.out.println(Arrays.toString(distances));
                    }

                    temp = temp.next;
                }


            }

        }

        boolean cycleFlag = false;
        /*perform the cycle check by looping through the edges*/
        System.out.println("\nChecking for negative cycles...");
        for (int i = 0; i < adjList.length; i++) {
            LinkedList currentLinkedList = adjList[i];
            LinkedList.Node currentNode = currentLinkedList.head;
            LinkedList.Node temp = currentNode.next;
            int currentNodeDistance = distances[i];
            while (temp != null){

                boolean isCycle =  distances[temp.data-1] > distances[currentLinkedList.head.data-1] + g.edgeWeights[currentLinkedList.head.data-1][temp.data-1];

                if (isCycle) {
                    cycleFlag = true;
                }

                /*uncomment this line to print the cycle checks for each edge*/
                System.out.println(distances[temp.data-1] + " > " + distances[currentLinkedList.head.data-1] +" + " +g.edgeWeights[currentLinkedList.head.data-1][temp.data-1]);

                temp = temp.next;
            }


        }

        System.out.println("\nMinimum Distances");

        if (cycleFlag) {
            System.out.println("Negative cycle exists.");
        }

        System.out.println(Arrays.toString(distances));

    }




    public static void main(String[] args)
    {
        System.out.println("Patrick Dayton\nDue 6 APR 2018\nUTD CS 5343\nProfessor Gupta\n\n#######################\n\n");


        /******************************************************************************/
        /*g1 should yield a distances of [0, 5, 5, 7, 9, 8] using 's' as starting node*/

//        Graph g1 = new Graph(6);
//
//        LinkedList.Node s = new LinkedList.Node(1);
//        LinkedList.Node a = new LinkedList.Node(2);
//        LinkedList.Node b = new LinkedList.Node(3);
//        LinkedList.Node c = new LinkedList.Node(4);
//        LinkedList.Node d = new LinkedList.Node(5);
//        LinkedList.Node e = new LinkedList.Node(6);
//
//        g1.adjList[0].head = s;
//        g1.adjList[1].head = a;
//        g1.adjList[2].head = b;
//        g1.adjList[3].head = c;
//        g1.adjList[4].head = d;
//        g1.adjList[5].head = e;
//
//        g1.addEdge(1, 6, 8);  //S --> E weight 8
//        g1.addEdge(1, 2, 10); //S --> A weight 10
//        g1.addEdge(2, 4, 2);  //A --> C weight 2
//        g1.addEdge(3, 2, 1);  //B --> A weight 1
//        g1.addEdge(4, 3, -2); //C --> B weight -2
//        g1.addEdge(5, 4, -1); //D --> C weight -1
//        g1.addEdge(5, 2, -4); //D --> A weight -4
//        g1.addEdge(6, 5, 1);  //E --> D weight 1
//
//
//        g1.printGraph();
//        System.out.println("\n\n");
//        g1.printEdgeWeights();
//        System.out.println("\n\n");
//        bellmanFord(g1, s);


        /*
        /******************************************************************************/
        /* Example from slides: g2 should yield [6, 3, 3, 2, 0]*/

//        Graph g2 = new Graph(5);
//
//        LinkedList.Node one = new LinkedList.Node(1);
//        LinkedList.Node two = new LinkedList.Node(2);
//        LinkedList.Node three = new LinkedList.Node(3);
//        LinkedList.Node four = new LinkedList.Node(4);
//        LinkedList.Node five = new LinkedList.Node(5);
//
//        g2.adjList[0].head = one;
//        g2.adjList[1].head = two;
//        g2.adjList[2].head = three;
//        g2.adjList[3].head = four;
//        g2.adjList[4].head = five;
//
//        g2.addEdge(1, 3, 6);
//        g2.addEdge(1, 4, 3);
//        g2.addEdge(2, 1, 3);
//        g2.addEdge(3, 4, 2);
//        g2.addEdge(4, 2, 1);
//        g2.addEdge(4, 3, 1);
//        g2.addEdge(5, 2, 4);
//        g2.addEdge(5, 4, 2);
//
//        g2.printGraph();
//        System.out.println("\n\n");
//        g2.printEdgeWeights();
//        System.out.println("\n\n");
//        bellmanFord(g2, five);
//        System.out.println("[6, 3, 3, 2, 0] is correct");

        /*
        /******************************************************************************/
        /* Question 1: g2 should yield [-1, 2, 3, 6, -3]*/
        System.out.println("QUESTION 1\n\n");
        Graph g3 = new Graph(5);

        LinkedList.Node s = new LinkedList.Node(1);
        LinkedList.Node t = new LinkedList.Node(2);
        LinkedList.Node x = new LinkedList.Node(3);
        LinkedList.Node y = new LinkedList.Node(4);
        LinkedList.Node z = new LinkedList.Node(5);

        g3.adjList[0].head = s;
        g3.adjList[1].head = t;
        g3.adjList[2].head = x;
        g3.adjList[3].head = y;
        g3.adjList[4].head = z;

        g3.addEdge(1, 2, 6);  //S --> T weight 6
        g3.addEdge(1, 4, 7);  //S --> Y weight 7
        g3.addEdge(2, 3, 5);  //T --> X weight 5
        g3.addEdge(2, 4, 8);  //T --> Y weight 8
        g3.addEdge(2, 5, -5); //T --> Z weight -5
        g3.addEdge(3, 2, -2); //X --> T weight -2
        g3.addEdge(4, 3, -3); //Y --> X weight -3
        g3.addEdge(4, 5, 9);  //Y --> Z weight 9
        g3.addEdge(5, 3, 7);  //Z --> X weight 7
        g3.addEdge(5, 1, 2);  //Z --> S weight 2

        System.out.println("Adjacency List");
        g3.printGraph();
        System.out.println("\n");
        System.out.println("Edge Weights");
        g3.printEdgeWeights();
        System.out.println("\n");
        bellmanFord(g3, s);



        /******************************************************************************/
        /* Question 2: Yields a graph WITHOUT a negative cycle*/

        System.out.println("\n\n#######################\n\nQUESTION 2\n\n");

        Graph g4 = new Graph(5);

        LinkedList.Node s1 = new LinkedList.Node(1);
        LinkedList.Node t1 = new LinkedList.Node(2);
        LinkedList.Node x1 = new LinkedList.Node(3);
        LinkedList.Node y1 = new LinkedList.Node(4);
        LinkedList.Node z1 = new LinkedList.Node(5);

        g4.adjList[0].head = s1;
        g4.adjList[1].head = t1;
        g4.adjList[2].head = x1;
        g4.adjList[3].head = y1;
        g4.adjList[4].head = z1;

        g4.addEdge(1, 2, 6);  //S --> T weight 6
        g4.addEdge(1, 4, 7);  //S --> Y weight 7
        g4.addEdge(2, 3, 5);  //T --> X weight 5
        g4.addEdge(2, 4, 8);  //T --> Y weight 8
        g4.addEdge(2, 5, -5); //T --> Z weight -5
        g4.addEdge(3, 2, -2); //X --> T weight -2
        g4.addEdge(4, 3, -2); //Y --> X weight -3
        g4.addEdge(4, 5, 9);  //Y --> Z weight 9
        g4.addEdge(5, 3, 7);  //Z --> X weight 7
        g4.addEdge(5, 1, 2);  //Z --> S weight 2

        System.out.println("Adjacency List");
        g4.printGraph();
        System.out.println("\n");
        System.out.println("Edge Weights");
        g4.printEdgeWeights();
        System.out.println("\n");
        bellmanFord(g4, s1);


    }
}
