package dao;

import entity.Movie;

import java.util.List;

public interface MoviesDao {
    List<Movie> getAllMovies();

    Movie getMovieDetails(String code);

    boolean addMovie(Movie movie);
}
