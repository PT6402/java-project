package store.book.resources.controller;

import java.io.IOException;

import store.book.resources.repository.BookRepo;
import store.book.resources.service.IBook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/store"})
public class StoreController extends HttpServlet {

    IBook ibook;

    public StoreController() {
        this.ibook = new BookRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", ibook.Gets());
        req.getRequestDispatcher("/view/user/index.jsp").forward(req, resp);
    }
}
