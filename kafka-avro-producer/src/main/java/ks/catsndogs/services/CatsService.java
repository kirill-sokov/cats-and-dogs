package ks.catsndogs.services;

import ks.catsndogs.model.Cat;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CatsService extends InMemStorageService<Cat>{

    public Cat add(Cat cat) {
        super.add(cat.getName(), cat);
        return cat;
    }

    public void remove(String catName) {
        super.remove(catName);
    }

    public Collection<Cat> getAll() {
        return super.getAll();
    }
}
