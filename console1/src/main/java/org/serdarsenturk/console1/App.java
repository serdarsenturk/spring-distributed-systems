package org.serdarsenturk.console1;
import org.serdarsenturk.console1.entity.Movie;
import org.serdarsenturk.console1.repository.MovieRepository;
import org.serdarsenturk.console1.repository.MySQLMovieRepository;
import org.serdarsenturk.console1.services.Consumer1;
import org.serdarsenturk.console1.services.Consumer2;
import org.serdarsenturk.console1.services.MovieService;
import org.serdarsenturk.console1.services.MySQLMovieService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class App
{
    public static void main(String[] argv) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
//        Consumer1.consumeAndSendMessage();
//        Consumer2.consumeAndSendMail();

            // Add a new Movie object
            Movie movie = new Movie();
            movie.setId(99991);
            movie.setName("sssss");
            movie.setBudget(19001);
            movie.setRevenues(9991);

            MovieRepository movieRepository = new MySQLMovieRepository();
            MovieService mysqlService = new MySQLMovieService((MySQLMovieRepository) movieRepository);

        mysqlService.update(movie);
        mysqlService.delete(99991);
        mysqlService.create(movie);
        mysqlService.find(1);
        mysqlService.findAll();
    }
}
