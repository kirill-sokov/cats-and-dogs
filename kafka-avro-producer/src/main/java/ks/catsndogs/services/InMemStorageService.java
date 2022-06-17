package ks.catsndogs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InMemStorageService<M> {

    private final Map<String, M> storage  = new HashMap<>();

    protected M get(String key) {
        if(storage.containsKey(key)){
            throw new IllegalArgumentException("Doesn't exist: " + key);
        }
        return storage.get(key);
    }
    protected Collection<M> getAll() {
        return storage.values();
    }

    protected void add(String key, M item) {
        if(storage.containsKey(key)){
            throw new IllegalArgumentException("Already exist: " + key);
        }
        storage.put(key, item);
    }

    protected void remove(String key) {
        if(!storage.containsKey(key)){
            throw new IllegalArgumentException("Doesn't exist: " + key);
        }
        storage.remove(key);
    }
}
