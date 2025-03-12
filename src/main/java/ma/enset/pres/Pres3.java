package ma.enset.pres;

import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pres3 {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = app.getBean(IMetier.class);

        System.out.println(metier.calcule());
    }
}
