# BOUJDI_Mohamed_JEE
## tous les activités et tutoriels à propos de Java Entreprise Edition


![SPRING LOGO](https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg) 
![JEE LOGO](https://miro.medium.com/max/1294/1*PBTTH5RGrfT1RBXxr989XQ.png)

  
 ### Inversion de contrôle et Injection des dépendances
 
**tp:one:: IOC & DI:**
<br>
   >l'injection des dépendances :<br>
- [x] [par l'instanciation statique:link:](https://github.com/mohamedBoujdi/BOUJDI_Mohamed_JEE/tree/main/enset_ioc_1)<br>
      
    ```java
      public static void main(String[] args) {
        IMetierImpl iMetier=new IMetierImpl();
        IDAO idao=new IDaoImpl();
        iMetier.setiDao(idao);
        System.out.println(iMetier.calcul());}
   
      
     
- [x] [par l'instanciation dynamique:link:](https://github.com/mohamedBoujdi/BOUJDI_Mohamed_JEE/tree/main/enset_ioc_2)<br>

     ```java
      public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(new File("config.txt"));
            String daoClassname=scanner.next();
            String metierClassName=scanner.next();
            Class cdao=Class.forName(daoClassname);
            IDAO dao= (IDAO) cdao.newInstance();
            Class cmetier=Class.forName(metierClassName);
            IMetier metier=(IMetier) cmetier.newInstance();
            Method meth=cmetier.getMethod("setiDao",IDAO.class);
            //Method m=cdao.getMethod("getvalue",null);
            //System.out.println("1: "+m.invoke(dao,null));
            meth.invoke(metier,dao);
            System.out.println("2: "+metier.calcul());
        } catch (Exception e) {
         e.printStackTrace();
        }}
    

- [x] [en utilisant le framework Spring:link:](https://github.com/mohamedBoujdi/BOUJDI_Mohamed_JEE/tree/main/enset_ioc_1)<br>
  - Version XML
  
    ```java
        public static void main(String[] args) {
        System.out.println("version d'injection par XML via setter");
        ApplicationContext context1= new ClassPathXmlApplicationContext("applicationContext1.xml");
        IMetier metier1= (IMetier) context1.getBean("metier1");
        System.out.println(metier1.calcul());

        System.out.println("version d'injection par XML via constructeur");
        ApplicationContext context2= new ClassPathXmlApplicationContext("applicationContext2.xml");
        IMetier metier2= (IMetier) context2.getBean("metier2");
        System.out.println(metier2.calcul());
    }
                 
  - Version annotations
  
    ```java
        public static void main(String[] args) throws Exception {
                System.out.println("version d'injection par Annotation");
                ApplicationContext ctx=new AnnotationConfigApplicationContext("IDao","metier");
                //ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
                IMetier metier=ctx.getBean(IMetier.class);
                System.out.println(metier.calcul());}```
  
**tp :seedling:: Mini framework d'injection dépendances**

  - [ ] A travers un fichier XML de configuration en utilisant Jax Binding (OXM : Mapping Objet XML)
  - [ ] En utilisant les annotations
  - [ ] Possibilité d'injection via :
    - Le constructeur
    - Le Setter
    - Attribut (accès direct à l'attribut : Field)
   
**tp :two:: JPA, Hibernate et Spring Data**

   **Reprendre :recycle: les exemples de mapping objet relationnel avec JPA, Hibernate et Spring Data**
  - [x] Cas  de Patient, Medecin, Rendez-vous, Consultation
  
      | ![diag_class](https://user-images.githubusercontent.com/59446813/159123891-c5e43c8e-4e4e-4a7b-bd74-a7fae2c57617.png "diagramme de classe des entities d'un hôpital") |
       |:--:|
      | - Fig.1 - diagramme de classe des entities d'un hôpital |

       
  - [ ] Cas de Users et Roles
  
   
     ###### created with ❤ by Mohamed boujdi
     
