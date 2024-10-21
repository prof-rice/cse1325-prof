public class Calculator {
    public static void main(String[] args) {
        try {
            if(args.length % 2 != 1) throw new 
                IllegalArgumentException(
                    "usage: java Calculator n1 [op n2]...");
            int accumulator = Integer.parseInt(args[0]);
            int index = 1;
            while(index+1 < args.length) {
                int operand = Integer.parseInt(args[index+1]);
                switch(args[index]) {
                    case "+" -> accumulator += operand;
                    case "-" -> accumulator -= operand;
                    case "x" -> accumulator *= operand;
                    case "÷" -> accumulator /= operand;
                    default -> throw new 
                        IllegalArgumentException("Bad operator " 
                                               + args[index]);
                }
                index += 2;
            }
            System.out.println(accumulator);
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
