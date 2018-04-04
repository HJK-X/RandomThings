
package usaco;

import java.io.IOException;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.util.StringTokenizer;
// import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class pos
{
	int x;
	int y;

	public pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class multimoo
{
	public static int[][] map;
	public static boolean[][] visited;
	public static HashMap<Integer, ArrayList<Integer>> regionNexts = new HashMap<>();
	public static ArrayList<Integer> regionCounts = new ArrayList<>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		visited = new boolean[size][size];
		HashMap<Integer, Integer> ids = new HashMap<>();
		int count = 0;
		for (int i = 0; i < size; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < size; j++)
			{
				int id = Integer.parseInt(st.nextToken());
				if (ids.containsKey(id))
					map[i][j] = ids.get(id);
				else
				{
					ids.put(id, count);
					map[i][j] = count;
					count++;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (!visited[i][j])// put new hashmap for new region
					max = Math.max(max, ff(i, j));
		out.println(max);

		max = 0;
		for (int i = 0; i < regionNexts.size(); i++)
			max = Math.max(max, ff1(i, new boolean[regionNexts.size()]));
		out.println(max);
		out.close();
		f.close();
	}

	public static int ff1(int region, boolean[] visited)
	{
		int max = 0;
		visited[region] = true;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(region);// loop through regions next to region
		return max;

	}

	public static int ff(int x, int y)
	{
		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		LinkedList<pos> q = new LinkedList<>();
		q.add(new pos(x, y));
		visited[x][y] = true;
		int id = map[x][y];
		int count = 1;
		while (!q.isEmpty())
		{
			pos curr = q.poll();
			for (int i = 0; i < 4; i++)
				if (curr.x + dx[i] > -1 && curr.x + dx[i] < map.length && curr.y + dy[i] > -1
						&& curr.y + dy[i] < map.length && !visited[curr.x + dx[i]][curr.y + dy[i]])
					if (map[curr.x + dx[i]][curr.y + dy[i]] == id)
					{
						q.add(new pos(curr.x + dx[i], curr.y + dy[i]));
						count++;
						visited[curr.x + dx[i]][curr.y + dy[i]] = true;// regioncount+1
					}
					else
						regionNexts.get(id).add(new pos(curr.x + dx[i], curr.y + dy[i]));
		}
		return count;
	}
}