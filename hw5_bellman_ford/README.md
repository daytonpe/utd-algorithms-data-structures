Patrick Dayton
6 APR 2018
UT-Dallas
CS-5343
Prof. Gupta

I used NetBeans IDE to build this project.

RUNNING ON COMMAND LINE
$cd bellmanford
$javac Graph.java Main.java LinkedList.java
$cd ..
$java -cp . bellmanford.Main

WHAT WILL HAPPEN
The Bellman Ford algorithm will run on both graphs, outputting their minimum distance arrays. If graph throws the negative cycle array, you will be notified in the terminal.

I also included (commented out) a graph implementation of one of the graphs given in the slides, as well as one I found online. I used these to check to ensure the algorithm was giving the correct matrices.

Let me know if you have any questions or have any issues running the code: pxd170130@utdallas.edu

EXPECTED OUTPUT
run:
Patrick Dayton
Due 6 APR 2018
UTD CS 5343
Professor Gupta

#######################


QUESTION 1


Adjacency List
1 --> 2 --> 4 --> null
2 --> 3 --> 4 --> 5 --> null
3 --> 2 --> null
4 --> 3 --> 5 --> null
5 --> 3 --> 1 --> null


Edge Weights
[0, 6, 0, 7, 0]
[0, 0, 5, 8, -5]
[0, -2, 0, 0, 0]
[0, 0, -3, 0, 9]
[2, 0, 7, 0, 0]


Bellman Ford Algorithm Called

Updating distances...
[0, 99999, 99999, 99999, 99999]
[0, 6, 99999, 99999, 99999]
[0, 6, 99999, 7, 99999]
[0, 6, 11, 7, 99999]
[0, 6, 11, 7, 1]
[0, 6, 4, 7, 1]
[0, 2, 4, 7, 1]
[0, 2, 4, 7, -3]
[-1, 2, 4, 7, -3]
[-1, 2, 4, 6, -3]
[-1, 2, 3, 6, -3]

Checking for negative cycles...
2 > -1 + 6
6 > -1 + 7
3 > 2 + 5
6 > 2 + 8
-3 > 2 + -5
2 > 3 + -2
3 > 6 + -3
-3 > 6 + 9
3 > -3 + 7
-1 > -3 + 2

Minimum Distances
Negative cycle exists.
[-1, 2, 3, 6, -3]


#######################

QUESTION 2


Adjacency List
1 --> 2 --> 4 --> null
2 --> 3 --> 4 --> 5 --> null
3 --> 2 --> null
4 --> 3 --> 5 --> null
5 --> 3 --> 1 --> null


Edge Weights
[0, 6, 0, 7, 0]
[0, 0, 5, 8, -5]
[0, -2, 0, 0, 0]
[0, 0, -2, 0, 9]
[2, 0, 7, 0, 0]


Bellman Ford Algorithm Called

Updating distances...
[0, 99999, 99999, 99999, 99999]
[0, 6, 99999, 99999, 99999]
[0, 6, 99999, 7, 99999]
[0, 6, 11, 7, 99999]
[0, 6, 11, 7, 1]
[0, 6, 5, 7, 1]
[0, 3, 5, 7, 1]
[0, 3, 5, 7, -2]

Checking for negative cycles...
3 > 0 + 6
7 > 0 + 7
5 > 3 + 5
7 > 3 + 8
-2 > 3 + -5
3 > 5 + -2
5 > 7 + -2
-2 > 7 + 9
5 > -2 + 7
0 > -2 + 2

Minimum Distances
[0, 3, 5, 7, -2]
