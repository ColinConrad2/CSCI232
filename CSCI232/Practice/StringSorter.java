import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;


public class StringSorter {
    //----------------------//
    public static void main(String[] args) {
        // Create String arry "e" by pulling in .txt file
        String [] e = In.readStrings(args[0]);
        // insert sort through "e"
        insertionSort(e);

        for (int i = 0; i <e.length; i++)
            StdOut.println(e[i]);

    }

    //insertionSort method modified to handle string comparison. DOES NOT SUPPORT INT.
    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n ; i++){
            String iPoint = arr[i];
            int j = i -1;
            // Compare lengths first, then compare strings if lengths are equal
            while (j >= 0 && (arr[j].length() > iPoint.length() || (arr[j].length() == iPoint.length() && arr[j].compareTo(iPoint) > 0))){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = iPoint;
        }
    }

}

// 1. Output to an excel file?
// 2. URL read to pull in website text?
// 3. INT/String sort capability with INT as High.`