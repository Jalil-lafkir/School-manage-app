package com.example.utils;

import java.util.ArrayList;
import java.util.Comparator;

import com.example.models.Student;
import com.example.models.Professor;

public class Sorter {


    public static ArrayList<Student> SortStudents(ArrayList<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students); 
        sortedList.sort(Comparator.comparing(Student::getFinalGarde).reversed()); 
        return sortedList;
    }
    
    public static ArrayList<Professor> SortProfessor(ArrayList<Professor> professors) {
        ArrayList<Professor> sortedList = new ArrayList<>(professors); 
        sortedList.sort(Comparator.comparing(Professor::getMountSalary).reversed()); 
        return sortedList;
    }

}
