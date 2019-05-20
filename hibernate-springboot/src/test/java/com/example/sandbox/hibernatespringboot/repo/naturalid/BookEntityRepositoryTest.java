package com.example.sandbox.hibernatespringboot.repo.naturalid;

import com.example.sandbox.hibernatespringboot.model.naturalid.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookEntityRepositoryTest {
    @Autowired
    BookRepository bookRepo;

    @Test
    public void testReplace() {
        BookEntity bookEntity = new BookEntity(2222, "tit222");
        BookEntity newBookEntity = new BookEntity(2222, "titUpdated");
        insert(bookEntity);
        replace(newBookEntity);
    }

    @Transactional
    public void insert(BookEntity bookEntity) {
        bookRepo.save(bookEntity);
    }

    @Transactional
    public void replace(BookEntity newBookEntity) {
        BookEntity toReplace = bookRepo.findAll().stream().filter(bookEntityNaturalId -> bookEntityNaturalId.getIsbn().equals(newBookEntity.getIsbn())).findFirst().get();
        bookRepo.delete(toReplace);
        bookRepo.save(newBookEntity);

        int aaa = 0;
    }


}
