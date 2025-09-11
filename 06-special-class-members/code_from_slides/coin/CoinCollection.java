public class CoinCollection {
    private static Coin[] coins;
    private static void printCoins() {
        for(Coin c : coins) System.out.println(c);
    }
    public static void main(String[] args) {
        coins = new Coin[] {
            new Coin(Coin.Grade.VeryGood, 
                     2018, 
                     Coin.USMint.SanFrancisco, 
                     Coin.Denomination.Dime),
            new Coin(Coin.Grade.Fair,
                     1868, 
                     Coin.USMint.WestPoint, 
                     Coin.Denomination.Dollar),
            new Coin(Coin.Grade.Uncirculated, 
                     1966, 
                     Coin.USMint.Denver, 
                     Coin.Denomination.Quarter),
            new Coin(Coin.Grade.Good, 
                     1930, 
                     Coin.USMint.Denver, 
                     Coin.Denomination.HalfDollar),
            new Coin(Coin.Grade.Good, 
                     1982, 
                     Coin.USMint.Denver, 
                     Coin.Denomination.Penny),
        };
        printCoins();
    }
}
