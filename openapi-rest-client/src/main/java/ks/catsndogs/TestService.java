package ks.catsndogs;

import ks.catsndogs.api.CatsApi;
import ks.catsndogs.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class TestService {

    TestService(@Autowired CatsApi catsApi){
        try {
            catsApi.createCat(new Cat()
                    .age(2)
                    .name("Joe")
                    .breed("Chinchilla")
                    .color("Black")
            );
            log.info("Cats currently known: {}", catsApi.listCats());

        } catch (ApiException e) {
            log.error("Failed to execute requests", e);
        }
    }
}
