import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "AuthorISBN")
public class AuthorISBN {
    // foregin key
    @Id
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Authors authorID;

    @Id
    @ManyToOne
    @JoinColumn(name = "ISBN")
    private Titles title;

    // Setters
    public void setAuthor(Authors authorID) {
        this.authorID = authorID;
    }

    public void setTitle(Titles title) {
        this.title = title;
    }
}
