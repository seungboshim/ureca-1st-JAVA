package com.ureca;

import java.util.*;

class B {
    public void lottoPrint(List<Integer> v, int n) {
        System.out.print(n + "회: ");
        for (int i : v) {
            System.out.print(i + ", ");
        }
    }
}

public class LottoTest {
    static Random random = new Random();
    static List<Integer> list = new ArrayList<Integer>();
    static void pickRandomNumber() {
        for (int j = 0; j < 6; j++) {
            list.add(random.nextInt(1, 46));
        }
    }

    static void sortLotto() {
        Collections.sort(list);
    }

    static B b = new B();

    public static void main(String[] args) {
        System.out.println("⭐️⭐ 금주 행운의 로또번호 ⭐⭐");
        for (int i = 0; i < 5; i++) {
            pickRandomNumber();
            sortLotto();
            b.lottoPrint(list, i+1);
            list.clear();
            System.out.println();
        }
    }
}
