public class JumsuTest {
    public static void main(String[] args) {
        int jumsu = 85;
//        switch (jumsu) {
//            case 90:
//                System.out.println("A학점");
//            case 80:
//                System.out.println("B학점");
//            case 70:
//                System.out.println("C학점");
//            case 60:
//                System.out.println("D학점");
//            default:
//                System.out.println("F학점");
//        }
        if (jumsu >= 90) {
            System.out.println("A학점");
        } else if (jumsu >= 80) {
            System.out.println("B학점");
        } else if (jumsu >= 70) {
            System.out.println("C학점");
        } else if (jumsu >= 60) {
            System.out.println("D학점");
        } else {
            System.out.println("F학점");
        }
    }
}
