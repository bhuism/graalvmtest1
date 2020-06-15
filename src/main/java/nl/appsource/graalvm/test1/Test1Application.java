package nl.appsource.graalvm.test1;

import org.springframework.fu.jafu.JafuApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static org.springframework.fu.jafu.Jafu.webApplication;
import static org.springframework.fu.jafu.webmvc.WebMvcServerDsl.webMvc;
import static org.springframework.web.servlet.function.ServerResponse.ok;


public class Test1Application {

    public static JafuApplication app = webApplication(a -> {

        a.beans(b -> b.bean(TestController.class));
        a.beans(b -> b.bean(Jackson2ObjectMapperBuilder.class));

        a.enable(webMvc(s -> {
            s.port(8080);
            s.router(router -> {
                final TestController handler = s.ref(TestController.class);
                router.GET("/", req -> ok().contentType(MediaType.APPLICATION_JSON).body(handler.getRandomQuote(req)));
            });
        }));

    });

    public static void main(String[] args) throws InterruptedException {
        app.run(args);
    }

}
