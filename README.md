# BOUJDI_Mohamed_JEE
## tous les activités et tutoriels à propos de Java Entreprise Edition


![SPRING LOGO](https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg) 
![JEE LOGO](https://miro.medium.com/max/1294/1*PBTTH5RGrfT1RBXxr989XQ.png)

  
 ### Inversion de contrôle et Injection des dépendances
 
**tp:one:: IOC & DI:**
<br>
   >l'injection des dépendances :<br>
- [x] [par l'instanciation statique](https://github.com/mohamedBoujdi/BOUJDI_Mohamed_JEE/tree/main/enset_ioc_1)<br>
      
    ```java
      public static void main(String[] args) {
        IMetierImpl iMetier=new IMetierImpl();
        IDAO idao=new IDaoImpl();
        iMetier.setiDao(idao);
        System.out.println(iMetier.calcul());}
   
      
     
- [x] [par l'instanciation dynamique](https://github.com/mohamedBoujdi/BOUJDI_Mohamed_JEE/tree/main/enset_ioc_2)<br>

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
    

- [x] [en utilisant le framework Spring](https://github.com/mohamedBoujdi/BOUJDI_Mohamed_JEE/tree/main/enset_ioc_1)<br>
  - Version XML
  
    ```java
        public static void main(String[] args) {
              System.out.println("version d'injection par XML");
              ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
              IMetier metier= (IMetier) context.getBean("metier");
                 System.out.println(metier.calcul()); }
                 
  - Version annotations
  
    ```java
        public static void main(String[] args) throws Exception {
                System.out.println("version d'injection par Annotation");
                ApplicationContext ctx=new AnnotationConfigApplicationContext("IDao","metier");
                //ApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
                IMetier metier=ctx.getBean(IMetier.class);
                System.out.println(metier.calcul());}
  
**tp :two:: Mini framework d'injection dépendances**

  - [ ] A travers un fichier XML de configuration en utilisant Jax Binding (OXM : Mapping Objet XML)
  - [ ] En utilisant les annotations
  - [ ] Possibilité d'injection via :
    - Le constructeur
    - Le Setter
    - Attribut (accès direct à l'attribut : Field)

        ###### :copyright:created with ❤ by Mohamed boujdi
