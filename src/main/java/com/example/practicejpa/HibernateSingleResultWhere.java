package com.example.practicejpa;

import com.example.practicejpa.model.Client;
import com.example.practicejpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernateSingleResultWhere {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Client c where c.methodPayment=?1", Client.class);
        System.out.println("Ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1, pago);
        query.setMaxResults(1);
        Client c = (Client) query.getSingleResult();
        System.out.println(c);
        em.close();
    }

}
