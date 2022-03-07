package dao;
import java.util.List; import javax.persistence.*;
import javax.transaction.Transactional;

public class ProduitDaoImpl implements IProduitDao {
    /* Déclaration de l’objet EntityManager qui permet de gérer les entités*/
    private EntityManager entityManager;
    /* Constructeur */
    public ProduitDaoImpl() throws Exception{
        /* Création de l’objet Entity Manager Factory */
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UP_CAT");
        /* Création de l’objet Entity Manager */
        entityManager=entityManagerFactory.createEntityManager();
    }

    @Override

    public void save(Produit p) {
        // first method
         //Création d’une transaction
        EntityTransaction transaction=entityManager.getTransaction();
         //Démarrer la transaction
        transaction.begin();
        try {
             //enregister le produit p dans la base de données
            //Ajouter un produit : La méthode persist()
            entityManager.persist(p);

            // Valider la transaction si tout se passe bien
            transaction.commit();
        } catch (Exception e) {
             //Annuler la transaction en cas d’exception
            transaction.rollback();
            e.printStackTrace();
        }
        //Déléguer les transaction à Spring IOC
        /*@Transactional
        public void save(Produit p) {
            entityManager.persist(p);
        }*/

    }

   //Consulter tous les produits : createQuery()
    @Override
    public List<Produit> findAll() {
            Query query=entityManager.createQuery("select p from Produit p");
            return query.getResultList();
    }

    @Override
    public List<Produit> findByDesignation(String mc) {
        Query query=entityManager.createQuery("select p from Produit p where p.designation like :x");
        query.setParameter("x", "%"+mc+"%");
        return query.getResultList();
    }

    @Override
    public Produit findByID(Long idProduit) {
        Produit p=entityManager.find(Produit.class, idProduit);
        return p;
    }

    @Override
    public void update(Produit p) {
        //Mettre à jour un produit : Méthode merge()
        entityManager.merge(p);
    }

    @Override
    public void deleteById(Long idP) {
        Produit p=entityManager.find(Produit.class, idP);
        entityManager.remove(p);
    }
}