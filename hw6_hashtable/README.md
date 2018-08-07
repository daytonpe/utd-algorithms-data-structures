Patrick Dayton
18 APR 2018
UT-Dallas
CS-5343
Prof. Gupta

I used NetBeans IDE to build this project.

RUNNING ON COMMAND LINE
$cd hashtable
$javac HashTable.java
$cd ..
$java -cp . hashtable.HashTable


WHAT WILL HAPPEN
1) Initial table size, word list size, and lambda will print
2) Hash table will grow in size until it reaches a lambda of < 0.5
3) Hash tables for both linear and quadratic probing will be initialized.
4) New table size and lambda values will print
5) Test to ensure all words were added to hash table will print
6) Test for average insert collisions for each word in wordlist will print
7) Interactive word lookup for 100-word hash table -- displays collisions in quadratic and linear hash tables
8) Adds 10 words to word list
9) Increases table size
10) Rehashes new word wordlist
11) Reprints updated values and tests
12) Interactive word lookup for 110-word hash table -- displays collisions in quadratic and linear hash tables

GOOD WORDS TO TRY
quiet
bologna
brush
duck


Let me know if you have any questions or have any issues running the code: pxd170130@utdallas.edu

EXPECTED OUTPUT

Patrick Dayton (pxd170130)
UTD CS5343 -- Gupta
Homework 6: Hashing
4/21/18


****************** 100 WORD HASH SETUP ******************

Initial Table Size:      53
Initial Word List Size:  100
Initial Lambda:          1.89

Increasing Size --> Tablesize: 59	Updated Lambda: 1.69
Increasing Size --> Tablesize: 61	Updated Lambda: 1.64
Increasing Size --> Tablesize: 67	Updated Lambda: 1.49
Increasing Size --> Tablesize: 71	Updated Lambda: 1.41
Increasing Size --> Tablesize: 73	Updated Lambda: 1.37
Increasing Size --> Tablesize: 79	Updated Lambda: 1.27
Increasing Size --> Tablesize: 83	Updated Lambda: 1.2
Increasing Size --> Tablesize: 89	Updated Lambda: 1.12
Increasing Size --> Tablesize: 97	Updated Lambda: 1.03
Increasing Size --> Tablesize: 101	Updated Lambda: 0.99
Increasing Size --> Tablesize: 103	Updated Lambda: 0.97
Increasing Size --> Tablesize: 107	Updated Lambda: 0.93
Increasing Size --> Tablesize: 109	Updated Lambda: 0.92
Increasing Size --> Tablesize: 113	Updated Lambda: 0.88
Increasing Size --> Tablesize: 127	Updated Lambda: 0.79
Increasing Size --> Tablesize: 131	Updated Lambda: 0.76
Increasing Size --> Tablesize: 137	Updated Lambda: 0.73
Increasing Size --> Tablesize: 139	Updated Lambda: 0.72
Increasing Size --> Tablesize: 149	Updated Lambda: 0.67
Increasing Size --> Tablesize: 151	Updated Lambda: 0.66
Increasing Size --> Tablesize: 157	Updated Lambda: 0.64
Increasing Size --> Tablesize: 163	Updated Lambda: 0.61
Increasing Size --> Tablesize: 167	Updated Lambda: 0.6
Increasing Size --> Tablesize: 173	Updated Lambda: 0.58
Increasing Size --> Tablesize: 179	Updated Lambda: 0.56
Increasing Size --> Tablesize: 181	Updated Lambda: 0.55
Increasing Size --> Tablesize: 191	Updated Lambda: 0.52
Increasing Size --> Tablesize: 193	Updated Lambda: 0.52
Increasing Size --> Tablesize: 197	Updated Lambda: 0.51
Increasing Size --> Tablesize: 199	Updated Lambda: 0.5
Increasing Size --> Tablesize: 211	Updated Lambda: 0.47


Initializing hash table with linear probing...
Initializing hash table with quadratic probing...

Word List Size:  100
Table Size:      211
Lambda:          0.47

TESTS
Hash table (linear) words detected:    100/100
Hash table (quadratic) words detected: 100/100
Avg insert collisions (linear):    5.11
Avg insert collisions (quadratic): 1.43



***INTERACTIVE WORD LOOKUP***

Enter a word (or type quit to continue): quiet

	Looking for quiet via linear probing --> Found "quiet" after 3 collisions
	Looking for quiet via quadratic probing --> Found "quiet" after 2 collisions

Enter a word (or type quit to continue): bologna

	Looking for bologna via linear probing --> Found "bologna" with no collisions
	Looking for bologna via quadratic probing --> Found "bologna" with no collisions

Enter a word (or type quit to continue): brush

	Looking for brush via linear probing --> Found "brush" after 1 collisions
	Looking for brush via quadratic probing --> Found "brush" after 1 collisions

Enter a word (or type quit to continue): duck

	Looking for duck via linear probing --> Error: "duck" not found;
	Looking for duck via quadratic probing --> Error: "duck" not found;

Enter a word (or type quit to continue): quit



****************** 110 WORD HASH SETUP ******************

Adding 10 words...

Increasing Size --> Tablesize: 223	Updated Lambda: 0.45


Initializing hash table with linear probing...
Initializing hash table with quadratic probing...

Word List Size:  110
Table Size:      223
Lambda:          0.45

***TESTS***

Hash table (linear) words detected:    110/100
Hash table (quadratic) words detected: 110/100
Avg insert collisions (linear):    5.44
Avg insert collisions (quadratic): 1.45



***INTERACTIVE WORD LOOKUP***

Enter a word (or type quit to continue): owl

	Looking for owl via linear probing --> Found "owl" after 18 collisions
	Looking for owl via quadratic probing --> Found "owl" after 3 collisions

Enter a word (or type quit to continue): goat

	Looking for goat via linear probing --> Found "goat" after 6 collisions
	Looking for goat via quadratic probing --> Found "goat" after 2 collisions

Enter a word (or type quit to continue): clog

	Looking for clog via linear probing --> Found "clog" with no collisions
	Looking for clog via quadratic probing --> Found "clog" with no collisions

Enter a word (or type quit to continue): potato

	Looking for potato via linear probing --> Found "potato" with no collisions
	Looking for potato via quadratic probing --> Found "potato" with no collisions

Enter a word (or type quit to continue): ice

	Looking for ice via linear probing --> Error: "ice" not found;
	Looking for ice via quadratic probing --> Error: "ice" not found;

Enter a word (or type quit to continue): quit
BUILD SUCCESSFUL (total time: 33 seconds)
