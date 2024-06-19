import java.util.LinkedList;
import java.util.Queue;

public class Candy {

    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<>(); // queue

        int no = 1; // 줄 서기 번호

        // 최초 데이터 삽입, queue.push()
        queue.offer(new int[] {no, 1}); // {사람 번호, 받을 캔디수}

        int[] person;
        int candyCnt = 20;
        int availableCnt = 0; // 나눠줄 캔디수

        while(candyCnt > 0) {
            if (!queue.isEmpty()) {
                person = queue.poll(); // queue.front(), 현재 캔디 받을 사람
                availableCnt = (candyCnt >= person[1]) ? person[1] : candyCnt; // 나눠줄 캔디
                // 해당 삼항 연산자에서 candyCnt가 음수로 가는 것을 방지
                // (마지막 사람의 받을 캔디 > 남은 캔디) 라면 남은 캔디만 주고 끝
                candyCnt -= availableCnt; // 남은 캔디 저장

                if (candyCnt == 0) { // 캔디가 다 떨어짐
                    System.out.println("마지막 캔디를 가져간 사람: " + person[0]);
                } else {
                    System.out.println(person[0] + "번 캔디 " + person[1] + "개 가져가요");
                    person[1]++;
                    queue.offer(person); // 받았으면 다시 줄서
                    queue.offer(new int[] {++no, 1}); // 다음 사람 들어와
                }
            }
        }
    }
}
