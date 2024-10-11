package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Models a media product to serve to the students
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Media {
    /**
     * Creates a Media instance.
     *
     * The Customer for whom this Order is placed is provide
     * as the constructor parameter. The Order number is
     * auto-generated as sequential integers. Items may be 
     * added to the Order via the addItem(Item) method.
     *
     * @param title     the name by which the media is known
     * @param url       the Uniform Resource Locator of the media
     * @param points    the cost for accessing the media
     * @since           1.0
     */
    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
        // EXTREME BONUS SOLUTION
        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
        }
        // END EXTREME BONUS SOLUTION
    }
    public Media(BufferedReader br) throws IOException {
        this(br.readLine(), br.readLine(),Integer.parseInt(br.readLine()));
    }
    public void save(BufferedWriter bw) throws IOException {
        bw.write(title + '\n');
        bw.write(url + '\n');
        bw.write("" + points + '\n');
    }
    /**
     * Returns the number of points required to access this media.
     *
     * The value of points varies depending on the deal currently offered
     * on the MOES website.
     *
     * @returns        the cost in points 
     * @since          1.0
     */
    public int getPoints() {
        return points;
    }
    /**
     * Returns an Order summary in receipt format.
     *
     * This includes the Order number and Customer, a table
     * of Items in the Order, and the total price of the Order.
     * Sales tax is not included at this time.
     *
     * @returns     the title with parenthetical url and points
     * @since       1.0
     */
    @Override
    public String toString() {
        return title + " (" + url + ", " + points + " points)";
    }
    private String title;
    private String url;
    private int points;
}
