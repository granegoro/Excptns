import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    @Test
    public void ShouldThrowExceptionIfProductDoesNotExist() {
        Repository repo = new Repository();

        Book book1 = new Book(101, "Bump Fiction", 300, "Willy");
        Book book2 = new Book(202, "Bump Mission", 500, "Billy");
        Book book3 = new Book(303, "Wham", 200, "Jack");
        Book book4 = new Book(404, "Mister Twister", 900, "Johns");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(333);
        });
    }

    @Test
    public void ShouldRemoveProductWithValidId() {
        Repository repo = new Repository();

        Book book1 = new Book(101, "Bump Fiction", 300, "Willy");
        Book book2 = new Book(202, "Bump Mission", 500, "Billy");
        Book book3 = new Book(303, "Wham", 200, "Jack");
        Book book4 = new Book(404, "Mister Twister", 900, "Johns");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);

        repo.removeById(101);

        Product[] expected = { book2, book3, book4 };
        Product[] actual = repo.findAll();
    }



    }

