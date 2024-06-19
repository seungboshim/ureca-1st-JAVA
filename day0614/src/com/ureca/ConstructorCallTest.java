package com.ureca;

class Parent {
    public Parent() {
        System.out.println("부모 기본생성자");
    }

    void good() {
        System.out.println("좋아요 :)");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("자식 기본생성자");
    }
}

public class ConstructorCallTest {
    public static void main(String[] args) {
        Child c = new Child(); // 부모도 할당함 -> 부모 기본생성자도 호출됨
        c.good(); // 부모의 메소드
    }
}
