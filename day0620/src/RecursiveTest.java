

public class RecursiveTest {
    static int[] arr = {10, 20, 30};

    // 재귀함수 (자신의 메서드를 다시 호출)
    private static void recursive(int i) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i] + "\t");
        recursive(i+1);
    }

    public static void main(String[] args) {
        recursive(0);
    }
}
