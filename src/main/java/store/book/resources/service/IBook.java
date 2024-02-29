package store.book.resources.service;

import java.util.List;

import store.book.resources.model.Book;

public interface IBook {

    List<Book> Gets();

    Book Get(int id);

    void Update(Book item);

    void Create(Book item);

    void Delete(int id);
}
