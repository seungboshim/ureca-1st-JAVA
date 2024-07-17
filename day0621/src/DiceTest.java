import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

    static int N, numbers[]; //N: 주사위 던지는 수, numbers: 던져진 주사위 수들
    static boolean[] isSelected;

    public static void main(String[] args) throws Exception{

        // 입력으로 주사위 던지는 횟수, 주사위 던지기 모드(1,2,3,4)
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 주사위 던지는 횟수 (0<N<7)
        int M = sc.nextInt(); // 주사위던지기 모드
        numbers = new int[N];

        switch(M) {
            case 1:{ //중복순열
                dice1(0);
            } break;
            case 2:{
                isSelected = new boolean[7];
                dice2(0);
            } break;
            case 3: {
                isSelected = new boolean[7];
                dice3(0, 1);
                break;
            }
            case 4: //dice4(); break;
        }

        sc.close();
    }//main

    // 중복순열
    private static void dice1(int depth) {
        //끝마칠 조건(수의 조합이 끝났어요!!)
        if(depth==N) { //원하는 만큼 주사위를 던졌다면 => 숫자 조합이 완성 되었다면
            System.out.println(Arrays.toString(numbers));
            return;
        }
        //==========================
        //공통적인 반복문
        for(int i=1; i<=6; i++) {	//무엇(무슨데이터)을 뽑을 건데? 주사위 눈!
//		   순열/조합저장변수 = 데이터
            numbers[depth] =  i ;
            dice1(depth+1);
        }

    }//dice1

    // 순열
    private static void dice2(int depth) {
        if(depth==N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=1; i<=6; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                numbers[depth] = i;
                dice2(depth + 1);
                isSelected[i] = false;
            }
        }
    }

    // 조합
//    private static void dice3(int depth, int start) {
//        if(depth==N) {
//            System.out.println(Arrays.toString(numbers));
//            return;
//        }
//        for(int i=start; i<=6; i++) {
//            if (!isSelected[i]) {
//                isSelected[i] = true;
//                numbers[depth] = i;
//                dice3(depth + 1, i);
//                isSelected[i] = false;
//            }
//        }
//    }

    // 중복조합
    private static void dice3(int depth, int start) {
        if(depth==N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=start; i<=6; i++) {
            numbers[depth] = i;
            dice3(depth+1, i);
        }
    }

}