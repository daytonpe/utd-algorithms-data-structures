Patrick Dayton
17 FEB 2018
UT-Dallas
CS-5343
Prof. Gupta

I used NetBeans IDE to build this project and generate the .jar file.

RUNNING ON COMMAND LINE
$cd avltree
$javac AVLInsert.java AVLTree.java 
$cd ..
$java -cp . avltree.AVLInsert


IF THAT DOESN'T WORK
$java -jar AVLTree.jar


WHAT WILL HAPPEN
15 nodes will be inserted into an AVL Tree. 

Prompts will show actions taken during the insert.

After insertions, Tree will be printed in BFS Order. Citation in AVLTree.java.

Last insertion will be traced to root, printing right and left heights.


SECOND TEST CASE
Comment out test 1 and uncomment test 2 if you want to try a different tree.