import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;		// for testing purposes

/**
 *	SortMethods - Sorts an ArrayList of Strings in ascending order.
 *
 *	Requires OpenFile class to compile.
 *	Requires file randomWords.txt to execute a test run.
 *
 *	@author	
 *	@since	
 */
public class SortMethods {
	
	/**
	 *	Merge Sort algorithm - in ascending order
	 *	@param arr		List of String objects to sort
	 */

	public void mergeSort(List<String> arr) {
		//array for merging the split arrays
        	String[] temp = new String[arr.size()];
        	split(0, arr.size() - 1, arr, temp);
		
    	}
	
	/**
	 *	Recursive mergeSort method.
	 *	@param arr		List of String objects to sort
	 *	@param first	first index of arr to sort
	 *	@param last		last index of arr to sort
	 */
	public void mergeSortRecurse(List<String> arr, int first, int last) {
		// insert your code here
	}
	
	private void merge
			  (int low, int mid, int high, List<String> arr, String[] temp) {
					//copy unsorted values into the temp. array
					for (int r = low; r <= high; r++) {
						temp[r] = arr.get(r);
			  }

			  int a = low;
        	  int b = mid + 1;
        	  int c = low;
		//Compare the values starting from low and mid + 1 because
		//these are the starts of two arrays that need to be merged.
		//Keep adding values while the indexes of the 
		//two arrays that have yet to be merged 
		//have not 'fallen off' their respective arrays.
        	while (a <= mid && b <= high) {
				//compare the values of the two arrays and 
				//add the smaller to arr increment the 
				//corresponding index and the compare the counter
            		if (temp[a].compareTo(temp[b]) <= 0) {
                		arr.set(c, temp[a]);
                		a++;
            		}
								else {

					        arr.set(c, temp[b]);
					        b++;
					      }

            	c++; //always increment the index
				     //after a value is added
        	}
			//Copy the rest of the left side
			//of the array into the target array.
       		while (a <= mid)    {
         			arr.set(c, temp[a]);
         			c++;
         			a++;
        	}
	
	}

	
	/**
	 *	Print an List of Strings to the screen
	 *	@param arr		the List of Strings
	 */
	public void printArray(List<String> arr) {
		if (arr.size() == 0) System.out.print("(");
		else System.out.printf("( %-15s", arr.get(0));
		for (int a = 1; a < arr.size(); a++) {
			if (a % 5 == 0) System.out.printf(",\n  %-15s", arr.get(a));
			else System.out.printf(", %-15s", arr.get(a));
		}
		System.out.println(" )");
	}
	
	/*************************************************************/
	/********************** Test program *************************/
	/*************************************************************/
	private final String FILE_NAME = "randomWords.txt";
	
	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}
	
		/**
	 *	The recursive method keeps spliting the
	 *  part of the array that will be sorted.
	 * 	After finding the middle index, it splits
	 *  the array in two at that index.
	 *	@param low		the first index of the array inside of arr
	 *  @param high   the last index of the array inside of arr
	 * 	@param arr		the original array of integers
	 * 	@param temp		the temporary array to be used for merging
	 */
	public void split(int low, int high, List<String> arr, String[] temp) {
		//if the index high is > or = low, then the array is sorted
        	if (low < high) {
            		//finds middle index
            		int mid = low + (high - low) / 2;
            		//split left side of array
            		split(low, mid, arr, temp);
            		//split right side of the array
            		split(mid + 1, high, arr, temp);
            		//merge arrays
            		merge(low, mid, high, arr, temp);
            		
            		//necessary:
            		//(int low, int mid, int high, List<String> arr, String[] temp)
		}
	}
	
	
	public void run() {
		List<String> arr = new ArrayList<String>();
		// Fill List with random words from file		
		fillArray(arr);
		
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
	}
	
	// Fill String array with words
	public void fillArray(List<String> arr) {
		Scanner inFile = OpenFile.openToRead(FILE_NAME);
		while (inFile.hasNext())
			arr.add(inFile.next());
		inFile.close();
	}
}