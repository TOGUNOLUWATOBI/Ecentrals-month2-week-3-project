package org.school;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class LibraryTest
{

    Library library=new Library();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addBookTest ()
    {
        String bookID="#id-5";
        String bookName="Introduction to physics";
        int book_count=50;

        String bookID2="#id-6";
        String bookName2="Introduction to maths";
        int book_count2=20;

        Book book1=new Book(bookID,bookName,book_count);
        Book book2=new Book(bookID2,bookName2,book_count2);
        boolean statusBook1=library.AddBook(book1);
        boolean statusBook2=library.AddBook(book2);
        assertTrue(statusBook1);
        assertTrue(statusBook2);
    }

    @Test
    public void addStudentTest ()
    {
        String studentID="19cg123456";
        String studentName="Blue Black";
        String studentID2="19cg098765";
        String studentName2="White harsh";

        Student student= new Student(studentID,studentName);
        Student student2= new Student(studentID2,studentName2);

        boolean status1=library.AddStudent(student);
        boolean status2=library.AddStudent(student2);
        assertTrue(status1);
        assertTrue(status2);
    }

    @Test
    public void borrowBookTest()
    {
        String bookID="#id-1";
        String bookName="Introduction to physics";
        int book_count=50;

        String bookID2="#id-2";
        String bookName2="Introduction to maths";
        int book_count2=20;

        Book book1=new Book(bookID,bookName,book_count);
        Book book2=new Book(bookID2,bookName2,book_count2);

        //Add book to database
        library.AddBook(book1);
        library.AddBook(book2);

        String studentID="19ch123456";
        String studentName="Blue Black";
        String studentID2="19ch098765";
        String studentName2="White harsh";

        Student student = new Student(studentID,studentName);
        Student student2 = new Student(studentID2,studentName2);
        Student student3 = new Student();

        //make student be marked for borrowed book
        student2.setStudent_status(1);

        //Add student to database
        library.AddStudent(student);
        library.AddStudent(student2);

        String Message1=library.borrowBook(student,book1.getID());
        String Message2=library.borrowBook(student2,book2.getID());
        String Message3=library.borrowBook(student3,"BAD ID");

        assertEquals("book successfully borrowed",Message1);
        assertEquals("you can't borrow the book please return former book",Message2);
        assertEquals("book doesn't exist",Message3);

        //test to check that their status for borrowed book
        assertEquals(1,student.getStudent_status());
        assertEquals(1,student2.getStudent_status());

    }

    @Test
    public void returnBookTest()
    {
        String bookID="#id-3";
        String bookName="Introduction to physics";
        int book_count=50;

        String bookID2="#id-4";
        String bookName2="Introduction to maths";
        int book_count2=20;

        Book book1=new Book(bookID,bookName,book_count);
        Book book2=new Book(bookID2,bookName2,book_count2);

        //Add book to database
        library.AddBook(book1);
        library.AddBook(book2);

        String studentID="19cj123456";
        String studentName="Blue Black";
        String studentID2="19cj098765";
        String studentName2="White harsh";

        Student student= new Student(studentID,studentName);
        Student student2= new Student(studentID2,studentName2);



        //Add student to database
        library.AddStudent(student);
        library.AddStudent(student2);

        library.borrowBook(student,book1.getID());

        //create another student
        Student student3 = new Student();
        student3.setStudent_status(1);

        String Message1=library.return_book(student,book1.getID());
        String Message2=library.return_book(student2,book2.getID());
        String Message3=library.return_book(student3,"BAD ID");

        assertEquals("book successfully returned",Message1);
        assertEquals("you didn't have any borrowed book",Message2);
        assertEquals("book doesn't exist",Message3);

    }
}
