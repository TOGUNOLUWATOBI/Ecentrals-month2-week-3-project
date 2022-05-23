package org.school;

import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Logger log=Logger.getLogger(App.class);

    public static Library lib=new Library();

    public static void execution(int action_code, String bookID, Student user){
        String message;
        switch(action_code){
            case 1:
                message=lib.return_book(user,bookID);
                log.info(message);
                break;
            case 2:
                message=lib.borrowBook(user, bookID);
                log.info(message);
                break;
            default:
                message="invalid action code";
                log.info(message);
                break;


        }

    }
    public static void main( String[] args )
    {
        Scanner scanner=new Scanner(System.in);

        //declare object of type student
        Student student=new Student();

        //assign values to the properties of student
        System.out.println("Please enter your Name");
        String username=scanner.nextLine();
        System.out.println("Please enter your ID");
        String userid=scanner.nextLine();

        student.setID(userid);
        student.setName(username);

        //get the id of the book that user needs
        System.out.println("please enter the ID of the book you need to borrow or return");
        String bookID= scanner.nextLine();


        System.out.println( "Hello User" );
        System.out.println("What action do you want to perform");
        System.out.println("type 1 and click enter to return book");
        System.out.println("type 2 and click enter to borrow book");

        int action = scanner.nextInt();

        execution(action,bookID,student);

    }
}
