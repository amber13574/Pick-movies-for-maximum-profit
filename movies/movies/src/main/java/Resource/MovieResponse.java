package Resource;

import java.util.List;

public class MovieResponse {

    Long totalEarnedAmount;
    List<String> movies;

    public MovieResponse(Long totalEarnedAmount, List<String> movies) {
        this.totalEarnedAmount = totalEarnedAmount;
        this.movies = movies;
    }

    public Long getTotalEarnedAmount() {
        return totalEarnedAmount;
    }

    public void setTotalEarnedAmount(Long totalEarnedAmount) {
        this.totalEarnedAmount = totalEarnedAmount;
    }

    public List<String> getMovies() {
        return movies;
    }

    public void setMovies(List<String> movies) {
        this.movies = movies;
    }
}
