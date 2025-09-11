import java.util.ArrayList;
import java.util.Scanner;

public class MyPets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();
        
        while(true) {
            System.out.print("\n0=exit, 1=dog, 2=cat, 3=rabbit, 4=iguana? ");
            int type = in.nextInt(); in.nextLine();
            if(type == 0) break;
            if(type<1 || type>4) {
                System.err.println("Invalid pet type - try again!");
                continue;
            }
            System.out.print("Pet's name? ");
            String name = in.nextLine();
            if(name.length() == 0) {
                System.err.println("Pets must have names - try again!");
                continue;
            }
            System.out.print("Pet's age? ");
            double age = in.nextDouble(); in.nextLine();
            
            pets.add(new Pet(name, age,
                switch(type) {
                    case 1 -> Type.DOG;
                    case 2 -> Type.CAT;
                    case 3 -> Type.RABBIT;
                    default -> Type.IGUANA;
            }));
            System.out.println(pets.get(pets.size()-1));
            System.out.println();
        }
        
        System.out.println();
        for(Pet p : pets)
            System.out.println(p);
    }
}

