package org.example.이론;

import java.sql.*;

public class First {
    public static void main(String[] args) {
        /*  1. DB 접속 정보
            >> JDBC 프로토콜
                - jdbc:사용하는 DBMS://서버주소:포트번호(MySQL기본3306)/DB명

            jdbc:mysql://localhost:3006/k3_iot_jdbc  */
        final String URL = "jdbc:mysql://localhost:3306/k3_iot_jdbc";
        String user = "root";
        String password = "root"; // 본인 비밀번호로 변경

        Connection conn = null; // DB 연결 객체
        Statement stmt = null; // DB 실행 객체
        PreparedStatement pstmt = null; // 동적 DB 실행 객체
        ResultSet rs = null; // DB 결과 객체

        try {
            // 1. 드라이버 로딩
            // : JDBC 드라이버 클래스를 메모리에 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DB 연결
            // : 실제 MySQL DB에 접속 시도 (성공 시 Connection 객체를 반환)
            conn = DriverManager.getConnection(URL, user, password);
            System.out.println("DB 연결 성공");

            // === DB 데이터 CRUD === //

            // 1) DB 데이터 삽입(INSERT)
//            String sql = "INSERT INTO members (name, email) VALUES (?, ?)";
//            pstmt = conn.prepareStatement(sql); // 동적 데이터 값은 set 설정 함수로 지정
//
//            pstmt.setString(1, "조승승");
//            pstmt.setString(2, "qwe123@example.com");
//
//            int result = pstmt.executeUpdate(); // INSERT 실행 = 반환은 영향받은 행의 수
//            System.out.println(result + "명 회원이 추가됨");

            // 2) DB 데이터 조회(READ - 전체 조회)
            String sql = "SELECT * FROM members";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); // SELECT 실행 - 반환은 ResultSet 객체

            while (rs.next()) { // rs.next(): 다음 행 존재 여부 확인 boolean값 반환
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("id: " + id + "/ name: " + name + "/ email: " + email);
            }

        } catch (Exception e) {
            System.out.println("DB 와의 커넥션 중 예외 발생");
            e.getMessage(); // - 예외 발생 시 예외 메시지 + 호출 스택 정보 출력 (예외 발생지 출력)
        }
    }
}
