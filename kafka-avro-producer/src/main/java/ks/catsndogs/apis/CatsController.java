package ks.catsndogs.apis;

import ks.catsndogs.api.CatsApi;
import ks.catsndogs.model.Cat;
import ks.catsndogs.services.CatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CatsController implements CatsApi {

    private final CatsService catsService;

    @Override
    public ResponseEntity<Cat> createCat(Cat cat) {
        return ResponseEntity.ok(
                catsService.add(cat)
        );
    }

    @Override
    public ResponseEntity<Void> adoptCat(String catName) {
        catsService.remove(catName);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Cat>> listCats() {
        return ResponseEntity.ok(
                catsService.getAll().stream().toList()
        );
    }
}
