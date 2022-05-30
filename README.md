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
  
   
 **tp :five: une application Web basée sur Spring et Angular qui permet de gérer des comptes bancaires.[repo de projet:link:](https://github.com/mohamedBoujdi/Digital-banking-springboot-angular.)**

Travail à faire :
  - [x]  Créer et tester la couche DAO (Voir la vidéo : https://www.youtube.com/watch?v=muuFQWnCQd0)
  ![Screenshot from 2022-05-30 18-15-54](https://user-images.githubusercontent.com/59446813/171052937-ab6181c6-d93e-4376-b28e-90111ed42ab8.png)

  - [x]  Créer et tester la couche service
  
  - [x]  Créer et tester la couche Web (Rest Controller)
![Screenshot from 2022-05-30 19-17-20](https://user-images.githubusercontent.com/59446813/171052881-a4376318-0a16-4d8b-94e3-f9811fa462d3.png)
![Screenshot from 2022-05-30 19-17-42](https://user-images.githubusercontent.com/59446813/171052897-df8b6508-ac2f-4014-bfb1-140e1f72dc21.png)
![Screenshot from 2022-05-30 19-17-55](https://user-images.githubusercontent.com/59446813/171052909-901d65ee-8037-40e0-9088-64decead0dfb.png)

  - [x]  Modifier la couche service et la couche web  en utilisant les DTO
  
  - [x]  Créer un service d'authentification séparé basé sur Spring Security et JWT (Voir https://www.youtube.com/watch?v=3q3w-RT1sg0)

  - [ ]  Sécuriser l'application Digital Banking en utilisant Spring Security et JWT
 
  - [x]  Créer la partie Frontend Web en utilisant Angular

  ![Screenshot from 2022-05-30 19-22-35](https://user-images.githubusercontent.com/59446813/171052653-1c858aaa-1759-42c1-be04-430f46f7bf70.png)

  - [ ]  Créer la partie Frontend Mobile avec Flutter
  
  ![Screenshot from 2022-05-30 19-52-48](https://user-images.githubusercontent.com/59446813/171053555-bdfa1422-5f45-476f-acaf-0c1639df272b.png)
 ![Screenshot from 2022-05-30 19-53-13](https://user-images.githubusercontent.com/59446813/171053561-c886c382-a090-4e48-bff1-cd3650c9a81a.png)
 ![Screenshot from 2022-05-30 19-53-36](https://user-images.githubusercontent.com/59446813/171053575-73ade03e-0486-46b5-8679-cb820146187a.png)
 ![Screenshot from 2022-05-30 19-53-48](https://user-images.githubusercontent.com/59446813/171053581-8aa8d278-7c32-480f-afb2-222d7ce1905b.png)
 ![Screenshot from 2022-05-30 19-54-04](https://user-images.githubusercontent.com/59446813/171053607-c4843a8c-66b2-41f5-97bb-ee2dace3794b.png)
![Screenshot from 2022-05-30 19-54-46](https://user-images.githubusercontent.com/59446813/171053624-c1e3cefb-58ac-4bb9-9e40-6c536304ec6b.png)
![Screenshot from 2022-05-30 19-55-02](https://user-images.githubusercontent.com/59446813/171053633-92fa4de4-4419-4b8a-974c-66395db02ef8.png)

  
  


  
   
     ###### created with ❤ by Mohamed boujdi
     
