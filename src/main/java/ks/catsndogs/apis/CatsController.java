package ks.catsndogs.apis;

import ks.catsndogs.api.CatsApi;
import ks.catsndogs.model.Cat;
import ks.catsndogs.model.CatUpdate;
import ks.catsndogs.services.CatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CatsController implements CatsApi {

    private final CatsService catsService;

    @Override
    @PreAuthorize("hasRole('catlover')")
    public ResponseEntity<Cat> createCat(Cat cat) {
        return ResponseEntity.ok(
                catsService.add(cat)
        );
    }

    @Override
    @PreAuthorize("hasRole('catlover')")
    public ResponseEntity<Void> deleteCat(String catName) {
        catsService.remove(catName);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Cat> getCat(String catName) {
        return ResponseEntity.ok(
                catsService.get(catName)
        );
    }

    @Override
    public ResponseEntity<List<Cat>> listCats() {
        return ResponseEntity.ok(
                catsService.getAll()
        );
    }

    @Override
    @PreAuthorize("hasRole('catlover')")
    public ResponseEntity<Cat> updateCat(String catName, CatUpdate catUpdate) {
        return ResponseEntity.ok(
                catsService.update(catName, catUpdate)
        );
    }
}
