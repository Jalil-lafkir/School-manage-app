package com.example.Database;

import java.util.ArrayList;

import com.example.models.*;
import com.example.models.Module;
import com.example.utils.Generator;

public class Tabels {

    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Professor> professors = new ArrayList<Professor>();
    public static ArrayList<Module> modules = new ArrayList<Module>();
    public static ArrayList<Session> sessions = new ArrayList<Session>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();




    public static void  init() {

        students.add(new Student(Generator.generateStudentId(), "Jalil", "jalil@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Omar", "omar@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Amina", "amina@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Khalid", "khalid@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Layla", "layla@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Youssef", "youssef@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Fatima", "fatima@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Tariq", "tariq@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Nour", "nour@gmail.com"));
        students.add(new Student(Generator.generateStudentId(), "Hassan", "hassan@gmail.com"));

        professors.add(new Professor("Ahmed Ali", "ahmed.ali@example.com"));
        professors.add(new Professor("Fatima Hassan", "fatima.hassan@example.com"));
        professors.add(new Professor("Omar Khaled", "omar.khaled@example.com"));
        professors.add(new Professor("Layla Mahmoud", "layla.mahmoud@example.com"));
        professors.add(new Professor("Youssef Saeed", "youssef.saeed@example.com"));
        professors.add(new Professor("Amina Mostafa", "amina.mostafa@example.com"));
        professors.add(new Professor("Khalid Nasser", "khalid.nasser@example.com"));
        professors.add(new Professor("Hana Adel", "hana.adel@example.com"));
        professors.add(new Professor("Mohammed Tarek", "mohammed.tarek@example.com"));
        professors.add(new Professor("Nour Sami", "nour.sami@example.com"));

        sessions.add(new Session("Mathematics 101", "2025-03-01", "10:00 AM", "Room A1", "P001", "MATH101"));
        sessions.add(new Session("Physics 201", "2025-03-02", "2:00 PM", "Room B2", "P002", "PHYS201"));
        sessions.add(new Session("Chemistry 301", "2025-03-03", "11:00 AM", "Room C3", "P003", "CHEM301"));
        sessions.add(new Session("Computer Science 101", "2025-03-04", "9:00 AM", "Room D4", "P004", "CS101"));
        sessions.add(new Session("History 202", "2025-03-05", "3:00 PM", "Room E5", "P005", "HIST202"));
        sessions.add(new Session("Biology 102", "2025-03-06", "1:00 PM", "Room F6", "P006", "BIO102"));
        sessions.add(new Session("Economics 303", "2025-03-07", "4:00 PM", "Room G7", "P007", "ECO303"));
        sessions.add(new Session("Psychology 201", "2025-03-08", "10:30 AM", "Room H8", "P008", "PSY201"));
        sessions.add(new Session("Philosophy 101", "2025-03-09", "8:00 AM", "Room I9", "P009", "PHIL101"));
        sessions.add(new Session("Statistics 401", "2025-03-10", "12:00 PM", "Room J10", "P010", "STAT401"));

        modules.add(new Module("Mathematics 101", "Introduction to Algebra and Calculus"));
        modules.add(new Module("Physics 201", "Fundamentals of Mechanics and Thermodynamics"));
        modules.add(new Module("Chemistry 301", "Organic and Inorganic Chemistry"));
        modules.add(new Module("Computer Science 101", "Programming Basics and Data Structures"));
        modules.add(new Module("History 202", "World History from Ancient to Modern Times"));
        modules.add(new Module("Biology 102", "Cell Biology and Genetics"));
        modules.add(new Module("Economics 303", "Microeconomics and Macroeconomics"));
        modules.add(new Module("Psychology 201", "Introduction to Cognitive and Behavioral Psychology"));
        modules.add(new Module("Philosophy 101", "Ethics, Logic, and Critical Thinking"));
        modules.add(new Module("Statistics 401", "Probability, Data Analysis, and Statistical Modeling"));

        rooms.add(new Room("Room A1", "CourseRoom"));
        rooms.add(new Room("Room B2", "TpRoom"));
        rooms.add(new Room("Room C3", "TdRoom"));
        rooms.add(new Room("Room D4", "CourseRoom"));
        rooms.add(new Room("Room E5", "TdRoom"));
        rooms.add(new Room("Room F6", "CourseRoom "));
        rooms.add(new Room("Room G7", "TpRoom"));
        rooms.add(new Room("Room H8", "TdRoom "));
        rooms.add(new Room("Room I9", "CourseRoom"));
        rooms.add(new Room("Room J10", "TpRoom"));

    }
    
    
}
