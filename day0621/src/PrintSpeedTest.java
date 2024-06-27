import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class PrintSpeedTest {
    public static void main(String[] args) throws Exception {
//        long start = System.currentTimeMillis();
////        long start = System.nanoTime();
//        for (int i = 0; i < 1000000; i++) {
//            System.out.println("유레카~!!");
//        }
//        long end = System.currentTimeMillis();
////        long end = System.nanoTime();
//
//        System.out.println("출력시간: " + (end - start) + "ms");

        StringBuilder sb = new StringBuilder();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            sb.append("유레카~!!").append('\n');
        }
        System.out.println(sb.toString());
        long end2 = System.currentTimeMillis();
        System.out.println("출력시간: " + (end2 - start2) + "ms");
    }
}
