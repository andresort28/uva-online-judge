package uva.accepted;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class Rank_the_Languages_10336 
{
	
	static char[][] matrix;
	static boolean[][] visited;
	static boolean exist = false;
	static ArrayList<Language> list = new ArrayList<Language>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(in.readLine());
		
		for (int i = 0; i < n; i++) 
		{
			String[] m = in.readLine().split(" ");
			int h = Integer.valueOf(m[0]);
			int w = Integer.valueOf(m[1]);
			
			matrix = new char[h][w];
			visited = new boolean[h][w];
			
			for (int j = 0; j < matrix.length; j++) 
			{
				Arrays.fill(visited[j], false);
				String line = in.readLine();
				for (int k = 0; k < matrix[j].length; k++) 
				{
					matrix[j][k] = line.charAt(k);
				}
			}
			
			//--------------------------------------------------------
			
			for (int j = 0; j < matrix.length; j++) 
			{
				for (int k = 0; k < matrix[j].length; k++) 
				{
					char c = matrix[j][k];
					if(!visited[j][k])
					{
						visited[j][k] = true;
						if(modifyMatrix(c, j, k))
						{
							Language l = exist(c);
							if(l != null)
								l.increase();
							else
								list.add(new Language(c+""));
						}
					}
				}
			}
			//Print
			Collections.sort(list);
			out.write("World #"+(i+1)+"\n");
			for(Language l : list)
			{
				out.write(l.getId()+": "+l.getNumber()+"\n");
			}
			list.clear();
		}
		in.close();
		out.close();
		System.exit(0);
	}
	
	static boolean modifyMatrix (char c, int i, int j)
	{
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;	
		
		
		if((i-1) >= 0 && matrix[i-1][j] == c && !visited[i-1][j])
		{
			visited[i-1][j] = true;
			up=true;
			modifyMatrix(c, i-1, j);
		}
		if((i+1) <= matrix.length-1  && matrix[i+1][j] == c && !visited[i+1][j])
		{
			visited[i+1][j] = true;
			down = true;
			modifyMatrix(c, i+1, j);			
		}
		if((j-1) >= 0   &&  matrix[i][j-1] == c && !visited[i][j-1])
		{
			visited[i][j-1] = true;
			left = true;
			modifyMatrix(c, i, j-1);
		}
		if((j+1) <= matrix[0].length-1  &&  matrix[i][j+1] == c && !visited[i][j+1])
		{
			visited[i][j+1] = true;
			right = true;
			modifyMatrix(c, i, j+1);		
		}
		
		
		//BASE CASE
		if(left || right || up || down)
			return true;
		return false;
	}
	
	static Language exist (char c)
	{
		for(Language l : list)
		{
			if(l.getId().equalsIgnoreCase(c+""))
				return l;
		}
		return null;
	}
	
	
	static class Language implements Comparable<Language>
	{
		String id;
		int n;
		
		public Language (String id)
		{
			this.id = id;
			this.n = 1;
		}
		
		public String getId () {
			return id;
		}
		
		public int getNumber ()	{
			return n;
		}
		
		public void increase () {
			n++;
		}
		
		@Override
		public int compareTo(Language l) 
		{
			if(this.n > l.getNumber())
				return -1;
			if(this.n < l.getNumber())
				return 1;
			return id.compareTo(l.getId());
		}
	}

}
