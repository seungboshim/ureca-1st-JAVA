import java.util.*;

class B {
    public void lottoPrint(ArrayList<Integer> v, int n) {
        System.out.print(n + "회: ");
        for (int i : v) {
            System.out.print(i + ", ");
        }
    }
}

public class LottoTest {
    static Random random = new Random();
    static HashSet<Integer> lottoSet = new HashSet<Integer>();

    static void pickRandomNumber() {
        while(lottoSet.size() < 6) {
            lottoSet.add(random.nextInt(1, 46));
        }
    }

    static ArrayList<Integer> sortLotto() {
        // HashSet 정렬법: List 화 하여 sort() 사용
        ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
        Collections.sort(lottoList);
        lottoSet.clear(); // clear 필요함
        return lottoList;
    }

    static B b = new B();

    public static void main(String[] args) {

        System.out.println("⭐️⭐ 금주 행운의 로또번호 ⭐⭐");
        for (int i = 0; i < 5; i++) {
            pickRandomNumber();
            ArrayList<Integer> list = new ArrayList<>(sortLotto());
            b.lottoPrint(list, i+1);
            list.clear();
            System.out.println();
        }
    }
}
