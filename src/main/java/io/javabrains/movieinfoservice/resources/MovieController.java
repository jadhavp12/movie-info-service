package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.model.MovieItem;
import io.javabrains.movieinfoservice.model.MovieSummery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${movie-db.api-key}")
    private String apikey;

    @Autowired
    RestTemplate restTemplate;

/*    @RequestMapping("/{movieId}")
    public MovieItem getMovieInfo(@PathVariable("movieId") String movieId){
            return   new MovieItem(movieId,"This is horror plus comedy Movie" ,"Title");

    }*/

    @RequestMapping("/{movieId}")
    public MovieItem getMovieInfoFromMovieDB(@PathVariable("movieId") String movieId){
       MovieSummery movieSummery= restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apikey, MovieSummery.class);
        return new MovieItem(movieId,movieSummery.getOverview(),movieSummery.getTitle());

    }

}
