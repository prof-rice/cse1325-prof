public class ListPrimes {
    private static final String USAGE =
        "usage: java ListPrimes <begin> <end> <#threads>";
    public static void main(String[] args) {
        try {
            qlogger.Qlogger.enabled = false;
        
            if(args.length != 3) {
                System.err.println(USAGE);
                System.exit(-3);
            };
            long begin = Long.parseLong(args[0].replaceAll("_", ""));
            long end = Long.parseLong(args[1].replaceAll("_", ""));
            int numThreads = Integer.parseInt(args[2]);
        
            Primes primes = (numThreads == 0) ? new Primes()
                                              : new ThreadedPrimes();
        
            primes.search(begin, end+1, numThreads);
            qlogger.Qlogger.log("\nFound " + primes.size() + 
                " primes!\n\n" + primes);
        } catch(Exception e) {
            System.err.println("PANIC: Abort searching for primes.");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
