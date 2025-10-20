package main;

import movers.Seal;
import movers.Bat;
import movers.Sub;
import movers.Jet;

public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub("Gato", 116_000);
        sub.dive(180);
        sub.refuel(13_000);
        System.out.println(sub);
        
        Jet jet = new Jet("F-86", 435);
        jet.fly(635);
        jet.refuel(114);
        System.out.println(jet);
        
        Bat bat = new Bat("MFT", 34);
        bat.fly(99);
        bat.eat("beetle");
        System.out.println(bat);
        
        Seal seal = new Seal("Sea Lion", 38);
        seal.dive(1280);
        seal.eat("herring");
        System.out.println(seal);
    }
}
