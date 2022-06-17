package ks.catsndogs.services;

import ks.catsndogs.model.Dog;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DogsService extends InMemStorageService<Dog>{

    public Dog add(Dog dog) {
        super.add(dog.getName(), dog);
        return dog;
    }

    public void remove(String catName) {
        super.remove(catName);
    }

    public Collection<Dog> getAll() {
        return super.getAll();
    }
}
