package OneToOneMappingBidirectional;


import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer customer = new Customer();
        customer.setName("SaiBi");
        customer.setEmail("saiBi@gmail.com");

        Account account = new Account();
        account.setAccountNumber("ACC1003");
        account.setBalance(10000);

        customer.assignAccount(account);

        em.persist(customer);  // cascade saves account too

        tx.commit();

        // Fetch
        Customer fetched = em.find(Customer.class, customer.getId());

        System.out.println("Customer: " + fetched.getName());
        System.out.println("Account Number: "
                + fetched.getAccount().getAccountNumber());
        System.out.println("Balance: "
                + fetched.getAccount().getBalance());

        em.close();
        emf.close();
    }
}