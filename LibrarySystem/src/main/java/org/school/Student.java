package org.school;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import javax.persistence.*;

//Class Teacher inheriting class Person
@Entity
@Table(name = "Student")

public class Student {

    @Id
    public String ID;
    @Column
    public String name;
    @Column
    public int student_status;

    public static Logger log= Logger.getLogger(Student.class);


    public Student() {
    }

    public Student(String id, String name)
    {
        this.ID=id;
        this.name=name;
        this.student_status=0;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudent_status() {
        return student_status;
    }

    public void setStudent_status(int student_status) {
        this.student_status = student_status;
    }
}
