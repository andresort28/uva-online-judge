package uva.accepted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Box_of_Bricks_591 
{

	
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokens;
		String line = in.readLine();
		
		int z = 1;
		while ( !line.equals("0") )
		{
			int n = Integer.valueOf(line);
			tokens = new StringTokenizer(in.readLine());
			int[] numbers = new int[n];
			
			int sum = 0;
			for (int i = 0; tokens.hasMoreElements(); i++) 
			{
				numbers[i] = Integer.valueOf(tokens.nextToken());
				sum += numbers[i];
			}
			int h = sum/n;
			
			int steps = 0;
			for (int i = 0; i < numbers.length; i++) 
			{
				if(numbers[i] > h)
					steps += numbers[i] - h;
			}
			out.write("Set #"+z+"\n");
			z++;
			out.write("The minimum number of moves is " + steps + "."+"\n");
			out.write("\n");
			line = in.readLine();
		}		
		in.close();
		out.close();
		System.exit(0);
	}

}
