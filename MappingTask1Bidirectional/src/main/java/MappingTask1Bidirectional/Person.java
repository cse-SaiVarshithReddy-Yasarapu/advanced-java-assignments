package MappingTask1Bidirectional;



import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Passport passport;

    public Person() {
    }

    public void assignPassport(Passport passport) {
        if (this.passport != null) {
            throw new RuntimeException("Passport already assigned!");
        }
        this.passport = passport;
        passport.setPerson(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
