package com.example.utils;

import com.example.models.Student;
import java.util.ArrayList;

import com.example.Database.*;
import com.example.models.Module;
import com.example.models.Professor;

public class Calculator {


    public Float calculateStudentGrade(Student student) {

        ArrayList<Module> modules = student.getStudent_modules();

        Float exam01 ;
        Float exam02 ;
        Float cm;
        Integer coeff ;

        Float totalMarks = 0.00f;
        Integer totalCoeff = 0;

        for (Module module : modules) {

            exam01 = module.getFirstExame();
            exam02 = module.getSecondExame();
            cm = module.getContinuousMonitoring();
            coeff = module.getCoefficient();

           totalMarks += (((exam01 + exam02 + cm ) / 3 ) * coeff );
           totalCoeff += coeff;

        }

        student.setFinalGarde(totalMarks / totalCoeff);
        Operations.Update(Tabels.students , student);
        return totalMarks / totalCoeff;
    }



    public Float calculateProfessorSalary(Professor professor){
        Float salart = professor.getProfessor_sessions().size() * Generator.generateRandomSessionPrice() +  Generator.generateRandomBonus();
        professor.setMountSalary(salart);
        Operations.Update(Tabels.professors , professor);
        return salart;
    }
    
}
