/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Cole
 */
public class Hibernate360 {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        Hibernate360.factory = factory;
    }

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        String input = "";
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Enter name (q to quit) ");
            input = sc.nextLine();
            
            if(input.equals("q")){
                continue;
            }

            Student stu = new Student();

            Integer entry = stu.addStudent(input);
        }
        while (!input.equals("q"));
        
        factory.close();
    }

}
