package com.example.qualite.EntityTests;

import com.example.qualite.entity.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookEntityTest {

    @Test
    void testBookFields() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setIsbn("9780132350884");
        book.setPublishedDate(LocalDate.of(2008, 8, 1));
        book.setAvailable(true);

        assertThat(book.getId()).isEqualTo(1);
        assertThat(book.getTitle()).isEqualTo("Clean Code");
        assertThat(book.getAuthor()).isEqualTo("Robert C. Martin");
        assertThat(book.getIsbn()).isEqualTo("9780132350884");
        assertThat(book.getPublishedDate()).isEqualTo(LocalDate.of(2008, 8, 1));
        assertThat(book.getAvailable()).isTrue();
    }
}
