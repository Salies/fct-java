import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    /**
     * Retorna todos os autores do banco de dados, em formato de classe Authors
     * @param em EntityManager JPA, previamente criado
     * @return List<Authors> Lista de autores
     */
    private static List<Authors> getAllAuthors(EntityManager em) {
        return em.createNamedQuery("Authors.findAll", Authors.class).getResultList();
    }

    /**
     *
     * @param em EntityManager JPA, previamente criado
     * @param author Autor cujos livros serao retornados. Deve ser previamente obtido (ex.: pegando da lista retornada por getAllAuthors).
     * @return List<Titles> Lista dos livros do autor author
     */
    private static List<Titles> getBooksFromAuthor(EntityManager em, Authors author) {
        return em.createNamedQuery("Titles.findByAuthor", Titles.class).setParameter("author", author).getResultList();
    }

    /**
     * Insere um novo livro no banco de dados
     * @param em EntityManager JPA, previamente criado
     * @param ISBN ISBN-13 do livro
     * @param title Titulo do livro
     * @param editionNumber Nimero da edicao do livro
     * @param copyright Editora a ano de lancamento do livro (ex.: "Darkhorse, 2013")
     */
    private static void insertNewBook(EntityManager em, String ISBN, String title, Integer editionNumber, String copyright) {
        Titles newBook = new Titles(ISBN, title, editionNumber, copyright);
        em.getTransaction().begin();
        em.persist(newBook);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("aulaExercicio");
        EntityManager em = emf.createEntityManager();

        // Todos os autores
        List<Authors> allAuthors = getAllAuthors(em);
        System.out.println(allAuthors);

        // Pega todos os livros do primeiro autor da lista
        List<Titles> booksFromAuthor = getBooksFromAuthor(em, allAuthors.get(0));
        System.out.println(booksFromAuthor);

        // Insere um novo livro
        insertNewBook(em, "9781338652086", "Fairy Tales of Remnant", 1, "Scholastic Inc., 2020");
    }
}
