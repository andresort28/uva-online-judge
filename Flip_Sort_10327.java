package uva.accepted;

import java.util.Scanner;

public class Flip_Sort_10327 {

	public static void main(String[] args)
	{			
		Scanner in = new Scanner(System.in);
		while ( in.hasNext() )
		{
			int n = in.nextInt();
			int[] array = new int[n];
			
			for (int i = 0; i < n; i++) 
			{
				array[i] = in.nextInt();
			}
			int i = sort(array);
			System.out.println("Minimum exchange operations : "+ i);
		}
		in.close();
		System.exit(0);
	}
	

	static int sort (int[] array)
	{
		int steps = 0; 
		for (int i = array.length; i > 0; i--)
		{
			for (int j = 0; j < i-1; j++) 
			{
				if(array[j]  > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					steps++;
				}
			}
		}
		return steps;
	}

}
