/**
 * Prints 1 to 6
 * 
 * Provides a method that counts from 1 to 6. Run like this:
 *
 * /* Calls the counting method */
 * CommentComplexities.oneToSix();
 *
 * @author:  Prof Rice
 * @version: 1.0
 * @since    1.0
 */
public class CommentComplexities {
    public static void oneToSix() {
        for(var f = 1; f < 6 ; ++f)
            System.out.println(f); /* print f */    
    }
    public static void main(String[] args) {
        oneToSix();  /* Count from 1 to 6 */
    }
}
