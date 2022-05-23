package org.school;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




// class Library acting as Librarian
public class Library {
    public static Logger logger=Logger.getLogger(Library.class);
    public static SessionFactory sessionFactory= buildSessionFactory(Student.class);
    public static SessionFactory sessionFactoryBook= buildSessionFactory(Book.class);

    public static Session sessionStudent=sessionFactory.openSession();
    public static Session sessionBook=sessionFactoryBook.openSession();


    //constructor Library
    public Library() {}

    //Method to return borrowed book
    public String borrowBook(Student student, String id)
    {
        String message;
        if(student.getStudent_status()==0)
        {
            try{
            Book book=sessionBook.find(Book.class,id);
            if(book != null)
            {
                book.setBook_count(book.getBook_count()-1);
                student.setStudent_status(1);
                sessionBook.save(book);
                sessionStudent.save(student);
                message="book successfully borrowed";
                logger.info(message);
                return message;
            }}
            catch (Exception e)
            {
                logger.error(e.toString());
            }

            {
                message="book doesn't exist";
                logger.error(message);
                return message;
            }
        }
        else
        {
            message="you can't borrow the book please return former book";
            logger.info(message);
            return message;
        }
    }

    //Method to return borrowed book
    public String return_book(Student student, String id)
    {
        String message;
        if(student.getStudent_status()==1)
        {
            try{
            Book book=sessionBook.find(Book.class,id);
            if(book != null)
            {
                book.setBook_count(book.getBook_count()+1);
                student.setStudent_status(0);
                sessionBook.save(book);
                sessionStudent.save(student);
                message="book successfully returned";

                return message;

            }}
            catch (Exception e)
            {
                logger.error(e.toString());
            }

            {
                message="book doesn't exist";
                return message;
            }
        }
        else
        {
            message="you didn't have any borrowed book";
            logger.info(message);
            return message;
        }
    }

    //method to addbook or initialize book properties
    public  boolean AddBook(Book book)
    {
        boolean success=false;

        var x= sessionBook.save(book);
        if(x!=null)
        {
            success=true;
        }
        return success;
    }

    public  boolean AddStudent(Student student)
    {
        boolean success=false;
        var x=sessionStudent.save(student);

        if(x!=null)
        {
            success=true;
        }
        return success;
    }

    //session factory
    private static SessionFactory buildSessionFactory(Class clazz)
    {
        return new Configuration()
                .configure().
                addAnnotatedClass(clazz).
                buildSessionFactory();
    }
}
