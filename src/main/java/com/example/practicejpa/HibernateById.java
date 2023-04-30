package com.example.practicejpa;

import com.example.practicejpa.model.Client;
import com.example.practicejpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernateById {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        Client client = em.find(Client.class, id);
        System.out.println(client);
        em.close();
    }
}
