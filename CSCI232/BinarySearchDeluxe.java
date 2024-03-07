import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    
    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    // Iterate through array comparing indecies to key until key is matched literally lets just use compare method.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        for (int i = 0; i <a.length; i++){
            if (comparator.compare(a[i], key)  == 0){
                return i; //Return first occurrence of the key.
            }
        }
        return -1; // if we get to this point then no a[i] matches key so -1
           
    }

    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    // So exactly the same as the last but starting from the end of our data.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        for (int j = a.length -1; j >= 0; j-- ){
            if (comparator.compare(a[j], key) == 0){
                return j;
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
