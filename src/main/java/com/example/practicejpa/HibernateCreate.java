package com.example.practicejpa;

import com.example.practicejpa.model.Client;
import com.example.practicejpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCreate {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago:");
            em.getTransaction().begin();
            Client c = new Client();
            c.setName(nombre);
            c.setLastName(apellido);
            c.setMethodPayment(pago);
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("el id del cliente registrado es " + c.getId());
            c = em.find(Client.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
