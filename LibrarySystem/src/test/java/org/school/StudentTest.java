package org.school;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void getterTest()
    {
        String studentID="19cg123456";
        String studentName="Blue Black";

        Student student= new Student(studentID,studentName);

        assertEquals(studentName,student.getName());
        assertEquals(studentID,student.getID());
        assertEquals(0,student.getStudent_status());
    }

}
