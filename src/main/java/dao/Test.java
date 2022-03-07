package dao;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        ProduitDaoImpl dao= null;
        try {
            dao = new ProduitDaoImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dao.save(new Produit(123456l,"P1", 8000, 4));
        dao.save(new Produit(786854l,"P2", 6700, 2));
        dao.save(new Produit(549686l,"P3", 5300, 1));
        System.out.println("--------------------");
        List<Produit> prods=dao.findAll();
        for(Produit p:prods){
            System.out.println(p.getDesignation());
        }

       // déja crée l'objet: ProduitDaoImpl dao=new ProduitDaoImpl();
        System.out.println("--------------------");
        System.out.println("Consulter les produits par mot clé");
        List<Produit> prods2=dao.findByDesignation("P");
        for(Produit p:prods2){
            System.out.println(p.getDesignation());
    }
        System.out.println("------------------------");
        System.out.println("Consulter un produit");
        Produit p=dao.findByID(1L);
        System.out.println(p.getDesignation());
        System.out.println(p.getPrix());
        System.out.println("------------------------");
        System.out.println("Modifier le prix du produit");
        p.setPrix(1234);
        dao.update(p);
        System.out.println("-------------------------");
        System.out.println("Supprimer un produit");
        dao.deleteById(3L);
    }}