import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		st = new StringTokenizer(in.readLine().trim());
		int start = Integer.parseInt(st.nextToken());;
		int end =  Integer.parseInt(st.nextToken());; //도착점 인덱스
		final int INF = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		
		for(int i=0; i<V; ++i){
			st = new StringTokenizer(in.readLine().trim(), " ");
			for(int j=0; j<V; ++j){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		int min=0, current=0;
		for(int i=0; i<V; ++i){
			//1단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			
			current = -1;
			min = INF;
			for(int j=0; j<V; ++j){
				if(!visited[j] && distance[j] < min){
					min = distance[j];
					current = j;
				}
			}
			if(current == -1) break;
			
			visited[current] = true; // 선택 정점 방문 처리
			if(current == end) break; // 선택 정점이 도착정점이면 탈출.
			
			//2단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=0; c<V; ++c){
				if(!visited[c] && matrix[current][c] != 0
						&&  distance[c] > min+matrix[current][c]){
					distance[c] = min+matrix[current][c];
				}
			}
		}
		System.out.println(distance[end] != INF ? distance[end] : -1);
		
	}

}