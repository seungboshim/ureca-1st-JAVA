package com.ureca;

import java.util.Arrays;
import java.util.Random;

public class LottoNumTest {
    static int[] lotto = new int[6];

    public static boolean isDuplicateNum(int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (lotto[index] == lotto[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Random r = new Random();
        System.out.println("⭐️⭐ 금주 행운의 로또번호 ⭐⭐");

        for (int no = 0; no <= 5; no++) {
            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = r.nextInt(45) + 1;
                if (isDuplicateNum(i)) i--;
            }
            Arrays.sort(lotto);
            System.out.print(no + "회: ");
            for (int i = 0; i < lotto.length; i++) {
                System.out.print(lotto[i]);
                if (i != lotto.length - 1) System.out.print(", ");
            }
            System.out.println();
        }


    }
}
