/******************************************************************************
 *  Compilation:  javac edu.princeton.cs.algs4.MinimumStack.java
 *  Execution:    java edu.princeton.cs.algs4.MinimumStack < in-p1e1.txt > out-p1e1.txt
 *  Dependencies: StdIn.java StdOut.java Stack.java
 *  Data files:   in-p1e1.txt
 *
 ******************************************************************************/

package edu.princeton.cs.algs4;

public class MinimumStack<Item extends Comparable<Item>>
{
	private Stack<Item> elements;//Η πρώτη στοίβα
	private Stack<Item> mins;	//Η δεύτερη (min) στοίβα	


	/*------------------------------ Constructor ---------------------------------*/
	public MinimumStack() 
	{
		elements = new Stack<Item>();
		mins = new Stack<Item>();
	}


	/*----------------------------------- push -----------------------------------*/
	public void push(Item item)
	{
		elements.push(item);//Το item εισάγεται στην elements
		//Πρέπει να ελέγξουμε εάν πρέπει να εισαχθεί και στην mins
		if (!mins.isEmpty())//Εάν η mins δεν είναι κενή
		{
			Item temp = mins.peek();//Αποθηκεύουμε το κορυφαίο στοιχείο της mins στην μεταβλητή temp, χωρίς να εξαχθεί από τη στοίβα		
			if (item.compareTo((Item)temp) <= 0)//Εάν αυτό το εισερχόμενο item είναι μικρότερο ή ίσο του temp
				mins.push(item);//Εισάγουμε και το item στην mins		
		}
		else//Εάν η mins είναι κενή
		{
			mins.push(item);//Το item εισάγεται στην mins (εφόσον είναι το μοναδικό θα είναι και το μικρότερο)
		}
	}

	/*----------------------------------- pop -----------------------------------*/
	public Item pop()
	{
		if (!elements.isEmpty())//Εάν η elements δεν είναι άδεια
		{
			Item temp1 = elements.pop();//Εξάγουμε το κορυφαίο στοιχείο από τη στοίβα elements στην μεταβλητή temp1
			Item temp2 = mins.peek();//αποθηκεύσουμε το κορυφαίο στοιχείο της mins στην μεταβλητή temp2, χωρίς να το εξάγουμε από τη στοίβα
			//Δεν χρειάζεται να ελέγξουμε αν είναι άδεια η mins. Εφόσον η elements δεν είναι άδεια, η mins θα περιέχει τουλάχιστον ένα στοιχείο

			if (temp1.compareTo(temp2)==0)//Εάν τα 2 στοιχεία είναι ίσα
			{
				temp2 = mins.pop();
				return temp1;//Επιστρέφουμε το temp1 (ή το temp2 εφόσον είναι ίσα)
			}
			else//Εάν τα 2 στοιχεία δεν είναι ίσα
			{
				return temp1;//Επιστρέφουμε το temp1
			}
		}
		else
			return null;//Εάν η elements είναι άδεια, επιστρέφεται null
	}

	/*----------------------------------- min -----------------------------------*/
	public Item min()
	{
		if (!mins.isEmpty())//Εάν η mins δεν είναι άδεια
			//Επιστρέφουμε το κορυφαίο στοιχείο της mins, χωρίς να το εξάγουμε
			return mins.peek();

		return null;//Εάν η mins είναι άδεια, επιστρέφεται null
	}

	public static void showMenu()
	{
		StdOut.println("Menu");
		StdOut.println("1 - Push an item");
		StdOut.println("2 - Pop an item");
		StdOut.println("3 - Get the Minimum item");
		StdOut.println("4 - Exit");
		StdOut.print("Choice:");
	}
	

	/*------------------------ MAIN -------------------------------*/
	public static void main(String[] args) 
	{
		MinimumStack<Integer> e1 = new MinimumStack<Integer>();//Υποθέτουμε για το παράδειγμα ότι χρειαζόμαστε Integer

		int choice;
		do //Δείξε το μενού, μέχρι ο χρήστης να επιλέξει έξοδο από το πρόγραμμα
		{
				
			do {
				showMenu();
				choice = StdIn.readInt();//Παίρνουμε την επιλογή του χρήστη
			} while (choice <1 || choice >4);
			 StdOut.println(choice);
			switch (choice)
			{
			case 1: 
				StdOut.print("Item to push:"); //Ζητάμε το αντικείμενο προς εισαγωγή και το εισάγουμε
				e1.push(StdIn.readInt()); 
				StdOut.println();
				//βοηθητικές εντολές για τον έλεγχο της εκτέλεσης του κώδικα, δεν ζητούνταν στην εκφώνηση
				if (!e1.elements.isEmpty()) {
					StdOut.println("top of elements:" + e1.elements.peek());
					StdOut.println("top of mins:" + e1.mins.peek());
				}
				break;

			case 2: 				
				if (!e1.elements.isEmpty()) {
					StdOut.println("Poped item:" + e1.pop()); 
					//βοηθητικές εντολές για τον έλεγχο της εκτέλεσης του κώδικα, δεν ζητούνταν στην εκφώνηση
					if (!e1.elements.isEmpty()) {
						StdOut.println("top of elements:" + e1.elements.peek());
						StdOut.println("top of mins:" + e1.mins.peek());
					}
				}
				else 
						StdOut.println("Minimum Stack is empty!");		
				break;

			case 3: 
					if (!e1.elements.isEmpty()) 
						StdOut.println("Minimum item:" + e1.min()); 
					else 
						StdOut.println("Minimum Stack is empty!");
				break;

			case 4: 
				StdOut.println("Exit") ;
				break;

			default:
				break;
			}
		}while (choice!=4);
	}
}
