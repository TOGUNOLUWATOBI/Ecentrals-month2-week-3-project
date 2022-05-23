package org.school;

import javax.persistence.*;
import java.util.ArrayList;

//create class Book
@Entity
@Table(name = "Book")

public class Book {
    //declare properties of book
    @Id
    public String ID;
    @Column
    public int Book_count;
    @Column
    public String Book_Name;


    public Book() {
    }

    //book constructor
    public Book(String id, String book_name,int book_count)
    {
        this.ID=id;
        this.Book_count=book_count;
        this.Book_Name=book_name;
    }

    public int getBook_count() {
        return Book_count;
    }

    public void setBook_count(int book_count) {
        Book_count = book_count;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }
}
