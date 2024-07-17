import java.util.Arrays;
import java.util.Scanner;

public class KruskalTest {
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) { // 오름차순
            return this.weight - o.weight;
        }
    }

    static int V;
    static int E;
    static int[] parents;
    static Edge[] edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt(); // 정점수
        E = sc.nextInt(); // 간선수

        parents = new int[V];
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        // 각 노드의 집합 만들기
        make();
        // 최소 신장 트리의 가중치 합 구하기
        Arrays.sort(edgeList);
        int sum = 0;
        int cnt = 0;
        for (Edge edge : edgeList) {
            if (union(edge.start, edge.end)){ // 사이클이 발생하지 않는다면
                sum += edge.weight;
                if (++cnt == V - 1) break;
            }
        }

        System.out.println(sum);
        sc.close();
    }

    static void make() {
        for (int i = 0; i < V; i++) {
            parents[i] = i;
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
}
