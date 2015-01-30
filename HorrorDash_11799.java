package uva.accepted;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HorrorDash_11799 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) 
		{
			String[] line = in.readLine().split(" ");
			int n2 = Integer.parseInt(line[0]);
			int max = -1;
			for (int j = 1; j < n2+1; j++) 
			{
				int a = Integer.parseInt(line[j]);
				if( a > max)
					max = a;
			}
			if(max == -1)
				max = 0;
			list.add(max);
		}
		in.close();
		for (int i = 1; i < list.size()+1; i++)
		{
			System.out.println("Case " + i + ": " + list.get(i-1));
		}
		System.exit(0);
	}

}
