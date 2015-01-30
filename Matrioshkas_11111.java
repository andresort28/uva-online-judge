package uva.accepted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Matrioshkas_11111 
{
	static StringTokenizer tokens;
	static LinkedList<Matrioshka> stack = new LinkedList<Matrioshka>();
	
	public static void main (String[] arg) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;	
		while (  (line= in.readLine()) != null )
		{
			tokens = new StringTokenizer(line);
			boolean error = false;
			while(tokens.hasMoreElements())
			{
				int n = Integer.valueOf(tokens.nextToken());
				if(n < 0)
				{
					Matrioshka matri = new Matrioshka(-n);
					stack.push(matri);
				}
				else
				{
					if(stack.isEmpty())
					{
						error = true;
						break;
					}
					else
					{
						if(stack.peek().getValue() == n && stack.peek().close())
						{
							Matrioshka matri = stack.poll();
							if(!stack.isEmpty())
								stack.peek().addCapacity(matri.getValue());							
						}
						else
						{
							error = true;
							break;
						}
					}
				}				
			}
			
			if(error || !stack.isEmpty())
				out.write(":-( Try again.\n");
			else
				out.write(":-) Matrioshka!\n");
			stack.clear();			
		}
		in.close();
		out.close();
		System.exit(0);
	}
	
	
	static class Matrioshka
	{
		int value  = 0;
		int sum = 0;
		public Matrioshka (int value)
		{
			this.value = value;
		}		
		
		public boolean close ()
		{
			if(sum < value)
				return true;
			return false;
		}	
		
		public int getValue ()
		{
			return value;
		}
		
		public int getSum ()
		{
			return sum;
		}
		
		public void addCapacity (int c)
		{
			sum += c;
		}
	}
	
	
}
