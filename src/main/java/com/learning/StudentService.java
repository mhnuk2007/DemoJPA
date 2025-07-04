package com.learning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentService {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPU");

    // CREATE
    public void createStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(student);
            transaction.commit();
            System.out.println("Student created: " + student);
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // READ
    public Student getStudent(int rollNo) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Student.class, rollNo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // UPDATE
    public void updateStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(student);
            transaction.commit();
            System.out.println("Student updated: " + student);
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // DELETE
    public void deleteStudent(int rollNo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Student student = em.find(Student.class, rollNo);
            if (student != null) {
                em.remove(student);
                System.out.println("Student deleted: " + student);
            } else {
                System.out.println("Student with rollNo " + rollNo + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Close the factory when the app is shutting down
    public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
