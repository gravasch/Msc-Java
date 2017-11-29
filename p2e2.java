 /******************************************************************************
 *  Compilation:  javac edu.princeton.cs.algs4.p2e2.java
 *  Execution:    java edu.princeton.cs.algs4.p2e2 <k> <x> <in-p2e2.txt > out-p2e2.txt
 *  			e.g. java edu.princeton.cs.algs4.p2e2 5 27 <in-p2e2.txt > out-p2e21.txt
 *                   java edu.princeton.cs.algs4.p2e2 5 35 <in-p2e2.txt > out-p2e22.txt
 *  Dependencies: StdIn.java StdOut.java MaxPQ.java
 *  Data files:   in-p2e2.txt 
 *
******************************************************************************/

package edu.princeton.cs.algs4;

public class p2e2 {
	private MaxPQ<Integer> maxHeap;
    
    /**
     * creates an empty integer max heap
     */
    public p2e2() {
        maxHeap = new MaxPQ<Integer>();
    }
    
    /**
     * Adds a new key to this maxHeap.
     * @param  x the int key to add to this maxHeap
     */
    public void insert(int x) {
        maxHeap.insert(x);
    }
    
    /**
     * Returns the number of keys on this maxHeap.
     * @return the number of keys on this maxHeap
     */
    public int size()
    {
    	return maxHeap.size();
    }
    
    /**
	* 1st alternative way to print all keys in the maxheap
	* use the foreach notation to iterate over all of the keys in the maxHeap.
	*/
    public void show()
    {
    	for (int item : maxHeap)
    		StdOut.print(item+ " | ");
    	StdOut.println();
    }
    
    /**
     * 2nd alternative way to print all keys in the maxheap
	 * Returns all keys in the maxHeap as an {@code Iterable}.
     * To iterate over all of the keys in the maxHeap named {@code heap},
     * use the foreach notation: {@code for (Integer item : heap.keys())}.
     *
     * @return all keys in the symbol table maxHeap
     */
    public Iterable<Integer> keysMaxHeap()  {
        return maxHeap;
    }
    
    /**
     * Removes the kth greater elements from the maxHeap
     * and returns the kth one
     * @param k the number of greater elements to be removed
     * @return the kth greater element of the maxHeap
     */
    public int getKth(int k) {
        for (int i = 0; i < k - 1; i++) {
            maxHeap.delMax();
        }
        return maxHeap.delMax();
    }
    
    private String theKOrdinal(int k) {
        if (k == 1)      return "1st";
        else if (k == 2) return "2nd";
        else if (k == 3) return "3rd";        
                         return k + "th";
    }
    
    
    /**
	 * 
	 * @param args first argument is k, second argument is x (both integers)
	 * 
	 * For testing purposes you can insert from standard input any sequence of numbers,
	 * the program make it a maximum oriented binary heap (using MaxPQ.java)
	 */
	 
    public static void main(String[] args) {
    	// check the arguments
        if (args.length != 2) {
			StdOut.println("You must give k and x!");
			System.exit(0);
        }
        // parse the arguments
        int k = Integer.parseInt(args[0]);
        int x = Integer.parseInt(args[1]);
        
        p2e2 heap = new p2e2();
               
        while(!StdIn.isEmpty()) {
            int item = StdIn.readInt();
            heap.insert(item);
        }
        
        StdOut.println("The max binary heap is:");
        // use on of the 2 ways heap.show() or the next
        //heap.show();
        for (Integer item : heap.keysMaxHeap())
        	StdOut.print(item+ " | ");
        StdOut.println();
        
        if (k > heap.size()) // if k is out of bounds
        	StdOut.println("k must be between 1 and "+ heap.size());
        else {
        	if (heap.getKth(k) > x) 
            StdOut.println("Yes. The " + heap.theKOrdinal(k) + " largest item is greater than "+ x);
        	else 
        		StdOut.println("No. The " + heap.theKOrdinal(k) + " largest item isn't greater than "+ x); 
        }
    }
}
