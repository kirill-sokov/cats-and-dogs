package ks.catsndogs.apis;

import ks.catsndogs.api.DogsApi;
import ks.catsndogs.model.Dog;
import ks.catsndogs.services.DogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DogsController implements DogsApi {

    private final DogsService dogsService;

    @Override
    public ResponseEntity<Dog> createDog(Dog dog) {
        return ResponseEntity.ok(
                dogsService.add(dog)
        );
    }

    @Override
    public ResponseEntity<Void> adoptDog(String dogName) {
        dogsService.remove(dogName);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Dog>> listDogs() {
        return ResponseEntity.ok(
                dogsService.getAll().stream().toList()
        );
    }
}
