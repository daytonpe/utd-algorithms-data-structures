//Patrick Dayton
//1 FEB 2018
//UT-Dallas
//CS-5343
//Prof. Gupta

package aa_hw1_2;

public class TertiarySort {
    
    public static int tertiarySort(int[] arr, int left, int right, int searchVal){
          
        //set our division limits
        int lDiv = left + (right - left)/3;
        int rDiv = left + ((right - left)*2)/3;
        
        //debugging print statment
        //System.out.println(left+ " " + lDiv+ " "+rDiv+ " "+right);

        
        if (right>0){
            if (searchVal==arr[lDiv]){ //we've found with our left division index
                return lDiv; //return the index rather than the value
            }
            if (searchVal == arr[rDiv]){ //we've found it with our right division index
                return rDiv; //return the index rather than the value
            }
            if (searchVal>arr[lDiv]){ //left third
                return tertiarySort(arr, left, lDiv, searchVal);
            }
            if (searchVal<arr[lDiv] && searchVal>arr[rDiv]){ //middle third
                return tertiarySort(arr, lDiv+1, rDiv, searchVal);
            }
            if (searchVal<arr[rDiv] && searchVal>=arr[right-1]){ //right third
                return tertiarySort(arr, rDiv+1, right, searchVal);
            }   
        }

        return -1; //cannot find the value
    }
    
    public static void main(String[] args) {
        int arr[];

        arr = new int[]{100,96,87,81,70,69,65,60,45,34,29,17,9,  0,-14};

        int n = arr.length;
          
        //search for a value that exists in the list
        int searchVal = 29;
        int found = tertiarySort(arr, 0, n, searchVal);
        System.out.println("found "+ searchVal +" at index "+ found);
        
        //search for a value that DOES NOT exists in the list
        int searchVal2 = 64;
        int found2 = tertiarySort(arr, 0, n, searchVal2);
        System.out.println("Couldn't find  "+ searchVal2 +" so returning "+ found2);
        
        
    }
}
