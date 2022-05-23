package org.school;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getterTest()
    {
        String bookID="#id-1";
        String bookName="Introduction to physics";
        int book_count=50;
        Book book= new Book(bookID,bookName,book_count);

        assertEquals(bookName,book.getBook_Name());
        assertEquals(bookID,book.getID());
        assertEquals(book_count,book.getBook_count());
    }

}
