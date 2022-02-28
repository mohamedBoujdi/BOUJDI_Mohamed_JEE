package pres;

import IDao.IDAO;
import IDao.IDaoImpl;
import IMetier.IMetierImpl;

public class pres {
    public static void main(String[] args) {
        IMetierImpl iMetier=new IMetierImpl();
        IDAO idao=new IDaoImpl();
        iMetier.setiDao(idao);
        System.out.println(iMetier.calcul());
    }
}
