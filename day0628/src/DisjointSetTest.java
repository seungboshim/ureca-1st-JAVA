import java.util.Arrays;

public class DisjointSetTest {
    static int N;
    static int[] parents;

    static void make() { // 각 집합 생성
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            // [i]번지: 각 노드를 식별 / i값: 부모 인덱스 표현
        }
    }
    static int find(int a) { // 대표자 찾기
        if (parents[a] == a) { // 대표자 찾음
            return a;
        }
        return find(parents[a]);
    }
    static boolean union(int a, int b) { // 집합 합치기 (대표자 일치시키기)
        // 대표자 일치 : return false; (이미 같은 그룹이라 합칠 필요 없다)
        // 대표자 불일치 : return true; (대표자를 일치 시킴)

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot; // a그룹의 대표자를 b그룹의 대표자로 하겠음
        return true;
    }

    public static void main(String[] args) {
        N = 5;

        parents = new int[N];

        make();
        System.out.println(Arrays.toString(parents));

        System.out.println(union(0,1));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(1,2));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(3,4));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(0,2));
        System.out.println(Arrays.toString(parents));
        System.out.println(union(0,4));
        System.out.println(Arrays.toString(parents));
    }
}
