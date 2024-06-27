import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_boj_16926 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        int[][] Arr = new int[N+1][M+1];
        int[][] Arr2 = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int temp = sc.nextInt();
                Arr[i][j] = temp;
                Arr2[i][j] = temp;
            }
        }

        int cycle = Math.min(N/2, M/2);

        for (int i = 0; i < R; i++) {
            for (int j = 1; j <= cycle; j++) {
                for (int k = M-j+1; k > j; k--) { // 왼쪽: Arr2[1][3] = Arr[1][4] ~ Arr2[1][1] = Arr[1][2]
                    Arr2[j][k-1] = Arr[j][k];
                }
                for (int k = j+1; k <= N-j+1; k++) { // 아래로: Arr2[2][1] = Arr[1][1] ~ Arr2[4][1] = Arr[3][1]
                    Arr2[k][j] = Arr[k-1][j];
                }
                for (int k = j+1; k <= M-j+1; k++) { // 오른쪽: Arr2[4][2] = Arr[4][1] ~ Arr2[4][4] = Arr[4][3]
                    Arr2[M-j+1][k] = Arr[M-j+1][k-1];
                }
                for (int k = N-j+1; k > j; k--) { // 위로: Arr2[3][4] = Arr[4][4] ~ Arr2[1][4] = Arr[2][4]
                    Arr2[k-1][N-j] = Arr[k][N-j];
                }
            }
        }

//        int[] dx = {0, 0, -1, 1};
//        int[] dy = {1, -1, 0, 0};
//
//        int cx = 1, cy = 1;
//
//        for (int i = 0; i < R; i++) {
//            for (int j = 1; j <= cycle; j++) {
//                for (int k = 0; k < 4; k++) {
//                    int nx = cx + dx[k];
//                    int ny = cy + dy[k];
//                    if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
//
//                    } else continue;
//                }
//            }
//        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(Arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
