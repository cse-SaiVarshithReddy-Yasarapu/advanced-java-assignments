package hibernatedemo1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

     
        EntityManager em = emf.createEntityManager();

      
        em.getTransaction().begin();
        Book b1 = new Book(1, "Java Basics", "John Doe",  "Programming", 450.0, "Available", 2022);
        em.persist(b1);
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Done");
    }
}