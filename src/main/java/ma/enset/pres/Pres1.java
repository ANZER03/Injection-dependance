package ma.enset.pres;

import ma.enset.doa.Doa;
import ma.enset.doa.IDoa;
import ma.enset.metier.IMetier;
import ma.enset.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        IDoa doa = new Doa();
        IMetier metier = new MetierImpl(doa);

        System.out.println("RES = " + metier.calcule());

    }
}
