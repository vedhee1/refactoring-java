import entity.Customer;
import entity.MovieRental;
import exception.MovieNotFoundException;
import org.junit.Test;
import service.RentalInfo;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieRentalTest {

    @Test
    public void statementSuccesstest() throws MovieNotFoundException {

        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";
        String result = new RentalInfo().statement(new Customer("C. U. Stomer", List.of(new MovieRental("F001", 3), new MovieRental("F002", 1))));

        assertEquals( expected, result);
    }

    @Test(expected = MovieNotFoundException.class)
    public void statementFailuretest() throws MovieNotFoundException{

        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";
        String result = new RentalInfo().statement(new Customer("C. U. Stomer", List.of(new MovieRental("F009", 3), new MovieRental("F002", 1))));

        }

    @Test
    public void statementCustomerNotFoundtest() throws MovieNotFoundException {

        String expected = "Customer Not found";
        String result = new RentalInfo().statement(new Customer("", List.of(new MovieRental("F001", 3), new MovieRental("F002", 1))));

        assertEquals( expected, result);
    }
}