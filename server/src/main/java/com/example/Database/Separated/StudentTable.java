package com.example.Database.Separated;

import java.util.ArrayList;

import com.example.models.Student;
import com.example.utils.Generator;

public class StudentTable {

    public static ArrayList<Student> students = new ArrayList<Student>();

    public static void init() {
        students.add(new Student(Generator.generateStudentId(),"Jalil","jalil@gmail.com"));
        students.add(new Student(Generator.generateStudentId(),"amin","amin@gmail.com"));
        students.add(new Student(Generator.generateStudentId(),"younes","younes@gmail.com"));
        students.add(new Student(Generator.generateStudentId(),"nadjib","nadjib@gmail.com"));
        students.add(new Student(Generator.generateStudentId(),"mohssin","mohssin@gmail.com"));
    }

    public static ArrayList<Student> readAllStudents() {
       return students;
    }

    public static Boolean createStudent(Student student) {
        students.add(student);
        return true;
    }

    public static Student readStudent(String token) {
        for (Student student : students) {
            if (student.getId().equals(token) || student.getName().equals(token) || student.getEmail().equals(token)) {
                return student;
            }
        }
        return null;
    }

    public static Boolean updateStudent(Student student) {
        for (Student dbstudent : students) {
            if (dbstudent.getId().equals(student.getId())) {
                students.remove(dbstudent);
                students.add(student);
                return true;
            }
        }
        return false;
    }

    public static Boolean deleteStudent(Student student) {
        for (Student dbstudent : students) {
            if (dbstudent.getId().equals(student.getId())) {
                students.remove(dbstudent);
                return true;
            }
        }
        return false;
    }
}
