package org.example.db.manager;

import org.example.dao.MemberDao;
import org.example.db.entity.Member;

import java.sql.SQLException;
import java.util.Scanner;

public class MemberManager {
    public void run() throws SQLException {
        Scanner sc = new Scanner(System.in);
        MemberDao memberDao = new MemberDao();

        while (true) {
            System.out.println("1. 사용자 정보 추가");
            System.out.println("2. 사용자 전체 조회");
            System.out.println("3. 사용자 단건 조회");
            System.out.println("4. 사용자 정보 수정");
            System.out.println("5. 사용자 정보 삭제");
            System.out.println("6. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요 >> ");

            String selectedMenu = sc.nextLine();

            switch (selectedMenu) {
                case "1" -> addMember(sc, memberDao);

                case "2" -> viewAllMenuMembers(memberDao);

                case "3" -> viewMemberById(sc, memberDao);

                case "4" -> updateMember(sc, memberDao);

                case "5" -> deleteMember(sc, memberDao);

                case "6" ->{
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }
    // 1. 사용자 추가
    private void addMember(Scanner sc, MemberDao dao) throws SQLException {
        System.out.print("새로운 사용자 이름 입력: ");
        String name = sc.nextLine();

        System.out.print("새로운 사용자 이메일 입력: ");
        String email = sc.nextLine();

        // cf) DB의 AUTO_INCREMENT 값으로 -1을 전달
        //      : 아직 DB에 저장되지 않음을 의미하는 값
        Member newMember = new Member(-1, name, email);
        dao.addMember(newMember);

        System.out.println("사용자가 성공적으로 추가되었습니다. ");
    }

    // 2. 사용자 전체 조회
    private void viewAllMenuMembers(MemberDao dao) throws SQLException {

    }

    // 3. 사용자 단건 조회
    private void viewMemberById(Scanner sc, MemberDao dao) throws SQLException {

    }

    // 4. 사용자 수정
    private void updateMember(Scanner sc, MemberDao dao) throws SQLException {

    }

    // 5. 사용자 삭제
    private void deleteMember(Scanner sc, MemberDao dao) throws SQLException {

    }

}
