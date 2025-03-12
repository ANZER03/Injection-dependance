package ma.enset.metier;

import ma.enset.doa.IDoa;

public class MetierImpl implements IMetier {
    private IDoa doa;

    public MetierImpl(IDoa doa) {
        this.doa = doa;
    }

    public MetierImpl() {
    }

    @Override
    public double calcule() {
        return 100 * doa.getData() / Math.PI * 10;
    }


    public void setDoa(IDoa doa) {
        this.doa = doa;
    }
}
