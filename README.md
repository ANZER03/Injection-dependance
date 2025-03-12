
# Instructions

## 1. Créer l'interface `IDoa` avec une méthode `getData`
Définir une interface `IDoa` avec une méthode `getData` qui retourne un `double`.

```java
public interface IDoa {
    double getData();
}
```

## 2. Créer une implémentation de cette interface
Implémenter l'interface `IDoa` dans une classe, par exemple, `DoaV2`.

```java
@Component("d2")
public class DoaV2 implements IDoa {
    @Override
    public double getData() {
        double nb = 24233;
        System.out.println("Version Web Service...");
        return nb;
    }
}
```

## 3. Créer l'interface `IMetier` avec une méthode `calcule`
Définir une interface `IMetier` avec une méthode `calcule` qui retourne un `double`.

```java
public interface IMetier {
    double calcule();
}
```

## 4. Créer une implémentation de cette interface en utilisant le couplage faible
Implémenter l'interface `IMetier` dans une classe, par exemple, `MetierImpl`, et utiliser l'injection de dépendances pour réaliser un couplage faible.

```java
@Component("metier")
public class MetierImpl implements IMetier {
    private IDoa doa;

    @Autowired
    public MetierImpl(@Qualifier("d2") IDoa doa) {
        this.doa = doa;
    }

    @Override
    public double calcule() {
        return 100 * doa.getData() / Math.PI * 10;
    }

    public void setDoa(IDoa doa) {
        this.doa = doa;
    }
}
```

## 5. Effectuer l'injection de dépendances
### a. Par instanciation statique
Instancier manuellement les dépendances dans la méthode main ou une classe de configuration.

```java
public class Main {
    public static void main(String[] args) {
        IDoa doa = new DoaV2();
        IMetier metier = new MetierImpl(doa);
        System.out.println("RES = " + metier.calcule());
    }
}
```

### b. Par instanciation dynamique
Utiliser la réflexion ou un modèle de fabrique pour instancier dynamiquement les dépendances.

```java
public class Main {
    public static void main(String[] args) {
        
        IDoa doa = (IDoa) Class.forName("ma.enset.ext.DoaV2").newInstance();
        IMetier metier = new MetierImpl(doa);
        System.out.println("RES = " + metier.calcule());

    }
}
```

### c. En utilisant le framework Spring
#### - Version XML
Configurer les beans et leurs dépendances dans un fichier de configuration XML.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="d2" class="ma.enset.ext.DoaV2"/>
    <bean id="metier" class="ma.enset.metier.MetierImpl">
        <property name="doa" ref="d"/>
    </bean>
</beans>
```

#### - Version Annotations
Utiliser les annotations Spring comme `@Component`, `@Autowired`, et `@Qualifier` pour gérer les beans et leurs dépendances.

```java
public class Pres4 {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext("ma.enset");
        IMetier metier = app.getBean(IMetier.class);

        System.out.println("RES = " + metier.calcule());
    }
}
```
