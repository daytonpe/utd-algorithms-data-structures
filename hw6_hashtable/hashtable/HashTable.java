/*
 * Patrick Dayton (pxd170130)
 * UTD CS5343 -- Gupta
 * Homework 6
 * Due 4/21/18
 */

package hashtable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class HashTable {


    /* perform the hash function */
    public static int hash(String key, int tableSize){

        /* hash function takes the ASCII sum and mods by table size */

        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            int letterValue = (int) key.charAt(i);
            sum+=letterValue;
        }

        return sum % tableSize;
    }


    /******* LINEAR PROBING FUNCTIONS **********/

    /* search hash table using linear probing */
    public static int findLinear(
        int tableSize,
        String word,
        boolean print,
        String[] hashTableLinear){

        if(print)
            System.out.print("\tLooking for "+ word +" via linear probing --> ");

        String current;

        int collisions = 0;
        int index;
        try{

            index = hash(word, tableSize);
            current = hashTableLinear[index];

            /* CASE 1: Found it */
            if(current.equals(word)){
                if (print)
                    System.out.println("Found \""+word+"\" with no collisions");
                return 0;
            }

            else{
                /* find the next empty spot to insert*/
                while(true){

                    /* CASE 2: Not found */
                    if(current == null){
                        if (print)
                            System.out.println("Error: \""+word+"\" not found");
                        return -1;
                    }

                    index++;
                    collisions++; //increment our collision count

                    current = hashTableLinear[index];

                    /* CASE 3: Collision */
                    if(current.equals(word)){
                        if (print)
                            System.out.println("Found \""+word+"\" after "+collisions+" collisions");
                        return collisions;
                    }
                }
            }

        } catch (NullPointerException e){
            if (print)
                System.out.println("Error: \""+word+"\" not found");
            return -1;
        }
    }

    /* seed the hash table via linear probing */
    public static void initLinear(
        int tableSize,
        String[] words,
        String[] hashTableLinear){

        System.out.println("Initializing hash table with linear probing...");
        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            int index = hash(key, tableSize);

            /* collision handling with linear probing */
            if (hashTableLinear[index] != null) {
                /* find the next empty spot to insert*/
                while(hashTableLinear[index] != null){
                    index++;
                }
            }

            /* insert into the hash table */
            hashTableLinear[index] = key;
        }
    }

    /* determine the avg number of collisions for inserting 'words' (in listed order) into hash table with linear probing */
    public static double avgLinear(String[] words, String[] hashTableLinear, int tableSize){
        double sum = 0;
        int count = hashTableLinear.length;
        int temp;

        for (int i = 0; i < count; i++) {
            temp = findLinear(tableSize, hashTableLinear[i], false, hashTableLinear);
            if (temp != -1) {
                sum+=temp;
            }
        }

        return sum/words.length;
    }


    /******* QUADRATIC PROBING FUNCTIONS **********/


    /* seed the hash table via quadratic probing */
    public static void initQuadratic(
        int tableSize,
        String[] words,
        String[] hashTableQuadratic){
        System.out.println("Initializing hash table with quadratic probing...");
        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            int index = hash(key, tableSize);

            /* collision handling with quadratic probing */
            if (hashTableQuadratic[index] != null) {
                /* find the next empty spot to insert*/
                int j = 1;
                while(hashTableQuadratic[index % tableSize] != null){
                    index = index + (j*j); // h + i^2
                    j++;
                }
            }

            /*insert into table*/
            hashTableQuadratic[index % tableSize] = key; //mod tableSize here so that it wraps

        }
    }

    /* search hash table using quadratic probing */
    public static int findQuadratic(
        int tableSize,
        String word,
        boolean print,
        String[] hashTableQuadratic){

        if(print)
            System.out.print("\tLooking for "+word +" via quadratic probing --> ");

        int collisions = 0;
        int index;
        String current;

        try{
          index = hash(word, tableSize);
          current = hashTableQuadratic[index];

            /* CASE 1: Found it */
            if(current.equals(word)){
                if (print)
                    System.out.println("Found \""+word+"\" with no collisions");
                return 0;
            }

            else{
                /* find the next empty spot to insert*/
                int j = 1;
                    while(hashTableQuadratic[index % tableSize] != null){

                        index = index + (j*j); // h + i^2
                        j++;
                        collisions++; //increment our collision count
                        current = hashTableQuadratic[index % tableSize];

                        /* CASE 3: Collision */
                        if(current.equals(word)){
                            if (print)
                                System.out.println("Found \""+word+"\" after "+collisions+" collisions");
                            return collisions;
                        }
                    }

                /* CASE 2: Not found */
                if (print)
                    System.out.println("Error: \""+word+"\" not found");
                return -1;
            }
        } catch (NullPointerException e){
            if (print)
                System.out.println("Error: \""+word+"\" not found");
            return -1;
        }
    }

    /* determine the avg number of collisions for inserting 'words' (in listed order) into hash table with quadratic probing */
    public static double avgQuadratic(String[] words, String[] hashTableQuadratic, int tableSize){
        double sum = 0;
        int count = hashTableQuadratic.length;
        int temp;

        for (int i = 0; i < count; i++) {
            temp = findQuadratic(tableSize, hashTableQuadratic[i], false, hashTableQuadratic);
            if (temp != -1) {
                sum+=temp;
            }
        }

        return sum/words.length;
    }

    static int nextPrime(int n)
    {
        BigInteger b = new BigInteger(String.valueOf(n));
        return Integer.parseInt(b.nextProbablePrime().toString());
    }

    /******* TESTING FUNCTIONS **********/


    /* count the number of words in the hash table to check hash table insert functions -- not null values */
    public static int wordCount(String[] hashTable){
        int wordCount = 0;

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null){
                wordCount++;
            }
        }

        return wordCount;
    }


    /******* MAIN FUNCTION **********/


    public static void main(String[] args) {
        System.out.println("\nPatrick Dayton (pxd170130)\nUTD CS5343 -- Gupta\nHomework 6: Hashing\n4/21/18\n\n");

        System.out.println("****************** 100 WORD HASH SETUP ******************\n");

        int tableSize = 53; // this prime table size gives us load factor of slightly less than .5

        /* words list */
        String[] words = {"medal", "care", "mix", "overall", "ready", "bologna", "purpose", "gesture", "justice", "begin", "pride", "husband", "command", "sword", "percent", "grimace", "mud", "belly", "office", "snuggle", "digital", "voter", "tired", "skin", "brush", "warning", "make", "which", "winter", "war", "general", "trial", "sustain", "tourist", "push", "noble", "faint", "draft", "despair", "defeat", "exploit", "cluster", "rubbish", "rare", "start", "stride", "blame", "hobby", "feign", "lodge", "cell", "shelf", "onion", "queen", "week", "bathtub", "line", "scheme", "brick", "prison", "budge", "quiet", "resign", "pudding", "request", "discuss", "urge", "spring", "tear", "twitch", "rub", "prey", "self", "house", "mild", "slam", "save", "scrape", "barb", "list", "paper", "frank", "design", "lot", "copy", "regard", "distant", "screw", "voice", "wrist", "gravity", "predict", "rally", "swop", "slab", "pass", "inquiry", "harass", "health", "penalty"};

        double lambda = (double)words.length / (double)tableSize;

        System.out.println("Initial Table Size:      " + tableSize);
        System.out.println("Initial Word List Size:  " + words.length);
        System.out.println("Initial Lambda:          " + (Math.round((lambda) * 100.0) / 100.0));
        System.out.println();


        /* increase table size if necessary */
        while(lambda > 0.5){
            /* increase the size of the table */
            tableSize = nextPrime(tableSize);
            lambda = (double)words.length / (double)tableSize;
            System.out.print("Increasing Size --> Tablesize: "+tableSize + "\t");
            System.out.println("Updated Lambda: " + (Math.round((lambda) * 100.0) / 100.0));
        }

        System.out.println("\n");


        String[] hashTableLinear = new String[tableSize];
        String[] hashTableQuadratic = new String[tableSize];


        initLinear(tableSize, words, hashTableLinear);
        initQuadratic(tableSize, words, hashTableQuadratic);

        System.out.println("\nWord List Size:  "+ words.length);
        System.out.println("Table Size:      "+ tableSize);
        System.out.println("Lambda:          "+ (Math.round((lambda) * 100.0) / 100.0));
        System.out.println("\nTESTS");
        System.out.println("Hash table (linear) words detected:    " + wordCount(hashTableLinear) +"/"+words.length);
        System.out.println("Hash table (quadratic) words detected: " + wordCount(hashTableQuadratic) +"/"+words.length);
        System.out.println("Avg insert collisions (linear):    " + avgLinear(words, hashTableLinear, tableSize));
        System.out.println("Avg insert collisions (quadratic): " + avgQuadratic(words, hashTableQuadratic, tableSize));
        System.out.println("\n");


        /****** INTERACTIVE WORD LOOKUP ******/
        System.out.println("\n***INTERACTIVE WORD LOOKUP***\n");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter a word (or type quit to continue): ");
            String word = sc.nextLine();
            if(word.equals("quit"))
                break;
            System.out.println("");
            findLinear(tableSize, word, true, hashTableLinear);
            findQuadratic(tableSize, word, true, hashTableQuadratic);
            System.out.println("");
        }



        /****** TABLE SIZE CHANGE ******/
        System.out.println("\n\n\n****************** 110 WORD HASH SETUP ******************\n");
        System.out.println("Adding 10 words...\n");

        /*creating our new word array*/
        String[] extraWords = {"chicken", "glass", "plant", "speaker", "potato", "windmill", "clog", "owl", "pigeon", "goat"};
        String[] allWords = new String[110];
        for (int i = 0; i < words.length; i++)
            allWords[i] = words[i];
        for (int i = 0; i < extraWords.length; i++)
            allWords[100+i] = extraWords[i];

        //System.out.println(Arrays.toString(allWords));

        lambda = (double)allWords.length / (double)tableSize;

        /* increase table size if necessary */
        while(lambda > 0.5){
            /* increase the size of the table */
            tableSize = nextPrime(tableSize);
            lambda = (double)words.length / (double)tableSize;
            System.out.print("Increasing Size --> Tablesize: "+tableSize + "\t");
            System.out.println("Updated Lambda: " + (Math.round((lambda) * 100.0) / 100.0));
        }

        System.out.println("\n");

        /* create new hash tables for increased size */
        String[] hashTableLinear2 = new String[tableSize];
        String[] hashTableQuadratic2 = new String[tableSize];

        initLinear(tableSize, allWords, hashTableLinear2);
        initQuadratic(tableSize, allWords, hashTableQuadratic2);

        System.out.println("\nWord List Size:  "+ allWords.length);
        System.out.println("Table Size:      "+ tableSize);
        System.out.println("Lambda:          "+ (Math.round((lambda) * 100.0) / 100.0));
        System.out.println("\n***TESTS***\n");
        System.out.println("Hash table (linear) words detected:    " + wordCount(hashTableLinear2) +"/"+words.length);
        System.out.println("Hash table (quadratic) words detected: " + wordCount(hashTableQuadratic2) +"/"+words.length);
        System.out.println("Avg insert collisions (linear):    " + avgLinear(words, hashTableLinear2, tableSize));
        System.out.println("Avg insert collisions (quadratic): " + avgQuadratic(words, hashTableQuadratic2, tableSize));
        System.out.println("\n");

        /****** INTERACTIVE WORD LOOKUP ******/
        System.out.println("\n***INTERACTIVE WORD LOOKUP***\n");
        while(true){
            System.out.print("Enter a word (or type quit to continue): ");
            String word = sc.nextLine();
            if(word.equals("quit"))
                break;
            System.out.println("");
            findLinear(tableSize, word, true, hashTableLinear2);
            findQuadratic(tableSize, word, true, hashTableQuadratic2);
            System.out.println("");
        }
    }

}
