package uva.accepted;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;


public class Searching_Quickly_123 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		
		ArrayList<String> words = new ArrayList<String>();
		while(!line.equals("::"))
		{
			words.add(line.toLowerCase());			
			line = in.readLine();
		}
		ArrayList<Title> titles = new ArrayList<Title>();
		while(  (line=in.readLine()) != null )
		{
			line = line.toLowerCase();
			String[] array = line.split(" ");
			ArrayList<String> rest = new ArrayList<String>();
			for (int i = 0; i < array.length; i++) 
			{
				if(!words.contains(array[i]))
					rest.add(array[i]);
				else
					rest.add(null);
			}
			
			for (int i = 0; i < rest.size(); i++) 
			{
				String word = rest.get(i);
				if(word != null)
				{
					String text = "";
					for (int j = 0; j < array.length; j++) 
					{
						if(j>0)
							text += " ";
						String word2 = array[j];
						if(j != i)
							text += word2;
						else
							text += word.toUpperCase();						
					}
					titles.add(new Title(text, word.toUpperCase()));
				}
			}
		}
		Collections.sort(titles);
		for (Title t : titles)
		{
			out.write(t.getText()+"\n");
		}		
		in.close();
		out.close();
		System.exit(0);
	}
	
	static class Title implements Comparable<Title>
	{
		String text;
		String key;
		
		public Title (String text, String key)
		{
			this.text = text;
			this.key = key;
		}
		
		public String getText () {
			return text;
		}
		
		public String getKey ()	{
			return key;
		}
		
		@Override
		public int compareTo(Title t) 
		{
			return key.compareTo(t.getKey());
		}
	}

}
