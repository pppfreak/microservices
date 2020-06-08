package microservice.level1.pppfreak.moviedataservice.models;

public class Rating {
    private String movie;
    private Integer rating;

    public Rating(String movie , Integer rating) {
        this.movie  = movie;
        this.rating = rating;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
