package store.book.resources.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import store.book.resources.model.Book;
import store.book.resources.service.IBook;
import store.book.resources.util.DbContext;

public class BookRepo implements IBook {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Book> Gets() {
        String query = "select * from Book";
        List<Book> list = new ArrayList<>();
        try {
            con = new DbContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book newB = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("photo"));
                list.add(newB);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Book Get(int id) {
        String query = "select * from Book where id =?";
        try {
            con = new DbContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("photo"));
                return b;
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void Update(Book item) {
        String query = "update Book set name=? photo=? where id=?";
        try {
            con = new DbContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, item.getName());
            ps.setString(2, item.getPhoto());
            ps.setInt(3, item.getId());
            ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    @Override
    public void Create(Book item) {
        String query = "insert into Book values(?,?)";
        try {
            con = new DbContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, item.getName());
            ps.setString(2, item.getPhoto());
            ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    @Override
    public void Delete(int id) {
        String query = "delete from Book where id=?";
        try {
            con = new DbContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

}
