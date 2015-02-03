package uva.accepted;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Train_Swapping_299 {

	public static void main(String[] args) throws Exception
	{
		ArrayList<Integer> list= new ArrayList<Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) 
		{
			int n2 = Integer.parseInt(in.readLine());
			String array[] = new String[n2];
			String array2[] = in.readLine().split(" ");	
			n2 = array2.length < n2 ? array2.length : n2;
			for (int j = 0; j < n2; j++) 
			{
				array[j] = array2[j];
			}
			int swaps = sort(array);
			list.add(swaps);
		}
		print(list);
		in.close();
		System.exit(0);
	}
	
	
	static void print (ArrayList<Integer> list)
	{
		for(int i : list)
		{
			System.out.println("Optimal train swapping takes " + i + " swaps.");
		}
	}
	
	static int sort (String[] array)
	{
		int steps = 0; 
		for (int i = array.length; i > 0; i--)
		{
			for (int j = 0; j < i-1; j++) 
			{
				if(Integer.parseInt(array[j])  > Integer.parseInt(array[j+1]))
				{
					String temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					steps++;
				}
			}
		}
		return steps;
	}

}
