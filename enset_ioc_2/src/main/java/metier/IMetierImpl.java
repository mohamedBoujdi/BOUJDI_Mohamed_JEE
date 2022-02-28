package metier;
import IDao.IDAO;

public class IMetierImpl implements IMetier{
    private IDAO iDao;

    public void setiDao(IDAO iDao) {
        this.iDao = iDao;
    }

    @Override
    public Double calcul() {
        return iDao.getValue();
    }
}