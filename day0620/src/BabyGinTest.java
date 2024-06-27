import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BabyGinTest {
    static int N;
    static int[] numbers;
    static int[] ans;
    static boolean[] selected;

    static int ginCount = 0;
    static boolean flag = false;

    private static void checkBabyGin() {
        if (ans[0] == ans[1] && ans[1] == ans[2]) {
            ginCount++;
        }
        if (ans[3] == ans[4] && ans[4] == ans[5]) {
            ginCount++;
        }

        if (ans[0]+1 == ans[1] && ans[1]+1 == ans[2]) {
            ginCount++;
        }
        if (ans[3]+1 == ans[4] && ans[4]+1 == ans[5]) {
            ginCount++;
        }
    }

    private static void permutation(int depth) { // depth 개만큼 뽑았음
        if (depth == 6) {
            checkBabyGin(); // 6개 뽑으면 baby gin 체크
            if (ginCount == 2) { // 한번의 경우라도 조건 만족 시 flag = true
                flag = true;
            }
            ginCount = 0; // 초기화
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!selected[i]) {
                selected[i] = true;
                ans[depth] = numbers[i];
                permutation(depth + 1);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine(); // 개행문자 소비 해야함

        numbers = new int[6];
        ans = new int[6];
        selected = new boolean[6];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine(); // "667767"
            for (int j = 0; j < 6; j++) {
                numbers[j] = line.charAt(j) - '0'; // 배열에 저장함
            }

            permutation(0); // 순열 + Baby-Gin 체크

            if (flag) {
                System.out.println("Baby-Gin");
            } else {
                System.out.println("Not Baby-Gin");
            }
            flag = false;
        }
    }
}
