class A {
    public static void hello() {
        System.out.println("hello");
    }
}

public class MethodCallTest {
    static void good() {
        System.out.println("good");
    }
    public static void main(String[] args) {
        System.out.println("안녕, 유플러스~^0^");
        A.hello();
        good();
    }
}