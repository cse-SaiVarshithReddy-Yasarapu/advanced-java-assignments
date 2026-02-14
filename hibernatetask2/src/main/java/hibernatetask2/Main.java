package hibernatetask2;

import jakarta.persistence.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("taskPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee e1 = new Employee("Sai", "Developer", 60000);
        Employee e2 = new Employee("Ravi", "Tester", 50000);
        Employee e3 = new Employee("Anu", "Manager", 80000);

        Department dept = new Department(
                "IT",
                "Hyderabad",
                Arrays.asList(e1, e2, e3)
        );

        em.persist(dept);  // saves department + employees automatically

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Saved Successfully");
    }
}