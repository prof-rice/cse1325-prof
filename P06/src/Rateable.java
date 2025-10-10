public interface Rateable {
    void addRating(Rating rating);
    double getAverageRating();
    Rating[] getRatings();
}
