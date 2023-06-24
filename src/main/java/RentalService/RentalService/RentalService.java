package RentalService.RentalService;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResponseErrorHandler;


@Service
public class RentalService {
    private RestTemplate restTemplate;

    public Movie getMovie(Long id) {
        Movie movie = restTemplate.getForObject("http://localhost:8080/movie/movies/{id}", Movie.class, id);
        return movie;
    }

    public void returnMovie(Long id) {
        restTemplate.put("http://localhost:8080/movie/movies/{id}", Movie.class, id);
    }

    public void rentMovie(Long id) {
        restTemplate.put("http://localhost:8080/movie/movies/false/{id}", Movie.class, id);
    }

}
