//Patrick Dayton
//3 MAR 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

package heapsort;


public class Heap{


/**
 *1. Write a program that would do heap sort - sort them in ascending order. (MAX HEAP)
a. make an array of at least 15 random numbers.
b. Make a heap of that array.
c. Sort the array using heap sort.
You will submit the readme file with information on what platform you used and how to compile it
You will submit the code file(s)
execution screen shot showing:
a. initial array of random numbers showing the index in the array and the number stored in that index
b. array after the heap has been made (same as before .. index and the number in that index)
c. sorted array.
 */


    public static void main(String args[]){

        //MAKE ARRAY OF 15 RANDOM INTEGERS
        System.out.println("\n\nPatrick Dayton");
        int[] array = {5, 78, 12, 41, -6, 0,  69, 30, 46, 86, 15, 3, 34, -40, 17};
        System.out.print("\n\nUNORDERED:  ");
        print(array);
        Heap h = new Heap();
        h.heapify(array);
        System.out.print("\n\nHEAPIFIED:  ");
        print(array);
        h.heapSort(array);
        System.out.println("\n");
        System.out.print("SORTED:     ");
        print(array);
        System.out.println("\n\n");
    }

    //METHOD FOR HEAPIFYING
    public void heapify(int arr[]){
        int len = arr.length;

        //FIRST WE HEAPIFY OUR ARRAY
        //Find the last parent node (6 when we have 15 nodes)
        for (int i = (len / 2) - 1; i >= 0; i--)
            heapifyHelper(arr, len, i);

    }

    //METHOD FOR HEAPSORT
    public void heapSort(int arr[]){

        //FIRST WE MUST HEAPIFY OUR DATA
        heapify(arr);
        //our largest value is now at arr[0]...woo!
        int len = arr.length;

        //ACTUAL SORTING
        for (int i=len-1; i>=0; i--)
        {
            //SWAP THE NEWLY FOUND LARGEST WITH LAST OF UNSORTED
            //This places it between our sorted and unserted sections
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //HEAPIFY THE UNSORTED BIT RECURSIVELY
            heapifyHelper(arr, i, 0);
        }
    }
    //HELPER METHOD FOR HEAPIFYING
    void heapifyHelper(int arr[], int len, int startingRoot){

        //START WITH ROOT OF SUBTREE
        //and initialize the indexes of your left and right nodes
        int newRoot = startingRoot;
        int left = (startingRoot*2) + 1;
        int right = (startingRoot*2) + 2;


        //DETERMINE IF A CHILD IS LARGER THAN STARTING ROOT
        //if nothing found, we are done.
        if (left < len && arr[left] > arr[newRoot]){ newRoot = left; }
        if (right < len && arr[right] > arr[newRoot]){ newRoot = right; }

        //IF A CHILD IS FOUND TO BE LARGER THAN STARTING ROOT
        if (startingRoot != newRoot)
        {
            //PERFORM SWAP
            int temp = arr[startingRoot];
            arr[startingRoot] = arr[newRoot];
            arr[newRoot] = temp;

            //CONTINUE HEAPIFYING THE SUBTREE RECURSIVELY
            heapifyHelper(arr, len, newRoot);
        }
    }

    //HELPER METHODS
    static int max(int arr[]){
        int max = -999999999;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+":"+arr[i]+"  ");
        }
    }

    static void printIndexes(int arr[]){
       for (int i = 0; i < arr.length; i++) {
            System.out.print(i+"  ");
        }
    }
}
