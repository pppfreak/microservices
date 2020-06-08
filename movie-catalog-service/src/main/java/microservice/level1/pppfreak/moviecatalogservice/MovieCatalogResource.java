package microservice.level1.pppfreak.moviecatalogservice;

import jdk.jfr.Category;
import microservice.level1.pppfreak.moviecatalogservice.models.CatalogItem;
import microservice.level1.pppfreak.moviecatalogservice.models.Movie;
import microservice.level1.pppfreak.moviecatalogservice.models.Rating;
import microservice.level1.pppfreak.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    WebClient.Builder webClient;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){

        UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratingsData/user/" + userId , UserRating.class);

        return userRating.getRatings().stream().map(rating ->{
            Movie movie = restTemplate.getForObject("http://movie-info-service/moviesInfo/" + rating.getMovie() , Movie.class);
            assert movie != null;
            return new CatalogItem(movie.getName(), "description", rating.getRating());
        }).collect(Collectors.toList());


    }
}


//    Movie movie = webClient
//            .build()
//            .get()
//            .uri("http://localhost:8083/moviesInfo/" + rating.getMovie())
//            .retrieve()
//            .bodyToMono(Movie.class)
//            .block();