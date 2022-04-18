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
  - [x] [Cas  de Patient, Medecin, Rendez-vous, Consultation:link:](https://github.com/mohamedBoujdi/JPA_Hibernate_springData/tree/main/hospital)
  
      | ![diag_class](https://user-images.githubusercontent.com/59446813/159123891-c5e43c8e-4e4e-4a7b-bd74-a7fae2c57617.png "diagramme de classe des entities d'un hôpital") |
       |:--:|
      | - Fig.1 - diagramme de classe des entities d'un hôpital |
      
      | ![structure](https://user-images.githubusercontent.com/59446813/159788918-249293f3-ad65-4833-aece-b8718bacf70c.png)|
      |:--:|
      | - Fig.2 - structure de projet hôpital |
       
       | ![database tables](https://user-images.githubusercontent.com/59446813/159791359-4c1b8752-5a4d-43b3-b355-894401d20275.png) |
       |:--:|
       | - Fig.3 - les tables dans la base de données |
       
       **le bout de code:**
       
       ```java 
             CommandLineRunner start(IHospitalServices iHospitalServices,Rendez_vousRepository rendezVousRepository){
		return args -> {
			//List.of(.....)
			Stream.of("hassan".toUpperCase(),"khalid","fatima","fadwa").forEach(
					p->{
						Patient patient=new Patient();
						patient.setName(p);
						patient.setDate_naissance(Date.from(Instant.now()));
						patient.setMalade(Math.random()>0.5);
						iHospitalServices.savePatient(patient);
					});
			Stream.of("HHHHH","ggggg","gggggg","tttttt","rrrrrrrrr")
					.forEach(
							m->{
								Medicine medicine=new Medicine();
								medicine.setNom(m);
								medicine.setEmail(m+"@gmail.com");
								medicine.setSpecialite("chirurgien");

								iHospitalServices.saveMedecine(medicine);
							}
					);


			Consultation consultation=new Consultation();
			consultation.setDateConsultation(Date.from(Instant.now()));
			consultation.setPrixConsulatation(2221.4);
			consultation.setRapportConsulatation("le rapport ......");
			iHospitalServices.saveConsultation(consultation);
			Rendez_vous rendezVous=new Rendez_vous();
			rendezVous.setDateRendez_vous(Date.from(Instant.now()));
			rendezVous.setStatutRDV(StatutRDV.PENDING);
			rendezVous.setConsultation(consultation);
			Rendez_vous rendezVous2=new Rendez_vous();
			rendezVous.setDateRendez_vous(Date.from(Instant.now()));
			rendezVous.setStatutRDV(StatutRDV.CANCELED);
			rendezVous.setConsultation(consultation);
			System.out.println(iHospitalServices.saveRendezVous(rendezVous2));
			System.out.println(iHospitalServices.saveRendezVous(rendezVous)); 
     

  - [x] [Cas de Users et Roles:link:](https://github.com/mohamedBoujdi/USERS_ROLES.git)
  
  **tp 3️⃣: Activité Pratique Spring MVC Thymeleaf**
  
  ***une application Web JEE basée sur Spring MVC, Thylemeaf et Spring Data JPA qui permet de gérer les patients. L'application doit permettre les fonctionnalités suivantes :[repo d'activité:link:](https://github.com/mohamedBoujdi/spring-mvc-thymeleaf)***
 - [x] Afficher les patients
 - [x] Faire la pagination
 - [x] Chercher les patients
 - [x] Supprimer un patient
     | ![lister les patients](https://user-images.githubusercontent.com/59446813/161455429-ccbb0ce8-bdbf-4fc2-b4dd-3102212553af.png) |
     |:--:|
     | - Fig.1 - Afficher la liste des patients |
     
 - [x] Faire des améliorations supplémentaires
 
 **tp :four: une application Web basée sur Spring MVC, Spring Data JPA et Spring Security [repo d'activité:link:](https://github.com/mohamedBoujdi/Gestion-des-etudiant-with-spring-boot-)**
 
 Créer une qui permet de gérer des étudiants.
Chaque étudiant est défini par:
 - Son id
 - Son nom
 - Son prénom
 - Son email
 - Sa date naissance
 - Son genre : MASCULIN ou FEMININ
 - Un attribut qui indique si il est en règle ou non
L'application doit offrir les fonctionnalités suivantes :
  - [x] Chercher des étudiants par nom
  - [x] Faire la pagination
  - [x] Supprimer des étudiants en utilisant la méthode (DELETE au lieu de GET)
  - [x] Saisir et Ajouter des étudiants avec validation des formulaires
  - [x] Editer et mettre à jour des étudiants
  - [x] Créer une page template 
  - [x] Sécuriser l'accès à l'application avec un système d'authentification basé sur Spring security en utilisant la stratégie UseDetails Service
  - [x] Ajouter d'autres fonctionnalités supplémentaires
  ***les captures d'écran***
  
   | ![Screenshot from 2022-04-18 00-45-56](https://user-images.githubusercontent.com/59446813/163738589-a05683fa-5026-4ba1-8660-996072f6c0b1.png) |
   |:--:|
   **login**
  
  | ![Screenshot from 2022-04-18 00-48-17](https://user-images.githubusercontent.com/59446813/163738668-915b7a96-bf77-405e-b302-4d8c15dd90a6.png) |
  |:--:|
  **espace selon le rôle user/Admin** 
  
  | ![Screenshot from 2022-04-18 00-50-00](https://user-images.githubusercontent.com/59446813/163738741-db0dfcc7-f4bd-4dad-b4a9-d3547a37e765.png) |
  |:--:|
  **Ajouter les utilisateurs**


  
   
     ###### created with ❤ by Mohamed boujdi
     
