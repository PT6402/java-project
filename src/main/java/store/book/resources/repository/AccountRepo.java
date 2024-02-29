package store.book.resources.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import store.book.resources.model.Account;
import store.book.resources.service.IAccount;
import store.book.resources.util.DbContext;

public class AccountRepo implements IAccount {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public Account CheckAccount(String email, String password) {
        String query = "select * from Account where email=?";
        try {
            con = new DbContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("password"), rs.getString("role"));
                if (password.equals(acc.getPassword())) {
                    return acc;
                }
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
