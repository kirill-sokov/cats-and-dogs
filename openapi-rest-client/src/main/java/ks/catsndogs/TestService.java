package ks.catsndogs;

import ks.catsndogs.api.DogsApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class TestService {


    TestService(@Autowired DogsApi dogsApi){
        try {
            dogsApi.listDogs();
        } catch (ApiException e) {
            log.error("Failed to execute requests", e);
        }
    }
}
