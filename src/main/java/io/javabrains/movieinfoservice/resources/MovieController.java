package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.model.MovieItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @RequestMapping("/{movieId}")
    public MovieItem getMovieInfo(@PathVariable("movieId") String movieId){
            return   new MovieItem(movieId,"This is horror plus comedy Movie");

    }

}
