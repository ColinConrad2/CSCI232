import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {


    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compr = comparator.compare(a[mid], key); // This will reduce the writing in my if statements
            if (compr < 0) {
                low = mid + 1;
            }
            else if (compr > 0) {
                high = mid - 1;
            }
            else {
                if ( mid == 0  || comparator.compare(a[mid - 1], key)!= 0){
                    return mid; // first occurrence
                }
                else {
                    high = mid -1; //Contiue search on other side
                }
            }
        }
        return -1;
    }



    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    // So exactly the same as the last but starting from the end of our data.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comparator.compare(a[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                if (mid == a.length - 1 || comparator.compare(a[mid + 1], key) != 0) {
                    return mid; // Found the last occurrence
                } else {
                    low = mid + 1; // Continue search in the right half.
                }
            }
        }
        return -1;
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
    
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);
        
        Term searchme = new Term("J",0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);
       
        searchme = new Term("E",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);
        
        searchme = new Term("T",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);        
    }
}
