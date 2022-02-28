package pres;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import metier.IMetier;
public class Presentation {
            public static void main(String[] args) throws Exception {
                System.out.println("version d'injection par Annotation");
                ApplicationContext ctx=new AnnotationConfigApplicationContext("IDao","metier");
                //ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
                IMetier metier=ctx.getBean(IMetier.class);
                System.out.println(metier.calcul());
    }
}