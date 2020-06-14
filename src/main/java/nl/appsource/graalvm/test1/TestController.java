package nl.appsource.graalvm.test1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.ACCEPT;

@RestController
public class TestController {

    @GetMapping
    public Mono<CatResponse> get() {

        return WebClient
                .builder()
                .baseUrl("https://cat-fact.herokuapp.com")
                .defaultHeader(ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path("/facts/random").build())
                .retrieve()
                .bodyToMono(CatResponse.class);

    }

}
