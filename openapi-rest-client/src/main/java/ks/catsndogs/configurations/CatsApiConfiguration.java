package ks.catsndogs.configurations;

import ks.catsndogs.ApiClient;
import ks.catsndogs.api.CatsApi;
import ks.catsndogs.api.DogsApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;


@Configuration
@Slf4j
public class CatsApiConfiguration {


    @Bean
    ApiClient apiClient(
            @Value("${ks.env.server.host}") String host,
            @Value("${ks.env.server.port}") Integer port,
            @Value("${ks.env.server.basePath}") String basePath,
            @Value("${ks.env.server.user.pass}") String password,
            @Value("${ks.env.server.user.login}") String username
    ) {
        return new ApiClient()
                .setRequestInterceptor(b -> b.header("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes())))
                .setHost(host)
                .setPort(port)
                .setBasePath(basePath);

    }

    @Bean
    CatsApi catsApi(ApiClient apiClient) {
        return new CatsApi(apiClient);
    }

    @Bean
    DogsApi dogsApi(ApiClient apiClient) {
        return new DogsApi(apiClient);
    }
}
