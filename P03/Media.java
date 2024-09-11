public class Media {
    public Media(String title, String url) {
        this.title = title;
        this.url = url;
        // EXTREME BONUS SOLUTION
        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
        }
        // END EXTREME BONUS SOLUTION
    }
    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
    private String title;
    private String url;
}
