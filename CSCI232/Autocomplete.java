import java.util.Arrays;

public class Autocomplete {
    private final Term[] terms;
    public Autocomplete(Term[] terms) {
        //
        this.terms = terms;
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        Term prefixKey = new Term(prefix, 0);// worked in mun matches can use it here
        int firstIndexA = BinarySearchDeluxe.firstIndexOf(terms, prefixKey, Term.byPrefixOrder(prefix.length()));
        if (firstIndexA == -1) { // Have been told I should avoid naming things same even in other methods so firstIndexA
            return new Term[0];
        }
        int lastIndexA = BinarySearchDeluxe.lastIndexOf(terms,prefixKey, Term.byPrefixOrder(prefix.length()));
        int numberOfMatches = lastIndexA -firstIndexA +1;
        Term[] matches = Arrays.copyOfRange(terms, firstIndexA, firstIndexA +numberOfMatches);//Actual matches.
        Arrays.sort(matches, Term.byReverseWeightOrder()); // Sort the matching terms by weight.

        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term thePrefix = new Term(prefix, 0); // this will be my key for the Binary search

        // method to find the index of the first occurence of prefixTerm in the sorted array of terms.
        int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, thePrefix, Term.byPrefixOrder(prefix.length()));

        //Same but for last occurrence. Really glad there was instructions for how to call BinarySearch correct.
        int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, thePrefix, Term.byPrefixOrder(prefix.length()));
        // -1 being returned means prefix matches nothing.
        if (firstIndex == -1 || lastIndex == -1) {
            return 0; // No matches found
        }
        //Calculate the number of matches by subtracting the index of the first occurrence from the index of the last occurrence and then adding 1.
        return lastIndex - firstIndex + 1;
        //Fixed?
    }


    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
