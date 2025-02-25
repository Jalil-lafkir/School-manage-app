package com.example.Database.Separated;

import java.util.ArrayList;

import com.example.models.Professor;

public class ProfessorTable {

    ArrayList<Professor> professors = new ArrayList<Professor>();


    public ProfessorTable() {}

    public ArrayList<Professor> readAllProfessors() {
       return professors;
    }

    public void createProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public Professor readProfessor(String id) {
        for (Professor professor : this.professors) {
            if (professor.getId().equals(id)) {
                return professor;
            }
        }
        return null;
    }

    public void updateProfessor(Professor professor) {
        for (Professor dbprofessor : this.professors) {
            if (dbprofessor.getId().equals(professor.getId())) {
                professors.remove(dbprofessor);
                professors.add(professor);
                return;
            }
        }
    }

    public void deleteProfessor(Professor professor) {
        for (Professor dbprofessor : this.professors) {
            if (dbprofessor.getId().equals(professor.getId())) {
                professors.remove(dbprofessor);
                return;
            }
        }
    }
    

}
