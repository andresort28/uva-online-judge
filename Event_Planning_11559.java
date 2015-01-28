package uva.accepted;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Event_Planning_11559 {
	
	
	public static void main (String[] arg) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		int p = 0;
		int b = 0;
		int h = 0;
		while (  (line = in.readLine())  != null )
		{
			String[] caso = line.split(" ");
			p = Integer.parseInt(caso[0]);
			b = Integer.parseInt(caso[1]);
			h = Integer.parseInt(caso[2]);
			
			int cost = 0;
			int total = 2147483647;			
			for (int i = 0; i < h; i++) 
			{
				cost = Integer.parseInt(in.readLine());
				String[] w = in.readLine().split(" ");
				for (int j = 0; j < w.length; j++) {
					if(Integer.parseInt(w[j]) >= p)
					{
						int s = cost*p;
						if(s < total)
							total = s;
					}
				}
			}
			if(total <= b)
				System.out.println(total);
			else
				System.out.println("stay home");
		}
		in.close();
		System.exit(0);
	}
	
	
}

