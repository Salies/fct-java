import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "AuthorISBN")
public class AuthorISBN {
    @Id
    @Column(name="AuthorID", updatable = false, unique = true, nullable = false)
    private UUID authorID;

    @Id
    @Column(name="ISBN", updatable = false, unique = true, nullable = false, length = 13)
    private String isbn;

    // Setters
    public void setAuthorID(UUID authorID) {
        this.authorID = authorID;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
