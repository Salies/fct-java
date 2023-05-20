import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Titles")
@NamedQueries({
        @NamedQuery(name = "Titles.findAll", query = "SELECT t FROM Titles t"),
        @NamedQuery(name = "Titles.findByIsbn", query = "SELECT t FROM Titles t WHERE t.isbn = :isbn"),
        @NamedQuery(name = "Titles.findByCopyright", query = "SELECT t FROM Titles t WHERE t.copyright = :copyright"),
        @NamedQuery(name = "Titles.findByEditionNumber", query = "SELECT t FROM Titles t WHERE t.editionNumber = :editionNumber"),
        @NamedQuery(name = "Titles.findByTitle", query = "SELECT t FROM Titles t WHERE t.title = :title")})
        // Adição minha
        @NamedQuery(name = "Titles.findByAuthor", query = "SELECT t FROM Titles t WHERE t.authorsCollection = :author")
public class Titles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "Copyright")
    private String copyright;
    @Basic(optional = false)
    @Column(name = "EditionNumber")
    private int editionNumber;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @ManyToMany(mappedBy = "titlesCollection")
    private Collection<Authors> authorsCollection;

    public Titles() {
    }

    public Titles(String isbn) {
        this.isbn = isbn;
    }

    public Titles(String isbn, String copyright, int editionNumber, String title) {
        this.isbn = isbn;
        this.copyright = copyright;
        this.editionNumber = editionNumber;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Authors> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Authors> authorsCollection) {
        this.authorsCollection = authorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titles)) {
            return false;
        }
        Titles other = (Titles) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // Modifiquei isso para printar o título também
        return "exercicio.Titles[ isbn=" + isbn + ", title=" + title + ", editionNumber = " + editionNumber + ", copyright = " + copyright + " ]";
    }

}