package ma.enset.pres;

import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Pres4 {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext("ma.enset");
        IMetier metier = app.getBean(IMetier.class);

        System.out.println("RES = " + metier.calcule());
    }
}
