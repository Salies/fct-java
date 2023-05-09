import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("aulaExercicio");
        EntityManager em = emf.createEntityManager();

        // Inserindo 3 dados em cada uma das tabelas
        // Dados dos 3 autores
        String[] firstNames = {"Neil", "Graciliano", "Grant"};
        String[] lastNames = {"Gayman", "Ramos", "Morrison"};

        // Dados dos 3 livros
        String[] bookTitles = {"Stardust", "Angústia", "Batman: Arkham Asylum"};
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
            title.setTitle(bookTitles[i]);
            title.setIsbn(isbn[i]);
            title.setEditionNumber(editionNumbers[i]);
            title.setCopyright(copyrights[i]);

            AuthorISBN authorISBN = new AuthorISBN();
            authorISBN.setAuthor(author);
            authorISBN.setTitle(title);

            // Persistindo os objetos

            em.persist(author);
            em.persist(title);
            em.persist(authorISBN);
        }

        em.getTransaction().commit();

        em.getTransaction().begin();
        // Fazendo uma atualização
        // Acha o autor com LastName = "Gayman"
        // (consulta)
        Authors author = em.createQuery("SELECT a FROM Authors a WHERE a.lastName = 'Gayman'", Authors.class).getSingleResult();
        // Substitui por "Gaiman"
        // (atualização)
        author.setLastName("Gaiman");
        em.persist(author);
        // Exclui o registro AuthorISBN com ISBN = "9788501115942"
        // (exclusão)
        AuthorISBN authorISBN = em.createQuery("SELECT a FROM AuthorISBN a WHERE a.title.isbn = '9788501115942'", AuthorISBN.class).getSingleResult();
        em.remove(authorISBN);
        // Persiste as operações
        em.getTransaction().commit();
    }
}
