package ma.gp.formation.java;

import java.util.Arrays;
import java.util.List;

public class ProviderCrud implements ICrud{
    List<Provider> providers = Arrays.asList(new Provider(1,"Danone"));
    @Override
    public void add() {
        providers.add(new Provider(2,"Coca"));
    }

    @Override
    public void delete(Integer id) {
        providers.remove(id);
    }

    @Override
    public void update(Integer id) {
        providers.set(id, new Provider(3,"Fiat"));
    }
}
