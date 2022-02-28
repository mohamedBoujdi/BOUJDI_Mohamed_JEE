package IDao;

import org.springframework.stereotype.Component;
//test error
@Component("d")
public class IDaoImpl implements IDAO{
    @Override
    public Double getValue() {
        return 200.1;
    }
}
