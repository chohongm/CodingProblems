package code;
import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int R = matrix.length, C = matrix[0].length;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;
        
        int N = R * C;
        boolean[][] visited = new boolean[R][C];
        int r = 0, c = 0;
        for(int i = 0; i < N; i++) {
            res.add(matrix[r][c]);
            visited[r][c] = true;
            int cr = r + dr[dir], cc = c + dc[dir];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !visited[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                dir = (dir + 1) % 4;
                r = r + dr[dir];
                c = c + dc[dir];
            }
        }
        
        return res;
    }
}
