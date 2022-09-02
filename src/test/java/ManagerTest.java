import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);


    @Test
    public void ShouldFindAllMatches() {

        Book book1 = new Book(101, "Bump Fiction", 300, "Willy");
        Book book2 = new Book(202, "Bump Mission", 500, "Billy");
        Book book3 = new Book(303, "Wham", 200, "Jack");
        Book book4 = new Book(404, "Mister Twister", 900, "Johns");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Bump");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindOneMatch() {

        Book book1 = new Book(101, "Bump Fiction", 300, "Willy");
        Book book2 = new Book(202, "Bump Mission", 500, "Billy");
        Book book3 = new Book(303, "Wham", 200, "Jack");
        Book book4 = new Book(404, "Mister Twister", 900, "Johns");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Wham");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindNoMatch() {

        Book book1 = new Book(101, "Bump Fiction", 300, "Willy");
        Book book2 = new Book(202, "Bump Mission", 500, "Billy");
        Book book3 = new Book(303, "Wham", 200, "Jack");
        Book book4 = new Book(404, "Mister Twister", 900, "Johns");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] actual = manager.searchBy("Gigi");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveInManager() {

        Book book1 = new Book(101, "Bump Fiction", 300, "Willy");
        Book book2 = new Book(202, "Bump Mission", 500, "Billy");
        Book book3 = new Book(303, "Wham", 200, "Jack");
        Book book4 = new Book(404, "Mister Twister", 900, "Johns");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        manager.removeById(101);

        Product[] actual = manager.getAll();
        Product[] expected = {book2, book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindAllMatchingSmartphones() {

        Smartphone smartphone1 = new Smartphone(11, "iPhone", 123000, "Apple");
        Smartphone smartphone2 = new Smartphone(22, "Mi", 78000, "Xiaomi");
        Smartphone smartphone3 = new Smartphone(33, "RedMi", 1001, "Xiaomi");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] actual = manager.searchBy("Mi");
        Product[] expected = {smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindOneMatchingSmartphones() {

        Smartphone smartphone1 = new Smartphone(11, "iPhone", 123000, "Apple");
        Smartphone smartphone2 = new Smartphone(22, "Galaxy", 78000, "Samsung");
        Smartphone smartphone3 = new Smartphone(33, "Redmi", 1001, "Xiaomi");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {smartphone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindNoMatchingSmartphones() {

        Smartphone smartphone1 = new Smartphone(11, "iPhone", 123000, "Apple");
        Smartphone smartphone2 = new Smartphone(22, "Galaxy", 78000, "Samsung");
        Smartphone smartphone3 = new Smartphone(33, "Redmi", 1001, "Xiaomi");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);


        Product[] actual = manager.searchBy("Motorolla");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}


