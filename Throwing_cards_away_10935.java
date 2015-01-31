package uva.accepted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;


public class Throwing_cards_away_10935 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = in.readLine();
		
		while (!line.equals("0"))
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			LinkedList<Integer> cards = new LinkedList<Integer>();
			
			for (int i = 1; i < Integer.parseInt(line) + 1; i++) 
			{
				cards.add(i);
			}			
			
			while(true)
			{
				if(cards.size() == 1)
					break;
				else if(cards.size() == 2)
				{
					list.add(cards.removeFirst());
					break;
				}
				else
				{
					list.add(cards.removeFirst());
					int n = cards.removeFirst();
					cards.add(n);
				}
			}
			String t = "";
			int z = 0;
			for (Integer i : list)
			{
				if(z > 0)
					t += ", ";
				t += i+"";
				z++;
			}
			if(list.isEmpty())
				out.write("Discarded cards:" + t + "\n");
			else
				out.write("Discarded cards: " + t + "\n");
			out.write("Remaining card: " + cards.getFirst()+ "\n");			
			line = in.readLine();
		}
		in.close();
		out.close();
		System.exit(0);
	}

}
