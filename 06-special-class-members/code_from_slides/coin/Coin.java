import java.time.YearMonth;
import java.util.Random;
import java.util.Objects;

public class Coin implements Comparable<Coin> {
    // Const for the first year the US minted coins
    public static final int firstYear = 1792;
    
    // These are the common criteria for coins in the US
    public enum Denomination {Penny, Nickel, Dime, Quarter, HalfDollar, Dollar};
    public enum Grade {Poor, Fair, Good, VeryGood, Fine, Uncirculated, Mint};
    public enum USMint {Philadelphia, Denver, SanFrancisco, WestPoint}
    
    // The explicit constructor, with data validation for the year
    // The parameter order matches the toString order, NOT sort order
    public Coin(Grade grade, int year, USMint mint, Denomination denom) {
        if(year < firstYear || year > YearMonth.now().getYear())
            throw new IllegalArgumentException("Invalid Coin.year");
        this.denom = denom;
        this.grade = grade;
        this.mint = mint;
        this.year = year;
    }
    // The default constructor, which returns a random coin
    //   (See static rand field definition below)
    //   You needn't write this on the first exam!
    public Coin() {
        this(
            Grade.values()[rand.nextInt(Grade.values().length)],
            rand.nextInt(YearMonth.now().getYear() - firstYear) + firstYear,
            USMint.values()[rand.nextInt(USMint.values().length)],
            Denomination.values()[rand.nextInt(Denomination.values().length)]
        );
    }
    
    // This converts the object into a String
    // Note that the order of fields does NOT match sort order
    @Override
    public String toString() {
        return "" + grade + " " + year + " " + mint + " " + denom;
    }
    // year, denom, and mint are relevant; grade is NOT relevant
    // This is the classic way to implement equals
    /*
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;  // 1. Is it me? true!
        if(o == null ||             // 2. Is it my type? false!
           o.getClass() != getClass()) return false;
        Coin c = (Coin) o;          // 3. Cast to my type
        return c.year  == year  &&  // 4. Compare relevant fields
               c.denom == denom &&
               c.mint  == mint;
    }
    */
    // Simpler equals when you also implement compareTo
    @Override
    public boolean equals(Object o) {
        return compareTo((Coin) o) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, denom, mint);
    }
    // Don't worry about a null parameter -
    //   This will automatically throw a NullPointerException as required
    // year, denom, and mint are relevant (in that order)
    // grade is NOT relevant
    // Note and remember the algorithm here
    @Override
    public int compareTo(Coin c) {
        int result = Integer.compare(year, c.year);
        if(result == 0) result = denom.compareTo(c.denom);
        if(result == 0) result = mint.compareTo(c.mint);
        return result;
    }
    
    // The relevant fields in comparisons and hash code calculations
    private Denomination denom;
    private USMint mint;
    private int year;
    
    // Fields that are NOT relevant in comparisons
    private Grade grade;
    private static Random rand = new Random();
}
