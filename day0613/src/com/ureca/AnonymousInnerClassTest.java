package com.ureca;

class A {
    void happy() {
        System.out.println("나는 행복합니다");
    }
}

class Child extends A
{//==> 클래스 시작괄호
    @Override
    public void happy() {
        System.out.println("행복찾기~!!");
    }
}//==> 클래스 끝괄호

interface Ureca{
    void good();
}

class My{
    public static void go(Ureca u) {
        u.good();
    }
}

class UrecaJunior implements Ureca {

    @Override
    public void good() {
        System.out.println("good");
    }
}

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
//        My.go(new Ureca()); // 인터페이스는 객체화 할 수 없음 !!
        My.go(new UrecaJunior()); // 자식 클래스 쓰기
        My.go(new Ureca() { // 자식 클래스 없이, 구현객체를 내부클래스로 정의
            @Override
            public void good() {
                System.out.println("goodgood");
            }
        });

        A a = new Child();
        A a1 = new Child() {
            public void happy() {
                System.out.println("자꾸 즐거워~~!!");
            }
        };
        a.happy();
        a1.happy();

    }
}