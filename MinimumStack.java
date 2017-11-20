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
	private Stack<Item> elements;//� ����� ������
	private Stack<Item> mins;	//� ������� (min) ������	


	/*------------------------------ Constructor ---------------------------------*/
	public MinimumStack() 
	{
		elements = new Stack<Item>();
		mins = new Stack<Item>();
	}


	/*----------------------------------- push -----------------------------------*/
	public void push(Item item)
	{
		elements.push(item);//�� item ��������� ���� elements
		//������ �� ��������� ��� ������ �� �������� ��� ���� mins
		if (!mins.isEmpty())//��� � mins ��� ����� ����
		{
			Item temp = mins.peek();//������������ �� �������� �������� ��� mins ���� ��������� temp, ����� �� ������� ��� �� ������		
			if (item.compareTo((Item)temp) <= 0)//��� ���� �� ����������� item ����� ��������� � ��� ��� temp
				mins.push(item);//��������� ��� �� item ���� mins		
		}
		else//��� � mins ����� ����
		{
			mins.push(item);//�� item ��������� ���� mins (������ ����� �� �������� �� ����� ��� �� ���������)
		}
	}

	/*----------------------------------- pop -----------------------------------*/
	public Item pop()
	{
		if (!elements.isEmpty())//��� � elements ��� ����� �����
		{
			Item temp1 = elements.pop();//�������� �� �������� �������� ��� �� ������ elements ���� ��������� temp1
			Item temp2 = mins.peek();//������������� �� �������� �������� ��� mins ���� ��������� temp2, ����� �� �� �������� ��� �� ������
			//��� ���������� �� ��������� �� ����� ����� � mins. ������ � elements ��� ����� �����, � mins �� �������� ����������� ��� ��������

			if (temp1.compareTo(temp2)==0)//��� �� 2 �������� ����� ���
			{
				temp2 = mins.pop();
				return temp1;//������������ �� temp1 (� �� temp2 ������ ����� ���)
			}
			else//��� �� 2 �������� ��� ����� ���
			{
				return temp1;//������������ �� temp1
			}
		}
		else
			return null;//��� � elements ����� �����, ������������ null
	}

	/*----------------------------------- min -----------------------------------*/
	public Item min()
	{
		if (!mins.isEmpty())//��� � mins ��� ����� �����
			//������������ �� �������� �������� ��� mins, ����� �� �� ��������
			return mins.peek();

		return null;//��� � mins ����� �����, ������������ null
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
		MinimumStack<Integer> e1 = new MinimumStack<Integer>();//���������� ��� �� ���������� ��� ������������ Integer

		int choice;
		do //����� �� �����, ����� � ������� �� �������� ����� ��� �� ���������
		{
				
			do {
				showMenu();
				choice = StdIn.readInt();//��������� ��� ������� ��� ������
			} while (choice <1 || choice >4);
			 StdOut.println(choice);
			switch (choice)
			{
			case 1: 
				StdOut.print("Item to push:"); //������ �� ����������� ���� �������� ��� �� ���������
				e1.push(StdIn.readInt()); 
				StdOut.println();
				//���������� ������� ��� ��� ������ ��� ��������� ��� ������, ��� ��������� ���� ��������
				if (!e1.elements.isEmpty()) {
					StdOut.println("top of elements:" + e1.elements.peek());
					StdOut.println("top of mins:" + e1.mins.peek());
				}
				break;

			case 2: 				
				if (!e1.elements.isEmpty()) {
					StdOut.println("Poped item:" + e1.pop()); 
					//���������� ������� ��� ��� ������ ��� ��������� ��� ������, ��� ��������� ���� ��������
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
