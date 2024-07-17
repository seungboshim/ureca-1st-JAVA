public class Review2 {
    static class InnerClass {

    }

    public static void main(String[] args) {
        ureca:
        for (int i = 0; i < 10; i++) {
            good:
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k == 1) {
                        break; // 1번으로
                    } else if (k == 2) {
                        break good; // 2번으로
                    } else if (k == 3) {
                        break ureca; // 3번으로
                    }
                }
                // 1번
            }
            // 2번
        }
        // 3번
    }
}
