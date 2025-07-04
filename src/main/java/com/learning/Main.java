package com.learning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(104, "Munesh", 54);
        StudentService service = new StudentService();

        // Create a student
        service.createStudent(s1);

        // Retrieve a student
        Student retrievedStudent = service.getStudent(104);
        System.out.println(retrievedStudent);

        // Update a student
        retrievedStudent.setMarks(98);
        service.updateStudent(retrievedStudent);

        // Delete a student
        service.deleteStudent(103);

        service.close();
    }
}