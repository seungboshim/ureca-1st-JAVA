import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // str = "0 1 0 0 1";

        // MARK: split 사용
        String[] strArr = str.split(" "); // strArr = {"0", "1", "0", "0", "1"};
        // split(regex) 호출 시 -> 정규식 조건검사, 추가 메소드 호출 -> 시간 소요

        int N=5;

        int[] arr = new int[N];
        for (int i = 0; i < strArr.length; i++) { // arr = {0, 1, 0, 0, 1};
            arr[i] = Integer.parseInt(strArr[i]); // String -> int로 ParseInt
        }

        System.out.println(Arrays.toString(arr));

        // MARK: StringTokenizer 사용
        StringTokenizer tokens = new StringTokenizer(str, " "); // tokens = [0, 1, 0, 0, 1];

        while(tokens.hasMoreTokens()) { // 토큰이 남아있을 때 까지
            System.out.println(tokens.nextToken());
        }
    }
}