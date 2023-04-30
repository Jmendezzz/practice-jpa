package com.example.practicejpa;

import com.example.practicejpa.model.Client;
import com.example.practicejpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateList {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList();


        clients.forEach(c-> System.out.println(c.toString()));
        em.close();


    }
}
