package Resource;

import java.util.Date;

public class MovieDetails implements Comparable<MovieDetails> {

    String movieName;
    Date startDate;
    Date endDate;

    public MovieDetails(String movieName, Date startDate, Date endDate) {
        this.movieName = movieName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int compareTo(MovieDetails o) {
        if (this.endDate.before(o.endDate))
            return -1;

        if (this.endDate.equals(o.endDate))
            if (this.startDate.before(o.startDate))
                return -1;

        return 1;
    }
}
