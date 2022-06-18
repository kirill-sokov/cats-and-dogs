package ks.catsndogs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InMemStorageService<M> {

    private final Map<String, M> storage = new HashMap<>();

    public M get(String key) {
        if (storage.containsKey(key)) {
            throw new IllegalArgumentException("Doesn't exist: " + key);
        }
        return storage.get(key);
    }

    public Collection<M> getAll() {
        return storage.values();
    }

    public M add(String key, M item) {
        if (storage.containsKey(key)) {
            throw new IllegalArgumentException("Already exists: " + key);
        }
        storage.put(key, item);
        return item;
    }

    public M remove(String key) {
        if (!storage.containsKey(key)) {
            throw new IllegalArgumentException("Doesn't exist: " + key);
        }
        return storage.remove(key);
    }
}
