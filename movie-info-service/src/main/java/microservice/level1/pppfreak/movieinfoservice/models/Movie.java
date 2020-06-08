package microservice.level1.pppfreak.movieinfoservice.models;

public class Movie {
    private Integer movieId;
    private String name;

    public Movie(Integer movieId , String name) {
        this.movieId = movieId;
        this.name    = name;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
