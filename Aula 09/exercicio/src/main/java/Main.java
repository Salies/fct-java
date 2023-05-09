import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("aulaExercicio");
        EntityManager em = emf.createEntityManager();

        // Inserindo 3 dados em cada uma das tabelas
        // Dados dos 3 autores
        String[] firstNames = {"Neil", "Graciliano", "Grant"};
        String[] lastNames = {"Gaiman", "Ramos", "Morrison"};

        // Dados dos 3 livros
        String[] titles = {"Stardust", "Angústia", "Batman: Arkham Asylum"};
        String[] isbn = {"9780380977284", "9788501115942", "9780930289485"};
        int[] editionNumbers = {1, 93, 1};
        String[] copyrights = {"DC Comics, 1999", "Record, 2019", "DC Comics, 1989"};

        em.getTransaction().begin();
        // Criando os objetos
        for(int i = 0; i < 3; i++) {
            Authors author = new Authors();
            author.setFirstName(firstNames[i]);
            author.setLastName(lastNames[i]);

            Titles title = new Titles();
            title.setTitle(titles[i]);
            title.setIsbn(isbn[i]);
            title.setEditionNumber(editionNumbers[i]);
            title.setCopyright(copyrights[i]);

            // Persistindo os objetos

            em.persist(author);
            em.persist(title);
        }

        em.getTransaction().commit();

        em.getTransaction().begin();
        // Criando os objetos de relacionamento
        for(int i = 0; i < 3; i++) {
            AuthorISBN authorISBN = new AuthorISBN();
            authorISBN.setAuthorID(em.find(Authors.class, i + 1).getId());
            authorISBN.setIsbn(em.find(Titles.class, i + 1).getIsbn());

            // Persistindo os objetos

            em.persist(authorISBN);
        }

        em.getTransaction().commit();
    }
}
