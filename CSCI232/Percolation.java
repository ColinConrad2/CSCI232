package CSCI232;/* *****************************************************************************
 *  Name:              Colin Conrad
 *  Last modified:     October 16, 1842
 **************************************************************************** */
//-----------------------------
//Imports ( Import all recommended)
//-----------------------------
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//-----------------------------

public class Percolation {
    private int N; // N = grid size
    private int[] grid; // 1D Array for grid. Kyle mentioned using 2D Array he had to flatted so lets just try 1D
    private int openSites; // Track number of open sites.
    private QuickFindUF qkuf; // QuickFind object
    public Percolation(int N)  {
        // create N-by-N grid, with all sites initially blocked
        if (N <= 0) {
            throw new IllegalArgumentException("Grid size must be greater than 0");
        }
        this.N = N;
        this.grid = new int[N * N]; // Size * Size like "Flattened 2D"
        this.openSites = 0;
        this.qkuf = new QuickFindUF(N * N); // Initialise with N*N elements

        //Set all sites to closed
        for (int i =0; i < N * N; i++){
            grid[i] = 0;
        }

    }
    public void open(int row, int col) {
        // open the site (row, col) if it is not open already
        int index = pullIndex(row, col);

        // If the site is already open get back to it ( should skip opens )
        if (isOpen(row, col)) {
            return;
        }

        // Open the site
        grid[index] = 1;
        openSites++;

        // Connect the site to its adjacent open sites
        theTrailThatWeBlaze(row, col);
    }
    //I need to connect all open sites into a path between nodes to actually check for percolation.
    //Pulling Index for reference then checking for open then union. This could work just need an index getter.
    private void theTrailThatWeBlaze(int row, int col) {
        int index = pullIndex(row, col);

        // Check adjacent sites and connect them if open
        if (row > 1 && isOpen(row - 1, col)) {
            qkuf.union(index, pullIndex(row - 1, col));
        }
        if (row < N && isOpen(row + 1, col)) {
            qkuf.union(index, pullIndex(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            qkuf.union(index, pullIndex(row, col - 1));
        }
        if (col < N && isOpen(row, col + 1)) {
            qkuf.union(index, pullIndex(row, col +1));
        }
        //Heeeeey it worked thanks el dorado
    }

    public boolean isOpen(int row, int col) {
        // is the site (row, col) open?
        // 1 is Open
        return grid[pullIndex(row, col)] == 1;
    }
    public boolean isFull(int row, int col) {
        // is the site (row, col) full?
        // If site is open and connected to top then full bc I assume that's where our water is coming from... or oil
        return isOpen(row, col) && qkuf.connected(pullIndex(row, col), 0);
    }
    public int numberOfOpenSites() {
        // number of open sites
        // If only I had had the foresight fo make some kind of variable to track this earlier... oh, wait.
        return openSites;
    }
    public boolean percolates() {
        // does the system percolate?
        // If top connected to bottom then yea.
        return qkuf.connected(0, N * N - 1);//Of course minus one you idiot god im so dumb
    }
    // Convert row and column indices to a 1D array index ( now im thinking flatten was better )
    private int pullIndex(int row, int col) {

        return (row - 1) * N + col - 1;
    }

    public static void main(String[] args) {
        // unit testing (suggested)
    }
}