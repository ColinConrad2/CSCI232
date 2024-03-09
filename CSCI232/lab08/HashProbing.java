package CSCI232;

import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class HashProbing {
    
    public static double avgCost(int N, Random random ) {
        int probes = 0;

        //Create a boolean array
        boolean[] boolArray = new boolean[2 * N];

        //Insert random keys using quadratic probing.
        for (int i = 0; i < N; i++) {
            int key = random.nextInt();
            int index = (key % (2 * N) + (2 * N)) % (2 * N);
            int offset = 1;

            // Handle collision
            while (boolArray[index]) {
                index = (index + offset * offset) % (2 * N);
                offset++;
            }
            boolArray[index] = true;
        }

        //
        for (int i = 0; i < 10000; i++){
            int key = random.nextInt();
            int index = (key % (2 * N ) + (2 * N)) % (2 * N);
            int offset = 1;
            int counter = 1; // set to one for initial probe

            // probe until empty cell is found
            while (boolArray[index] && counter < 2 * N){
                index = ( index + offset * offset) % (2 * N);
                offset ++;
                counter ++;
            }
            probes += counter;
        }
        return (double) probes / 10000;
    }




    public static void main(String[] args) {
        Random random = new Random();

        for (int N = 1000; N <=1000000; N*=10) {
            double mean = avgCost(N, random);

            //do all the things
            
            StdOut.println("Average probes for a miss with N="+N+" is: "+mean);
        }
    }
}