package com.ureca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        // 1. 제품군 선택 (Driver Loading)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 연결객체 생성
        String url = "jdbc:mysql://127.0.0.1:3306/ureca?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
        Connection conn = DriverManager.getConnection(url, "root", "qw85638563!@");

        System.out.println("DB연결 성공~~~");

        // 3. 실행객체 생성
        Statement stmt = conn.createStatement();

        /* stmt.executeUpdate("sql"); */
        // insert, update, delete 중 한개일때 사용하는 메소드
        // 결과값 : 추가/수정/삭제한 행의 갯수

        String sql = "insert into dept (deptno, dname, loc) values (50, 'IT', '서울')";
        int rowCnt = stmt.executeUpdate(sql);
        System.out.println("입력된 행의 갯수 >>> "+rowCnt);

        // 4. 결과집합 객체 생성
        sql = "select empno, ename, sal from emp where deptno = 20";
        // 인덱스 번호 :   1      2     3

        /* stmt.executeQuery("sql"); */
        // select일 때 사용
        // 결과값 : ResultSet, 조회한 결과(행열) 집합
        ResultSet rs = stmt.executeQuery(sql);

        // 4-1 행 데이터 얻기, rs.next()
        while (rs.next()) {
            // 4-2 행 안의 열 데이터 뽑아오기, rs.getString() rs.getInt() rs.getDate() <- 조회 인덱스, 컬럼명으로
            System.out.println("사원번호: " + rs.getInt(1));
            System.out.println("사원명: " + rs.getString(2)); // 조회 인덱스로
            System.out.println("급여: " + rs.getInt("sal")); // 컬럼명으로
            System.out.println("-------------------");
        }
    }
}
