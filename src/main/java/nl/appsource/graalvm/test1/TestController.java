package nl.appsource.graalvm.test1;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.function.ServerRequest;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.ACCEPT;

public class TestController {

    public Mono<CatResponse> getRandomQuote(ServerRequest request) {

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
