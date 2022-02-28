package IMetier;

import IDao.IDAO;

public class IMetierImpl implements IMetier{
    private IDAO iDao;

    public void setiDao(IDAO iDao) {
        this.iDao = iDao;
    }

    @Override
    public double calcul() {
        return iDao.getvalue();
    }
}
