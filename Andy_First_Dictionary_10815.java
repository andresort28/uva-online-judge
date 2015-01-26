package uva.accepted;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Andy_First_Dictionary_10815 {
	
	static TreeSet<String> list = new TreeSet<String>();

	public static void main(String[] args) throws Exception
	{		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;		
		StringTokenizer tokens;
		
		
		while (  (line= in.readLine()) != null )
		{
			tokens = new StringTokenizer(line);
			while(tokens.hasMoreElements())
			{
				check(tokens.nextToken().toLowerCase());
			}
		}
		for(String i : list)
		{
			out.write(i+"\n");
		}		
		in.close();
		out.close();
		System.exit(0);
	}
	
	static void check (String word)
	{
		String l = "";
		for (int i = 0; i < word.length(); i++) 
		{
			char c = word.charAt(i);
			int n = (int)c;
			if((n >= 97 && n <= 122))
				l += c+"";
			else
			{
				if(!l.equals(""))
					list.add(l);
				l="";
			}				
		}
		if(!l.equals(""))
			list.add(l);
	}

}
