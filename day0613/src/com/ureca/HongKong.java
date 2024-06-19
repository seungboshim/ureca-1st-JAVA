package com.ureca;

public class HongKong implements MenuPan{
    public void 짜장면() {
        System.out.println("짜장면짜장면");
    }

    @Override
    public void 짬뽕() {
        System.out.println("짱뽕");
        초밥();
    }

    @Override
    public void 볶음밥() {
        System.out.println("볶음볶음");
    }

    public void 초밥() {
        System.out.println("초밥오버라이딩");
    }
}
