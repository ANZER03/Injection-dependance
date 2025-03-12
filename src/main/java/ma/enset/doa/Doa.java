package ma.enset.doa;

public class Doa implements IDoa {
    @Override
    public double getData() {
        double nb = 243;
        System.out.println("Version Base de donnee...");
        return nb;
    }
}
