package code;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
	
	private static Queue<Cell> q = new LinkedList<>();
	private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, bot, left
	
	public static class Cell {
		public int dist;
		public int[] pos;
		
		public Cell(int dist, int[] pos) {
			this.dist = dist;
			this.pos = pos;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 0 is blocked, 1 is open.
		int[][] graph = {
				{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
		
		boolean[][] visited = new boolean[graph.length][graph[0].length];
		
		int[] origin = {0, 0};
		int[] target = {3, 4};
		int shortedPath = findShortedPath(graph, visited, origin, target);
		System.out.println(shortedPath);
	}
	
	public static int findShortedPath(int[][] g, boolean[][] v, int[] pos, int[] target) {
		
		q.offer(new Cell(0, pos));
		
		while (!q.isEmpty()) {
			Cell c = q.poll();
			System.out.println(Arrays.toString(c.pos));
			if (isTarget(c.pos, target)) {
				return c.dist;
			}
			
			v[c.pos[0]][c.pos[1]] = true;
			for (int[] dir : dirs) {
				int[] cand = {c.pos[0] + dir[0], c.pos[1] + dir[1]};
				if (isValid(g, v, cand)) {
					q.offer(new Cell(c.dist + 1, cand));
				}
			}
		}
		
		return -1;
	}
	
	public static boolean isTarget(int[] cand, int[] target) {
		return cand[0] == target[0] && cand[1] == target[1];
	}
	
	public static boolean isValid(int[][] graph, boolean[][] v, int[] pos) {
		int rs = graph.length;
		int cs = graph[0].length;
		
		int x = pos[0];
		int y = pos[1];
		
		// 1. check within grid
		if (x < 0 || x >= rs || y < 0 || y >= cs) return false;
		
		// 2. check not blocked. check not visited.
		if (graph[x][y] == 0|| v[x][y]) return false;
				
		return true;
	}

}
