import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Titles")
public class Titles {
    @Id
    @Column(name="ISBN", updatable = false, unique = true, nullable = false, length = 13)
    private String isbn;

    @Column(name="Title", nullable = false, length = 256)
    private String title;

    @Column(name="EditionNumber", nullable = false)
    private int editionNumber;

    @Column(name="Copyright", nullable = false, length = 128)
    private String copyright;

    // Setters
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }
}
