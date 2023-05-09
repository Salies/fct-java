import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="AuthorID", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name="FirstName", nullable = false)
    private String firstName;

    @Column(name="LastName", nullable = false)
    private String lastName;
}