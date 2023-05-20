import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "Authors")
@NamedQueries({
        @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a"),
        @NamedQuery(name = "Authors.findByAuthorID", query = "SELECT a FROM Authors a WHERE a.authorID = :authorID"),
        @NamedQuery(name = "Authors.findByFirstName", query = "SELECT a FROM Authors a WHERE a.firstName = :firstName"),
        @NamedQuery(name = "Authors.findByLastName", query = "SELECT a FROM Authors a WHERE a.lastName = :lastName")})
public class Authors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AuthorID")
    // Tive que mudar porque o NetBeans simplesmente gerou errado
    private UUID authorID;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @JoinTable(name = "AuthorISBN", joinColumns = {
            @JoinColumn(name = "AuthorID", referencedColumnName = "AuthorID")}, inverseJoinColumns = {
            @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")})
    @ManyToMany
    private Collection<Titles> titlesCollection;
    public Authors() {
    }

    public Authors(UUID authorID) {
        this.authorID = authorID;
    }

    public Authors(UUID authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getAuthorID() {
        return authorID;
    }

    public void setAuthorID(UUID authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Titles> getTitlesCollection() {
        return titlesCollection;
    }

    public void setTitlesCollection(Collection<Titles> titlesCollection) {
        this.titlesCollection = titlesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorID != null ? authorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.authorID == null && other.authorID != null) || (this.authorID != null && !this.authorID.equals(other.authorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exercicio.Authors[ authorID=" + authorID + " ]";
    }

}
