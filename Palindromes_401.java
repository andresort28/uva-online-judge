package uva.accepted;


import java.util.Hashtable;
import java.util.Scanner;

public class Palindromes_401 
{	
	
	public final static Hashtable<Character, Character> table = new Hashtable<Character, Character>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		table.put('A', 'A');
		table.put('E', '3');
		table.put('H', 'H');
		table.put('I', 'I');
		table.put('J', 'L');
		table.put('L', 'J');
		table.put('M', 'M');
		table.put('O', 'O');
		table.put('S', '2');
		table.put('T', 'T');
		table.put('U', 'U');
		table.put('V', 'V');
		table.put('W', 'W');
		table.put('X', 'X');
		table.put('Y', 'Y');
		table.put('Z', '5');
		table.put('1', '1');
		table.put('2', 'S');
		table.put('3', 'E');
		table.put('5', 'Z');
		table.put('8', '8');
		
		
		Scanner in  = new Scanner(System.in);
		String line = "";
		while ( in.hasNext())
		{
			line = in.nextLine();
			boolean p = palindrome(line);
			boolean m = mirrored(line);				
			if(p)
			{
				if(m)
					System.out.println(line + " -- is a mirrored palindrome.");
				else
					System.out.println(line + " -- is a regular palindrome.");
			}
			else
			{
				if(m)
					System.out.println(line + " -- is a mirrored string.");
				else
					System.out.println(line + " -- is not a palindrome.");
			}
			System.out.println();
		}
		in.close();		
		System.exit(0);
	}
	
	
	
	static boolean palindrome (String msg)
	{
		int n = msg.length();
		String line1 = "";
		String line2 = "";
		if(n%2 == 0)
		{
			int a = n/2;
			line1 = msg.substring(0, a);			
			line2 = msg.substring(a);			
		}
		else
		{
			int a = (int)(n/2);
			line1 = msg.substring(0, a);
			line2 = msg.substring(a+1);
		}		
		StringBuilder builder = new StringBuilder(line1);
		builder.reverse();
		if( line2.equals(builder.toString()) )
			return true;
		else
			return false;
	}
	
	
	static boolean mirrored (String msg)
	{
		int n = msg.length();
		if(n%2 == 0)
		{
			int a = n/2;
			String line1 = msg.substring(0, a);
			StringBuilder builder = new StringBuilder(line1);
			builder.reverse();
			String line2 = msg.substring(a);
			return byChar(builder.toString(), line2);
		}
		else
		{
			int a = (int)(n/2);
			String line1 = msg.substring(0, a);
			StringBuilder builder = new StringBuilder(line1);
			builder.reverse();
			String line2 = msg.substring(a+1);
			if( byChar(builder.toString(), line2) && byChar(msg.charAt(a)+"", msg.charAt(a)+"") )
				return true;
			else
				return false;
		}
	}
	

	
	static boolean byChar (String line1, String line2)
	{
		for (int i = 0; i < line1.length(); i++) 
		{
			char c = line1.charAt(i);
			
			if(table.containsKey(c))
			{
				char c2 = line2.charAt(i);
				if(c2 != table.get(c))
					return false;
			}
			else
				return false;			
		}
		return true;
	}

}
