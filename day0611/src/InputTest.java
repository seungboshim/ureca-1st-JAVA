public class InputTest {
    public static void main(String[] args) throws Exception {
        System.out.print("한자리 수를 입력하세요: ");
        int su = System.in.read()-'0';

        System.in.read(); // 엔터키 처리 문장

        System.out.println("입력된 수=" + su);

        System.out.print("동일한 수를 다시 입력하세요: ");
        int su2 = System.in.read();
        System.out.println("아스키코드=" + su2);
    }
}
