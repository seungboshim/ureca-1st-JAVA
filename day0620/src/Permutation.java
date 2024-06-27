import java.util.Arrays;

public class Permutation {

	static int N, totalCount; // N: 뽑을 숫자 갯수
	static int[] numbers = {3,5,7};
	static boolean[] selected; // 이미 뽑은 숫자의 인덱스 기록 -> 지우면 중복순열
	static int[] ans; // 뽑은 걸 집어넣는 배열, 이거 안쓰고 numbers에 swap을 써도 된다.
	
	public static void main(String[] args) {
		N = numbers.length; // 3P3
		ans = new int[N];
		selected = new boolean[N];
		go(0);
		System.out.println("===> "+totalCount);
	}

	private static void go(int count) {
		if(count == N) {
			totalCount++;
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				ans[count] = numbers[i];
				go(count+1);
				selected[i] = false;
			}
		}
	}
}