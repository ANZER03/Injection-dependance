package ma.enset.ext;

import ma.enset.doa.IDoa;

public class DoaV2 implements IDoa {
    @Override
    public double getData() {
        double nb = 24233;
        System.out.println("Version Web Service...");
        return nb;
    }
}
