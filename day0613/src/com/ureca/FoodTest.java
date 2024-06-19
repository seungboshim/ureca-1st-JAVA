package com.ureca;

public class FoodTest {
    public static void main(String[] args) {
        MenuPan menu; // 연결객체
        menu = new HongKong(); // 구현객체(구현체)

        menu.짬뽕();
        menu.초밥();
    }
}
