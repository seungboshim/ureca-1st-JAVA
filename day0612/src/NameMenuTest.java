import java.util.Scanner;

public class NameMenuTest {

    public static void main(String[] args) {
        //화면출력
        //사용자 데이터 입력
        //=> Scanner    BufferedReader

        Scanner scan = new Scanner(System.in);
        NameMenu menu = new NameMenu();

        int no;
        do {
            System.out.print("<이름메뉴>\r\n"
                    + "1.추가 2.검색 3.수정 4.삭제 5.종료\r\n"
                    + "번호입력 ==> ");
            no = scan.nextInt();

            System.out.println();
            switch (no) {
                case 1: {
                    System.out.print("이름입력: ");
                    String name = scan.next();
                    menu.create(name);
                }
                break;
                case 2:
                    String []names=menu.read();
                    System.out.println("#이름목록");
                    for(String name:names) {
                        if(name != null)
                            System.out.println(" "+name);
                    }
                    break;
                case 3:
                    System.out.print("기존 이름 입력: ");
                    String oldName = scan.next();
                    System.out.print("변경 이름 입력: ");
                    String newName = scan.next();

                    menu.update(oldName, newName);
                    break;
                case 4:
                    System.out.print("삭제 이름 입력: ");
                    String delName = scan.next();

                    menu.delete(delName);
            }

            System.out.println();
        }while(no!=5);  //(no<5)

        scan.close();//입력객체 반환
    }//main

}


