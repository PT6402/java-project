package store.book.resources.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import store.book.resources.model.Book;
import store.book.resources.repository.BookRepo;
import store.book.resources.service.IBook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig()
@WebServlet(urlPatterns = {"/admin/book"})
public class BookController extends HttpServlet {

    IBook ibook;

    public BookController() {
        this.ibook = new BookRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id;
        if (action == null) {
            req.setAttribute("list", ibook.Gets());
            req.getRequestDispatcher("/view/admin/book/index.jsp").forward(req, resp);
        } else {
            switch (action) {
                case "create":
                    req.getRequestDispatcher("/view/admin/book/create.jsp").forward(req, resp);
                    break;
                case "edit":
                    id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("book", ibook.Get(id));
                    req.getRequestDispatcher("/view/admin/book/edit.jsp").forward(req, resp);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        Part photo = req.getPart("photo");
        String filename = null;
        switch (action) {
            case "create":

                if (photo != null) {
                    String realPath = "C:/Users/pc/store/src/main/webapp/upload";
                    // String realPath = req.getServletContext().getRealPath("uploads");
                    filename = Path.of(photo.getSubmittedFileName()).getFileName().toString();
                    if (!Files.exists(Path.of(realPath))) {
                        Files.createDirectory(Path.of(realPath));
                    }
                    photo.write(realPath + "/" + filename);
                }
                ibook.Create(new Book(name, filename));
                break;
            case "edit":
                break;
            default:
                break;
        }
    }

}
