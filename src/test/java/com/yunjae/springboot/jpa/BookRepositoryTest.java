package com.yunjae.springboot.jpa;

import com.yunjae.springboot.jpa.entity.Book;
import com.yunjae.springboot.jpa.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testFindByIsbn() {
        Book book = new Book();
        book.setIsbn("1234");
        book.setTitle("spring");
        bookRepository.save(book);

        Optional<Book> book1234 = bookRepository.findByIsbn("1234");

        assertThat(book1234).isNotEmpty();
    }

    @Test
    public void findByIsTileLike() {
        List<Book> books = bookRepository.findByTitleIsLike("spring");
        assertThat(books).isEmpty();
    }

}
