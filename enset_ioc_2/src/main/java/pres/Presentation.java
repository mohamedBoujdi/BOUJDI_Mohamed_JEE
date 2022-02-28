package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;
public class Presentation {
    public static void main(String[] args) {
        System.out.println("version d'injection par XML");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier= (IMetier) context.getBean("metier");
        System.out.println(metier.calcul());

    }
}