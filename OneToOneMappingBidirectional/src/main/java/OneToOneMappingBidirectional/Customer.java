package OneToOneMappingBidirectional;



import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Account account;

    public Customer() {
    }

    // Helper method (important for bidirectional consistency)
    public void assignAccount(Account account) {
        this.account = account;
        account.setCustomer(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}