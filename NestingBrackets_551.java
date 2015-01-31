package uva.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class NestingBrackets_551 
{
	
	static String[] brackets = {"(", "[", "{", "<", "(*", ")", "]", "}", ">", "*)" };

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		LinkedList<String> stack = new LinkedList<String>();

		String line = "";		
		int z = 0;
		while (  (line=in.readLine()) != null )
		{
			if(z>0)
				out.write("\n");
			
			int posError = -1;
			int length = line.length();
			int special = 0;
			
			for (int i = 0; i < length; i++) 
			{
				String c = line.charAt(i)+"";
				String c2 = "";
				if((i+1) < length )
					c2 = line.charAt(i+1)+""; 
				int pos = getPos(c+""+c2);
				
				//Por aqui voy
				
				
				if(pos == 4)
				{
					stack.push(brackets[pos]);
					special++;																
					i++;
				}
				else if(pos == 9)
				{					
					if(!stack.isEmpty() && stack.getFirst().equals(brackets[4]))
					{
						stack.pop();
						i++;
						special++;
					}
					else
					{
						posError = i-special+1;
						break;
					}
				}
				else
				{
					pos = getPos(c);
					if(pos>-1 && pos<5)
						stack.push(brackets[pos]);
					else if(pos>4 && pos<10)
					{
						if(!stack.isEmpty() && stack.getFirst().equals(brackets[pos-5]))
							stack.pop();
						else
						{
							posError = i-special+1;
							break;
						}
					}
					//Sino no me importa es un caracter
				}
				
			}
			if(posError == -1)
			{
				if(!stack.isEmpty())
					out.write("NO " + (length+1-special));
				else
					out.write("YES");
			}
			else
				out.write("NO " + posError);			
			stack.clear();			
			z++;
		}
		out.flush();
		in.close();
		out.close();
		System.exit(0);
	}
	
	static int getPos (String c)
	{
		for (int i = 0; i < brackets.length; i++) 
		{
			if(brackets[i].equalsIgnoreCase(c))
				return i;
		}
		return -1;
	}
}
