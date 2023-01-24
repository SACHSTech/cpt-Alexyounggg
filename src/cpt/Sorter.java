package cpt;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorter {
    
    public int[] mergeSort(int[] reverseData)
    {
        int [] temp = new int[reverseData.length];
        
        mergeSortHelper(reverseData, 0, reverseData.length - 1, temp);

        return temp;
    }

    private static void mergeSortHelper(int[] arr, int from, int to, int[] temp)
    {
        // If the array length is greater than 1
        if(to - from >= 1)
        {
            int mid = (from + to) / 2;   // split the list in half
            mergeSortHelper(arr, from, mid, temp);  //mergesort the first half
            mergeSortHelper(arr, mid + 1, to, temp); // mergesort the second half
            merge(arr, from, mid, to, temp); //merge
         
        }
    }
   
    private static void merge(int[] arr, int from, int mid, int to, int[] temp)
    {
        int i = from;       // track left array position
        int j = mid + 1;    // track right array position
        int k = from;       // track temp position
       
        while(i <= mid && j <= to)
        {
            // If the element in the left subarray is less
            // than the element in the right subarray it
            // is next in the merged list
            if(arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
       
        // We may have missed elements from either list
        while(i <= mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }
       
        while(j <= to)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }
       
        // Copy over elements from temp to arr
        for(k = from; k <= to; k++)
        {
            arr[k] = temp[k];
        }
    }
 
 
    
        
        public static void main(String[] args) {
            ArrayData arrayDataTwo = new ArrayData();
            ArrayList<Players> no = arrayDataTwo.threePercent();

            int[] reverseData = new int [no.size()];

            for (int i = 0; i < no.size(); i++){
                reverseData[i] = no.get(i).getThreesMade();
            }

    
    
    
     
    }
}

