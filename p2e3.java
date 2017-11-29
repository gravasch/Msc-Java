/******************************************************************************
 *  Compilation:  javac edu.princeton.cs.algs4.p2e3.java
 *  Execution:    java edu.princeton.cs.algs4.p2e3 < in-p2e3.txt > out-p2e3.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   in-p2e3.txt, in-p2e31.txt, in-p2e32.txt, 
 *
******************************************************************************/

package edu.princeton.cs.algs4;
import java.lang.Math;

public class p2e3 {
	// print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i <a.length; i++) {
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }

    /**
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] nums = StdIn.readAllInts();	
 /*       StdOut.println("nums");	
        show(nums);
*/
        int len=(int)(Math.ceil(((double)nums.length)/2));
        int[] A=new int[len];
        int[] B=new int[len];
/*      StdOut.println("A");
        show(A);
        StdOut.println("B");
        show(B);
*/
        int j=0;
        for (int i=0;i<nums.length-1;i=i+2)
        {
        	if (nums[i]<nums[i+1]) {
        		A[j]=nums[i];
        		B[j]=nums[i+1];
        	}
        	else {
        		B[j]=nums[i];
        		A[j]=nums[i+1];
        	}
        	j++;
        }
/*      StdOut.println("A");
        show(A);
        StdOut.println("B");
        show(B);
*/
        if (nums.length%2 !=0) {
        	A[j]=nums[nums.length-1];
        	B[j]=nums[nums.length-1];
        }

        StdOut.println("nums");	
        show(nums);
        StdOut.println("A");
        show(A);
        StdOut.println("B");
        show(B);
        int min=A[0];
        for (int i=0;i<len;i++)
        {
        	if (A[i]<min) min=A[i];
        }
        StdOut.println("min="+min);
        int max=B[0];
        for (int i=0;i<len;i++)
        {
        	if (B[i]>max) max=B[i];
        }
        StdOut.println("max="+max);
    }

}
