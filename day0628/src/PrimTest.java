import java.util.Arrays;
import java.util.Scanner;

public class PrimTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];

        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N]; // 각 정점에 도달하는 최소 가중치

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int minVertex, min, result = 0;
        minEdge[0] = 0;
        for (int c = 0; c < N; c++) {

        }

        sc.close();
    }
}
