public class Mission {
    static int[] su = {1, 2, 3, 4, 5, 65, 7};
    static int n = su.length;

    static void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(su[i]);
        }
    }

    static void printReverse() {
        for (int i = n-1; i >= 0; i--) {
            System.out.println(su[i]);
        }
    }

    static int[][] su2 = {{1}, {1,2}, {1,2,3}};
    static void printSu2() {
        for (int i = 0; i < su2.length; i++) {
            for (int j = 0; j < su2[i].length; j++) {
                System.out.println("su2[" + i + "][" + j + "]번지=" + su2[i][j]);
            }
        }
    }

    static int[] su3 = new int [7];
    static void copySu() {
        for (int i = 0; i < n; i++) {
            su3[i] = su[i];
        }
        su3[2] = 33;
        System.out.println("su3[2] = " + su3[2]);
        System.out.println("su[2] = " + su[2]);
    }

    static int[] suReverse = new int [7];
    static void swapSu() {
        for (int i = n - 1; i >= 0; i--) {
            suReverse[n - 1 - i] = su[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.println(suReverse[i]);
        }
    }

    static void printOddIdxSu() {
        for (int i = 1; i < n; i+=2) {
            System.out.println(su[i]);
        }
    }

    static void printOddSu() {
        for (int i = 0; i < n; i++) {
            if (su[i] % 2 != 0) {
                System.out.println(su[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("문제 1");
        printAll();

        System.out.println("문제 2");
        printReverse();

        System.out.println("문제 3");
        printSu2();

        System.out.println("문제 4");
        copySu();

        System.out.println("문제 5");
        swapSu();

        System.out.println("문제 6");
        printOddIdxSu();

        System.out.println("문제 7");
        printOddSu();
    }
}
