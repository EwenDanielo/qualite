package com.example.qualite.RepositoryTests;

import com.example.qualite.entity.Book;
import com.example.qualite.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Should save and retrieve a book")
    void testSaveAndFindById() {
        Book book = new Book();
        book.setTitle("1984");
        book.setAuthor("George Orwell");
        book.setIsbn("9780451524935");
        book.setPublishedDate(LocalDate.of(1949, 6, 8));
        book.setAvailable(true);

        Book saved = bookRepository.save(book);
        Optional<Book> found = bookRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("1984");
    }

    @Test
    @DisplayName("Should return empty list if no books exist")
    void testFindAllEmpty() {
        List<Book> books = bookRepository.findAll();
        assertThat(books).isEmpty();
    }

    @Test
    @DisplayName("Should delete a book")
    void testDelete() {
        Book book = new Book();
        book.setTitle("To Delete");
        book.setAuthor("Someone");
        book.setIsbn("0000000000000");
        book.setPublishedDate(LocalDate.now());
        book.setAvailable(true);

        Book saved = bookRepository.save(book);
        bookRepository.delete(saved);

        Optional<Book> found = bookRepository.findById(saved.getId());
        assertThat(found).isNotPresent();
    }
}
