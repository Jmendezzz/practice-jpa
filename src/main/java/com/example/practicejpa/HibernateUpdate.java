package com.example.practicejpa;

import com.example.practicejpa.model.Client;
import com.example.practicejpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.Scanner;

public class HibernateUpdate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a actualizar:");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Client clientToUpdate = em.find(Client.class, id);
            if (clientToUpdate != null) {
                String name = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                String lastname = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
                String payment = JOptionPane.showInputDialog("Ingrese el metodo de pago del cliente");

                clientToUpdate.setName(name);
                clientToUpdate.setLastName(lastname);
                clientToUpdate.setMethodPayment(payment);
            } else {
                throw new IllegalArgumentException("Cliente con id " + id + " no encontrado.");
            }

            em.getTransaction().commit();
            System.out.println("Cliente actualizado exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
