package ma.enset.pres;

import ma.enset.doa.IDoa;
import ma.enset.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("config.txt"));

        String SDoa = scanner.nextLine();
        Class cDoa = Class.forName(SDoa);
        IDoa doa = (IDoa) cDoa.newInstance();

        String SMetier = scanner.nextLine();
        Class cMetier = Class.forName(SMetier);
        IMetier metier = (IMetier) cMetier.getConstructor(IDoa.class).newInstance(doa);



        System.out.println("RES = " + metier.calcule());
    }
}
