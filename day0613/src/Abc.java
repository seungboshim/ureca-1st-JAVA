public class Abc {
    // 멤버 변수 선언
    int su; // su == 0;
    My my; // my == null;
    String str; // str == null

    // 생성자
    Abc() { // 파라미터가 없다면 기본생성자 : 초기화 메서드
        this("ureca"); // 다른 생성자 호출시 첫번째 문장에서 초기화
        // 여기서 초기화 시키기
        su = 1000; // su == 1000
        my = new My(); // my == @@@@(할당된 주소값)
    }

    // 생성자 오버로딩
//    Abc(String str) { // 멤버변수, 지역변수 이름이 같음
//        str = str; // Duplicate error 발생하지만, 서로 영역이 달라 허용함
//    }
    Abc(String str) {
        this.str = str; // 현재 클래스(Abc)를 가리키는 자기참조 변수 this
        // 매개변수(지역변수), 멤버변수(필드) 를 구분하기 위해 사용
    }

    void hello() {
        System.out.println("hello");
    }
}
