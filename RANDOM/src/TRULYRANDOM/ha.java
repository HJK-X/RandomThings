package TRULYRANDOM;

import java.io.*;          // put tester in file into usaco not bin/src the
					          // folder with bin/src in it
import java.util.*;

public class ha
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("a.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("words3.txt")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int i=0;

		while (st.hasMoreTokens())
		{
			out.print("\""+st.nextToken()+"\",");
			st=new StringTokenizer(f.readLine());
			i++;
			if(i==100)
			{
				out.print("\n");
				i=0;
			}
		}

		// closing up
		f.close();
		out.close();
	}
}