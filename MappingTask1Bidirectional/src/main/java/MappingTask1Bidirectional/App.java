package MappingTask1Bidirectional;


import jakarta.persistence.*;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Person person = new Person();
        person.setName("Sai");
        person.setEmail("sai@gmail.com");

        Passport passport = new Passport();
        passport.setPassportNumber("IND12345");
        passport.setIssueDate(LocalDate.now());
        passport.setExpiryDate(LocalDate.now().plusYears(10));

        person.assignPassport(passport);

        em.persist(person);

        tx.commit();

        Person fetched = em.find(Person.class, person.getId());

        System.out.println("Passport Number: "
                + fetched.getPassport().getPassportNumber());

        System.out.println("Is Expired? "
                + fetched.getPassport().isExpired());

        em.close();
        emf.close();
    }
}