import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_boj_12891 {
    static int[] minOccurs; // A, C, G, T 의 최소 필요 갯수

    public static void main(String[] args) throws Exception {
        minOccurs = new int[4];
        //System.setIn(new FileInputStream("input.txt")); // Exception 던져야함
        Scanner sc = new Scanner(System.in);

        int strLength = sc.nextInt(); // 문자열 길이 S
        int partLength = sc.nextInt(); // 부분문자열 길이 P
        int answer = 0;

        String dnaStr = sc.next(); // DNA 문자열

        for (int i = 0; i < 4; i++) {
            minOccurs[i] = sc.nextInt();
        }

        // Key: A/C/G/T, Value: 윈도우 너비 내 출현 카운트
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        for (int i = 0; i < partLength; i++) {
            map.put(dnaStr.charAt(i), map.get(dnaStr.charAt(i)) + 1);
        }

        // sliding window
        for (int i = 1; i + partLength <= strLength; i++) {
            char delKey = dnaStr.charAt(i - 1); // window 에서 제거
            char addKey = dnaStr.charAt(i - 1 + partLength); // window 에서 추가

            map.put(delKey, map.get(delKey) - 1); // 제거한 window 의 문자 카운트 -1
            map.put(addKey, map.get(addKey) + 1); // 추가할 window 의 문자 카운트 +1

            if (check(map)) {
                answer++;
            }
        }

        System.out.print(answer);

        sc.close();
    }

    /** 각 알파벳 갯수가 min 이상인지 check */
    static boolean check(Map<Character, Integer> map) {
        for (Character key : map.keySet()) {
            if (key == 'A') {
                if (map.get(key) < minOccurs[0]) return false;
            } else if (key == 'C') {
                if (map.get(key) < minOccurs[1]) return false;
            } else if (key == 'G') {
                if (map.get(key) < minOccurs[2]) return false;
            } else if (key == 'T') {
                if (map.get(key) < minOccurs[3]) return false;
            }
        }
        return true;
    }
}
