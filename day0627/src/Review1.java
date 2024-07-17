

class A {
    void helloA() {
        System.out.println("helloA");
    }
}

class B {
    static void helloB() {
        System.out.println("helloB");
    }
}

public class Review1 {
    public static void main(String[] args) {
        A a = new A();
        a.helloA();
        int su1 = 10;
        int su2 = 10;

        System.out.println(su1++); // 10
        System.out.println(++su2); // 11
    }
}

