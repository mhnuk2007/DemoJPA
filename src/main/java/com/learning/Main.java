package com.learning;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(102, "Sunny", 95);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s1);
        transaction.commit();
        em.close();
        emf.close();


        System.out.println(s1);

    }
}