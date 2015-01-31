package uva.accepted;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Simplifying_Fractions_10814 {

	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(in.readLine());
		
	
		for (int i = 0; i < n; i++) 
		{
			StringTokenizer tokens = new StringTokenizer(in.readLine());
			BigInteger p = new BigInteger(tokens.nextToken());
			tokens.nextToken();
			BigInteger q = new BigInteger(tokens.nextToken());
			boolean negative = false;
			if(q.signum() == -1)
				negative = true;
			q = q.abs();
			
			BigInteger a = new BigInteger("0");
			BigInteger b = new BigInteger("0");
			if(p.compareTo(q) == 1)
			{
				a = p;
				b = q;
			}
			else
			{
				a = q;
				b = p;
			}
			BigInteger r = new BigInteger("-1");
			while(r.intValue() != 0)
			{
				r = a.mod(b);
				a = b;
				b = r;
			}
			p = p.divide(a);
			q = q.divide(a);

			if(negative)
				out.write(p.toString()+" / -"+q.toString()+"\n");
			else
				out.write(p.toString()+" / "+q.toString()+"\n");

		}			
		in.close();
		out.close();
		System.exit(0);
	}

}
