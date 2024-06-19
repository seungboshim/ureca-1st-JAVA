public class ConstructorTest {
    public static void main(String[] args) {
        Abc a = new Abc(); // 메모리 할당 직후, 생성자 호출
        // 생성자는 어떠한 메소드보다도 먼저 호출된다~
        // -> su, my의 초기화된 값이 들어옴

        System.out.println(a.str);

        Abc a2 = new Abc("Java");

        System.out.println(a2.str);
    }
}
