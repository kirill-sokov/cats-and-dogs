package ks.catsndogs.apis;

import ks.catsndogs.api.DogsApi;
import ks.catsndogs.model.Dog;
import ks.catsndogs.model.DogUpdate;
import ks.catsndogs.services.DogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DogsController implements DogsApi {

    private final DogsService dogsService;

    @Override
    @PreAuthorize("hasRole('doglover')")
    public ResponseEntity<Dog> createDog(Dog dog) {
        return ResponseEntity.ok(
                dogsService.add(dog)
        );
    }

    @Override
    @PreAuthorize("hasRole('doglover')")
    public ResponseEntity<Void> deleteDog(String dogName) {
        dogsService.remove(dogName);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Dog> getDog(String dogName) {
        return ResponseEntity.ok(
                dogsService.get(dogName)
        );
    }

    @Override
    public ResponseEntity<List<Dog>> listDogs() {
        return ResponseEntity.ok(
                dogsService.getAll()
        );
    }

    @Override
    @PreAuthorize("hasRole('doglover')")
    public ResponseEntity<Dog> updateDog(String name, DogUpdate dogUpdate) {
        return ResponseEntity.ok(
                dogsService.update(name, dogUpdate)
        );
    }
}
