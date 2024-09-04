public class Purse {
    public static void main(String[] args) {
        final int numCoins = 5;
        Coin[] purse = new Coin[numCoins];
        purse[0] = new Coin(Denomination.PENNY, 1909);
        purse[1] = new Coin(Denomination.NICKEL, 1939);
        purse[2] = new Coin(Denomination.DIME, 1946);
        purse[3] = new Coin(Denomination.QUARTER, 1964);
        purse[4] = new Coin(Denomination.PENNY, 2014);

        double totalValue = 0;
        int minYear = 2025;
        int maxYear = 0;
        for(Coin coin : purse) {
            System.out.println(coin);
            totalValue += coin.getValue();
            int year = coin.getYear();
            minYear = (year < minYear) ? year : minYear;
            maxYear = (year > maxYear) ? year : maxYear;
        }
        System.out.printf("You have $%5.2f in coins between %d and %d\n", 
                          totalValue, minYear, maxYear);
    }
}
