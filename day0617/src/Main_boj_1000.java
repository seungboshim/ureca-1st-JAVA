import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_boj_1000 {
    public static void main(String[] args) throws Exception {
        int A, B;
//        Scanner sc = new Scanner(System.in);
//        A = sc.nextInt();
//        B = sc.nextInt();
//        System.out.println(A+B);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer tokens = new StringTokenizer(str, " ");

        A = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());
        System.out.println(A+B);

        br.close();
    }
}