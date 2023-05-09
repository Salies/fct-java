import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AuthorISBN")
public class AuthorISBN {
    @Id
    @Column(name="AuthorID", updatable = false, unique = true, nullable = false)
    private String authorID;

    @Id
    @Column(name="ISBN", updatable = false, unique = true, nullable = false, length = 13)
    private String isbn;
}
