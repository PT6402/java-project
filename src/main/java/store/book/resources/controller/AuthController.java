package store.book.resources.controller;

import java.io.IOException;

import store.book.resources.model.Account;
import store.book.resources.repository.AccountRepo;
import store.book.resources.service.IAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class AuthController extends HttpServlet {

    IAccount iacc;

    public AuthController() {
        this.iacc = new AccountRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        } else {
            switch (action) {
                case "logout":
                    HttpSession session = req.getSession();
                    if (session.getAttribute("user") != null) {
                        session.removeAttribute("user");
                    }
                    resp.sendRedirect(req.getContextPath() + "/login");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        if (iacc.CheckAccount(email, pass) == null) {
            req.setAttribute("error", "email or password invalid");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        } else {
            Account acc = iacc.CheckAccount(email, pass);
            HttpSession session = req.getSession(true);
            session.setAttribute("user", acc);
            resp.sendRedirect(req.getContextPath() + "/store");
        }

    }

}
