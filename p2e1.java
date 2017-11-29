/******************************************************************************
 *  Compilation:  javac edu.princeton.cs.algs4.p2e2.java
 *  Execution:    java edu.princeton.cs.algs4.p2e2 > out-p2e1.txt
 *  Dependencies: StdIn.java StdOut.java StdIn.java Date.java Student.java Grade.java MergeX.java
 *  Data files:   
 *
******************************************************************************/

package edu.princeton.cs.algs4;

import java.util.Arrays;

public class p2e1 {

	public static void printTitle()
	{
		StdOut.println("Name            Section    Height   Grade         Date");
        StdOut.println("------------------------------------------------------");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create an array of student
		//Date(String date) date month/day/year
		Student alice = new Student("Alice", 2, new Date("9/12/2012"), 175.1,new Grade("A"));
		Student bob = new Student("Bob", 1, new Date("9/3/2010"), 167.1, new Grade("A"));
		Student carol = new Student("Carol", 2, new Date("9/8/2011"), 173.0, new Grade("B"));
		Student dave = new Student("Dave", 1, new Date("9/12/2009"), 190.00, new Grade("F"));
		Student eve = new Student("Eve", 2, new Date("9/21/2008"), 163.33,new Grade("C+"));
		Student frank = new Student("Frank", 3, new Date("8/4/2012"), 183.67,new Grade("A-"));
		Student grant = new Student("Grant", 1, new Date("7/14/2012"), 182.33, new Grade("C+"));
		Student helia = new Student("Helia", 3, new Date("9/3/2011"), 127.2,new Grade("A"));
		Student isaac = new Student("Isaac", 3, new Date("8/22/2010"), 183.67, new Grade("C-"));
		Student jen = new Student("Jen", 1, new Date("2/18/2012"), 175.2,new Grade("A"));
		Student kevin = new Student("Kevin", 1, new Date("2/15/2011"), 196.3,new Grade("A"));
		Student larry = new Student("Larry", 2, new Date("4/2/2011"), 200.00,new Grade("C"));
		Student dora = new Student("Dora", 2, new Date("9/13/2010"), 172.67,new Grade("B-"));
		Student[] students = { dora, larry, kevin, jen, isaac, grant, helia, frank,
				eve, dave, carol, bob, alice };

		// sort by name and print results
        StdOut.println("Sort by name");
        StdOut.println("------------");
        printTitle();
        Arrays.sort(students, Student.BY_NAME);
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();

		StdOut.println("Sort by name Descending");
        StdOut.println("-----------------------");
        printTitle();
        MergeX.sort(students, Student.NAME_DESC_ORDER);
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();

        // now, sort by section and print results
        StdOut.println("Sort by section");
        StdOut.println("---------------");
        printTitle();
        Arrays.sort(students, Student.BY_SECTION);
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();

		// now, sort by registration date and print results
        StdOut.println("Sort by registration date");
        StdOut.println("-------------------------");
        printTitle();
        MergeX.sort(students, Student.BY_DATE);
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();

        // now, sort by grade and print results
        StdOut.println("Sort by height");
        StdOut.println("--------------");
        printTitle();
        Arrays.sort(students, Student.BY_HEIGHT);
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
		
		 // now, sort by GPA and print results
        StdOut.println("Sort by grade");
        StdOut.println("-------------");
        printTitle();
        MergeX.sort(students, Student.BY_GRADE);
        for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
        StdOut.println();
        
        // now, sort by name relative to Dora! my name!
		StdOut.println("Sort by Dora -my name");
		StdOut.println("---------------------");
		printTitle();
		MergeX.sort(students, dora.RELATIVE_NAME_ORDER);
		for (int i = 0; i < students.length; i++)
            StdOut.println(students[i]);
		StdOut.println();
	}
}
