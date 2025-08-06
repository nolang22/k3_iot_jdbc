package org.example.dao;

import org.example.db.DBConnection;
import org.example.db.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
    public void addMember(Member newMember) throws SQLException {
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO members (name, email) VALUES (?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, newMember.getName());
        pstmt.setString(2, newMember.getEmail());

        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }
}
