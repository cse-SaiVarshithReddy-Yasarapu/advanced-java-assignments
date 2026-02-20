package OneToManyUnidirectional;


import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer customer = new Customer();
        customer.setName("Sai");
        customer.setEmail("sai@gmail.com");

        Account acc1 = new Account();
        acc1.setAccountNumber("ACC1001");
        acc1.setBalance(5000);

        Account acc2 = new Account();
        acc2.setAccountNumber("ACC1002");
        acc2.setBalance(10000);

        customer.addAccount(acc1);
        customer.addAccount(acc2);

        em.persist(customer);

        tx.commit();

        System.out.println("Customer Saved Successfully!");

        // Fetch & Test Lazy Loading
        Customer fetched = em.find(Customer.class, customer.getId());

        System.out.println("Customer Name: " + fetched.getName());

        for (Account acc : fetched.getAccounts()) {
            System.out.println("Account: " + acc.getAccountNumber()
                    + " Balance: " + acc.getBalance());
        }

        em.close();
        emf.close();
    }
}