package metier;
import IDao.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("m")
public class IMetierImpl implements IMetier{
    @Autowired
    private IDAO iDao;

    public void setiDao(IDAO iDao) {
        this.iDao = iDao;
    }

    @Override
    public Double calcul() {
        return iDao.getValue();
    }
}