package ma.enset.metier;

import ma.enset.doa.IDoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
//    @Autowired
    private IDoa doa;

    public MetierImpl(@Qualifier("d2") IDoa doa) {
        this.doa = doa;
    }

//    public MetierImpl() {
//    }

    @Override
    public double calcule() {
        return 100 * doa.getData() / Math.PI * 10;
    }


    public void setDoa(IDoa doa) {
        this.doa = doa;
    }
}
