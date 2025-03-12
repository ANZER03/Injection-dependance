package ma.enset.doa;

import org.springframework.stereotype.Component;

@Component("d1")
public class Doa implements IDoa {
    @Override
    public double getData() {
        double nb = 243;
        System.out.println("Version Base de donnee...");
        return nb;
    }
}
