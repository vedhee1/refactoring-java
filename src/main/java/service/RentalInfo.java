package service;

import constants.MovieRentalConstants;
import constants.MovieType;
import dao.MoviesDao;
import daoImpl.MoviesDaoImpl;
import entity.Customer;
import entity.Movie;
import entity.MovieRental;
import exception.MovieNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RentalInfo {

  private static final Logger logger = LogManager.getLogger(RentalInfo.class);

  public String statement(Customer customer) throws MovieNotFoundException {
    logger.debug(MovieRentalConstants.ENTERED_STATEMENT);
    if(customer == null) {
      return MovieRentalConstants.CUSTOMER_NOT_FOUND;
    }else{
      MoviesDao moviesDao = new MoviesDaoImpl();
      double totalAmount = 0;
      int frequentEnterPoints = 0;
      if (customer.getName() == null || customer.getName().isBlank()) {
        return MovieRentalConstants.CUSTOMER_NOT_FOUND;
      }
      StringBuilder result = new StringBuilder();
      result.append(MovieRentalConstants.RENTAL_RECORD_FOR + customer.getName() + "\n");
      for (MovieRental movieRental : customer.getRentals()) {
        try {
          // determine amount for each movie
          String movieId = movieRental.getMovieId();
          Movie movie = moviesDao.getMovieDetails(movieId);
          double thisAmount = getAmount(movie.getType(), movieRental.getDays());
          //add frequent bonus points
          frequentEnterPoints++;
          // add bonus for a two day new release rental
          if (movie.getType() == MovieType.NEW && movieRental.getDays() > 2) frequentEnterPoints++;
          //print figures for this rental
          result.append("\t" + movie.getTitle() + "\t" + thisAmount + "\n");
          totalAmount += thisAmount;
        } catch (Exception exception) {
          logger.error(MovieRentalConstants.NO_MOVIES_FOUND);
          throw new MovieNotFoundException(MovieRentalConstants.NO_MOVIES_FOUND);
        }
      }
      // add footer lines
      result.append(MovieRentalConstants.AMOUNT_OWED_IS + totalAmount + "\n");
      result.append(MovieRentalConstants.YOU_EARNED + frequentEnterPoints + MovieRentalConstants.FREQUENT_POINTS + "\n");
      logger.debug(MovieRentalConstants.EXIT_STATEMENT);
      return result.toString();
    }
  }

  public static double getAmount(MovieType movieCode, int daysRented) {
    logger.debug(MovieRentalConstants.ENTERED_GETAMOUNT);
    double thisAmount = 0;
    switch(movieCode){
      case REGULAR:
        thisAmount = 2;
        if (daysRented > 2)
          thisAmount = ((daysRented - 2) * 1.5) + thisAmount;
        break;
      case NEW:
        thisAmount = daysRented * 3;
        break;
      case CHILDREN:
        thisAmount = 1.5;
        if (daysRented > 3)
          thisAmount = ((daysRented - 3) * 1.5) + thisAmount;
        break;
    }
    logger.debug(MovieRentalConstants.EXIT_GETAMOUNT);
    return thisAmount;
  }

}
