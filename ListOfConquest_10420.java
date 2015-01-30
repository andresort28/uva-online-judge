package uva.accepted;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;

public class ListOfConquest_10420 
{
	
	public static void main (String[] arg) throws Exception
	{
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < n; i++) 
		{
			String[] line = in.readLine().split(" ");
			String name = line[0];
			if( table.containsKey(name) )
			{
				int number = table.get(name);
				table.put(name, number + 1);
			}
			else
				table.put(name, 1);
		}
		in.close();
		
		Enumeration<String> e = table.keys();
		ArrayList<String> list = new ArrayList<String>();
		while(e.hasMoreElements())
		{
			list.add(e.nextElement());	
		}
		Collections.sort(list);
		for(String key: list)
		{
			System.out.println(key + " " + table.get(key));	
		}
		System.exit(0);
	}
	
	//10420
}
